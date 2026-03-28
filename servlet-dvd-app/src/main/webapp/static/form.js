// 폼 태그안에 들어있는 key,value를 일반객체로 변환하는 작업
function handleSubmitAllClick() {
	const forms = document.querySelectorAll("form");
	const formData1 = new FormData(forms[0]);
	const formData2 = new FormData(forms[1]);
	
	// 담을 곳
	let reqData = {}
	
	/*
		formData1 = {
			username : "admin",
			password: "1234"
		}
		entries 변환
		entries = [
			["username","admin"],
		 	["password","1234"]
		 ] 
	*/
	for(let entry of formData1.entries()) {
		// 비구조할당으로 받음
		const [ key, value ] = entry;
		
		//
		reqData = {
			...reqData,
			[key]: value
		}
	}
	/*
		 formData2 = {
			chk : "chk1",
			chk : "chk2",
			rdo: "rdo1"
		}
		entries =[
			["chk", "chk1"],
			["chk", "chk2"],
			["rdo", "rdo1"]
			
		]
	*/
	let duplicatedKeys = [];
	let keyCount = {}
	
	for(let key of formData2.keys()) {
		// 중복된 key값이 있다면 배열로 만들어라 -> 태그의 name이 같은것들 때문에
		if(Object.keys(keyCount).includes(key)) {
			keyCount = {
				...keyCount,
				[key]: keyCount[key] + 1
			}
			continue;
		}
		keyCount = {
			...keyCount,
			[key]: 1
		}
	}
	
	// 중복 key만 담기
	for(let key of Object.keys(keyCount)) {
		if(keyCount[key] > 1) {
			duplicatedKeys = [ ...duplicatedKeys, key ];
		}
	}
	
	console.log(keyCount);
	console.log(duplicatedKeys);
	
	for(let entry of formData2.entries()) {
		const [ key, value ] = entry;
		if(duplicatedKeys.includes(key)) {
			reqData = {
				...reqData,
				// 넣고자하는 객체에 해당 키값이 존재하냐 ? 후에 , value값 추가 즉 , 하나의 키값에 value들이 배열형태로 들어감 
				[key]: [ ...(!reqData[key] ? [] : reqData[key]), value ]
			}
			continue;
		}
		reqData = {
			...reqData,
			[key]: value
		}
	}
	
	console.log(reqData);
	
	const queryString = new URLSearchParams(reqData).toString();
	
	fetch(`http://localhost:8080/dvd/form?${queryString}`)
	.then(response => {
		response.text()
		.then(data => {
			const body = document.querySelector("body");
			body.innerHTML += `<h1>${data}</h1>`;
			console.log(data);
		})
	});
	
}