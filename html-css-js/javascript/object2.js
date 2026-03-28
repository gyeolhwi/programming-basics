function createUser(username, password, name, email) {
    // 객체로 반환해주기
    return {
        "username" : username,
        "password" : password,
        "name" : name,
        "email" : email
    }

}


function createUser2(username, password, name, email) {
    return {
        ["username"] : username,
        ["password"] : password,
        ["name"] : name,
        ["email"] : email
    }

}
// key value 변수명이 같을 땐 기입안해줘도 됨
function createUser3(username, password, name, email) {
    return {
        username,
        password,
        name,
        email
    }

}
function main() {
    const username = "admin";
    const password = "1234";
    const name = "김결휘";
    const email = "aaa@gmail.com";

    let user = createUser(username, password, name, email);
    let user2 = createUser2(username, password, name, email);
    let user3 = createUser3(username, password, name, email);
    
    console.log(user);
    console.log(user2);
    console.log(user3);

}
main();