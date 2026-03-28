function Button(props) {
    const handleClick = () => {
        if (props.text === "증가") {
            props.setNumber(n => n + 1);
        }
        if (props.text === "감소") {
            props.setNumber(n => n + -1);
        }
    }

    return <button onClick={handleClick}>{props.text}</button>

}

export default Button;