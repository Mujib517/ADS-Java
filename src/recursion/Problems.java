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
}
