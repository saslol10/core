package org.lol.javacore.L1.Task1;

import java.util.Scanner;

/**
 * javadoc
 * I don't know what should I say.
 * @author kamilalol
 * Task1: Заполните двумерный массив случайным числами и выведите максимальное, минимальное и среднее значение.
 * -Random можно, но не желательно. -> ГПСЧ
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Добро пожаловать в программу для поиска максимального, минимального и среднего значения в двумерном массиве." );

        Scanner console = new Scanner(System.in);
        String line = "Y";

        int seed = 0;
        int a = 41;
        int c = 661;
        int m = 617;

        int[][] array = new int[10][10];

        int max;
        int min;
        double mid = 0.0;

        int sum;
        int count;


        while (line.equals("Yes")||line.equals("yes")||line.equals("Y")||line.equals("y")) {
            try {
                System.out.println("Введите любое целое число, чтобы сгенерировать случайные числа в массиве: ");

                max = -2147483648;
                min = 2147483647;
                mid = 0;

                sum = 0;
                count = 0;

                line = console.nextLine();
                seed = Integer.parseInt(line);

                for (int i = 0; i < array.length; ++i) {
                    for (int j = 0; j < array[0].length; ++j) {

                        seed = (a * seed + c) % m;
                        array[i][j] = seed;
                        System.out.print(array[i][j] + " ");

                        if (array[i][j] > max) {
                            max = array[i][j];
                        }
                        if (array[i][j] < min) {
                            min = array[i][j];
                        }
                        sum += array[i][j];
                        count++;
                    }
                    System.out.print("\n");
                }
                mid = (double) sum / (double) count;

                System.out.println("Максимальное: " + max + ". Минимальное: " + min + ". Среднее: " + mid + ".");
            }catch (NumberFormatException e) {
                System.out.println("Ошибка!!! Неверный формат числа. ");
            }
            System.out.println("Хотите попробовать еще раз? Введите Y или Yes, если да.");
            line = console.nextLine();
        }
        System.out.println("До новых встреч!");
    }
}