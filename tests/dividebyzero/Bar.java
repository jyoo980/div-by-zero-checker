import org.checkerframework.checker.dividebyzero.qual.*;

class Bar {

    public static void test_long_winded_denominator_zero() {
        int a = 11;
        int b = (1 + 1 - 2) * (12 + 4 - 16);
        // :: error: divide.by.zero
        int c = a / b;
    }

    public static void test_zero_div_zero() {
        // Working with literals
        // :: error: divide.by.zero
        int a = 0 / 0;

        // With variables
        int b = 0;
        int c = 0;
        // :: error: divide.by.zero
        int d = b / c;
    }

    public static void test_limitations_of_checker_false_positive() {
        int a = 2340;
        int b = 2340 + -2342;

        // Checker should report an error here due to how
        // the transfer function for addition is implemented.
        // A positive number plus a negative number is Top.
        // :: error: divide.by.zero
        int d = a / b;
    }

    public static void test_arithmetic_expr_in_conditional() {
        int denominator = 0;
        if (denominator == 1 - 1) {
            // :: error: divide.by.zero
            int foo = 1 / denominator;
        } else {
            // The Checker should NOT raise an error here.
            int bar = 1 / denominator;
        }
    }
}
