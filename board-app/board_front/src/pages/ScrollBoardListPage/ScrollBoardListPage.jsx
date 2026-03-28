/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';
import React, { useEffect, useRef, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { IoMdHeart } from "react-icons/io";
import { useInfiniteQuery } from 'react-query';
import { instance } from '../../apis/util/instance';
import parse from 'html-react-parser';


const layout = css`
    margin: 0 auto;
    width: 1030px;
`;

const cardLayout = css`
    display: flex;
    flex-wrap: wrap;
    border-top: 3px solid #dbdbdb;
    padding: 50px 0 0 0;
    width: 100%;
    list-style-type: none;
`
const card = css`
    display: flex;
    flex-direction: column;
    box-sizing: border-box;
    border-radius: 0 0 5px 5px;
    margin: 0 0 40px;
    width: 330px;
    height: 330px;
    box-shadow: 0 3px 5px #00000011;
    transition: all 0.3s ease-in-out;
    cursor: pointer;
    &:nth-of-type(3n-1){
        margin: 0 20px 40px;
    }

    &:hover{
        box-shadow: 0 3px 10px #00000011;
        transform: translateY(-2%);
    }

`;
const cardMain = css`
    display: flex;
    flex-direction: column;
    flex-grow: 1;
`
const cardImg = css`
    display: flex;
    justify-content: center;
    align-items: center;
    height: 170px;
    overflow: hidden;

    & > img {
        height: 100%;
    }

`
const cardCotent = (isShowImg) => css`
    display: flex;
    flex-direction: column;
    flex-grow: 1;
    padding: 10px;

    & > h3{
        margin: 0 0 4px;
        width: 100%;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
    & > div {
        display: -webkit-box;
        overflow: hidden;
        word-break: break-all;
        max-height: 60px;
        -webkit-line-clamp: ${isShowImg ? 3 : 11};
        -webkit-box-orient: vertical;
        text-overflow: ellipsis;
        & > * {
            font-size: 16px;
            font-weight: 400;
        }
    }
`
const cardFooter = css`
    box-sizing: border-box;
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-top: 1px solid #f5f5f5;
    padding: 0 15px;
    height: 50px;

    & > div:nth-of-type(1){
        display: flex;
        align-items: center;
        font-weight: 600;

        & > img {
            margin: 0 5px 0 0;
            border: 1px solid #dbdbdbdb;
            border-radius: 50%;
            width: 20px;
            height: 20px;
        }
        & > span{
            margin: 0 8px 0 0;
            font-weight: 400;
            font-size: 14px;
            color: #999999;
        }
    }
    & > div:nth-of-type(2){
        display: flex;
        align-items: center;

        & > span{
            line-height: 10px;
        }

    }
`;


// 무한스크롤 옵저버
function ScrollBoardListPage(props) {
    const navigate = useNavigate();
    const loadMoreRef = useRef(null); // 해당 ref로 업로딩 위치 지정
    const [totalPageCount, seTtotalPageCount] = useState(1);
    const pageRef = useRef(1);
    const limit = 20;

    const boardList = useInfiniteQuery( // scroll 로딩 관련 쿼리
        ["boardListQuery"],
        async ({ pageParam = 1 }) => await instance.get(`/board/list?page=${pageParam}&limit=${limit}`), // pageParam 기본값 1번으로 페이지 1번 들고옴 응답에 성공하게되면 getNextPageParam 동작 lastPage = 마지막에 응답받은 객체(dto)
        {
            getNextPageParam: (lastPage, allPage) => lastPage.nextPage ?? null, // 값이 null이거나 undefined 일 땐 ?? 뒤에값 아닐 땐 해당 값 그대로
            // useInfiniteQuery allPage에 배열로 쌓음 해서 배열의 length로 가져오면 배열의 페이지갯수와 같음
            // lastpage가 현재요청받은 객체수 ?
            // getNextPageParam이 백에서 응답받은 response로 한번 응답받은  response를 lastpage에 넣어준다 그리고 한번 더 요청 보내서 응답받으면 그다음부터 배열로 allpage에 차곡차곡 넣어줌
            /*
            getNextPageParam: (lastPage, allPage) => {
                seTtotalPageCount(lastPage.data.totalCount % limit === 0
                    ? lastPage.data.totalCount / limit                              // totalCount 계산하는 이유 마지막페이지에선 응답 가면 안되니까
                    : Math.floor(lastPage.data.totalCount / limit) + 1
                )
                return totalPageCount !== allPage.length ? allPage.length + 1 : null;   // 현재페이지수totalPageCount와 전체페이지의 길이와 같지 않다면 페이지증가, 같다면 null로 응답 안 가게 함
            },*/
            onSuccess: r => console.log(r)
        }
    )

    useEffect(() => {
        if (!boardList.hasNextPage || !loadMoreRef.current) {
            return;
        }

        const observer = new IntersectionObserver((entries) => { // 생성자 안에 콜백함수 들어감 entries는 무조건 키밸류 배열 
            if (entries[0].isIntersecting) { // 해당위치 감지되면 참
                console.log("div보임");
            }

        },
            { threshold: 1.0 }); // (콜백함수,옵션) threshold: 1.0 -> 보여지는 범위 옵션 얼마나 보이면 동작할지
        observer.observe(loadMoreRef.current); // 해당 ref가 나타나면 메서드실행됨
        return () => observer.disconnect();
    }, [boardList.hasNextPage]);


    //이미지의 src추출
    const extractSrcAttributesFromHtml = (html) => {
        const parser = new DOMParser();
        const doc = parser.parseFromString(html, 'text/html');
        const srcArray = [];

        doc.querySelectorAll('img').forEach(img => {
            srcArray.push(img.getAttribute('src'));
        });

        return srcArray;
    };


    /*
    const extractParagraphText = (html) => {
        const parser = new DOMParser();
        const doc = parser.parseFromString(html, 'text/html');

        const paragraphTexts = Array.from(doc.querySelectorAll('p')).map(p => p.textContent.trim());
        return paragraphTexts;
    };
    */



    // parser
    const extractTextFromHtml = (htmlString) => {
        const elements = parse(htmlString);

        const extractText = (elements) => {
            let text = '';

            React.Children.forEach(elements, (element) => {
                if (typeof element === 'string') {
                    text += element;
                } else if (element && element.props && element.props.children) {
                    text += extractText(element.props.children);
                }
            });

            return text;
        };

        return extractText(elements);
    };

    return (
        <div css={layout}>
            <Link to={"/"}><h1>사이트 로고</h1></Link>
            <ul css={cardLayout}>

                {/* ----------------------------------------------------------------------------------- */}
                {
                    boardList?.data?.pages.map(page => page.data.boards.map(board =>// page.data가 array 

                    {
                        // console.log(extractSrcAttributesFromHtml(board.content));
                        // console.log(board.content);

                        // console.log(parse(board.content));
                        // console.log(extractParagraphText(board.content));
                        // console.log(parse(board.content));

                        // let mainContent = board.content;
                        // while (true) {
                        //     const pIndex = mainContent.indexOf("<p>");
                        //     if (pIndex === -1) {
                        //     mainContent = "";
                        //         break;
                        //     }
                        //     mainContent = mainContent.slice(mainContent.indexOf("<p>") + 3);
                        //     if (mainContent.indexOf("<img") !== 0) {
                        //         mainContent = mainContent.slice(0, mainContent.indexOf("</p>"));
                        //     }
                        // }

                        const mainImgStartIndex = board.content.indexOf("<img");
                        // let mainImg = board.content.slice(mainImgStartIndex);
                        // mainImg.slice(0, mainImg.indexOf("/>") + 1);
                        // const mainImgSrc = mainImg.slice(mainImg.indexOf("src") + 5, mainImg.length - 2);
                        // const mainContent = board.content.slice(board.content.indexOf("<p>") + 3, board.content.indexOf("</p>"));

                        console.log(extractTextFromHtml(board.content));
                        return (
                            <li key={board.id} css={card} onClick={() => navigate(`/board/detail/${board.id}`)}>
                                <main css={cardMain}>
                                    {
                                        // mainImgStartIndex != -1 &&
                                        <div css={cardImg}>
                                            <img src={extractSrcAttributesFromHtml(board.content)} alt='' />
                                        </div>
                                    }
                                    <div css={cardCotent(mainImgStartIndex != -1)}>
                                        <h3>{board.title}</h3>
                                        <div>{extractTextFromHtml(board.content)}</div>1
                                    </div>

                                </main>

                                <footer css={cardFooter}>

                                    <div>
                                        <img src={board.writerProfileImg} alt="" />
                                        <span>by</span>
                                        {board.writerName}
                                    </div>

                                    <div>
                                        <IoMdHeart />
                                        <span>10</span>
                                    </div>
                                </footer>
                            </li>
                        )
                    }
                    ))
                }

                {/* ----------------------------------------------------------------------------------- */}

            </ul>
            <div ref={loadMoreRef}></div>
        </div>
    );
}

export default ScrollBoardListPage;