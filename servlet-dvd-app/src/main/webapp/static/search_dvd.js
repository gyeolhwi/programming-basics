// onclick 백엔드서버에 요청 날려줘야함
function handleSearchClick() {
			const searchInput = document.querySelector(".search-input");
			location.href = `http://localhost:8080/dvd/search?searchText=${searchInput.value}`;
		}
		
function handleSearchClickToPublisherName() {
			const searchInput = document.querySelector(".search-input");
			location.href = `http://localhost:8080/dvd/producer/search?searchText=${searchInput.value}`;
		}