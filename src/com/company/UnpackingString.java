package com.company;

import java.util.ArrayList;


public class UnpackingString {
    ArrayList<Integer> numberInWord = new ArrayList<>();
    ArrayList<Integer> indexOfnumbInWord = new ArrayList<>();
    ArrayList<Integer> indexOfSymbol = new ArrayList<>();
    ArrayList<Integer> indexOfSymbolO = new ArrayList<>();
    String params;
    char[] arr;

    boolean StringValidation(String params) {
        char[] symbls = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', ']'};

        for (int i = 0; i < params.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < symbls.length; j++) {
                if (params.charAt(i) == symbls[j]) {
                    flag = false;
                    continue;
                }


            }
            if (flag == true) {
                System.out.println("Введено не корректное выражение");
                return true;
            }
        }
        return false;
    }

    void DataCollection(String params) {
        arr = params.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                numberInWord.add(Character.getNumericValue(arr[i])); //создаем массив чисел из введеной строки
                indexOfnumbInWord.add(i);

            }
            if (']' == arr[i]) {
                indexOfSymbol.add(i);
            }
            if ('[' == arr[i]) {
                indexOfSymbolO.add(i);
            }
        }
    }

    /*Распаковывает строку*/
    String Result(String params) {
        String h = "";
        int n = 1;
        String d = "";
        String p = "";
        String a = "";
        for (int j = 0; j < indexOfnumbInWord.size(); j++) {
            if (Character.isLetter(arr[0]) && j == 0) {
                a = params.substring(0, indexOfnumbInWord.get(0));
                h = a;
            }

            if (indexOfnumbInWord.get(indexOfnumbInWord.size() - 1) < indexOfSymbol.get(0)) {
                String b = params.substring(indexOfnumbInWord.get(indexOfnumbInWord.size() - 1) + 2, indexOfSymbol.get(0)).repeat(numberInWord.get(numberInWord.size() - 1));
                String g = "";
                for (int t = 0; t < indexOfSymbol.size() - 1; t++) {
                    g = params.substring(indexOfSymbol.get(t) + 1, indexOfSymbol.get(t + 1));
                    b = (b + g).repeat(numberInWord.get(numberInWord.size() - 2 - t));
                }
                h = b;
                break;
            }
            if (Character.isLetter(arr[indexOfnumbInWord.get(j) + 2])) {
                a = params.substring(indexOfnumbInWord.get(j) + 2, indexOfSymbol.get(j)).repeat(numberInWord.get(j));
                if (j != indexOfnumbInWord.size() - 1 && indexOfSymbol.get(j) + 1 != indexOfnumbInWord.get(j + 1)) {
                    a += params.substring(indexOfSymbol.get(j) + 1, indexOfnumbInWord.get(j + 1));
                }
                h += a;
            }

            if (Character.isDigit(arr[indexOfnumbInWord.get(j) + 2])) {
                while (true) {
                    if (indexOfnumbInWord.get(j + n) < indexOfSymbol.get(j)) {
                        if (indexOfnumbInWord.get(j + n) == indexOfnumbInWord.get(indexOfnumbInWord.size() - 1)) {
                            n++;
                            break;
                        }
                        n++;
                    } else {
                        break;
                    }
                }
                d = params.substring(indexOfnumbInWord.get(j + n - 1) + 2, indexOfSymbol.get(j)).repeat(numberInWord.get(j + n - 1));
                int k = 0;
                while (k < n - 1) {
                    p = params.substring(indexOfSymbol.get(j + k) + 1, indexOfSymbol.get(j + k + 1));
                    d = (d + p).repeat(numberInWord.get(j + k));
                    System.out.println("вывод второй");
                    k++;
                }
                j += n - 1;
                if (j < indexOfnumbInWord.size() - 1 && indexOfSymbol.get(j) + 1 != indexOfnumbInWord.get(j + 1)) {
                    d += params.substring(indexOfSymbol.get(j) + 1, indexOfnumbInWord.get(j + 1));
                }
                h += d;

                n = 1;
            }
            if (indexOfSymbol.get(indexOfSymbol.size() - 1) != arr.length - 1 && j == indexOfSymbol.size() - 1) {
                d = params.substring(indexOfSymbol.get(indexOfSymbol.size() - 1) + 1, arr.length);
                h += d;
            }
        }
        return h;
    }
}


