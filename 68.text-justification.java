class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> results = new ArrayList<>();
    	int i = 0, st = 0, ed = -1;
    	int length = 0, actualLength = 0;
    	while(i < words.length) {
    		if(length + words[i].length() < maxWidth) {
    			length += words[i].length() + 1;
    			actualLength += words[i].length();
    			ed = i;
    			i++;
    		} else if(length + words[i].length() == maxWidth) {
    			//"abcd abcd abc"
    			ed = i;
    			actualLength += words[i].length();
    			results.add(formatString(words, st, ed, actualLength, maxWidth));
    			st = ++i;
    			length = 0;
    			actualLength = 0;
    		} else {
    			results.add(formatString(words, st, ed, actualLength, maxWidth));
    			st = i;
    			length = 0;
    			actualLength = 0;
    		}
    	}
    	if(st < words.length) {
    		StringBuilder sb = new StringBuilder();
    		for(i=st; i<words.length; i++) {
    			sb.append(words[i]);
    			sb.append(" ");
    		}
    		sb.append(generateSpaces(maxWidth - sb.length()));
    		results.add(sb.toString());
    	}
    	return results;
    }

    private String formatString(String[] words, int st, int ed, int actualLength, int maxWidth) {
    	if(st > ed) {
    		return null;
    	} else if(st == ed) {
    		return words[st] + generateSpaces(maxWidth - actualLength);
    	}
    	StringBuilder sb = new StringBuilder();
    	int leftSpaces = maxWidth - actualLength;
		int numOfEachSpaces = leftSpaces/(ed - st);
    	int restOfEachSpaces = leftSpaces%(ed-st);
    	for(int j=st; j<=ed; j++) {
    		sb.append(words[j]);
    		if(j != ed) {
				sb.append(generateSpaces(restOfEachSpaces-- > 0 ? numOfEachSpaces + 1 : numOfEachSpaces));
    		}
    	}
    	return sb.toString();
    }

    private String generateSpaces(int n) {
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<n; i++) {
    		sb.append(" ");
    	}
    	return sb.toString();
    }
}
