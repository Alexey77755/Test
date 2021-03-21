package com.company;


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String params;
        UnpackingString test = new UnpackingString();
        do {
            System.out.print("Введите строку: ");
            params = sc.next();
        } while (test.StringValidation(params));
        test.DataCollection(params);
        System.out.print(test.Result(params));
    }
}

