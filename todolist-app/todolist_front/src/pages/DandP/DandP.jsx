/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';
import React from 'react';

const parent = css`
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    /* align-content: center; */
    align-items: center;
    box-sizing: border-box;
    margin: 0px auto;
    border: 1px solid #dbdbdb;
    padding: 10px;
    width: 800px;
    height: 400px;
`;
const parent2 = css`
    display: flex;
    align-items: center;
    box-sizing: border-box;
    border: 1px solid #dbdbdb;
    padding: 10px;
    width: 800px;
    height: 400px;
`;

const child = css`
    box-sizing: border-box;
    border: 4px solid red;
    width: 150px;
    height: 50px;
    background-color: white;

    &:nth-of-type(1){
        align-self: flex-start;
        background-color: pink;
    }
    &:nth-of-type(3){
        /* align-self: flex-end; */
        background-color: pink;
    }
    &:nth-of-type(5){
        align-self: flex-start;
        background-color: pink;
    }
`;
const inputbox =css`
    position: relative;
`;
const input = css`
    box-sizing: border-box;
    width: 300px;
    height: 50px;
    padding-right: 70px;

    & + button{
        position: absolute;
        right : 10px;
        top: 50%;
        transform: translateY(-50%);
    }
`;

const child2 = css`
    box-sizing: border-box;
    border: 4px solid blue;
    width: 300px;
    height: 100%;
    flex-shrink: 0;

    &:nth-of-type(1){
        background-color: yellow;
        flex-shrink: 1;
    }
    &:nth-of-type(2){
        background-color : green;
        flex-shrink: 1;
    }
    &:nth-of-type(3){
        background-color :purple;
        flex-shrink: 1;
    }
`;

function DandP(props) {
    return (
        <>
            <div css={parent}>
                <div css={child}>1</div>
                <div css={child}>2</div>
                <div css={child}>3</div>
                <div css={child}>4</div>
                <div css={child}>5</div>
                <div css={inputbox}>
                    <input type="text" css={input} />
                    <button>button</button>
                </div>
            </div>
            <div css={parent2}>
                <div css={child2}>1</div>
                <div css={child2}>2</div>
                <div css={child2}>3</div>

            </div>
        </>
    );
}

export default DandP;