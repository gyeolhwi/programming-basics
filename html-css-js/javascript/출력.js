var num = 10;
var sNum = "10";

console.log(num === sNum);
var num2;
console.log(!num2);
console.log();

/* 
    !(not) 연산자를 활용하여 문자 , 숫자 등의 자료를 논리데이터로 변환하는 법
    var num = 10;
    !!num -> true
    num = 0;
    !!num -> false

    var str = "test";
    !!str -> true
    str = "";
    !!str -> false

    var array = [1, 2, 3];
    !!array -> true
    array = [];
    !!array -> true
    배열은 비어있어도 true값임 그래서 길이를 확인해서 비어있는지 판단해야함
    !!array.length -> false

    boolean type 변환을 위해서 !! 사용 (명시적형변환)
*/

var num = 0;
console.log(!!num);
var str = "";
console.log(!!str);
var array = [];
console.log(!!array);
console.log(!!array.length);
var a;
console.log(!!a);
var b = null;
console.log(!!b);
var c = 0 / 0;
console.log(c);
console.log(!!c);

num = 0;
if(!num /*num === 0*/){
    var num2 = 20;
    console.log("num은 0입니다");
    if(!!num2)/* true */{
        /* if(num2 =="" || num2 == 0){} */
        console.log("num2는 값이 있습니다");
        console.log(!num2);
        console.log(!!num2);
    }
}
str = "";
if(!str){
    console.log("빈 문자열입니다");
}
b = null;
if(!b){
    console.log("Null입니다.");
}