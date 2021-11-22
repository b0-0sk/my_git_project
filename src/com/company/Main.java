package com.company;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        // write your code here
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Introdueix un nombre natural major que zero: ");

        int sizeInput = myObj.nextInt();  // Read user input

        GeneradorTaulers board = new GeneradorTaulers();
        board.init(sizeInput);
        board.print();

        }
    }

