import React from 'react';
/** @jsxImportSource @emotion/react */
import * as s from "./style";
import { FaCirclePlus } from "react-icons/fa6";
import { useSetRecoilState } from 'recoil';
import { registerModalAtom } from '../../atoms/modalAtoms';


function RegisterTodoButton(props) {
    const setOpen = useSetRecoilState(registerModalAtom);

    const handleModalOpenClick = () => {
        setOpen(true);
    }
    return (
        <button css={s.layout} onClick={handleModalOpenClick}>
            <FaCirclePlus/>
            <span> 아따라시이 모노 </span>
        </button>
    );
}

export default RegisterTodoButton;