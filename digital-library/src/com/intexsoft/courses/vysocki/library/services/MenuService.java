package com.intexsoft.courses.vysocki.library.services;

import com.intexsoft.courses.vysocki.library.model.Comics;
import com.intexsoft.courses.vysocki.library.model.Journal;
import com.intexsoft.courses.vysocki.library.model.LibraryDepartment;
import com.intexsoft.courses.vysocki.library.model.PrintedEdition;
import com.intexsoft.courses.vysocki.library.utils.ConstantsUtil;
import com.intexsoft.courses.vysocki.library.utils.PropertiesUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuService {
    private LibraryDepartmentService libraryDepartmentService = new LibraryDepartmentService();
    private PropertiesUtil propertiesUtil = new PropertiesUtil();
    private BookService bookService = new BookService();
    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<LibraryDepartment> libraryDepartments = null;

    public void run() {
        System.out.println("Hi, please, choose the Library Department, which you want to work with:");
        libraryDepartments = libraryDepartmentService.getLibraryDepartments();
        printDepartmentsOptions(libraryDepartments);
        int chosenOption = getUserIntInput();

        this.printAvailableFunctions(chosenOption);

    }


    private void printAvailableFunctions(int chosenOption) {
        String booksPath = this.getChosenDepartmentPath(chosenOption, ConstantsUtil.BOOKS_PATH);

        System.out.println("Please, choose function, you wanna run:");
        System.out.println("1 - print all books;");
        System.out.println("2 - filter by author;");
        System.out.println("3 - filter by genre;");
        System.out.println("4 - filter by printed edition type;");

        int chosenFunction = getUserIntInput();

        switch (chosenFunction) {
            case 1: {
                ArrayList<PrintedEdition> printedEditions = bookService.getPrintedEditions(booksPath);
                printBooksJson(printedEditions);
                break;
            }
            case 2: {
                System.out.println("Enter your author, please:");
                String enteredAuthor = getUserStrInput();
                String booksByAuthorPath = this.getChosenDepartmentPath(chosenOption, ConstantsUtil.BOOKS_FILTERED_BY_AUTHOR);
                bookService.filterByAuthor(booksPath, booksByAuthorPath, enteredAuthor);
                System.out.println("Your result was written in: " + booksByAuthorPath);
                break;
            }
            case 3: {
                System.out.println("Enter your genre, please:");
                String enteredGenre = getUserStrInput();
                String booksByGenrePath = this.getChosenDepartmentPath(chosenOption, ConstantsUtil.BOOKS_FILTERED_BY_GENRE);
                bookService.filterByGenre(booksPath, booksByGenrePath, enteredGenre);
                System.out.println("Your result was written in: " + booksByGenrePath);
                break;
            }
            case 4: {
                System.out.println("Enter your printed edition type, please:");
                String enteredType = getUserStrInput();
                String booksByTypePath = this.getChosenDepartmentPath(chosenOption, ConstantsUtil.BOOKS_FILTERED_BY_EDITION_TYPE);
                bookService.filterByType(booksPath, booksByTypePath, enteredType);
                System.out.println("Your result was written in: " + booksByTypePath);
                break;
            }
        }

    }

    private int getUserIntInput() {
        return scanner.nextInt();
    }

    private String getUserStrInput() {
        scanner.nextLine(); //hack to fix scanner's behaviour
        return scanner.nextLine();
    }

    private void printDepartmentsOptions(ArrayList<LibraryDepartment> libraryDepartments) {
        for (int i = 0; i < libraryDepartments.size(); i++) {
            System.out.println(i + 1 + " - " +
                    libraryDepartments.get(i).getName() +
                    ", " + libraryDepartments.get(i).getWebsite());
        }
    }



    private String getChosenDepartmentPath(int chosenOption, String pathPart) {
        String rootLibraryPath = propertiesUtil.getPropertyValue(ConstantsUtil.ROOT_LIBRARY_PATH);
        String booksPathPart = propertiesUtil.getPropertyValue(pathPart);
        String chosenDepartmentPath = libraryDepartments.get(chosenOption - 1).getPath();
        return rootLibraryPath + "\\" + chosenDepartmentPath + "\\" + booksPathPart;
    }

    private void printBooksJson(ArrayList<PrintedEdition> printedEditions) {
        for (PrintedEdition printedEdition : printedEditions) {
            String printedBooks = printedEdition.getName() +
                    " - " + printedEdition.getAuthor() +
                    " - year  " + printedEdition.getYear() +
                    " - " + printedEdition.getEditionType() +
                    " - " + printedEdition.getGenre() +
                    " - " + printedEdition.getPublisher() +
                    " - " + printedEdition.getIsbn();
            if (printedEdition instanceof Journal) {
                printedBooks += " - " + ((Journal) printedEdition).getIssue();
            }
            if (printedEdition instanceof Comics) {
                printedBooks += " - " + ((Comics) printedEdition).getArtist();
            }
            System.out.println(printedBooks);
        }
    }
}
