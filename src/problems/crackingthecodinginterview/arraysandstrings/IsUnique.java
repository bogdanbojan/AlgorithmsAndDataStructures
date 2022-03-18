package problems.crackingthecodinginterview.arraysandstrings;

import java.util.Arrays;
import java.util.HashSet;

public class IsUnique {

    private static boolean isUniqueSet(String string)
    {
        HashSet<Character> stringSet = new HashSet<>();
        for (Character c : string.toCharArray())
        {
            stringSet.add(c);
        }

        return stringSet.size() == string.length();
    }

    private static boolean isUniqueSort(String string)
    {
        char[] stringChars = string.toCharArray();
        Arrays.sort(stringChars);
        for (int i = 0; i < stringChars.length; i++)
        {
            if ( i+1 < stringChars.length && stringChars[i] == stringChars[i+1]) return false;
        }

        return true;
    }

    private static boolean ctciIsUniqueChars(String str)
    {
        if (str.length() > 128) return false;

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++)
        {
            int val = str.charAt(i);
            if (charSet[val]) return false;
            charSet[val] = true;
        }
        return true;
    }

    public static void main(String[] args)
    {
        String testString = "alphabet";
        isUniqueSet(testString);
    }
}
