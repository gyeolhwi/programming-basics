import React from 'react';
/** @jsxImportSource @emotion/react */
import * as s from "./style";

import Icon from '../Icon/Icon';
import DashboardListItem from '../../DashboardListItem/DashboardListItem';
import { BsCalendar4Week, BsCalendarEvent, BsCalendarCheck } from 'react-icons/bs';
import { useNavigate } from 'react-router-dom';
import { todolistAtom } from '../../../atoms/todolistAtoms';
import { useRecoilState } from 'recoil';
import { MENUS } from '../../../constants/menus';


function Menu({ icon, color, title, count, path }) {


    const navigate = useNavigate();
    const handleClick = () => {
        navigate(path);
    }

    return (
        <div css={s.menuContainer} onClick={handleClick}>
            <div css={s.menuTop}>
                <Icon color={color}> {icon} </Icon>
                <p>{count}</p>
            </div>
            <h3 css={s.menuBottom}>
                {title}
            </h3>
        </div>
    );
}

function MenuList(props) {
    const [todolist, setTodolist] = useRecoilState(todolistAtom);
    return (
        <DashboardListItem title={"Menu"}>
            <div css={s.layout}>
                <Menu
                    path={MENUS.all.path}
                    icon={<BsCalendarEvent />}
                    color={MENUS.all.color}
                    title={MENUS.all.title}
                    count={todolist.counts.today} />
                <Menu
                    path={MENUS.today.path}
                    icon={<BsCalendar4Week />}
                    color={MENUS.today.color}
                    title={MENUS.today.title}
                    count={todolist.counts.all} />
                <Menu
                    path={MENUS.important.path}
                    icon={<BsCalendar4Week />}
                    color={MENUS.important.color}
                    title={MENUS.important.title}
                    count={todolist.counts.busy} />
                <Menu
                    path={MENUS.busy.path}
                    icon={<BsCalendar4Week />}
                    color={MENUS.busy.color}
                    title={MENUS.busy.title}
                    count={todolist.counts.important} />
                <Menu
                    path={MENUS.complete.path}
                    icon={<BsCalendarCheck />}
                    color={MENUS.complete.color}
                    title={MENUS.complete.title}
                    count={todolist.counts.complete} />
            </div>
        </DashboardListItem>
    );
}

export default MenuList;