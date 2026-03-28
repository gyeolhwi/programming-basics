import { Global } from "@emotion/react";
import { Route, Routes } from "react-router-dom";
import DandP from "./pages/DandP/DandP";
import Dashboard from "./pages/Dashboard/Dashboard";
import Join from "./pages/Join/Join";
import Login from "./pages/Login/Login";
import NotFound from "./pages/NotFound/NotFound";
import { reset } from "./styles/common";
import MainLayout from "./components/MainLayout/MainLayout";
import { SAMPLE_LIST } from "./apis/todoApis/getTodoApi";
import { GiKlingon } from "react-icons/gi";
import { useEffect } from "react";
import Note from "./pages/Note/Note";
import MainContainer from "./components/MainContainer/MainContainer";


function App() {
    let monthList = [];

    useEffect(() => {
        const obj = [
            ["a", {
                "test1": 40,
                "test2": 50,
                "test3": 60,
            }],

            ["b", {
                "test4": 50,
                "test5": 60,
                "test6": 70,
            }]
        ]

        const obj2 = {
            "a": {
                "test1": 40,
                "test2": 40,
                "test3": 40,
                "test4": {
                    "test4-1": 90,
                    "test4-2": 80,
                    "test4-3": 70,
                }
            },
            "b": {
                "test5": 50,
                "test6": 50,
                "test7": 50,
                "test8": 50,
            }
        }
        // console.log(obj2["a"]);

        console.log("");
        const obj22 = Object.entries(obj2);
        const obj33 = obj22[0];

        console.log(obj33[1]["test4"]);

        // console.log(obj33); 

        const objList = (Object.entries(obj));
        // console.log(objList);
        for (let o of objList) {
            const key = o[0];
            const value = Object.entries(o[1]);

            // console.log("key: " + key);
            // console.log("value: " + value);
            for (let e of value) {
                const key2 = e[0]
                const value2 = e[1]

                // console.log("key2: " + key2);
                // console.log("value2: " + value2);
            }
        }

    });

    const handle = () => {
        // console.log(SAMPLE_LIST[0]);
        // console.log(SAMPLE_LIST[0].DateTime);
        /*
        {2024:{1:{
            todoId:1,
            text : "hi"}
            }
            }
            */
        // let month = new Date(SAMPLE_LIST[2].DateTime);

        const calendarDate = {};

        for (let mm of SAMPLE_LIST) {
            let date = new Date(mm.DateTime);

            if (!calendarDate[date.getFullYear()]) {
                calendarDate[date.getFullYear()] = {};
            }
            if (!calendarDate[date.getFullYear()][date.getMonth() + 1]) {
                calendarDate[date.getFullYear()][date.getMonth() + 1] = [];
            }

            calendarDate[date.getFullYear()][date.getMonth() + 1].push({ nice: 1 });
        }
        // console.log(calendarDate);
    }

    return (
        <>
            <Global styles={reset} />
            <button onClick={handle}>button</button>
            <MainLayout>
                <Routes>
                    <Route path="/todo/*" element={<Dashboard />} />
                    <Route path="/login" element={<Login />} />
                    <Route path="/join" element={<Join />} />
                    <Route path="*" element={<NotFound />} />
                    <Route path="/dp" element={<DandP />} />
                    <Route path="/note" element={<MainContainer><Note /></MainContainer>} />
                </Routes>
            </MainLayout>
        </>
    );
}

export default App;