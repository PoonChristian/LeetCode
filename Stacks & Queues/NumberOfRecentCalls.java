// LeetCode 933: Number of Recent Calls
// https://leetcode.com/problems/number-of-recent-calls/

public class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<Integer>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.remove();
        }
        return queue.size();
    }

}