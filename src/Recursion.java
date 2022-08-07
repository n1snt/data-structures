public class Recursion {

    void primeNumbers(int n) {
        // This method prints 1 to n prime numbers backward.
        if (n != 0) {
            System.out.println(n);
            primeNumbers(n-1);
        }
    }

    int factorial(int n) {
        if (n == 1 | n == 0) {
            return 1;
        }
        return n*factorial(n-1);
    }

    public static void main(String[] args) {
        Recursion recursionObject = new Recursion();
        recursionObject.primeNumbers(10);
        System.out.println(recursionObject.factorial(4));
    }

}
