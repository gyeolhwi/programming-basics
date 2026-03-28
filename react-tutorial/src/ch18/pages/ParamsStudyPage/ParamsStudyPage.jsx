import { useParams } from "react-router-dom";

/** @jsxImportSource @emotion/react */
function ParamsStudyPage() {
    const params = useParams();
    console.log(params.name);
    console.log(params.age);

    return (
        <div>

        </div>
    );
}

export default ParamsStudyPage;