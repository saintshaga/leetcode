class Solution {
	// 	public boolean checkInclusion(String s1, String s2) {
	// 	if(s1 == null || s1.length() == 0) {
	// 		return true;
	// 	} else if(s2 == null || s2.length() == 0 || s1.length() > s2.length()) {
	// 		return false;
	// 	}
	// 	int[] stat1 = new int[26];
	// 	int[] stat2 = new int[26];
	// 	for(int i=0; i<s1.length(); i++) {
	// 	    stat1[s1.charAt(i)-'a']++;
	// 	}
	// 	int st=0;
	// 	for(int i=0; i<s2.length(); i++) {
	// 		char c = s2.charAt(i);
	// 		if(stat1[c-'a'] == 0) {
	// 			st = i+1;
	// 			initialArray(stat2);
	// 		} else {
	// 		    stat2[c-'a']++;
	// 			if(i-st+1 > s1.length()) {
	// 				char ignoredChar = s2.charAt(st);
	// 				stat2[ignoredChar-'a']--;
	// 				st++;
	// 			}
	// 			if(i-st+1 == s1.length() && isSame(stat1, stat2)) {
	// 				return true;
	// 			}
	// 		}
	// 	}
	// 	return false;
	// }

	// private void initialArray(int[] a) {
	//     for(int i=0; i<a.length; i++) {
	//         a[i] = 0;
 //        }
 //    }

 //    private boolean isSame(int[] a, int[] b) {
	//     for(int i=0; i<a.length; i++) {
	//         if(a[i] != b[i]) {
	//             return false;
 //            }
 //        }
 //        return true;
 //    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.length() == 0) {
        	return true;
        } else if(s2 == null || s2.length() == 0 || s1.length() > s2.length()) {
        	return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        for(int i=0; i<s1.length(); i++) {
        	int value = map1.getOrDefault(s1.charAt(i), 0);
        	map1.put(s1.charAt(i), value+1);
        }
        int st=0;
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<s2.length(); i++) {
        	char c = s2.charAt(i);
        	if(!map1.containsKey(c)) {
        		st = i+1;
        		map2.clear();
        	} else {
        		int count = map2.getOrDefault(c, 0) + 1;
        		map2.put(c, count);
        		if(i-st+1 > s1.length()) {
      				char ignoredChar = s2.charAt(st);
        			map2.put(ignoredChar, map2.get(ignoredChar)-1);
        			st++;
        		}
        		if(i-st+1 == s1.length() && isPermutation(map1, map2)) {
        			return true;
        		}
        	}
        }
        return false;
    }

    private boolean isPermutation(Map<Character, Integer> map1, Map<Character, Integer> map2) {
    	for(char c : map1.keySet()) {
    		if(!map1.get(c).equals(map2.get(c))) {
    			return false;
    		}
    	}
    	return true;
    }
}
