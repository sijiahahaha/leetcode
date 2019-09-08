class Solution {
    private int index;
    public String countOfAtoms(String formula) {
        if (formula == null || formula.length() == 0) return formula;
        index = 0;
        Map<String, Integer> map = dfs(formula.toCharArray());
        StringBuilder sb = new StringBuilder();
        for (String atom : map.keySet()) {
            sb.append(atom);
            if (map.get(atom) > 1) {
                sb.append(map.get(atom));
            }
        }
        
        return sb.toString();
    }
    
    private Map<String, Integer> dfs(char[] formula) {
        Map<String, Integer> map = new TreeMap<>();
        while (index < formula.length) {
            if (formula[index] == '(') {
                index ++;
                Map<String, Integer> subMap = dfs(formula);
                int count = getCount(formula);
                for (String atom : subMap.keySet()) {
                    if (!map.containsKey(atom)) map.put(atom, 0);
                    map.put(atom, map.get(atom) + subMap.get(atom) * count);
                }
            } else if (formula[index] == ')') {
                index++;
                return map;
            } else {
                String atom = getAtom(formula);
                int count = getCount(formula);
                if (!map.containsKey(atom)) map.put(atom, 0);
                map.put(atom, map.get(atom) + count);
            }
        }
        return map;
    }
    
    private String getAtom(char[] formula) {
        StringBuilder sb = new StringBuilder();
        sb.append(formula[index++]);
        while (index < formula.length && Character.isLowerCase(formula[index])) {
            sb.append(formula[index++]);
        }
        return sb.toString();
    }
    
    private int getCount(char[] formula) {
        StringBuilder sb = new StringBuilder();
        while (index < formula.length && Character.isDigit(formula[index])) {
            sb.append(formula[index++]);
        }
        return sb.length() == 0 ? 1 : Integer.valueOf(sb.toString());
    }
}