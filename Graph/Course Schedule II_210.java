/**  
There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

1.统计inDegree
2.把inDegree=0的点放入queue, 存到result中
3.BFS.每到一个新节点，inDegree-1，如果inDegree=0，放入queue，存到result中，count++
4.count = size，则全部点都走了。否则有环状依赖

**/



import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> que = new LinkedList<>();
        int[] degree = new int[numCourses];
        int count = 0;
        int[] result = new int[numCourses];
        
        for (int[] pair : prerequisites) {
            degree[pair[0]] ++;
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                que.offer(i);
                result[count] = i;
                count ++;
            }
        }
        
        
        while (!que.isEmpty()) {
            int req = que.poll();
            for (int[] pair : prerequisites) {
                if (pair[1] == req ) {
                    degree[pair[0]] --;
                    if (degree[pair[0]] == 0) {
                        que.offer(pair[0]);
                        result[count] = pair[0];
                        count ++;
                    }
                }
            }
        }
        
        if (count != numCourses) {
            return new int[0];
        }
        return result;
    }
}