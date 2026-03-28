import React, { useEffect, useRef, useState } from 'react';
/** @jsxImportSource @emotion/react */
import RegisterModal from '../RegisterModal/RegisterModal';
import * as s from "./style";

function MainContainer({ children }) {
    const [modalElement, setModalElement] = useState(<></>);
    const containerRef = useRef();
    /*
        const [scroll, setScroll] = useState({
            startY: 0,
            isDown: false
        });
    
        const handleDown = useCallback((e) => setScroll({
            starY: e.clientY,
            isDown: true
        }), []);
    
        const handleUp = useCallback((e) => setScroll({
            starY: 0,
            isDown: false
        }), []);
    
        const handleMove = (e) => {
            if (scroll.isDown) {
                const MAX_TOP = containerRef.current.scrollHeight - containerRef.current.offsetHeight;
                const MIN_TOP = 0;
                // console.log(e.clientY - scroll.starY)
                if (moveY < MIN_TOP) {
    
                }
                const moveY = e.clientY - scroll.startY < MAX_TOP && e.clientY - scroll.startY
                    ? e.clientY - scroll.startY
                    : moveY;
    
                // console.log({ s: containerRef.current });
    
                const scrollTop = containerRef.current.scrollTop; // 현재 스크롤 제일 위
                containerRef.current.scrollTop = scrollTop + (moveY * (-1));
            };
        }
            *
    
        // client hegiht -> 전체높이
        // e.clientY 현재높이
        // scrollHeight -> 스크롤길이
        // 전체길이 - 스크롤 높이 
    
        // onMouseMove={handleMove}
        // onMouseDown={handleDown}
        // onMouseUp={handleUp}
    */
    useEffect(() => {
        if (!!containerRef) {
            setModalElement(<RegisterModal containerRef={containerRef} />)
        }
    }, [containerRef]);
    return (
        <div css={s.container} ref={containerRef}>
            {modalElement}
            {children}
        </div>
    );
}

export default MainContainer;