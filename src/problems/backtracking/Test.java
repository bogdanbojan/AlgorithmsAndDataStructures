package problems.backtracking;

import java.util.HashSet;

public class Test {

    public static int countGoodSubstrings(String s) {
        int count = 0;
        int length = 3;

        HashSet<Character> substr = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            substr.add(s.charAt(i));

            if (i > length - 1) {
                substr.remove(s.charAt(i - length));
            }

            if (i >= length - 1) {
                if (substr.size() == length) {
                    count++;
                }
            }
        }


        return count;


    }

    public static void main(String[] args)
    {
        String testString = "aababcabc";
        System.out.println(countGoodSubstrings(testString));
    }

}