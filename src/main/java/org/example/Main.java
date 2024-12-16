package org.example;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    /*
    Необходимо реализовать метод таким образом, чтобы он возвращал индекс первого
    вхождения числа x в массив arr. Если число не входит в массив – возвращается -1.
    */
    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[ i ] == x) {
                return i;
            }
        }
        return -1;
    }

    /*
   Необходимо реализовать метод таким образом, чтобы он возвращал индекс последнего
   вхождения числа x в массив arr. Если число не входит в массив – возвращается -1.
    */
    public static int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[ i ] == x) {
                return i;
            }
        }
        return -1;
    }

    /*
   Необходимо реализовать метод таким образом, чтобы он возвращал наибольшее
   по модулю (то есть без учета знака) значение массива arr.
    */
    public static int maxAbs(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым или null");
        }
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(maxValue)) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    /*
   Необходимо реализовать метод таким образом, чтобы он возвращал
   количество положительных элементов массива arr.
    */
    public static int countPositive(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        int count = 0;
        for (int num : arr) {
            if (num > 0) {
                count++;
            }
        }
        return count;
    }

    /*
    Необходимо реализовать метод таким образом, чтобы он возвращал true, если массив arr является
    палиндромом, то есть справа-налево и наоборот читается одинаково
    */
    public static boolean palindrom(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /*
    Необходимо реализовать метод таким образом, чтобы он изменял массив arr.
    После проведенных изменений массив должен быть записан задом-наперед
    */
    public static void reverse(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /*
    Необходимо реализовать метод таким образом, чтобы он возвращал
    новый массив, в котором значения массива arr записаны задом наперед.
    */
    public static int[] reverseBack(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        int[] reversedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arr.length - 1 - i];
        }
        return reversedArr;
    }

    /*
   Необходимо реализовать метод таким образом, чтобы он возвращал новый массив,
   в котором сначала идут элементы первого массива (arr1), а затем второго (arr2).
   */
    public static int[] concat(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            throw new IllegalArgumentException("Массивы не должны быть null");
        }
        int[] result = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        return result;
    }

    /*
    Необходимо реализовать метод таким образом, чтобы он возвращал новый массив,
    в котором записаны индексы всех вхождений числа x в массив arr.
    */
    public static int[] findAll(int[] arr, int x) {
        if (arr == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        // List для динамического добавления, т.к не знаем размер массиа
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[ i ] == x) {
                index.add(i);
            }
        }
        // if (index.isEmpty()) { return new int[0];}
        int[] result = new int[index.size()];
        for (int i = 0; i < index.size(); i++) {
            result[i] = index.get(i);
        }
        return result;
    }

    /*
   Необходимо реализовать метод таким образом, чтобы он возвращал новый массив,
   в котором записаны все элементы массива arr кроме отрицательных.
   */
    public static int[] deleteNegative(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        List<Integer> resultList = new ArrayList<>();
        for (int num : arr) {
            if (num >= 0) {
                resultList.add(num);
            }
        }
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[ i ] = resultList.get(i);
        }
        return resultArray;
    }

    /*
    Необходимо реализовать метод таким образом, чтобы он возвращал новый массив,
    который будет содержать все элементы массива arr, однако в позицию pos будет вставлено значение x.
    */
    public static int[] add(int[] arr, int x, int pos) {
        if (arr == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        if (pos < 0 || pos > arr.length) {
            throw new IllegalArgumentException("Некорректная позиция");
        }
        int[] result = new int[arr.length + 1];
        System.arraycopy(arr, 0, result, 0, pos);
        result[pos] = x;
        System.arraycopy(arr, pos, result, pos + 1, arr.length - pos);
        return result;
    }
     /*
    Необходимо реализовать метод таким образом, чтобы он возвращал новый массив, который будет содержать все
    элементы массива arr, однако в позицию pos будут вставлены значения массива ins.
    */
     public static int[] add(int[] arr, int[] ins, int pos) {
         if (arr == null || ins == null) {
             throw new IllegalArgumentException("Массивы не должны быть null");
         }
         if (pos < 0 || pos > arr.length) {
             throw new IllegalArgumentException("Некорректная позиция");
         }
         int[] result = new int[arr.length + ins.length];
         System.arraycopy(arr, 0, result, 0, pos);
         System.arraycopy(ins, 0, result, pos, ins.length);
         System.arraycopy(arr, pos, result, ins.length + pos, arr.length - pos);
         return result;
     }
}
