const print = (data) => { console.log(data) };
let userList = [];
loadUser();
function loadUser() {
    const lsUserList = localStorage.getItem("userList");
    userList = !lsUserList ? [] : JSON.parse(lsUserList);
    renderTodoList();
}
function renderTodoList() {
    const todoListContainer = document.querySelector(".todo-list-container");
    todoListContainer.innerHTML = userList.map(({ id, content, date }) => {
        return `
                <li class="todo-card">
                    <h3 class="todo-date">${date}</h3>
                    <p class="todo-content">${content}</p>
                    <div class="todo-buttons">
                    <button class="button edit-button" onclick="handleEditClick(event)" value="${id}">수정</button>
                        <button class="button delete-button" onclick="handleDeleteClick(event)" value="${id}">삭제</button>
                    </div>
                </li>
        `
    }).join("");

}

function handleTodoInputKeyDown(e) {
    if (e.keyCode === 13) {
        handleTodoOkClick();
    }
}
function handleTodoOkClick(e) {
    const todoInput = document.querySelector(".todo-input");
    if (isBlank(todoInput.value)) {
        alert("빈 값은 안되오");
        clear();
        return;
    }
    addTodo();
    renderTodoList();
    clear();
}
function clear(){
    const todoInput = document.querySelector(".todo-input");
    todoInput.value = "";
    todoInput.focus();
}
function isBlank(inputValue) {
    return !inputValue.replaceAll(" ", "");
}
function addTodo() {
    const user = {
        id: createNewId(),
        content: document.querySelector(".todo-input").value,
        date: transformDate(new Date())
    };
    userList = [...userList, user];
    saveLocalStorage();
    
}
function createNewId() {
    const idList = userList.map(user => user.id);
    const maxId = !idList.length ? 0 : Math.max.apply(null, idList);
    return maxId + 1;
}
function transformDate(date) {
    const dayList = ["일", "월", "화", "수", "목", "금", "토"];
    return `${date.getFullYear()}년 ${date.getMonth() + 1}월 ${date.getDate()}일 ${dayList[date.getDay()]}요일 ${date.getHours()}시 ${date.getMinutes()}분`;
}

function saveLocalStorage() {
    localStorage.setItem("userList", JSON.stringify(userList));
}


function handleDeleteClick(e) {
    if (confirm("삭제할 껴?")) {
        userList = userList.filter(user => user.id !== parseInt(e.target.value));
        saveLocalStorage();
        loadUser();
        renderTodoList();
    }
}

function handleEditClick(e) {
    const element = `
        <div class="modal-edit-container" onclick="event.stopPropagation()">
            <h4 class="modal-title">ToDo 수정하기</h4>
            <div class="input-box">
                <input type="text" class="todo-input" onkeydown="if(event.keyCode === 13) document.querySelector('.modal button:nth-of-type(1)').click()">
            </div>
            <div class="todo-buttons">
                <button class="button" onclick="handleEditOkClick(event)" value="${e.target.value}" >확인</button>
                <button class="button" onclick="CloseModal()">취소</button>
            </div>
        </div>
    `
    openModal(element);

}
function openModal(element) {
    const modal = document.querySelector(".modal");
    modal.classList.add("modal-show");
    modal.innerHTML = element;
}
function closeModal() {

}