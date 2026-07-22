class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s2.charAt(i);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
        }
        if (map.equals(window)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            char left = s2.charAt(i - s1.length());
            window.put(left, window.get(left) - 1);
            if (window.get(left) == 0) {
                window.remove(left);
            }
            char right = s2.charAt(i);
            window.put(right, window.getOrDefault(right, 0) + 1);
            if (map.equals(window)) {
                return true;
            }
        }
        return false;
    }
}