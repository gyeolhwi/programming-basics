import { css } from '@emotion/react';
import { getDownloadURL, ref, uploadBytesResumable } from 'firebase/storage';
import React, { useState } from 'react';
import { useQueryClient } from 'react-query';
import { useNavigate } from 'react-router-dom';
import { storage } from '../../firebase/firebase';
import { v4 as uuid } from 'uuid'
import { Progress } from 'react-sweet-progress';
import "react-sweet-progress/lib/style.css";
import { updateProfileImgApi } from '../../apis/userApi';
import { set } from 'firebase/database';


/** @jsxImportSource @emotion/react */

const layout = css`
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 100px auto;
    width: 1000px;
`;
const imgBox = css`
    box-sizing: border-box;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 50%;
    width: 300px;
    height: 300px;
    box-shadow: 0 0 2px #00000088;
    overflow: hidden;
    cursor: pointer;

    & > img {
        height: 100%;
    }
`;
const progressBox = css`
    padding-top: 20px;
    width: 300px;
    border-radius: 50%;
`;
function UserProfilePage(props) {

    const [uploadPercent, setUploadPercent] = useState();
    const navigate = useNavigate();
    const [inputUser, setInputUser] = useState({
        username: "",
        password: ""
    });
    const queryClient = useQueryClient();
    const  userInfodata = queryClient.getQueryData("userInfoQuery"); // data?.data ㄴㄴ data
    // console.log(userInfodata);
    const userInfostate = queryClient.getQueryState("userInfoQuery");

    console.log(userInfostate);
    const handleImageChangeOnClick = () => {
        if (window.confirm("프로필 사진을 변경하시겠습니깡!")) {
            const fileInput = document.createElement("input");
            fileInput.setAttribute("type", "file");
            fileInput.setAttribute("accept", "image/*");
            fileInput.click();

            fileInput.onchange = (e) => {
                const profileImage = Array.from(e.target.files)[0]; // Set.of()
                // const profileImage = files;

                setUploadPercent(0);
                // console.log(files);
                
                const storageRef = ref(storage, `user/profile/${uuid()}_${profileImage.name}`); //파이어베이스 연결내용 명시
                const uploadTask = uploadBytesResumable(storageRef, profileImage); // 해당주소에 이미지를 저장

                uploadTask.on(
                    "state_changed",
                    (snapshot) => { // 업로드중일 때
                        setUploadPercent(
                            Math.round(snapshot.bytesTransferred / snapshot.totalBytes) * 100
                        );
                        console.log(snapshot.totalBytes);       // 실제파일
                        console.log(snapshot.bytesTransferred); // 전송중인데이터
                    },
                    (e) => { // 오류
                        console.error(e);
                    },
                    async (success) => { // 완료
                        const url = await getDownloadURL(storageRef); // 업로드가 완료되고나서 이미지 주소값 리턴

                        const response = await updateProfileImgApi(url); // 
                        queryClient.invalidateQueries(["userInfoQuery"]); // 강제로 쿼리를 만료시키겠다. 쿼리가 만료되면 알아서 요청갔다가 다시 들고옴
                    }
                )
            }
        }
    }

    const handleDefaultImgChangeOnclick = async () => {
        if (window.confirm("기본이미지로 변경하시겠습니깡")) {
            await updateProfileImgApi("");
            setUploadPercent(100);
            queryClient.invalidateQueries(["userInfoQuery"]); // 강제로 쿼리를 만료시키겠다. 쿼리가 만료되면 알아서 요청갔다가 다시 들고옴
        }
    }


    return (
        <div css={layout}>
            <h1>프로필</h1>
            <div css={imgBox} onClick={handleImageChangeOnClick}>
                <img src={userInfostate?.data?.data.img} alt="" />
            </div>
            {/* <h3>{uploadPercent}</h3> */}
            <div css={progressBox}>
                <Progress percent={uploadPercent} status={uploadPercent !== 100 ? "active" : "success"} />
            </div>
            <div><button onClick={handleDefaultImgChangeOnclick}>기본 이미지로 변경</button></div>
        </div>
    );
}

export default UserProfilePage;
/*
rules_version = '2';

service firebase.storage {
  match /b/{bucket}/o {
    match /{allPaths=**} {
      allow read, write: if
          request.time < timestamp.date(2024, 10, 2);
    }
  }
}
caution:
*/