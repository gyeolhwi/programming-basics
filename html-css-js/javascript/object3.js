function modifyUser(user, target, value) {
    const newUser = {
        ...user, // 객체 안에 들어있는 값들만 복사가됨
        // 타겟이름 : value
        // [target]에 들어있는 이름을 key값으로 쓰겠다고 하는 것
        [target]: value
    };
    return newUser;
}


function main() {
    let user = {
        username: "admin",
        password: "1234"
    }
    // delete user.password;

    console.log(user);
    const newUser = modifyUser(user, "username", "test-user");
    console.log(newUser);
    const newUser2 = modifyUser(newUser, "password", "1111");
    console.log(newUser2);


    const userList = [user, newUser];
    const newUserList = [...userList, newUser2];  // 값만 복사 

    // 스프레드 -> 깊은 복사
    const userList2 = userList; // 얕은복사(주소같음)
    // user,newUser
    const [a, b, c] = newUserList;
    // const {username, password} = newUserList[0]; // => newUserList[0] = a 랑 같음
    console.log(newUserList[0]);
    }
main();