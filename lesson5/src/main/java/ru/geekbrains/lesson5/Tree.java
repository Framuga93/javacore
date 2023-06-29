package ru.geekbrains.lesson5;

import java.io.File;

public class Tree {

    /**
     * Рекурсивная функция, выводящая в консоль дерево деректории
     *
     * @param file файл либо директория
     * @param indent отступ
     * @param isLast булево значение являются ли файл/директория последними в директории которая подана в качестве
     *               аргумента в функцию
     */
    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent); // рисуем отступ
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;


        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory())
                subDirTotal++;
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, subDirCounter == subDirTotal - 1);
                subDirCounter++;
            }else print(files[i],indent,i == files.length - 1);
        }


    }

}
