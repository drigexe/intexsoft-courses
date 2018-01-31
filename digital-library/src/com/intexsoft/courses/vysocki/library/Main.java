package com.intexsoft.courses.vysocki.library;

import com.intexsoft.courses.vysocki.library.services.MenuService;

public class Main {

    public static void main(String[] args){
        MenuService menuService = new MenuService();
        menuService.run();

    }

}
