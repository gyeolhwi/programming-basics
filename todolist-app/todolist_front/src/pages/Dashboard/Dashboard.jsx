import React, { useEffect } from 'react';
/** @jsxImportSource @emotion/react */
import { Route, Routes } from 'react-router-dom';
import DateTitle from '../../components/Dashboard/DateTitle/DateTitle';
import MenuList from '../../components/Dashboard/MenuList/MenuList';
import Search from '../../components/Dashboard/Search/Search';
import MainContainer from '../../components/MainContainer/MainContainer';
import RegisterTodoButton from '../../components/RegisterTodoButton/RegisterTodoButton';
import * as s from "./style";
import { useRecoilState, useSetRecoilState } from 'recoil';
import { refreshTodoListAtom, todolistAtom } from '../../atoms/todolistAtoms';
import { getTodoAllApi, getTodoCountsApi } from '../../apis/todoApis/getTodoApi';
import TodoAll from '../TodoAll/TodoAll';

function Dashboard(props) {
    const setTodoListAll = useSetRecoilState(todolistAtom);
    const [refresh, setRefresh] = useRecoilState(refreshTodoListAtom);


    const requestTodolist = async () => {
        const todolist = await getTodoAllApi();
        const counts = await getTodoCountsApi();
        setTodoListAll(({
            todolist: todolist?.data,
            counts: counts?.data
        }))
    }

    useEffect(() => {
        if (refresh) {
            requestTodolist();
        }
        setRefresh(false);
    }, [refresh])

    return (
        <MainContainer>
            <div css={s.layout}>
                <header >
                    <Search />
                </header>
                <main>
                    <DateTitle />
                    <MenuList />
                </main>
                <footer>
                    <RegisterTodoButton />
                </footer>
            </div>
            <Routes>
                <Route path="/all" element={<TodoAll />} />
            </Routes>
        </MainContainer>
    );
}

export default Dashboard;