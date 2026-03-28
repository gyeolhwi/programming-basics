/** @jsxImportSource @emotion/react */
import * as s from "./style";

function App() {
    return (
        <div css={s.container}>
            <div css={s.boxContainer("red")}>
                <div css={s.boxContainer("aqua")}>
                    <div css={s.boxContainer("coral")}>
                        <button>button</button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;