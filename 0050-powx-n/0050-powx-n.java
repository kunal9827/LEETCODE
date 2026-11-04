class Solution {

    public double power(double x, long n) {

        if (n == 0) return 1.0;
        if (n == 1) return x;

        double res = power(x, n / 2);

        if (n % 2 == 1) {
            return x * res * res;
        }

        return res * res;
    }

    public double myPow(double x, int n) {

        if (n < 0) {
            double ans = power(x, -(long)n);
            return 1.0 / ans;
        }

        return power(x, (long)n);
    }
}