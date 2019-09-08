public class MovingAverage {
    double sum;
    int size;
    Queue<Integer> que;
    public MovingAverage(int size) {
        this.sum = 0.0;
        this.size = size;
        this.que = new LinkedList<Integer>();
    }


    public double next(int val) {
        sum += val;
        que.offer(val);
        if (que.size() > size) {
            sum -= que.poll();
        }
        return sum / que.size();
    }
}