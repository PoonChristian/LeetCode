// LeetCode 933: Number of Recent Calls
// https://leetcode.com/problems/number-of-recent-calls/

public class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<Integer>();
    }

    public int ping(int t) {
        this.queue.add(t);
        while (this.queue.peek() < t - 3000) {
            this.queue.remove();
        }
        return this.queue.size();
    }

}