function Box(props) {
    return <div>
        <h1>{props.name}</h1>
        {/* 호출된 하위요소의 모든 태그들은 children으로 정의된다 */}
        {props.children}
    </div>
}
export default Box;