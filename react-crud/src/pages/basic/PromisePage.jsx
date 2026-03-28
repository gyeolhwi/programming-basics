import React from 'react';

function PromisePage(props) {
    const loop = (name) => {
        const random = Math.floor(Math.random() * 100) + 1;
        for (let i = 0; i < random; i++) {
            console.log(`${name} : ${i}`);
        }
    }

    const testPromise1 = () => {
        return new Promise((resolve, reject) => {
            loop("test1");
            resolve("test1 반복 완료");
        });
    }
    const testPromise2 = () => {
        return new Promise((resolve, reject) => {
            loop("test2");
            resolve("test2 반복 완료");
            console.log("2비동기 실행");
        });
    }
    const testPromise3 = () => {
        return new Promise((resolve, reject) => {
            loop("test3");
            console.log("비동기실행");
            resolve("test3 반복 완료");
        });
    }




    const testPromise4 = (num) => {
        return new Promise((resolve, reject) => {
            console.log("test4");
            if (num == 0) {
                reject("4번 오류");
                return;
            }
            resolve("4번 성공!");
        });
    }

    const testPromise5 = async (num) => {
        console.log("test5");
        if (num == 0) {
            throw new Error("5번 오류!!!");
        }
        return "5번 성공!";
    }


    /*
    const handleClick1 = () => {
        testPromise1().then(r => {
            console.log(r);
            testPromise2().then(r => {
                console.log(r);
                testPromise3().then(r => { console.log(r) });
            });
        });
        // return new Promise;
   }
*/

    const handleClick1 = () => {
        console.log("1동기실행됨");
        testPromise1().then(r => console.log(r));
        console.log("2동기실행됨");
        testPromise2().then(r => console.log(r));
        console.log("3동기실행됨");
        testPromise3().then(r => console.log(r));

        // return new Promise;
    }





    //  ↕ == 
    const handleClick2 = async () => {
        const r = await testPromise1();
        console.log(r);

        const r2 = await testPromise2();
        console.log(r2);

        const r3 = await testPromise3();
        console.log(r3);
    }

    const handleClick3 = () => {
        testPromise4(1).then(r => {
            console.log(r);
        }).catch(e => {
            console.error(e);
        });

        testPromise5(1).then(r => {
            console.log(r);
        }).catch(e => {
            console.error(e);
        });
    }
    const handleClick4 = async () => {
        try {
            const r = await testPromise4();
            console.log("r = ", r); // resolve 값 담음
        } catch (e) {
            console.log(e);
        }

        try {
            const r = await testPromise5();
            console.log(r);
        } catch (e) {
            console.log(e);
        }
    }
    return (
        <div>
            <button onClick={handleClick1}>버튼1</button>
            <button onClick={handleClick2}>버튼2</button>
            <button onClick={handleClick3}>버튼3</button>
            <button onClick={handleClick4}>버튼4</button>
        </div>
    );

}

export default PromisePage;