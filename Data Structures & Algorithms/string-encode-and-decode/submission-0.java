class Solution {

    //Naive Solution of adding a Non ASCII Separator
    public String encode(List<String> strs) {
        String out = new String();
        for(String str: strs){
            out += str+'~';
        }
        return out;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        StringBuilder b = new StringBuilder();
        for(Character c: str.toCharArray()){
            if(c == '~'){
                ans.add(b.toString());
                b = new StringBuilder();
            }
            else
                b.append(c);
        }
        return ans;
    }
}
