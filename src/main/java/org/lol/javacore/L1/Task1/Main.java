package org.lol.javacore.L1.Task1;

import java.util.Scanner;

/**
 * javadoc
 * I don't know what should I say.
 * @author kamilalol
 * Task1: Заполните двумерный массив случайным числами и выведите максимальное, минимальное и среднее значение.
 * -Random можно, но не желательно. -> ГПСЧ
 *
 * + Не надо на гитхаб пушить лишние файлы (папка .idea и target), только то что нужно для запуска проекта (в этом тебе поможет gitignore).
 * + Подумай над оптимизацией кода, много лишнего
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Добро пожаловать в программу для поиска максимального, минимального и среднего значения в двумерном массиве." );

        Scanner console = new Scanner(System.in);
        String line = "Y";

        int[][] array = new int[10][10];

        int max, min, seed, sum;
        double mid;


        while (line.equals("Yes")||line.equals("yes")||line.equals("Y")||line.equals("y")) {
            try {
                System.out.println("Введите любое целое число, чтобы сгенерировать случайные числа в массиве: ");

                max = -2147483648;
                min = 2147483647;

                sum = 0;

                seed = Integer.parseInt(console.nextLine());

                for (int i = 0;i < array.length; ++i) {
                    for (int j = 0;j < array[0].length; ++j) {

                        seed = (41 * seed + 661) % 617;
                        array[i][j] = seed;
                        System.out.print(array[i][j] + " ");

                        if (array[i][j] > max) {
                            max = array[i][j];
                        }
                        if (array[i][j] < min) {
                            min = array[i][j];
                        }
                        sum += array[i][j];
                    }
                    System.out.print("\n");
                }
                mid = (double) sum / (double) (array.length*array[0].length);

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