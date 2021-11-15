// LeetCode 973: K Closest Points to Origin
// https://leetcode.com/problems/k-closest-points-to-origin/

/*
    This problem boils down to knowing the formula for the Euclidean Distance.
    LeetCode provides the Euclidean Distance formula as follows "√(x1 - x2)^2 + (y1 - y2)^2)"

    Because we are trying to find the distance to the origin, we can simply treat x2 and y2 as 0
    This would simplify the formula to x^2 + y^2.

    From here, you would decide whether to approach the problem with sorting or a priority queue to get the K closest points
*/

public class KClosestPointsToOrigin {
    public int[][] kClosestSorting(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0]* b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(points, 0, k);
    }
    public int[][] kClosestPriorityQueue(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, (a, b) -> a[0] - b[0]);
        
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int distance = x * x + y * y;
            minHeap.add(new int[]{distance, i});
        }
        
        int[][] closestPoints = new int[k][2];
        
        for (int i = 0; i < k; i++) {
            closestPoints[i] = points[minHeap.remove()[1]];
        }
        
        return closestPoints;
    }
}
