/**  
一个处理器要处理一堆request，一次只能处理一条，每次执行一个任务最多执行时间q，接着执行等待着的下一个任务。若前一个任务没执行完则放到队尾，等待下一次执行

假设只要有任务开始以后cpu是不会空闲的，也就是说cpu开始后如果空闲了就说明没有任务了，另外Robin Round最后返回值是float


**/



import java.util.LinkedList;
import java.util.Queue;

class process {
    int arrTime;
    int exeTime;
    process(int arr, int exe) {
        arrTime = arr;
        exeTime = exe;
    }
}

public class RoundRobinScheduling {
    public float Solution(int[] Atime, int[] Etime, int q) {
        if (Atime == null || Etime == null || Atime.length != Etime.length)
            return 0;
        int length = Atime.length;
        Queue<process> queue = new LinkedList<process>();
        int curTime = 0, waitTime = 0;
        int index = 0;
        while (!queue.isEmpty() || index < length) {
            if (!queue.isEmpty()) {
                process cur = queue.poll();
                waitTime += curTime - cur.arrTime;
                curTime += Math.min(cur.exeTime, q);
                for (; index < length && Atime[index] <= curTime; index++)
                    queue.offer(new process(Atime[index], Etime[index]));
                if (cur.exeTime > q)
                    queue.offer(new process(curTime, cur.exeTime - q));
            }
            else {
                queue.offer(new process(Atime[index], Etime[index]));
                curTime = Atime[index++];
            }
        }
        return (float) waitTime / length;
    }
}