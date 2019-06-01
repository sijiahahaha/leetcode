/**
swap two digit make the num max : 1993 -> 9913

希望把高位上的小数和最低位大数换

对于每一位，找到右边最大数
第一个最大数不是本身的，置换
 1 9 9 3

 **/

class Solution {
    public int maximumSwap(int num) {
    	if (num <= 9) {
    		return num;
    	}

    	char[] numc = String.valueOf(num).toCharArray();

    	for (int i = 0; i < numc.length; i++) {
    		int maxIndex = i;
    		int curr = numc.length - 1;
    		while (curr >= i) {
    			if (numc[curr] > numc[maxIndex]) {
    				maxIndex = curr;
    			}
    			curr--;
    		}
    		if (maxIndex > i) {
    			char temp = numc[maxIndex];
    			numc[maxIndex] = numc[i];
    			numc[i] = temp;
    			break;
    		}
    	}
    	return Integer.valueOf(new String(numc));
    	
    }
    
}

