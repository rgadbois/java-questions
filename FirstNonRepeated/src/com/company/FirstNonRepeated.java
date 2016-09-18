package com.company;

import java.util.HashMap;

/**
 * Created by rgadbois on 9/17/16.
 */
public class FirstNonRepeated {

    private String value;
    HashMap<Character,Integer> wordCount;

    public FirstNonRepeated(String value) {
        this.value = value;
        this.wordCount = new HashMap<Character,Integer>();
    }
    public void process() {
        for (Character c : value.toCharArray()) {
            if (wordCount.containsKey(c)) {
                Integer count = wordCount.get(c);
                wordCount.put(c,count+1);
            } else {
                wordCount.put(c,1);
            }
        }
    }
    public Character firstNonRepeatedChar() {
        for (int i=0; i < value.length(); i++) {
            char c = value.charAt(i);
            Integer count = wordCount.get(c);
            if (count == 1) {
                return c;
            }
        }
        return null;
    }

}
