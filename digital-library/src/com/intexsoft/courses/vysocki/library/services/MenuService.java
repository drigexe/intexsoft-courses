package com.intexsoft.courses.vysocki.library.services;

import java.util.Scanner;

public class MenuService {

    public void run(){
        printWelcomeText();
        int chosenOption = getUserInput();
    }

    private void printWelcomeText(){
        System.out.println("Privet");
        /* TODO
         * ридрайтер читает из джейсонки инфу,
         * затем джейсонпарсер её преобразует в массив и
         * этот массив получает департментсервис и вот в этом самом методе я его пилю в массив.
         *  потом этот массив выводится на экран, как опции*/
    }

    private int getUserInput(){
        Scanner scanner = new Scanner(System.in);
        int userOptionNumber = scanner.nextInt();
        scanner.close();
        return userOptionNumber;
    }

    public int chooseLibraryDepartment(int chosenOption){

       // libraryDepartmentList[chosenOption].getPath()
    }
}