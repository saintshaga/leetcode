class Solution {
    public String getHint(String secret, String guess) {
        int a=0, b=0;
        Map<Character, Set<Integer>> secretMap = new HashMap<>();
        for(int i=0; i<secret.length(); i++) {
        	Character c = secret.charAt(i);
        	if(!secretMap.containsKey(c)) {
        		secretMap.put(c, new HashSet<Integer>());
        	}
        	secretMap.get(c).add(i);
        }
        List<Character> bSet = new ArrayList<>();
        for(int i=0; i<guess.length(); i++) {
        	Character c = guess.charAt(i);
        	if(!secretMap.containsKey(c)) {
        		continue;
        	}
        	if(secretMap.get(c).contains(i)) {
        		a++;
        		secretMap.get(c).remove(i);
        		if(secretMap.get(c).isEmpty()) {
        			secretMap.remove(c);
        		}
        	} else {
        		bSet.add(c);
        	}
        }
        for(Character c : bSet) {
        	if(secretMap.containsKey(c)) {
        		b++;
        		int index = secretMap.get(c).iterator().next();
        		secretMap.get(c).remove(index);
        		if(secretMap.get(c).isEmpty()) {
        			secretMap.remove(c);
        		}
        	}
        }
        return "" + a + "A" + b + "B";
    }
}
