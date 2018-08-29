/**
将数字存入list， 用map记录<num, index>

insert: 看map里有没有，有了就return false，没有就放进list和map
delete：因为arraylist删除中间的项目，不是O(1)时间，只有删除最后一个才是O(1)。所以把要删除项和最后一项交换
random：nums.get(rand.nextInt(nums.size()));
**/


class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> map;
    Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        if (index < nums.size() - 1) {
            int lastNum = nums.get(nums.size() - 1);
            nums.set(index, lastNum);
            map.put(lastNum, index);
        }
        nums.remove(nums.size() - 1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */