const user = {
    username: "admin",
    password: "1234",
    name: {
        lastName: "김",
        firstName: "결휘",
    },
    prints: () => {
        console.log("사용자이름 " + user.username);
        console.log(`비밀번호${user.password}`);
    }
};
const print = (data) => console.log(data);
print(user);
print(user.username);
print(user.password);
user.prints();

print(user.name.lastName);
print(user.name.firstName);