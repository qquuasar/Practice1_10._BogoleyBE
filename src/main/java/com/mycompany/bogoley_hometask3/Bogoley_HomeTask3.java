/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bogoley_hometask3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Bogoley_HomeTask3 {
    public static void main(String[] args) {
        System.out.println("Bogoley Bogdan Evgenyevich, Variant 2, Group RIBO-01-22");
        String inputFilepath = args.length > 0 ? args[0] : null;
        if (inputFilepath == null) {
            System.out.println("Путь к файлу не был указан.");
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilepath));
            String outputFilepath = getOutputFilePath(inputFilepath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilepath));

            String line;
            while ((line = reader.readLine()) != null) {
                String reversedLine = reverseString(line);
                writer.write(reversedLine);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("Файл успешно модифицирован.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }

    private static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private static String getOutputFilePath(String inputFilepath) {
        int lastDotIndex = inputFilepath.lastIndexOf('.');
        String extension = "";
        if (lastDotIndex != -1) {
            extension = inputFilepath.substring(lastDotIndex);
        }

        return inputFilepath.replaceFirst("[.][^.]+$", "") + "_modified" + extension;
    }
}
