/** @jsxImportSource @emotion/react */
import React from 'react';
import { FaBars } from "react-icons/fa";
import { useRecoilState } from 'recoil';
import { mainSidebarShowAtom } from '../../atoms/mainSidebarShowAtom';
import MainContainer from '../MainContainer/MainContainer';
import * as s from './style';


function MainHeader() {
    const [a, b] = useRecoilState(mainSidebarShowAtom);

    const handleMainMenuToggleClick = () => {
        b(true);
    }
    return (
        <div css={s.layout}>
            <MainContainer>
                <div css={s.headerBody}>
                    <button onClick={() => { b(true) }}><FaBars /></button>
                </div>
            </MainContainer>
        </div>
    );
}

export default MainHeader;