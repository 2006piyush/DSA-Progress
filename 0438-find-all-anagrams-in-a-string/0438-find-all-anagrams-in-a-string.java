class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
        }

        if (map.equals(window)) {
            list.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            char left = s.charAt(i - p.length());
            window.put(left, window.get(left) - 1);
            if (window.get(left) == 0) {
                window.remove(left);
            }
            char right = s.charAt(i);
            window.put(right, window.getOrDefault(right, 0) + 1);
            if (map.equals(window)) {
                list.add(i - p.length() + 1);
            }
        }
        return list;
    }
}