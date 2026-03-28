import React, { useEffect, useState } from 'react';
import { IoIosBatteryFull, IoIosWifi } from "react-icons/io";
import { IoCellularSharp } from "react-icons/io5";

/** @jsxImportSource @emotion/react */
import MainContainer from '../MainContainer/MainContainer';
import * as s from "./style";

function MainLayout({ children }) {
    // console.log(children);

    const [clock, setClock] = useState("0:00");

    useEffect(() => {
        // setClock("0:00");
        setInterval(() => {
            const now = new Date();
            const hours = now.getHours();
            // 절삭 Math.floor
            // 분 1의자리 / 10 = 0.8 에 대한 절삭(Math.floor) = 0
            // const minutes =  Math.floor(now.getMinutes() / 10 === 0 ? "0" : "") + now.getMinutes();
            const minutes = (now.getMinutes() < 10 ? "0" : "") + now.getMinutes();

            // 오전 00:00:00
            // const localTime = now.toLocaleTimeString();
            setClock(`${hours}:${minutes}`);
        }, 1000);
    }, []);

    return (
        <div css={s.layout}>
            <div css={s.frame}>
                <div css={s.topBar}>
                    <div css={s.clock}>{clock}</div>
                    <div css={s.topBarCenter}></div>
                    <div css={s.rightItems}><IoCellularSharp /> <IoIosWifi /> <IoIosBatteryFull /></div>
                </div>
                {children}
            </div>
        </div>
    );
}

export default MainLayout;