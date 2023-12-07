package com.ohgiraffers.pos.menu.controller;

import com.ohgiraffers.pos.menu.dto.MenuDTO;
import com.ohgiraffers.pos.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    private MenuService menuService;


    @GetMapping("/main")
    public String mainView(){
        return "menu/mainView";
    }

    @PostMapping("/menu_auth")
    public String admin(){
        return "menu/mainView";
    }

    @GetMapping("/all_menu")
    public ModelAndView selectAllMenu(ModelAndView mv){
        List<MenuDTO> menus = menuService.selectAllMenu();

        if(Objects.isNull(menus)){
            System.out.println("exeption으로 대체한다.");
        }
        mv.addObject("menus", menus);
        mv.setViewName("menu/allMenu");
        return mv;
    }

    @GetMapping("/insert_menu")
    public String insertMenu(){
        return "menu/menuInsert";
    }

    @PostMapping("/insert")
    public String insertMenuPage(MenuDTO menuDTO){
        menuService.insertMenu(menuDTO);
        return "redirect:/menus/all_menu";
    }

    @GetMapping("/delete_menu")
    public String deleteMenuView(){
        return "menu/menuDelete";
    }

    @PostMapping("/delete")
    public String deleteMenu(@RequestParam int code, @RequestParam String name){    // requestParam으로 PK와 이름을 전달
        menuService.deleteMenu(code, name);
        return "menu/allMenu";
    }

    @GetMapping("/update_menu")
    public String updateMenuView(){
        return "menu/menuUpdate";
    }

    @PostMapping("/update")
    public String updateMenu(MenuDTO menuDTO){
       menuService.updateMenu(menuDTO);

        return "menu/allMenu";
    }

}
