package com.intexsoft.courses.vysocki.library;

import com.intexsoft.courses.vysocki.library.services.MenuService;
import com.intexsoft.courses.vysocki.library.utils.ConstantsUtil;
import com.intexsoft.courses.vysocki.library.utils.PropertiesUtil;
import com.intexsoft.courses.vysocki.library.utils.ReadWriteUtil;

public class Main {

    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        menuService.run();

    }

}
