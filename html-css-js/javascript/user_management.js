const print = (data) => console.log(data);
// inputMode = 1 -> 추가 2 -> 수정
let inputMode = 1;


let userList = [];
loadUserList();
// const lsTextList = localStorage.getItem("users");
// let userList = !lsTextList ? [] : JSON.parse(lsTextList);


let emptyUser = {
    id: 0,
    username: "",
    name: "",
    password: ""
};
let user = {
    ...emptyUser
}

function renderTable() {
    const userTableBody = document.querySelector(".user-table-body");
    userTableBody.innerHTML = userList.map(({ name, id, username, password }, i) => {
        return `
        <tr>
            <th><input type="checkbox" onclick="handleUserCheck(event)" value="${id}"></th>
            <td>${i + 1}</td>
            <td>${id}</td>
            <td>${name}</td>
            <td>${username}</td>
            <td>${password}</td>
            <th><button onclick="deleteUser(event)" value="${id}">삭제</button></th>
        </tr>
        `;
    }).join(""); // ,기호 들어가서 기본적인 세팅을 공백으로 맞춰주는 것
}

function handleUserInputKeyDown(e) {
    user = {
        ...user,
        [e.target.name]: e.target.value
    }
    print(user);
    if (e.keyCode === 13) {
        const usernameInput = document.querySelector(".username-input");
        const passwordInput = document.querySelector(".password-input");
        const name = document.querySelector(".name-input");

        getNewId();


        if (e.target.name === "name") {
            usernameInput.focus();
        }
        if (e.target.name === "username") {
            passwordInput.focus();
        }
        if (e.target.name === "password") {

            if (inputMode === 1) {
                // const newUser = {
                //     ...user,
                //     id: getNewId()
                // }
                userList = [...userList, { ...user, id: getNewId() }];
            }
            if (inputMode === 2) {
                let findIndex = -1;
                for (let i = 0; i < userList.length; i++) {
                    if (userList[i].id === user.id) {
                        findIndex = i;
                        break;
                    }
                }
                if (findIndex === -1) {
                    alert("사용자 정보 수정 중 오류 발생 관리자에게 문의하세요");
                    return;
                }
                userList[findIndex] = user;
            }
            // 스프레드 쓴 이유 객체의 주소가 같으면 
            // 즉 , 동일한 주소값이 들어갈 때 새로운객체로 넣어주기위해서


            saveUserList();
            // localStorage.setItem("users", JSON.stringify(userList));

            renderTable();
            clearInputValue();


            name.focus();

        }
    }
    print(e.target.name);
}

function saveUserList() {
    localStorage.setItem("userList", JSON.stringify(userList));
}

function loadUserList() {
    const lsUserList = localStorage.getItem("userList");
    userList = !lsUserList ? [] : JSON.parse(lsUserList);
    renderTable();
}

function deleteUser(e) {
    userList = userList.filter(({ id }) => id !== parseInt(e.target.value));
    saveUserList();
    renderTable();

}

function getNewId() {
    const userIds = userList.map(user => user.id).sort();
    const maxUserId = userIds.length === 0 ? 20240000 : Math.max.apply(null, userIds);
    return maxUserId + 1;
}

// function handleUserCheck(e) {
//     // const checkedList = document.querySelectorAll("input");
//     const checkBoxList = document.querySelectorAll(`input[type="checkbox"]`);

//     for (let i = 0; i < checkBoxList.length; i++) {
//         const checkBox = checkBoxList[i];
//         if (checkBox === e.target) {
//             continue;
//         }
//         checkBox.checked = false;
//     }
//     renderInput();
// }

function handleUserCheck(e) {
    const checkedList = document.querySelectorAll("input");
    for (let checkBox of checkedList) {
        if (checkBox === e.target) {
            continue;
        }
        checkBox.checked = false;
    }
    if (e.target.checked) {
        inputMode = 2;
        const [findUser] = userList.filter(user => user.id === parseInt(e.target.value));
        setInputValue(findUser);
        user = {
            ...findUser,
        }
        return;
    }
    clearInputValue();
}


function setInputValue(user) {
    const nameInput = document.querySelector(".username-input");
    const usernameInput = document.querySelector(".password-input");
    const passwordInput = document.querySelector(".name-input");


    // const findeUser = userList.filter(user => user.id === id)[0];
    nameInput.value = user.name;
    usernameInput.value = user.username;
    passwordInput.value = user.password;


}
function clearInputValue() {
    const nameInput = document.querySelector(".name-input");
    const usernameInput = document.querySelector(".username-input");
    const passwordInput = document.querySelector(".password-input");

    nameInput.value = emptyUser.name;
    usernameInput.value = emptyUser.username;
    passwordInput.value = emptyUser.password;

    inputMode = 1;
    user = {
        ...emptyUser
    }

//     // 공백처리
//     usernameInput.value = emptyUser.username;
//     name.value = emptyUser.name;
//     passwordInput.value = emptyUser.password;
}