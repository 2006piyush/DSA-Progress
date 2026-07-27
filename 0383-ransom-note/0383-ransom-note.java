class Solution {
    public boolean canConstruct(String r, String m) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < r.length(); i++) {
            char ch = r.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < m.length(); i++) {
            char ch = m.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        for (Character key : map1.keySet()) {
            if (!map2.containsKey(key) || map2.get(key) < map1.get(key)) {
                return false;
            }
        }

        return true;
    }
}