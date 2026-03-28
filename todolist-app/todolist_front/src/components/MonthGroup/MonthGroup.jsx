import React from 'react';
import TodoInfo from '../TodoInfo/TodoInfo';

function MonthGroup({ months }) {
    const monthEntries = Object.entries(months);
    return (
        <ul>
            {
                monthEntries?.map(([month, todos]) => {
                    return <li key={month}>
                        <h3>{month}월</h3>
                        <TodoInfo todos={todos}/>
                    </li>
                })
            }
        </ul>
    );
}

export default MonthGroup;