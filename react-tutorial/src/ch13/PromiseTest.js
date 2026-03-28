
function PromiseTest() {
    /*
        Promise 비동기 객체
        프로미스 3가지 상태
        대기 -> 이행되지도 거부되지도 않은 상태
        이행 -> 연산이 성공했을 때의 상태
        거부 -> 연산을 실패했을 떄의 상태
    */
    function p1(name) {
        // resolve = 이행 / reject = 거부
        return new Promise((resolve, reject) => {
            // 대기상태(동기처리)
            console.log(name + " 프로미스 생성");
            if (!name) {
                reject("오류!!!");
            }
            resolve("이행한상태 " + name);
        });
    }

    async function p2() {
        let a = null;
        try {
            a = await p4(); // await -> 이행할 때까지 기다려 -> 동기처리됨
            // await은 async 안에서만 사용할 수 있다. Promise 객체에만 사용할 수 있다.
            // p4().then(r => a = r);
            await p5()
        } catch (error) {
            console.log(error);
            a = "p5";
        }
        return a;
    }
    //   ↑ == ↓
    function p3() {
        return new Promise((resolve, reject) => {
            resolve("p3");
        });
    }

    async function p4() {
        return "p4";
    }

    async function p5() {
        throw new Error("오류!");
    }

    const handleClick = () => {
        p1("p1")
            .then(result => {
                console.log("이행");
                console.log(result);
                if (true) {
                    throw new Error("거부"); // 거부 (reject)
                }
                return "두번 째 then"; // 이행 resolve
            }).then(result => {
                //비동기 안에서의 동기적 실행
                console.log(result);
                console.log("없네");
            }).catch(error => {
            });
    }
    const handleClick2 = () => {
        setTimeout(() => {
            p2().then(r => {
                console.log(r);
            });
        }, 2000);
        // p3().then(r => console.log(r));

    }


    return (
        <>
            <button onClick={handleClick}>promise</button>
            <button onClick={handleClick2}>async</button>
        </>
    );
}

export default PromiseTest;