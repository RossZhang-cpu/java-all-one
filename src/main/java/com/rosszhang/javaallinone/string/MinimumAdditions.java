package com.rosszhang.javaallinone.string;

public class MinimumAdditions {

    /**
     * Given a string word to which you can insert letters "a", "b" or "c" anywhere and any number of times, return the minimum number of letters that must be inserted so that word becomes valid.
     *
     * A string is called valid if it can be formed by concatenating the string "abc" several times.
     *
     *
     *
     * Example 1:
     *
     * Input: word = "b"
     * Output: 2
     * Explanation: Insert the letter "a" right before "b", and the letter "c" right next to "a" to obtain the valid string "abc".
     * Example 2:
     *
     * Input: word = "aaa"
     * Output: 6
     * Explanation: Insert letters "b" and "c" next to each "a" to obtain the valid string "abcabcabc".
     * @param word
     * @return
     *
     *
     *
     *0 1 2
     * abc
     *
     *
     * bb
     *
     * cb
     *
     * ab
     *
     * ba ca aa
     *
     * T[0] =
     * T[i] = count(i) + T[i - 1]
     *
     * count[i] = if it could be concatenated with previous word 0 j - i == 1
     *            else   j === i  2
     *                  j > i     j - i ==1  0
     *                            j - i == 2 1
     *             ab  bc  ac   j - i
     *
     *
     *    ba  cb        j < i     j - i = -1  1
          ca                    j - i   = -2 0
                        distance  ca  |2 - (0 + 3)| = 1   0
                                  ba  |1 - (0 + 3)| = 2   1
                                  cb  |2 - (1 + 3)| = 2   1

            distance = 1  0
            distance = 2
            distance = 0


     */



    public int addMinimum(String word) {
        int result = 0;
        char[] chars = word.toCharArray();
        result += chars[0] - 'a';
        for (int i = 1; i < chars.length; ++i) {
            char ch = chars[i];
            char pre = chars[i - 1];
            if (ch > pre) {
                result += ch - pre - 1;
            } else if (ch < pre) {
                result += ch + 3 - pre - 1;
            } else {
                result += 2;
            }
        }
        result += 'c' - chars[chars.length - 1];
        return result;
    }

    public static void main(String[] args) {
        MinimumAdditions additions = new MinimumAdditions();
        int i = additions.addMinimum("abc");
        System.out.println(i);
        i = additions.addMinimum("aaa");
        System.out.println(i);
    }

}
