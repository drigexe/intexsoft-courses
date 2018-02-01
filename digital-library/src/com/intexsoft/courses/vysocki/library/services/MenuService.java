package com.intexsoft.courses.vysocki.library.services;

import com.intexsoft.courses.vysocki.library.model.LibraryDepartment;
import com.intexsoft.courses.vysocki.library.utils.ConstantsUtil;
import com.intexsoft.courses.vysocki.library.utils.PropertiesUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuService {

    public void run() {
        printWelcomeText();
        LibraryDepartmentService libraryDepartmentService = new LibraryDepartmentService();
        ArrayList<LibraryDepartment> libraryDepartments = new ArrayList<LibraryDepartment>();
        libraryDepartments = libraryDepartmentService.getLibraryDepartments();
        for (int i = 0; i < libraryDepartments.size(); i++) {
            System.out.println(i + 1 + " - " + libraryDepartments.get(i).getName() + ", " + libraryDepartments.get(i).getWebsite());
        }
        int chosenOption = getUserInput();
        PropertiesUtil propertiesUtil = new PropertiesUtil();
        chooseLibraryDepartment(chosenOption, libraryDepartments,propertiesUtil);

    }

    private void printWelcomeText() {
        System.out.println("Hi, please, choose the Library Department, which you want to work with");
    }

    private int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int userOptionNumber = scanner.nextInt();
        scanner.close();
        return userOptionNumber;
    }

    public static String chooseLibraryDepartment(int chosenOption, ArrayList<LibraryDepartment> libraryDepartments, PropertiesUtil propertiesUtil) {
        String rootLibraryPath = propertiesUtil.getPropertyValue(ConstantsUtil.ROOT_LIBRARY_PATH);
        String chosenDepartmentPath = libraryDepartments.get(chosenOption-1).getPath();
        String chosenDepartmentpath = rootLibraryPath + "\\" + chosenDepartmentPath;
        System.out.println(chosenDepartmentpath);
        return chosenDepartmentpath;
    }
}
