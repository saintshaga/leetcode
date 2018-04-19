class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if(strs == null || strs.length == 0) {
        	return results;
        }
        Map<String, List<String>> map = new LinkedHashMap<>();
        for(String str : strs) {
        	char[] chars = str.toCharArray();
        	Arrays.sort(chars);
        	String key = new String(chars);
        	List<String> row = map.getOrDefault(key, new ArrayList<>());
        	row.add(str);
        	map.put(key, row);
        }
        results = new ArrayList<>(map.values());
        Comparator<List<String>> comparator = Comparator.comparingInt(List::size);
        Collections.sort(results, comparator);
        results.stream().forEach(Collections::sort);
        return results;
    }
}
