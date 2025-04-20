import java.util.Random;

public class Fermat {
    public static void main(String[] args) {
       int num = 22;
        System.out.println("Testing number: " + num);

        double start1 = System.nanoTime();
        System.out.println("isPrimeOne: " + isPrimeOne(num));
        double finish1 = System.nanoTime();
        System.out.println("Time: " + (finish1 - start1) / 100000 + " ms");

        double start2 = System.nanoTime();
        System.out.println("isPrimeTwo: " + isPrimeTwo(num, 10)); // 10 random bases
        double finish2 = System.nanoTime();
        System.out.println("Time: " + (finish2 - start2) / 1000000 + " ms");


    }

    public static boolean isPrimeOne(int p) {
        if (p < 2) return false;//all numbers less than 2 arent primes

        if (p == 2) return true;

        if (p % 2 == 0) return false; // rule of prime's numbres (3th if)


        for (int i = 3; i * i <= p; i += 2) {
            if (p % i == 0) return false;
        }// why i*i<=p is better than i<=sqrt p because sqrt need more time
        // and isnt the object in this task, and why we use i*i ^ i+=2?
        //because we need a lot of time if we use like 3,4,5,6,7,8,9,10 until
        // sqrt p, is better use odd numbers we use less steps and beacuse 4,6,8
        // work in  the 3th if, and why until i*i, becuase if they have one number
        // for example inside the for thats mean that isnt prime, for example,
        // we need to know that always in number that isnt prime have more divisor
        // that 1 and the number for example 36, 1*36, 2*18,3*12,4*9,6*6, we noticed
        //that the maximun numer is 6 = sqrt p, p=36, thats mean that 36=a*b, where
        // a or b should be <= sqrt 6 , and if exits number in i*i<=p , this for is
        // for odd number and if inside the for exist number that p%i==0 then
        // this number p isnt prime.
        return true;
    }

    public static int expBySquaring(int base, int exp, int mod) {
        //method for find (base^exp) mod

        int result = 1;
        base %= mod; // base^n mod x == (base mod x)^n modx , we used this method
        //for use less numbers in ^
        while (exp > 0) {
            if ((exp & 1) == 1) {// & is for compare bits for example 5 = 0101 y 1 = 0001
                // & is AND is true when both are 1 , 5 & 1 = 0001 ==1 , odd number.
                // is the same exp &1 == exp%2==1 when exp is ood number
                result = (result * base) % mod; // reuslt save the number when is odd number
            }
            exp /=2 ; // in Yt i found that exp/=2 == exp >>1;
            base = (base * base) % mod; // is like use binarian number for example 7 = 2^2 +2 + 2^0
        }
        return result;
    }
    //Ludwing Cerda

    public static boolean isPrimeTwo(int p, int k) {
        if (p <= 1) return false;
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            int a = 1 + random.nextInt(p - 1); // Random a en [1, p-1]
            if (expBySquaring(a, p - 1, p) != 1) return false;
            // we need to remember that a^p-1 ==1(mod p), p is the number
        }
        // for verify if is prime or not. a is a number between 1<=a<=p-1;
        return true; // if the result is =1 is prime , Fermat's theorem
    }
}
