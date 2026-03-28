import { instance } from "../utils/instance";

export async function getTodoAllApi() {
    let response = null;
    try {
        response = await instance.get("/todolist");
    } catch (e) {
        console.log(e)
        response = e.response;
    }
    return response
}
export async function getTodoCountsApi() {
    let response = null;
    try {
        response = await instance.get("/todo/counts");
    } catch (e) {
        console.log(e)
        response = e.response;
    }
    return response;
}

export const SAMPLE_LIST = [
    { DateTime: "2022-08-02 15:27:00" },
    { DateTime: "2024-08-08 17:33:00" },
    { DateTime: "2024-07-09 11:09:00" },
    { DateTime: "2022-06-09 14:19:00" },
    { DateTime: "2024-08-09 14:19:00" },
    { DateTime: "2023-05-09 14:19:00" },
    { DateTime: "2024-08-09 14:19:00" },
    { DateTime: "2021-02-09 14:20:00" },
    { DateTime: "2020-08-09 14:21:00" }
]








