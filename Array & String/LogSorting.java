/**  
给一个日志，由List< String >组成，每个元素代表一行日志。
每行日志的信息用一个空格分开，最前面的是日志的ID，后面是日志的内容，内容要么是全部由字母和空格组成，要么是全部由数字和空格组成。
现在将日志进行排序，要求字母内容按照内容字典序排序放在顶部，数字内容放到底部且按照输入顺序输出。
(注意，空格也属于内容，并且当字母内容字典序相等时，按照日志ID字典序排序，保证ID都不重复)

1. 从后往前遍历，如果内容是数字就直接按顺序放去result，如果是字符就单独放在一个List里
2. sort List
3. 按顺序把List加入到result
**/

public class Solution {
    /**
     * @param logs: the logs
     * @return: the log after sorting
     */
    public String[] logSort(String[] logs) {
        String[] result = new String[logs.length];
        int count = logs.length - 1;
        List<String> strList = new ArrayList<String>();
        for (int i = logs.length - 1; i >= 0; i--) {
            int index = logs[i].indexOf(' ');
            String body = logs[i].substring(index + 1);
            if (body.charAt(0) >= '0' && body.charAt(0) <= '9') {
                result[count] = logs[i];
                count--;
            } else {
                strList.add(logs[i]);
            }
        }
        
        Collections.sort(strList, new Comparator<Object>(){
            @Override
            public int compare(Object a, Object b) {
                String s1 = (String)a;
                String s2 = (String)b;
                int index1 = s1.indexOf(' ');
                int index2 = s2.indexOf(' ');
                String ID1 = s1.substring(0,index1);
                String ID2 = s2.substring(0,index2);
                String body1 = s1.substring(index1);
                String body2 = s2.substring(index2);
                
                if (body1.equals(body2)) {
                    return ID1.compareTo(ID2);
                } else {
                    return body1.compareTo(body2);
                }
            }
        });
        
        count = 0;
        for (String str : strList) {
            result[count] = str;
            count++;
        }
        return result;
    }
}