// 조건부 랜더링
const print = (data) => console.log(data);
function Box2({ name, isShow, children }) {
    const result = true && "tt";
    print(result);
    return <div>
        <h1>{name}</h1>
        {isShow && <h3>안녕하세요</h3>}
        {children}
        {result}
    </div>
}
export default Box2;