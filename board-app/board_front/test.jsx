import React, { useState, useEffect, useCallback } from 'react';
import axios from 'axios';
import { useInView } from 'react-intersection-observer';

// 데이터를 가져오는 함수
const fetchData = async (page) => {
    try {
        const response = await axios.get(`https://api.example.com/data?page=${page}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        return []; // 오류 발생 시 빈 배열 반환
    }
};

function InfiniteScroll() {
    const [items, setItems] = useState([]);
    const [page, setPage] = useState(1);
    const [hasMore, setHasMore] = useState(true);
    const [loading, setLoading] = useState(false);

    const { ref, inView } = useInView();

    // 데이터를 로드하는 함수
    const loadMoreItems = useCallback(async () => {
        if (loading || !hasMore) return;

        setLoading(true);
        try {
            const newItems = await fetchData(page);
            setItems((prevItems) => [...prevItems, ...newItems]);
            setPage((prevPage) => prevPage + 1);
            if (newItems.length === 0) {
                setHasMore(false);
            }
        } catch (error) {
            console.error('Failed to load more items', error);
        } finally {
            setLoading(false);
        }
    }, [loading, hasMore, page]);

    // inView가 true일 때 데이터를 로드
    useEffect(() => {
        if (inView) {
            loadMoreItems();
        }
    }, [inView, loadMoreItems]);

    return (
        <div>
            <ul>
                {items.map((item, index) => (
                    <li key={index}>{item}</li>
                ))}
            </ul>
            <div ref={ref} style={{ height: '1px' }}></div>
            {loading && <p>Loading...</p>}
            {!hasMore && <p>No more items to load.</p>}
        </div>
    );
};

export default InfiniteScroll;
