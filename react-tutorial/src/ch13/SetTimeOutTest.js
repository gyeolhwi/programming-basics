function SetTimeOutTest() {
    const print = (data) => console.log(data);
    /*
    콜백함수
    함수의 매개변수 안에다 넣어주는 거
    setTimeout(() => {함수호출}, 2000);
                                  초

    */
    setTimeout(() => {
        printFour(count);
    }, 2000);

    function printFour(fx) {
        console.log(4);
        fx();
    }
    function count() {
        print(1);
        print(2);
        print(3);

    }

    //콜백함수 예시
    function test(fx) {
        console.log("test함수 호출");
        fx();
    }
    function add() {
        console.log("add함수 호출");
    }
    test(add);
    // --------------------------------------


    return (
        <>
        </>
    );
}

export default SetTimeOutTest;