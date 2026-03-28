const USERNAME = "admin";
const PASSWORD = "1234";
function login(username, password) {
    if (USERNAME === username && PASSWORD === password) {
        console.log("로그인 성공");
        return;
    }
    console.log("로그인 실패");
}

login("admin", "1234");

const login2 = login; // 함수 주소가 대입 됨 
login2("admin","1234");

const add2 = function add(x,y){
    return x + y;
}
console.log(add2(10,20));

// const sub2 = function sub(x,y){
//     return x - y;
// }

// 익명함수
const sub2 = function (x,y){
    return x - y;
}
console.log(sub2(20,10));
// 화살표 함수(람다)
let div = (x, y) => {
    return !x || !y ? 0 : x / y;
}
console.log(div(10,2));

//화살표 함수 (매개변수가 하나면 괄호생략가능)
div = (x,y) => !x || !y ? 0 : x / y;

console.log(div(10,2));

const print = (data) => console.log(data);
print("출력");

// 함수 안에 함수 정의할 경우 상위함수인지 구분이 어렵기 때문에 하위함수 안에서는 화살표 함수를 쓰자고 정의함
function main(){
    const test = () => {
        console.log("테스트 함수 호출");
    }
    test();
}
main();
