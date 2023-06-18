package main;

// class representing the p-adic distance (over integers only, for simplicity)
public class PAdicDistance implements Metric<Integer>{
    private static int p; //prime we are working with

    // sets this metric to calculate the p-adic distance, for given prime
    // REQUIRES: "prime" is prime
    public PAdicDistance(int prime) {
        p = prime;
    }

    public int getPrime() { return p; }

    // returns the p-adic distance between t1 and t2
    @Override
    public Double dist(Integer t1, Integer t2) {
        return PAdicAbsVal(t1 - t2);
    }

    // returns the p-adic absolute value of i
    public double PAdicAbsVal(int i) {
        if (i==0){
            return 0;
        } else {
            return Math.pow(p,-1 * PAdicVal(i));
        }
    }

    // returns the p-adic valuation of i
    // that is, the number of times p divides i
    // REQUIRES: i != 0
    // RETURNS: number of factors of p in i (non-negative integer)
    private int PAdicVal(int i) {
        int n = 0;
        int curr = i;
        while ((curr % p) == 0) { //while curr divisible by p
            curr /= p; // next curr is this curr divided by p
            n++; // increment counter of number of factors of p in curr
        }
        return n;
    }
}
