/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';
import { Link, useNavigate, useSearchParams } from 'react-router-dom';
import { IoMdArrowDropleft, IoMdArrowDropright } from "react-icons/io";
import ReactPaginate from 'react-paginate';
import { useState } from 'react';
import { useQuery } from 'react-query';
import { instance } from '../../../apis/util/instance';
import { RingLoader } from 'react-spinners';

const paginateContainer = css`
    & > ul {
        list-style-type: none;
        display: flex;
        & > li{
            margin: 0 5px;
        }
            &  a{
            box-sizing: border-box;
            display: flex;
            justify-content: center;
            align-items: center;
            border: 1px solid #dbdbdb;
            border-radius: 30px;
            padding: 0 10px;
            min-width: 32px;
            height: 30px;
            font-size: 12px;
            font-weight: 600;
            cursor: pointer;
                /* line-height: ; */
            }
            & .active{
                border-radius: 32px;
                background-color: #bbbbbb;
                color: #ffffff;
            }
        }
        
        & > :nth-of-type(1){
            /* border: none; */
            
        }
        & > :nth-last-of-type(1){
            /* border: none; */
        }
`

function SearchBoardPage(props) {
    const navigate = useNavigate();
    const [searchParams, setSearchParams] = useSearchParams();
    const [totalPageCount, setTotalPageCount] = useState(1);
    const [searchValue, setSearchValue] = useState(searchParams.get("search") ?? "");
    const [searchOption, setSearchOption] = useState(searchParams.get("option") ?? "all");
    const limit = 10;

    const boardList = useQuery(
        ["boardListQuery", searchParams.get("page"), searchParams.get("option"), searchParams.get("search")],
        async () => await instance.get(`/board/search?page=${searchParams.get("page")}&limit=${limit}&search=${searchValue}&option=${searchOption}`),
        {
            retry: 0,
            onSuccess: r => setTotalPageCount(
                r.data.totalCount % limit === 0
                    ? r.data.totalCount / limit
                    : Math.floor(r.data.totalCount / limit) + 1)
        }
    )


    const handleSearchInputOnChange = (e) => {
        setSearchValue(e.target.value);
    }
    const handleSearchOptionOnChange = (e) => {
        setSearchOption(e.target.value)
    }
    const handleSearchButtonOnClick = () => {
        navigate(`/board/search?page=1&option=${searchOption}&search=${searchValue}`);
    }
    const handlePageOnChange = (e) => {
        navigate(`/board/search?page=${e.selected + 1}&option=${searchOption}&search=${searchValue}`);
    }

    return (
        <>
            <Link to={"/"}><h1>사이트 로고</h1></Link>
            <div>
                <div>
                    <select onChange={handleSearchOptionOnChange}>
                        <option value="all">전체</option>
                        <option value="title">제목</option>
                        <option value="writer">작성자</option>
                    </select>
                </div>
                <input type="search" onChange={handleSearchInputOnChange} value={searchValue} />
                <button onClick={handleSearchButtonOnClick}>검색</button>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>추천</th>
                        <th>조회</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        // 4번
                        boardList.isLoading
                            ?
                            <RingLoader />
                            :
                            // 5번
                            boardList?.data?.data.boards?.map(board =>
                                <tr key={board.id} onClick={() => navigate(`/board/detail/${board.id}`)}>
                                    <td>{board.id}</td>
                                    <td>{board.title}</td>
                                    <td>{board.writerName}</td>
                                    <td>{board.likeCount}</td>
                                    <td>{board.viewCount}</td>
                                </tr>
                            )
                    }
                </tbody>
            </table >
            <div css={paginateContainer}>
                <ReactPaginate
                    breakLabel="..."
                    previousLabel={<IoMdArrowDropleft />}
                    nextLabel={<IoMdArrowDropright />}
                    pageCount={totalPageCount}
                    renderOnZeroPageCount={null}
                    marginPagesDisplayed={2}
                    pageRangeDisplayed={5}
                    activeClassName='active'
                    onPageChange={handlePageOnChange} // 1번동작
                    forcePage={parseInt(searchParams.get("page")) - 1}
                // 파라미터(주소창)에서 가지고온 것과 현재 페이지를 동기화시켜주려고하는 것
                // 페이지번호 -1을 해준 이유는 페이지 리스트가 index로 인식
                />
            </div>

        </>
    );
}

export default SearchBoardPage;