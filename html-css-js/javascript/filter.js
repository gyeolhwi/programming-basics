const print = (data) => console.log(data);
let names = ["김준일", "김준이", "김준삼"];

print(names);

names = names.map((name,index) => {
    return name + "님"
});

print(names);

// filter 해당 조건이 참인 경우만 담겠다 
names = names.filter((name,index) => {return index !== 1});

print(names);