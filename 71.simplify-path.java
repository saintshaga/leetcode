class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
        	return "/";
        }
        String[] elements = path.split("/");
        if(elements.length == 0) {
        	return "/";
        }
        List<String> effectiveElements = new ArrayList<>();
        for(String e : elements) {
        	if(".".equals(e) || e == null || e.length() == 0) {
        		continue;
        	} else if("..".equals(e)) {
        		if(effectiveElements.size() != 0) {
        			effectiveElements.remove(effectiveElements.size()-1);
        		}
        	} else {
        		effectiveElements.add(e);
        	}
        }
        if(effectiveElements.size() == 0) {
        	return "/";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : effectiveElements) {
        	sb.append("/");
        	sb.append(s);
        }
        return sb.toString();
    }
}
