package com.drbhagwat;

import java.util.HashMap;
import java.util.Map;

public class IsAStringPermutationOfOther {
  private static void buildMap(String string, Map<Character, Integer> map) {
    int stringLength = string.length();

    for (int i = 0; i < stringLength; i++) {
      Character c = string.charAt(i);
      Integer frequency = 1;

      if (map.containsKey(c)) {
        frequency = map.get(c);
        map.replace(c, ++frequency);
      } else {
        map.put(c, frequency);
      }
    }
  }

  private static boolean isStringPermutationOfOtherString(String firstString,
                                                          String secondString) {
    int stringLength1 = firstString.length();
    int stringLength2 = secondString.length();
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();

    if (stringLength1 != stringLength2) {
      return false;
    }
    buildMap(firstString, map1);
    buildMap(secondString, map2);
    boolean isFirstStringAPermutationOfSecondString = true;

    for (int i = 0; i < stringLength1; i++) {
      Character c = firstString.charAt(i);
      Integer frequency1 = map1.get(c);

      if (!map2.containsKey(c)) {
        return false;
      }
      Integer frequency2 = map2.get(c);

      if (!frequency1.equals(frequency2)) {
        return false;
      }
    }
    return isFirstStringAPermutationOfSecondString;
  }

  public static void main(String[] args) {
    System.out.println(isStringPermutationOfOtherString("abc", "cab"));
  }
}
