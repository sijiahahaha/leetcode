/**  
There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

1.统计inDegree
2.把inDegree=0的点放入queue
3.BFS.每到一个新节点，inDegree-1，如果inDegree=0，放入queue，count++
4.count = size，则全部点都走了。否则有环状依赖

**/



import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //in degree
        int[] degree = new int[numCourses];
        for (int[] pair : prerequisites) {
            degree[pair[0]] ++;
        }
        //offer(indegree=0)
        int count = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                que.offer(i);
                count ++;
            }
        }
        //BFS, indegree --, offer()if = 0
        while (!que.isEmpty()) {
            int req = que.poll();
            for (int[] pair : prerequisites) {
                if (pair[1] == req) {
                    degree[pair[0]] --;
                    if (degree[pair[0]] == 0) {
                        que.offer(pair[0]);
                        count ++;
                    }
                }
            }
        }
        //check count = all
        return count == numCourses;
    }
}