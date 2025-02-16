package day35_Hashing;

import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram1(String str1, String str2) {
        // Check if lengths of strings are same
        if (str1.length()!= str2.length()) {
            return false;
        }

        // Create a character count array
        int[] count = new int[26];

        // Count characters in str1
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
        }

        // Decrease count for characters in str2
        for (int i = 0; i < str2.length(); i++) {
            count[str2.charAt(i) - 'a']--;
            if (count[str2.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        // If all counts are zero, return true
        return true;
    }
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch) || map.get(ch) == 0) return false;
            map.put(ch, map.get(ch) - 1);
        }
        // Ensure all counts are zero
        for (int count : map.values()) {
            if (count != 0) return false;
        }

        return true;
    }
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch)) return false;

            // Decrement count
            map.put(ch, map.get(ch) - 1);

            // Remove entry if count becomes zero
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s = "listen";// o(n)
        String t = "silent";

        System.out.println(isAnagram2(s, t));
    }
}
