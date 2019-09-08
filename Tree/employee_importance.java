employee_importance.java
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int res = 0;
        if (employees == null) return res;

        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int sum = 0;
        while (!queue.isEmpty()) {
            int currId = queue.poll();
            sum += map.get(currId).importance;
            for (Integer subEid : map.get(currId).subordinates) {
                queue.offer(subEid);
            }
        }
        return sum;
    }
}