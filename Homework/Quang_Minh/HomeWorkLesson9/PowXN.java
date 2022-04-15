package HomeWorkLesson9;

public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 2) return x * x;
        if (n < 0) return 1 / x * myPow(1 / x, -(n + 1));
        if (n % 2 == 0) return myPow(myPow(x, n / 2), 2);
        return x * myPow(myPow(x, n / 2), 2);
    }
}
