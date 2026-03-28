
const obj = {

    a: {
        "test11": 70,
        "test12": 70,
        "test13": 70,
        "test14": 70,
        "test15": {
            "test1112": 80,
            "test1113": 80,
            "test1114": 80,
            "test1115": 80
        }
    },
    b: {
        "test2": 80,
        "test3": 80,
        "test4": 80,
        "test5": 80,
        "test6": 80
    }

}

const a = Object.entries(obj);
// console.log(a);
// console.log(a[0][1]);
const b = Object.entries(a[0][1]);
// console.log(b);
// console.log(b[4][1]["test1114"]);
console.log(b);
// console.log(b[4][1]);

/*
b[1][1];
70
[[test11,70],[test12,70]]
0,0
1,0


*/



console.log("----")
/*
    [a:{
    객체들
    }],
    b:{
    객체들}
*/
// const aa = Object.entries(a[0]);
// console.log(aa);