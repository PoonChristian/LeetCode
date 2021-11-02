// LeetCode 56: Merge Intervals
// https://leetcode.com/problems/merge-intervals/

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // If intervals is null or has a length less than or equal to 1, return it immediately since nothing needs to be merged
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        
        // Sort the intervals array based on start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // Initialize an ArrayList to store the merged intervals
        List<int[]> intervalList = new ArrayList<>();
        
        // Set the first interval to be the current interval and add it to the interval list
        int[] currentInterval = intervals[0];
        intervalList.add(currentInterval);

        // Iterate from the second interval to the end
        for (int i = 1; i < intervals.length; i++) {
            // Extract the beginning and ending values for each interval for readability
            int currentBegin = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextBegin = intervals[i][0];
            int nextEnd = intervals[i][1];
            
            // If the end value of the current interval is greater than or equal to the beginning value of the next interval, then two things can occur
            // 1. We can set the current interval's end value to be the next interval's end value (ex. [1,3],[2,6] -> [1,6])
            // 2. We keep the current interval's end value since it is greater than the next interval's end value, essentially meaning the next interval doesn't cover enough of the intervals in the input (e.x. [1,4],[2,3] -> [1,4])
            if (currentEnd >= nextBegin) {
                // This changes the interval in the ArrayList since the ArrayList has a reference to it
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // If the current interval's end value is less than the next interval's beginning value, then we can't merge these intervals
                // Therefore, we should set the current interval equal the next interval and add it to the list to try merging the next one
                currentInterval = intervals[i];
                intervalList.add(currentInterval);
            }
        }
        
        // Convert the interval list to an array
        return intervalList.toArray(new int[intervalList.size()][2]);
    }
}
