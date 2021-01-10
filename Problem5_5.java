import java.math.BigInteger;
import java.util.Scanner;

public class Problem5_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long beforeTime = System.currentTimeMillis();

        System.out.println(factorial1(n));

        long afterTime = System.currentTimeMillis();
        System.out.println("시간차이(ms): " + (afterTime-beforeTime));

        beforeTime = System.currentTimeMillis();

        /*System.out.println(factorial2(n));

        afterTime = System.currentTimeMillis();
        System.out.println("시간차이(ms): " + (afterTime-beforeTime));

        beforeTime = System.currentTimeMillis();*/

        System.out.println(factorial3(n));

        afterTime = System.currentTimeMillis();
        System.out.println("시간차이(ms): " + (afterTime-beforeTime));

    }

    public static BigInteger factorial1(int n) {
        BigInteger result = new BigInteger("1");
        for (int i=1; i<=n; i++) {
            result = result.multiply(new BigInteger(Integer.toString(i)));
        }
        return result;
    }

    public static BigInteger factorial2(int n) {
        if (n<=1) {
            return new BigInteger("1");
        }
        return (new BigInteger(Integer.toString(n)).multiply(factorial2(n-1)));
    }

    public static BigInteger factorial3(int n) {
        return factorial4(n, new BigInteger("1"));
    }

    public static BigInteger factorial4(int n, BigInteger result) {
        if (n==1) {
            return result;
        }
        else {
            return factorial4(n-1, new BigInteger(Integer.toString(n)).multiply(result));
        }
    }
}
