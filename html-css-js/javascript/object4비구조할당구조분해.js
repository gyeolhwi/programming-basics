// 비구조할당 , 구조분해
function main() {
    const user = {
        username: "admin",
        password: "1234",
        name: "김결휘",
        email: "aaa@gmail.com"
    }
    const names = ["박현주", "이성희", "권오광", "권혁진"];
    console.log(names.slice(1, 3)); // >>> 이성희~권오광

    const { username, password, email } = user;
    console.log(username);
    console.log(password);
    console.log(email);

    const [a, b, ...rest1] = names;
    console.log(a);
    console.log(b);
    console.log(rest1);

    // 제외 스프레드형식으로 해당 변수를 가지고옴
    const { name, ...rest } = user;
    console.log(rest);
}

main();