class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, Character[]> map = new HashMap<>();
        map.put('2', new Character[] {'a', 'b', 'c'});
        map.put('3', new Character[] {'d', 'e', 'f'});
        map.put('4', new Character[] {'g', 'h', 'i'});
        map.put('5', new Character[] {'j', 'k', 'l'});
        map.put('6', new Character[] {'m', 'n', 'o'});
        map.put('7', new Character[] {'p', 'q', 'r', 's'});
        map.put('8', new Character[] {'t', 'u', 'v'});
        map.put('9', new Character[] {'w', 'x', 'y', 'z'});
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;
        recurse(map, digits, new String(), ans, 0);
        return ans;
    }

    public void recurse(HashMap<Character, Character[]> map, String digits, String curr,
        List<String> ans, int ind) {
        if (curr.length() == digits.length()) {
            ans.add(curr);
            return;
        }

        for (int i = ind; i < digits.length(); i++) {
            Character[] chArr = map.get(digits.charAt(i));
            for (int j = 0; j < chArr.length; j++) {
                curr += chArr[j];
                recurse(map, digits, curr, ans, i + 1);
                curr = curr.substring(0, curr.length() - 1);
            }
        }
    }
}
