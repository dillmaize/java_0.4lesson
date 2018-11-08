package ru.stqa.ak.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

    @Test
    public void testPrimes(){
        Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
    }

    @Test
    public void testNonPrime(){

        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
    }

    @Test
    public void testPrimeLong(){
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrime(n));
    }

}
