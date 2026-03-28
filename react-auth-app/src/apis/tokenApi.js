/*
import { instance } from "./util/instance"

export const getTokenApi = async() =>{
    let response = null;
    try {
        response = await instance.get("/auth/access",{
            params:{
                accessToken:localStorage.getItem("accessToken")
            }
        });
    } catch (e) {
        console.error(e);
    }
    return response
}
    */