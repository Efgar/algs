package com.efgh.simple;

/**
 * Write the factorial method to return unity digit of the factorial of n (n!).
 */
public class Factorial {
    /**
     * @param n Input number for factorial
     * @return Unity digit of the factorial
     */
    public int factorial(int n) {
        if(n <=1 ){
            return 1;
        }

        int factorial = n;
        while(n > 1){
            n--;
            factorial = factorial * n;
        }
        return factorial % 10;
    }
}
