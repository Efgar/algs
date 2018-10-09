package com.efgh.simple;

public class Fibonacci {
    /**
     * @param n id of fibonacci term to be returned
     * @return  N'th term of Fibonacci sequence
     */
    public long fib(int n) {
        if(n < 0){
            throw new IllegalArgumentException("Invalid value");
        }
        if(n == 0){
            return 0L;
        }
        if(n == 1){
            return 1L;
        }
        return fib(n-1) + fib(n-2);
    }
}
