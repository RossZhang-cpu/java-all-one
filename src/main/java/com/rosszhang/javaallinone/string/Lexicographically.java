package com.rosszhang.javaallinone.string;

public class Lexicographically {
    /**
     * Given a string s consisting of lowercase English letters. Perform the following operation:
     *
     * Select any non-empty
     * substring
     *  then replace every letter of the substring with the preceding letter of the English alphabet. For example, 'b' is converted to 'a', and 'a' is converted to 'z'.
     * Return the
     * lexicographically smallest
     *  string after performing the operation.
     *
     */
    public String smallestString(String s) {
        char[] chars = s.toCharArray();
        int performTimes = 0;
        int i = 0;
        for (; i < chars.length; ++i) {
            if (chars[i] != 'a') {
                chars[i] = (char) (chars[i] - 1);
                ++performTimes;
            } else if (performTimes > 0) {
                break;
            }
        }
        if (performTimes == 0) {
            chars[chars.length - 1] = ((char) (chars[chars.length - 1] + 25));
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Lexicographically lexicographically = new Lexicographically();
        String s = lexicographically.smallestString("aa");
        System.out.println(s);
    }

}
