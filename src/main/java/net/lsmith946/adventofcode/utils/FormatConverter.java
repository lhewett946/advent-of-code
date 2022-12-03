package net.lsmith946.adventofcode.utils;

import java.util.HashSet;
import java.util.Set;

public class FormatConverter {

    public static Set<Character> stringToCharSet(String s) {
        Set<Character> charSet = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            charSet.add(s.charAt(i));
        }
        return charSet;
    }
}
