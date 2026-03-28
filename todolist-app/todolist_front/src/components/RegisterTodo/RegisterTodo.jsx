import React, { useEffect, useState } from 'react';
/** @jsxImportSource @emotion/react */
import ReactSelect from 'react-select';
import * as s from "./style";
import { addTodoApi } from '../../apis/todoApis/addTodoApi';
import { refreshTodoListAtom } from '../../atoms/todolistAtoms';
import { useRecoilState } from 'recoil';

function RegisterTodo({ closeModal }) {
    const [todo, setTodo] = useState({
        title: "",
        content: "",
        dateTime: "",
        important: 1,
        busy: 1
    });

    const [refresh, setRefresh] = useRecoilState(refreshTodoListAtom);
    useEffect(() => {
        const parse = (value) => (value < 10 ? "0" : "") + value;
        const now = new Date();
        const year = now.getFullYear();
        const month = parse(now.getMonth() + 1);
        const day = parse(now.getDate());
        const hours = parse(now.getHours());
        const minutes = parse(now.getMinutes());

        console.log(now);

        console.log(now.getFullYear());
        console.log(now.getMonth());
        console.log(now.getDate());
        console.log(now.getHours());
        console.log(now.getMinutes());
        setTodo(todo => ({
            ...todo,
            dateTime: `${year}-${month}-${day}T${hours}:${minutes}`
        }))

    }, []);
    const handleOnChange = (e) => {
        setTodo(todo => ({
            ...todo,
            [e.target.name]: e.target.value
        })
        );
        console.log(e);
    }
    const importantOptions = [
        { label: "⭐", value: 1, target: { name: "important", value: 1 } },
        { label: "☆", value: 2, target: { name: "important", value: 2 } }
    ]
    const busyOptions = [
        { label: "🚄", value: 1, target: { name: "busy", value: 1 } },
        { label: "🦼", value: 2, target: { name: "busy", value: 2 } }
    ]

    const handleSubmitClick = (e) => {
        addTodoApi(todo);
        setRefresh(true);
        closeModal();
    }
    const handle = (e) => {
        console.log(e.content);
    };


    return (
        <div css={s.layout} >
            <header>
                <button onClick={closeModal}>취소</button>
                <h2>새로운 할 일</h2>
                <button onClick={handleSubmitClick} disabled={!todo.title.trim() || !todo.content.trim()}>추가</button>
            </header>

            <main>
                <div css={s.todoDataBox}>
                    <input type="text" name='title' placeholder='제목' onChange={handleOnChange} value={todo.title} />
                    <textarea name="content" id="" placeholder='내용' onChange={handleOnChange} vlaue={todo.content}></textarea>
                </div>
                <div css={s.dateSelect}>
                    <input type="datetime-local" name='dateTime' onChange={handleOnChange} value={todo.dateTime} />
                </div>
                <div css={s.importantSelect} >
                    <div onClick={handle} >hi</div>
                    <ReactSelect
                        onChange={handleOnChange}
                        styles={{
                            control: (style) => ({
                                ...style,
                                border: "none",
                                borderRadius: "0",
                                outline: "none",
                                boxShadow: "none",
                            })
                        }}
                        options={importantOptions}
                        value={importantOptions.filter(option => option.value === todo.important)[0]}
                    />
                    <hr style={{ width: "100%", border: "1px solid #dbdbdb" }} />
                    <ReactSelect
                        onChange={handleOnChange}
                        styles={{
                            control: (style) => ({
                                ...style,
                                border: "none",
                                outline: "none",
                                boxShadow: "none"
                            })
                        }}
                        options={busyOptions}
                        value={busyOptions.filter(option => option.value === todo.busy)[0]}
                    />
                </div>
            </main>

        </div>
    );
}

export default RegisterTodo;