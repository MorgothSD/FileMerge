package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) break;
            names.add(input);
        }
        scanner.close();

        String outN = null;
        int max = 0;
        for (String name : names) {
            String[] subStr;
            String del = ".part";
            subStr = name.split(del);

            outN = subStr[0];
            int num = Integer.parseInt(subStr[1]);
            if (num > max) max = num;
        }

        String[] s = new String[max];
        for (String name : names) {
            BufferedReader reader = new BufferedReader(new FileReader(name));
            String[] subStr;
            String del = ".part";
            subStr = name.split(del);

            String fileR = "";
            while (reader.ready()) {
                fileR += (char)reader.read();
            }

            s[Integer.parseInt(subStr[1]) - 1] = fileR;
            reader.close();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(outN));
        for (int i = 0; i < s.length; i++) {
            writer.write(s[i]);
        }
        writer.close();
    }
}
