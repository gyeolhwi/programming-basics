import { css } from "@emotion/react";

export const reset = css`
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap');
    html, body, #root{
        *{
            font-family: "Noto Sans KR", sans-serif;
            /* font-optical-sizing: auto; */
            font-weight: 400;
            /* font-style: normal; */
            font-size: 16pxs;
        }
        position: relative;
        margin: 0;
        padding: 0;
        height: 100%;
        background-color: #555555;
    }
    h1, h2, h3, p, ul{
        margin: 0;
        padding: 0;
    }
    ul, ol{
        list-style-type: none;
    }
    button{
        border: none;
        padding: 10px 20px;
        color: #087fff;
        background-color: transparent;
        cursor: pointer;

        &:active{
            background-color: transparent;
        }
        &:disabled{
            color: #087fff40;
            background-color: transparent;
            cursor: default;
        }

        /* .ReactModal_Overlay{
            background-color: transparent !important;
        } */
            @keyframes registerModalContentOpen{
                from{
                    inset: auto 0 -650px;
            }
            to{
                inset: auto 0 0;
            }

            }
            @keyframes registerModalContentClose {
            from{
                inset: auto 0 0;
           
            }
            to{
                inset: auto 0 -650px;
            }

        }

    }
`;