function handleSearchOnclick(){
	const searchInput = document.querySelector(".search-input");
	location.href = `http://localhost:8080/ssa/test?searchText=${searchInput.value}`;
}