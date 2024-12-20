package com.rosszhang.javaallinone.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSubstrings {

    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;

        Map<Character, List<Integer>> charIndex = new HashMap<>();
        int result = s.length();
        char[] chars = s.toCharArray();
        List list = new ArrayList<>();
        list.add(0);
        charIndex.put(chars[0], new ArrayList<>(list));


        for(int i = 1; i < chars.length; ++i){
            list.clear();
            var temp = charIndex.get(chars[i]);

            if(temp != null){       //头尾相等 存在可能的字符串
                for(int index : temp){
                    StringBuilder m1 = new StringBuilder(s.substring(index, i+1));
                    StringBuilder m2 = new StringBuilder(s.substring(index, i+1)).reverse();
                    if(m1.toString().equals(m2.toString())) {   //为回文子串
                        System.out.println(m1);
                        System.out.println(m2);
                        ++result;
                    }
                }
                temp.add(i);
            }else {
                list.add(i);
                charIndex.put(chars[i], new ArrayList<>(list));
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountSubstrings().countSubstrings("fdsklf"));
    }
}
