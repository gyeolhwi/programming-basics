import { instance } from "./util/instance";

export const oauth2MergeApi = async (user) => {
    let mergeData = {
        isSuccess: false,
        fieldErrors: [
            {
                field: "",
                defaultMessage: ""
            }
        ]
    }

    try {
        const response = await instance.post("/auth/oauth2/merge", user);
        mergeData = {
            isSuccess: true,
        }
    } catch (e) {
        const response = e.response;

        mergeData = {
            isSuccess: false,
        }

        if (typeof (response.data) === 'string') {
            mergeData['errorStatus'] = "loginError";
            mergeData['error'] = response.data;
        } else {
            mergeData['errorStatus'] = "fieldError"; // 빈칸오류
            mergeData['error'] = response.data.map(fieldError => ({
                field: fieldError.field,
                defaultMessage: fieldError.defaultMessage
            }))
        }
    }

    return mergeData;
}

export const oauth2SignupApi = async (user) => {
    let signupData = {
        isSuccess: false,
        ok: {
            message: "",
            user: null
        },
        fieldErrors: [
            {
                field: "",
                defaultMessage: ""
            }
        ]
    }

    try {
        const response = await instance.post("/auth/oauth2/signup", user);
        signupData = {
            isSuccess: true,
            ok: response.data
        }
    } catch (e) {
        const response = e.response;
        signupData = {
            isSuccess: false,
            fieldErrors: response.data.map(fieldError => ({
                field: fieldError.field,
                defaultMessage: fieldError.defaultMessage
            }))
        }
    }
    return signupData;
}