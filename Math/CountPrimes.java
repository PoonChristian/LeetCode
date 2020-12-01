// LeetCode 204: Count Primes
// https://leetcode.com/problems/count-primes/
// The Sieve of Eratosthenes
// Based on this elementary video explanation of the Sieve of Eratosthenes: https://youtu.be/Lj_SzTGr-G4

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        
        Arrays.fill(primes, true);
        
        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        
        int numPrimes = 0;
        
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                numPrimes++;
            }
        }
        
        return numPrimes;
    }
}
