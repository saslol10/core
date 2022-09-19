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

 * + Не надо на гитхаб пушить лишние файлы (папка .idea и target), только то что нужно для запуска проекта (в этом тебе поможет gitignore).
 * + Подумай над оптимизацией кода, много лишнего
 * */


public class Main {

    public static void value_output(int [] source, int a)
    {
        quickSort(source, 0, a - 1);
        for (int j : source) {
            System.out.print(j + " ");
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
                    value_output(array, array.length);
                } else if (line.equals("2")) {
                    System.out.println("Введите размер массива:");
                    a = Integer.parseInt(console.nextLine());

                    while (a<=0)
                    {
                        System.out.println("Число эелементов в массиве должно быть больше 0.");
                        a = Integer.parseInt(console.nextLine());
                    }
                    array = new int[a];
                    System.out.println("Введите элементы массива:");

                    for (int i = 0; i < array.length; i++) {
                        System.out.print("["+ (i+1) + "]:");
                        array[i] = Integer.parseInt(console.nextLine());
                    }
                    value_output(array, array.length);
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