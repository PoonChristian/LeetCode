// LeetCode 621: Task Scheduler
// https://leetcode.com/problems/task-scheduler/

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // Store the frequencies of the tasks in a map (we can use an int array since we only deal with uppercase letters)
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        // Sort the frequencies in ascending order (most frequent will be at the end)
        Arrays.sort(freq);
        
        // maxFreq is the last element
        // We subtract 1 because we don't need to consider idle slots for the last task since it won't be used again
        int maxFreq = freq[25] - 1;

        // The number of idle slots is equal to the number of most frequent tasks * n (excluding the last slot)
        int idle = maxFreq * n;
        
        // Loop backwards from the array and while we still have idle slots to fill
        for (int i = 24; i >= 0 && idle > 0; i--) {
            // Fill the idle slots by subtracting the minimum between the frequency of the current task and the frequency of the most common task

            // We use Math.min for the following two reasons that go hand in hand:
            //  1. There is no guarantee that the current task will be less than the most common task
            //  2. We only want to fill idle slots within the cooldown periods of the most common task

            // Example: ["A","A","A","B","B","B"], n = 2
            //      { "A": 3, "B": 3 } -> [0,0,....,3,3]
            //      maxFreq = 3 - 1 = 2
            //      idle = 2 * 2 = 4
            //      freq[24] = 3
            //      Math.min(3, 2) = 2
            //      A -> idle -> idle -> A -> idle -> idle -> A
            //      A -> B -> idle -> A -> B -> idle -> A

            // In the above example, we have four idle slots (two cooldown periods with two idle slots each)
            // If we subtract 3 from idle instead of 2, it means that we are considering idle slots past the last A
            // This would not make sense since there cannot be any idle slots past the last A
            idle -= Math.min(freq[i], maxFreq);
        }
        
        // If there still remain idle slots, then we should consider those idle slots plus the length of the task list
        // Otherwise, the answer will simply just be the length of the task list
        return idle > 0 ? tasks.length + idle : tasks.length;
    }
}
