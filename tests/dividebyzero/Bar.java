import org.checkerframework.checker.dividebyzero.qual.*;

class Bar {

    public static void test_long_winded_denominator_zero() {
        int a = 420;
        int b = (1 + 1 - 2) * (12 + 4 - 16);
        // :: error: divide.by.zero
        int c = a / b;
    }
}
