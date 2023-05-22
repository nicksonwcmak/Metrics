package main;
// represents the Hamming distance
public class HammingDist implements Metric<String>{
    // returns the distance between t1 and t2 under the Hamming distance
    // returns the number of spaces where t1 and t2 differ
    @Override
    public Integer dist(String t1, String t2) {
        if (t1.length() != t2.length()) {
            throw new DifferentSizeException();
        }
        int diffs = 0;
        for (int i=0; i < t1.length(); i++) {
            if (t1.charAt(i) != t2.charAt(i)) {
                diffs++;
            }
        }
        return diffs;
    }
}
