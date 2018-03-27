class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
        	return new ArrayList<>();
        }
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return letterCombinations(digits, mapping, 0);
    }

    private List<String> letterCombinations(String digits, String[] mapping, int st) {
    	List<String> results = new ArrayList<>();
    	if(st == digits.length()) {
    		results.add("");
    		return results;
    	}
    	List<String> rnext = letterCombinations(digits,mapping, st+1);
    	String alphabet = mapping[digits.charAt(st) - '0'];
    	if(alphabet.length() == 0) {
    		return rnext;
    	} else {
    		for(int i=0; i<alphabet.length(); i++) {
    			for(String result : rnext) {
    				results.add("" + alphabet.charAt(i) + result);
    			}
    		}
    	}
    	return results;
    }
}
