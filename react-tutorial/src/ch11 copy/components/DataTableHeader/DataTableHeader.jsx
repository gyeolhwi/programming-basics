import { useEffect, useRef, useState } from "react";
import "./style.css";
import Swal from "sweetalert2";
function DataTableHeader({ mode, setMode, products, setProducts, setDeleting, editProductId }) {

    // const getNewId = () => {
    //     setProducts(products => {
    //         const newProduct = products.map(product =>  product.id )
    //         const maxId = newProduct.length === 0 ? 0 : Math.max.apply(null, newProduct);
    //         return maxId + 1;
    //     })
    // };

    const refs = {
        productName: useRef(),
        size: useRef(),
        color: useRef(),
        price: useRef(),
    }
    const { productName, size, color, price } = refs;
    const emptyProduct = {
        id: "",
        productName: "",
        size: "",
        color: "",
        price: ""
    };
    const [inputData, setInputData] = useState({ ...emptyProduct });

    useEffect(() => {
        if (mode === 2) {
            const [editData] = products.filter(product => product.id === editProductId);
            setInputData(!editData ? emptyProduct : editData);
        }
        if (mode === 3) {
            const editData = products.filter(product => product.id === editProductId);
            
        }
    }, [editProductId]);

    const handleInputChange = (e) => {
        setInputData(inputData => ({
            ...inputData,
            [e.target.name]: e.target.value
        }));
    }
    const handleChangeModeClick = (e) => {
        setMode(parseInt(e.target.value));
    }

    const handleSubmitClick = () => {

        if (mode === 1) {
            Swal.fire({
                title: "상품추가",
                text: "추가하시겠습니까",
                icon: "question",
                showCancelButton: true,
                confirmButtonText: "yeah"
            }).then((result) => {
                if (result.isConfirmed) {
                    setProducts(products => {
                        const productIds = products.map(product => product.id);
                        const maxId = productIds.length === 0
                            ? 0
                            : Math.max.apply(null, productIds);
                        return [...products, {
                            ...inputData,
                            id: maxId + 1
                        }];
                    });
                }
            }).then(() => {
                Swal.fire({
                    title: "상품 정보 저장 완료",
                    icon: "success",
                    position: "top-end",
                    showConfirmButton: false,
                    timer: 500
                });
                resetMode();
            });

        }


        if (mode === 2) {
            Swal.fire({
                title: "상품 정보 수정",
                text: "수정할거야?",
                showCancelButton: true,
                confirmButtonText: "확인",
                cancelButtonText: "취소",
            }).then((result) => {
                if (result.isConfirmed) {
                    setProducts(products => [...products.map(product => {
                        if (product.id === editProductId) {
                            // if에서 id값이 같은 걸 가지고옴
                            // id 값은 현재 문자열 이므로 레스트문법으로 빼줌
                            const { id, ...restData } = inputData;
                            //해당 하는 것의 기존 데이터를 restData로 바꿔줌
                            return {
                                ...product,
                                ...restData
                            }
                        }
                        return product;
                    })
                    ])
                }
            });
            resetMode();
        }

        if (mode === 3) {
            // id 값을 header에 던져주고 viewProduct를 쓸 게 아니라 기존 productid 값에 filter 후 삭제 처리
            Swal.fire({
                title: "상품 정보 삭제",
                text: "정말로 삭제 하시겠습니까?",
                showCancelButton: true,
                confirmButtonText: "삭제",
                confirmButtonColor: "red",
                cancelButtonText: "취소"
            }).then(result => {
                if (result.isConfirmed) {
                    setDeleting(true);
                    alert("상품삭제")
                }
            })
            resetMode();
        }
    }

    const handleCancelClick = () => {
        resetMode();
    }

    const resetMode = () => {
        setMode(0);
        setInputData({ ...emptyProduct });
    }

    const handleKeyDown = (e) => {
        if (e.keyCode === 13) {
            switch (e.target.name) {
                case "productName":
                    size.current.focus();
                    break;
                case "size":
                    color.current.focus();
                    break;
                case "color":
                    price.current.focus();
                    break;
                case "price":
                    handleSubmitClick();
                    break;
                default:
            }
        }
    }
    return (
        <header className="table-header">
            <div className="input-group">
                <input
                    type="text"
                    disabled={mode === 0 || mode === 3}
                    name="productName"
                    value={inputData.productName}
                    placeholder="상품명"
                    onChange={handleInputChange}
                    onKeyDown={handleKeyDown}
                    ref={productName} autoFocus
                />
                <input
                    type="text"
                    disabled={mode === 0 || mode === 3}
                    name="size"
                    value={inputData.size}
                    placeholder="사이즈"
                    onChange={handleInputChange}
                    onKeyDown={handleKeyDown}
                    ref={size}
                />
                <input
                    type="text"
                    disabled={mode === 0 || mode === 3}
                    name="color"
                    value={inputData.color}
                    placeholder="색상"
                    onChange={handleInputChange}
                    onKeyDown={handleKeyDown}
                    ref={color}
                />
                <input
                    type="text"
                    disabled={mode === 0 || mode === 3}
                    name="price"
                    value={inputData.price}
                    placeholder="가격"
                    onChange={handleInputChange}
                    onKeyDown={handleKeyDown}
                    ref={price}
                />
            </div>
            <div>
                {
                    !mode && (
                        <div className="button-group">
                            <button onClick={handleChangeModeClick} value={1}  >추가</button>
                            <button onClick={handleChangeModeClick} value={2}  >수정</button>
                            <button onClick={handleChangeModeClick} value={3}  >삭제</button>
                        </div>
                    )
                }
                {
                    !!mode && (
                        <div>
                            <button onClick={handleSubmitClick}>확인</button>
                            <button onClick={handleCancelClick}>취소</button>
                        </div>
                    )
                }
            </div>
        </header>
    );
}
export default DataTableHeader;