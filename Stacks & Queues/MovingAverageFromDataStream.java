// LeetCode 346: Moving Average from Data Stream
// https://leetcode.com/problems/moving-average-from-data-stream/

public class MovingAverage {

    private int maxSize;
    private double sum;
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.maxSize = size;
        this.sum = 0.0;
        this.queue = new LinkedList<Integer>();
    }

    public double next(int val) {
        if (this.queue.size() == this.maxSize) {
            this.sum -= this.queue.remove();
        }
        this.sum += val;
        this.queue.add(val);
        return this.sum / this.queue.size();
    }

}