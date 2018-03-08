package recursion;

public class Problems {

    /*
     * T(N)= 1+T(n-1)
     * O(N)
     *
     * */
    public static int factorial(int n) {
        if (n == 0 || n == 1 || n == 2) return n;
        return n * factorial(n - 1);
    }

    /*
     *T(N)=1+T(n-1)+T(n-2)
     *
     * T(1)=1
     * T(N-1)= 1+ T(n-2)+T(n-3)
     * T(N-2)= 1+ T(n-3)+T(n-4)
     *
     */
    public static int fib(int n) {
        if (n == 1 || n == 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    public static int pow(int n, int k) {
        if (k == 1) return n;
        return n * pow(n, k - 1);
    }

    public static int sumOfDigits(int number) {
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            number = number / 10;
            sum += digit;
        }

        return sum;
    }

    public static int sumOfDigitsRecursive(int number) {

        if (number <= 0) return 0;

        int digit = number % 10;
        return digit + sumOfDigits(number / 10);
    }

    public static String decToBin(int n) {

        if (n == 0) return "0";

        int result = n % 2;
        return decToBin(n / 2) + result;
    }

    public static int findMin(int[] arr, int i, int min) {
        if (arr.length == i) return min;

        min = Math.min(min, arr[i]);
        return findMin(arr, i + 1, min);
    }
}
