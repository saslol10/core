package org.lol.javacore.L1.Task2;

import java.util.Scanner;

/**
 * javadoc
 * I don't know what should I say.
 * @author kamilalol
 * Task2: Отсортируйте массив [5,6,3,2,5,1,4,9]. -> Использован алгоритм быстрой сортировки.
 * - Array.sort() использовать нельзя.
 * Задача(*) №1: написать простые тесты. -> assert(?) Не могу придумать куда их вписать.
 * Задача(*) №2: учесть дубликаты в массиве 2 задачи. (Надо сделать так, чтобы алгоритм работал правильно с дублями). Example: input: 8 2 3 4 2 3 1 9 output: 1 2 2 3 3 4 8 9
 */


public class Main {

    public static void value_output(int [] source, int a)
    {
        quickSort(source, 0, a - 1);
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
        }
    }
    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String line = "Y";
        int a;
        int[] array;

        while (line.equals("Yes") || line.equals("yes") || line.equals("Y") || line.equals("y")) {
            System.out.println("Введите: \n1 - если хотите отсортировать массив: [5,6,3,2,5,1,4,9]. \n2 - если хотите отсортировать свой массив.");
            line = console.nextLine();
            try {
                if (line.equals("1")) {
                    array = new int[]{5, 6, 3, 2, 5, 1, 4, 9};
                    a = 7;
                    value_output(array, a);
                } else if (line.equals("2")) {
                    System.out.println("Введите размер массива:");
                    line = console.nextLine();
                    a = Integer.parseInt(line);
                    while(a<=0)
                    {
                        System.out.println("Число элементов в массиве должно быть положительным. Попробуйте еще раз:");
                        line = console.nextLine();
                        a = Integer.parseInt(line);
                    }
                    array = new int[a];
                    System.out.println("Введите элементы массива:");

                    for (int i = 0; i < array.length; i++) {
                        System.out.print("["+ (i+1) + "]:");
                        line = console.nextLine();
                        array[i] = Integer.parseInt(line);
                    }
                    value_output(array, a);
                } else {
                    System.out.println("Что-то пошло не так.");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Ошибка!!! Неверный формат числа. ");
            }
            System.out.println("\nХотите попробовать еще раз? Введите Y или Yes, если да.");
            line = console.nextLine();
        }
        System.out.println("До новых встреч!");
    }
}