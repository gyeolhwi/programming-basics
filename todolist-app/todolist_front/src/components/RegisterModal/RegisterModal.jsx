import React, { useState } from 'react';
import ReactModal from 'react-modal';
/** @jsxImportSource @emotion/react */
import { useRecoilState } from 'recoil';
import { registerModalAtom } from '../../atoms/modalAtoms';
import RegisterTodo from '../RegisterTodo/RegisterTodo';
ReactModal.setAppElement("#root");
function RegisterModal({ containerRef }) {
    const [isOpen, setOpen] = useRecoilState(registerModalAtom);
    const [animation, setAnimation] = useState("registerModalContentOpen");
    
    const closeModal = () => {
        setAnimation("registerModalContentClose");
        setTimeout(() => {
            setAnimation("registerModalContentOpen")
            setOpen(false);
        }, 500);
    }
    return (
        <ReactModal
            style={{
                // 뒷배경
                overlay: {
                    position: "absolute",
                    backgroundColor: "transparent",
                },
                // 가운데박스
                content: {
                    inset: "auto 0 0",
                    boxSizing: "border-box",
                    borderRadius: "10px",
                    padding: "0",
                    width: "100%",
                    height: "80%",
                    animation: `${animation} 0.6s 1`,
                    animationTimingFunction: "ease-in-out"
                },
            }}
            isOpen={isOpen}
            onRequestClose={closeModal}
            ariaHideApp={false}
            parentSelector={() => containerRef.current}
        >
            <RegisterTodo closeModal={closeModal} />
        </ReactModal >
    );
}

export default RegisterModal;