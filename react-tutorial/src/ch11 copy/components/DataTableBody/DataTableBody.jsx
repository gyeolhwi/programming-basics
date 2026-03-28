import { useEffect, useRef, useState } from "react";
import "./style.css";
function DataTableBody({ mode, setMode, products, setProducts, isDeleting, setDeleting, setEditProductId }) {
    const [viewProducts, setViewProducts] = useState([]);
    const [checkedAll, setCheckedAll] = useState(false);

    useEffect(() => {
        if (mode === 0) {
            resetViewProducts();
            setCheckedAll(false);
        }
    }, [products, mode]);

    useEffect(() => {
        const checkStates = viewProducts.map(product => product.isChecked);
        if (checkStates.includes(false)) {
            setCheckedAll(false);
        } else {
            setCheckedAll(true);
        }
    }, [viewProducts]);

    //로컬스토리지 양식맞추기
    
    useEffect(() => {
        if (isDeleting) {
            setProducts([...viewProducts
                .filter(viewProduct => viewProduct.isChecked === false)
                .map(viewProduct => {
                    // 레스트문법
                    const { isChecked, ...product } = viewProduct;
                    return product;
                })
            ])
            setMode(0);
            setDeleting(false);
        }
    }, [isDeleting])

    const deletee = () => {
        // setproduct.map에(setviewproductlfilter isChecked 된 아이디만 가지고오기)
        setViewProducts(viewProducts.filter(({ isChecked }) => !!isChecked));
    }
    useEffect(() => {
        // 여기서 사용한 비구조 할당은 첫번째만 가지고올 거라서 인건가요
        if (mode === 2) {
            const [selectedProduct] = viewProducts.filter(product => product.isChecked);
            setEditProductId(!selectedProduct ? 0 : selectedProduct.id);
        }
    }, [viewProducts]);

    const resetViewProducts = () => {
        setViewProducts([...products.map(product => ({ ...product, isChecked: false }))]);
    }

    // 체크 속성을 넣은 viewProducts를 만듬

    const handleCheckedAllChange = (e) => {
        setCheckedAll(checked => {
            if (!checked) {
                setViewProducts([...products.map(product => ({ ...product, isChecked: true }))]);
            }
            if (checked) {
                resetViewProducts();
            }
            return !checked
        });
    }

    const handleCheckedChange = (e) => {
        if (mode === 2) {

            setViewProducts(viewProducts => {
                return [...viewProducts.map(product => {
                    if (product.id === parseInt(e.target.value)) {
                        return {
                            ...product,
                            isChecked: !product.isChecked
                        }
                    }
                    return {
                        ...product,
                        isChecked: false
                    };
                })
                ];
            })
        }


        if (mode === 3) {
            setViewProducts(viewProducts => {
                return [...viewProducts.map(product => {
                    if (product.id === parseInt(e.target.value)) {
                        return {
                            ...product,
                            isChecked: !product.isChecked
                        }
                    }
                    return product;
                })];
            })
        }
    }

    return (
        <div className="table-body">
            <table>
                <thead>
                    <tr>
                        <th><input
                            type="checkbox"
                            disabled={mode !== 3}
                            onChange={handleCheckedAllChange}
                            checked={checkedAll}
                        /></th>
                        <th>상품코드</th>
                        <th>상품명</th>
                        <th>사이즈</th>
                        <th>색상</th>
                        <th>가격</th>
                    </tr>
                </thead>
                {/* 스크롤할 때 기준을 잡아주기 위한 div */}
                <tbody>
                    {
                        viewProducts.map(product =>
                        (<tr key={product.id}>
                            <th>
                                <input
                                    type="checkbox"
                                    disabled={mode === 0 || mode === 1}
                                    onChange={handleCheckedChange}
                                    value={product.id}
                                    checked={product.isChecked} />
                            </th>
                            <td>{product.id}</td>
                            <td>{product.productName}</td>
                            <td>{product.size}</td>
                            <td>{product.color}</td>
                            <td>{product.price}</td>
                        </tr>
                        )
                        )}
                </tbody>
            </table>
        </div>
    );
}

export default DataTableBody;