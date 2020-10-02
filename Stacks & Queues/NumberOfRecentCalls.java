// LeetCode 933: Number of Recent Calls
// https://leetcode.com/problems/number-of-recent-calls/

public class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<Integer>();
    }

    public int ping(int t) {
        this.queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.remove();
        }
        return queue.size();
    }

}