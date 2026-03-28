function add(x,y){
    console.log("1번째 함수 호출");
    return x + y;
}


console.log("호출 전 출력");
const result = add(10,20);
console.log("호출 후 출력");
// let result2 = add(20,20);
console.log("result : " + result);
// console.log(result2);


// 호이스팅
// 전 add 재선언
function add(x,y,z){
    console.log("2번째 함수 호출")
    console.log(x);
    console.log(y);
    console.log(z);
}
console.log("마지막실행");
add(1,2,3);

// 1.정의 2.호출 3.출력 4. 호출의 출력
