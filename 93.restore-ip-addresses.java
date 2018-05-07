class Solution {
    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() < 4) {
        	return new ArrayList<>();
        }
        return restoreIpAddresses(s, 0, 4);
    }

    public List<String> restoreIpAddresses(String s, int st, int k) {
    	List<String> results = new ArrayList<>();
    	if(k == 0 && st == s.length()) {
    		results.add("");
    		return results;
    	} else if(k <= 0 || st >= s.length()) {
    		return results;
    	}
    	for(int i=1; i<=3; i++) {
    		if(i >= 2  && s.charAt(st) == '0') {
    			break;
    		}
    		if(s.length() - st >= i) {
    			int ip = Integer.valueOf(s.substring(st, st+i));
    			if(ip <= 255 && ip >= 0) {
	    			List<String> ri = restoreIpAddresses(s, st+i, k-1);
	    			for(String r : ri) {
	    				results.add(s.substring(st, st+i) + ("".equals(r) ? "" : "." + r));
	    			}
    			}
    		}
    	}
    	return results;
    }
}
