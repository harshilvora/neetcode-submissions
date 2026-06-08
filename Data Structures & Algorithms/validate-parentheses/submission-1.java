class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        ArrayList<Character> openB = new ArrayList<>(List.of('(', '[', '{'));
        for (Character ch : s.toCharArray()) {
            if (openB.contains(ch)) {
                st.push(ch);
            } else {
                if (st.size() > 0 && st.pop() == map.get(ch)) {
                    continue;
                } else{
                    return false;
                }
            }
        }
        return true && st.size()==0;
    }
}
