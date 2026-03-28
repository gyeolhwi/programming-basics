import React, { useEffect, useState } from 'react';
import { useRecoilState } from 'recoil';
import { todolistAtom } from '../../atoms/todolistAtoms';
import BackButtonTop from '../../components/BackButtonTop/BackButtonTop';
import MainContainer from '../../components/MainContainer/MainContainer';
import PageAnimationLayout from '../../components/PageAnimationLayout/PageAnimationLayout';
import PageTitle from '../../components/PageTitle/PageTitle';
import RegisterTodoButton from '../../components/RegisterTodoButton/RegisterTodoButton';
import TodoCalendar from '../../components/TodoCalendar/TodoCalendar';
import { MENUS } from '../../constants/menus';
/** @jsxImportSource @emotion/react */
import * as s from "./style";


function TodoAll(props) {
    const [isShow, setShow] = useState(true);
    const [todolistAll] = useRecoilState(todolistAtom);
    const [calendarData, setCalendarData] = useState({});



    /**/
    useEffect(() => {
        // const preYears =  todolistAll.todolist.map(todo => todo.todoDateTime.slice(0,4));
        const tempCalendarData = {};
        for (let todo of todolistAll.todolist) {
            const dateTime = todo.todoDateTime;
            const year = dateTime.slice(0, 4);
            const month = dateTime.slice(5, 7);
            // const date = new Date().getTime(dateTime);
            const date = dateTime.slice(10);

            if (!tempCalendarData[year]) {
                //key - value = undefined
                tempCalendarData[year] = {};
            }
            if (!tempCalendarData[year][month]) {
                tempCalendarData[year][month] = {};
            }
            if (!tempCalendarData[year][month][date]) {
                tempCalendarData[year][month][date] = [];
            }
            tempCalendarData[year][month][date].push(todo);
        }
        setCalendarData(tempCalendarData);

        // const calendarDateEntries = Object.entries(calendarData);
        // setCalendar(<YearGroup calendarData={calendarData} />);

        /*
        setCalendar(calendarDateEntries.map((entry) => {
            const yearText = entry[0];
            const monthEntries = Object.entries(entry[1]);
            return (
                <li>
                    <h2>{yearText}년</h2>
                    <ul>
                        {
                            monthEntries.map(monthEntry => {
                                const monthText = monthEntry[0];
                                const todos = monthEntry[1];
                                return <li>
                                    <h3>{monthText}월</h3>
                                    <ul>
                                        {
                                            todos.map(todo => {
                                                return <li>
                                                    <h4>{todo.title}</h4>
                                                    <div>
                                                        <input type="checkbox" checked={todo.status === 2} />
                                                        <div>
                                                            <code>{todo.content}</code>
                                                            <p>{todo.todoDateTime}</p>
                                                            <p>{todo.important},{todo.busy}</p>
                                                        </div>
                                                    </div>
                                                </li>
                                            })
                                        }
                                    </ul>
                                </li>
                            })
                        }
                    </ul>
                </li>
            )
        }));
        */
    }, [todolistAll]);
    /**/

    return (
        <PageAnimationLayout isShow={isShow} setShow={setShow}>
            <MainContainer>
                <div css={s.layout}>
                    <BackButtonTop setShow={setShow} />
                    <PageTitle title={MENUS.all.title} color={MENUS.all.color} />
                    <TodoCalendar calendarData={calendarData} />
                    <RegisterTodoButton />
                </div>
            </MainContainer>
        </PageAnimationLayout>
    );
}

export default TodoAll;