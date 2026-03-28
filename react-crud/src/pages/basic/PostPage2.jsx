import axios from 'axios';
import React, { useEffect, useState } from 'react';

function PostPage2(props) {
    const emptyProduct = {
        productName: "",
        price: "",
        sizeId: "",
        colorId: ""
    }

    const [product, setProduct] = useState({
        ...emptyProduct
    });

    const [sizeOptions, setSizeOptions] = useState([]);
    const [colorOptions, setColorOptions] = useState([]);

    useEffect(() => {
        const getSize = async () => {
            const response = await axios.get("http://localhost:8080/api/v1/sizes");
            setSizeOptions(response.data);
            setProduct(product => ({
                ...product,
                sizeId: response.data[0].sizeId
            }));
        }
        const getColors = async () => {
            const response = await axios.get("http://localhost:8080/api/v1/colors");
            setColorOptions(response.data);
            setProduct(product => ({
                ...product,
                colorId: response.data[0].colorId,
            }));


        }
        getSize();
        getColors();
    }, []);




    const handleInputChange = (e) => {
        setProduct(product => {
            return {
                ...product,
                [e.target.name]: e.target.value
            }
        });
    }

    const resetProduct = () => {
        setProduct(emptyProduct);
    }

    const handleSubmitClick = async () => {
        let resp;
        try {
            const response = await axios.post("http://localhost:8080/api/v1/product", product);
            console.log(response.data);
            resp = response;
            resetProduct();
        } catch (error) {
            console.log(error);
        }
        console.log(resp);
    }
    
    const handleSubmitClick2 = async () =>{
        await axios.post("http://localhost:8080/api/v1/product",product).then(response => {
            console.log(response.data)
        }).catch(error=>{
            console.log(error);
        });

    }

    return (
        <>
            <header>
                <h1>비동기 데이터 통신(POST2)</h1>
            </header>
            <main>
                <h3>상품등록</h3>
                <p>
                    <label htmlFor="">상품명</label>
                    <input
                        name='productName'
                        onChange={handleInputChange}
                        value={product.productName}>
                    </input>
                </p>
                <p>
                    <label htmlFor="">가격</label>
                    <input
                        name='price'
                        onChange={handleInputChange}
                        value={product.price}>
                    </input>
                </p>
                <p>
                    <label htmlFor="">사이즈</label>
                    <select
                        name='sizeId'
                        onChange={handleInputChange}
                        value={product.sizeId}>
                        {
                            sizeOptions.map(size => <option key={size.sizeId} value={size.sizeId} >{size.sizeName}</option>)
                        }
                    </select>
                </p>
                <p>
                    <label htmlFor="">색상</label>
                    <select
                        name='colorId'
                        onChange={handleInputChange}
                        value={product.colorId}>
                        {
                            colorOptions.map(color => <option key={color.colorId} value={color.colorId} >{color.colorName}</option>)
                        }
                    </select>
                </p>
                <p>
                    <button onClick={handleSubmitClick}>등록하기</button>
                </p>
            </main>
        </>
    );
}

export default PostPage2;