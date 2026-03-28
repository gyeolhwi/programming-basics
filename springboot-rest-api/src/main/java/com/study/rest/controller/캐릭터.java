package com.study.rest.controller;

import com.study.rest.di.exam.무기;
import com.study.rest.di.exam.방패;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.expression.TypedValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class 캐릭터 {

    @Autowired
    @Qualifier("총")
    private 무기 weapon;

    @Autowired
    @Qualifier("칼")
    private 무기 weapon2;

    @Autowired
    @Qualifier("물공방패")
    private 방패 shield;

    @ResponseBody
    @GetMapping("/maple/attack")
    public Object maple(@RequestParam String searchText) {
        System.out.println(searchText);
        if (searchText.equals("총")) {
            weapon.공격();
        } else if (searchText.equals(("칼"))) {
            weapon2.공격();
        }
        return null;
    }

    @ResponseBody
    @GetMapping("/maple/defense")
    public Object mapleDefense() {
        shield.방어();
        return null;
    }
    @Autowired
    private TypedValue typedValue;
}
