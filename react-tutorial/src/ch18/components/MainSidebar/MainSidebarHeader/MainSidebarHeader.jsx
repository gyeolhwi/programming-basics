/** @jsxImportSource @emotion/react */
import React from 'react';
import * as s from './style';
import MainContainer from '../../MainContainer/MainContainer';
import { FaBars, FaBook, FaHome } from 'react-icons/fa';
import { mainSidebarShowAtom } from '../../../atoms/mainSidebarShowAtom';
import { useRecoilState } from 'recoil';

function MainSidebarHeader() {
    const [mainSidebarShow, setMainSidebarShow] = useRecoilState(mainSidebarShowAtom);


    const handleMainMenuToggleClick = () => {
        setMainSidebarShow(false);
    }
    return (
        <div css={s.layout}>
            <MainContainer>
                <div css={s.header}>
                    <h1 css={s.title}>
                        <FaBook />
                        <span>수업자료</span>
                    </h1>
                    <button onClick={handleMainMenuToggleClick}><FaBars /></button>
                </div>
            </MainContainer>

        </div>
    );
}

export default MainSidebarHeader;