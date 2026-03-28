const print = (data) => console.log(data);
function Custominput({ ph, disabled, value }) {
    // print(value);

    return <input type="text" placeholder={ph} disabled={disabled} value={value} />
}
Custominput.defaultProps = {
    ph: "test",
    disabled: false,
    value: "빈값"
}
export default Custominput;