// LeetCode 1046: Last Stone Weight
// https://leetcode.com/problems/last-stone-weight/

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> (b - a));
        
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        
        while (maxHeap.size() >= 2) {
            int firstStone = maxHeap.remove();
            int secondStone = maxHeap.remove();
            
            if (firstStone != secondStone) {
                maxHeap.add(firstStone - secondStone);
            }
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.remove();
    }
}