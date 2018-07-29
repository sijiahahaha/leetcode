r/**  
每个学生有两个属性 id 和 scores。找到每个学生最高的5个分数的平均值。

PiorityQueue (fix size = 5) , 小先出， 留大。 用HashMap<Integer, PiorityQueue>储存学生的<id，top 5 score>

1.遍历list
    如果map中没有学生id，(!map.containsKey(id)), 则建立一个学生的<id,new pq>
    取出学生的pq
        如果size<5，offer()
        else, 比较peek()和score，当score大的时候，poll(),offer()
2.遍历map.entrySet()
    对于每个Map.Entry<> entry, id = entry.getKey(), pq<Integer> = entry.getValue, 求出average, 放入answer

**/



/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
import java.util.PiorityQueue;
import java.util.HashMap;
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> result = new HashMap<Integer, Double>();
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        if (results == null || results.length == 0) {
            return result;
        }
        for (Record student : results) {
            if (!map.containsKey(student.id)) {
                PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
                map.put(student.id, pq);
            }
            PriorityQueue<Integer> pq = map.get(student.id);
            if (pq.size() < 5) {
                pq.offer(student.score);
            } else {
                if (student.score > pq.peek()) {
                    pq.poll();
                    pq.offer(student.score);
                }
                
            }
            
        }
        
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> scores = entry.getValue();
            double avg = 0.0;
            for (int i = 0; i < 5; i++) {
                avg += scores.poll();
            }
            avg /= 5.0;
            result.put(id, avg);
        }
        return result;
    }
}