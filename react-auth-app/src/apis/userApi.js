import { instance } from "./util/instance";

export const updateProfileImgApi = async (img) => {
    let response = null;

    try {
        response = await instance.patch("/user/img", { img });
    } catch (e) {
        console.error(e);
        response = e.response;
    }
    return response;
}