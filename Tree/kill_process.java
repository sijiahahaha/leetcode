kill_process.java
public class Solution {
    /**
     * @param pid: the process id
     * @param ppid: the parent process id
     * @param kill: a PID you want to kill
     * @return: a list of PIDs of processes that will be killed in the end
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        if (pid == null || ppid == null || pid.size() != ppid.size()) return res;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            if (!map.containsKey(ppid.get(i))) map.put(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);
            if (map.containsKey(curr)) {
                for (int parent : map.get(curr)) {
                    queue.offer(parent);
                }
            }
        }
        return res;
    }
}