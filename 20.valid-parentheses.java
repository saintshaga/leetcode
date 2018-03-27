class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
        	return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        LinkedList<Character> stack = new LinkedList<>();
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if(map.keySet().contains(c)) {
        		stack.push(c);
        	} else if (stack.isEmpty() || map.get(stack.pop()) != c){
        		return false;
        	}
        }
        return stack.isEmpty();
    }
}
