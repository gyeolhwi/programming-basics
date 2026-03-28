import { instance } from "./util/instance"

export const signupAPi = async (user) => {
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
        const response = await instance.post("/auth/signup", user);
        signupData = {
            isSuccess: true,
            ok: response.data
        }
    } catch (e) {
        console.error(e);
        const response = e.response;
        console.log(response);
        // getFieldErrors 로 배열이 들어옴
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

export const signinApi = async (user) => {
    let signinData = {
        isSuccess: false,
        token: null,
    }

    try {
        const response = await instance.post("/auth/signin", user);
        signinData = {
            isSuccess: true,
            token: response.data,
        }
    } catch (e) {
        const response = e.response;
        // getFieldErrors 로 배열이 들어옴
        signinData = {
            isSuccess: false,
        }

        if (typeof (response.data) === 'string') {
            signinData['errorStatus'] = "loginError";
            signinData['error'] = response.data;
        } else {
            signinData['errorStatus'] = "fieldError";
            signinData['error'] = response.data.map(fieldError => ({
                field: fieldError.field,
                defaultMessage: fieldError.defaultMessage
            }))
        }
    }
    return signinData;

}