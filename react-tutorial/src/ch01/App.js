/*
  컴포넌트 : HTML 태그를 리턴하는 함수 
  태그 무조건 닫아야함 -> input이 예외
  여러 태그를 리턴해야하는 경우 하나로 묶어야한다 (Fragment 태그 이용<></>)
  JSX 안에 값 또는 변수를 사용할 경우 {} 표현식 사용 -> (JS에서는 ${}사용했었음)
  boolean,null 값은 문자로 안 봄 (랜더링을 하지않는다)
  조건부 랜더링 &&연산자 -> boolean && 태그 boolean값에 따라 보이게할 수 있다


*/
import "./App.css";
import Box from "./components/Box";
import Box2 from "./components/Box2";
import Custominput from "./components/Custominput";
import Hello from "./components/Hello";

function App() {

  const name = "김준일";
  const fontColorRed = {
    color: "green"
  }
  const age = <h2>{33}</h2>

  return <>
    <div>
      <Hello />
    </div>
    <h1 style={{ color: "coral" }}>{name}</h1>
    <h1 style={fontColorRed}>{name}</h1>
    <h1 style={fontColorRed} className={"fs-20 italic"}>{name}</h1>
    <Hello />
    <Custominput ph={"이름"} disabled={true} value={"김준잉"} />
    <Custominput ph={"나이"} disabled={false} />
    <Custominput ph={"연락처"} disabled={true} />
    {/* <Box name={"김결휘"} children={age} /> */}
    <Box name={"김기리"}>
      <h2>{35}</h2>
      <h2>{31}</h2>
      <h2>{32}</h2>
    </Box>
    <Box2 isShow={true}>
      <h2>{22}</h2>
      <h2>{33}</h2>
      <h2>{44}</h2>
    </Box2>
    {age}
  </>
}


export default App;