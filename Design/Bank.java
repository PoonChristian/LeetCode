// LeetCode 2043: Simple Bank System
// https://leetcode.com/problems/simple-bank-system/

// Implementation: Simulate bank operations while being conscious of error checking
public class Bank {
    // Initialize a balance array to keep track of all the accounts
    // For comments, n == balance.length
    private long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        // A transfer is valid if and only if:
        // 1. account1 is between [1,n] inclusive
        // 2. account2 is between [1,n] inclusive
        // 3. account1 has enough money to transfer to account2
        if (isValidAccount(account1) && isValidAccount(account2) && money <= balance[account1 - 1]) {
            balance[account2 - 1] += money;
            balance[account1 - 1] -= money;
            return true;
        }
        
        return false;
    }
    
    public boolean deposit(int account, long money) {
        // A deposit is valid if and only if:
        // 1. account is between [1,n] inclusive
        // 2. money is greater than or equal to 0
        if (isValidAccount(account) && money >= 0) {
            balance[account - 1] += money;
            return true;
        }
        
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        // A withdrawal is valid if and only if:
        // 1. account is between [1,n] inclusive
        // 2. account has enough money to withdraw
        if (isValidAccount(account) && money <= balance[account - 1]) {
            balance[account - 1] -= money;
            return true;
        }
        
        return false;
    }

    // Helper function to determine whether or not an account number is valid
    private boolean isValidAccount(int account) {
        return account >= 1 && account <= balance.length;
    }
}
