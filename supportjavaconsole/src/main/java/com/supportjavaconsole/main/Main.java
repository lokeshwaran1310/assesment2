package com.supportjavaconsole.main;

import com.supportjavaconsole.consoleui.Console;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        try {
            console.start();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
