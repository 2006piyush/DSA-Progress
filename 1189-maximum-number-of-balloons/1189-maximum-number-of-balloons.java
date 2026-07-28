class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>(); 
        map1.put('b', 1);
        map1.put('a', 1);
        map1.put('l', 2);
        map1.put('o', 2);
        map1.put('n', 1);
         for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        int ans = Integer.MAX_VALUE;
        String s = "balon"; 
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int available = map2.getOrDefault(ch, 0);
            int required = map1.get(ch);
            ans = Math.min(ans, available / required);
        }
        return ans;
    }   
}