package com.example.Brackets;



import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.ArrayList;
        import java.util.Scanner;

public class Brackets {

    ArrayList<Character> a;
    ArrayList<Character> b;
    public Brackets() {
        a = new ArrayList<Character>();
        b = new ArrayList<Character>();
    }



    public int check() {
        a.clear();
        int count = 0;
        for (char y : b){
            if (y == '[' || y == '(' || y == '{'){
                a.add(y);
                continue;
            }
            //if (a.isEmpty())
                //continue;
            if (y == ']' && (a.isEmpty()||a.getLast() != '[')) {count++; continue;}
            //return false;
            if (y == ')' && (a.isEmpty()|| a.getLast() != '(')) {count++; continue;}
            // return false;
            if (y == '}' && (a.isEmpty()|| a.getLast() != '{')) {count++; continue;}
            // return false;
            if (!a.isEmpty())a.removeLast();
        }
        if (!a.isEmpty()) count++;
        return count;
    }
    public void readFromFile(String fname) throws FileNotFoundException {
        b.clear();
        Scanner scanner = new Scanner(new File(fname));
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            char[] x = s.toCharArray();
            for (char y : x){
                if (y == '[' || y == '(' || y == '{' || y == ']' || y == ')' || y == '}')
                    b.add(y);
            }
        }
        scanner.close();
    }
}