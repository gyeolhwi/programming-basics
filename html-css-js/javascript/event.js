function handleButtonClick(e) {
    console.log({ event: e });
    // e.target.innerHTML = "취소";
    if (e.target.innerHTML = e.target.innerHTML == "확인" ? "취소" : "확인");
}
const print = (data) => console.log(data);

function handleInputChange(e) {
    // print(e.target.value);
    // print(e);
    /*
    if (e.keyCode === 13 || e.key === "Enter") {
        alert(e.target.value);
    }   
    */
    if (e.ctrlKey && (e.keyCode === 13 || e.key === 'Enter')) {
        alert(e.target.value);
    }
}
let isFocus = false;
function handleInputFocus(e) {
    /*
    if(!isFocus){
        isFocus = true;
        alert("입력하쇼")
    }
    */
    if (!!e.target.value) {
        e.target.value = "";
    }
}
function handleInputBlur(e){
    if(!e.target.value){
        alert("값을 입력해주쇼");
    }
}