package com.studentmanagement;

import com.studentmanagement.dao.DatabaseInitializer;
import com.studentmanagement.ui.ConsoleMenu;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.initialize();

        ConsoleMenu menu = new ConsoleMenu();
        menu.start();
    }
}