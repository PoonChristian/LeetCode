// LeetCode 547: Friend Circles
// https://leetcode.com/problems/friend-circles/

public class FriendCircles {
    private void union(int person1, int person2, int[] friendGroups) {
        int group1 = find(person1, friendGroups);
        int group2 = find(person2, friendGroups);
        
        // If both groups aren't the same, then set the value at one index to be the other value in order to union
        if (group1 != group2) {
            friendGroups[group1] = group2;
        }
    }
    
    private int find(int personNum, int[] friends) {
        while (personNum != friends[personNum]) {
            // Path compression
            friends[personNum] = friends[friends[personNum]];
            // Set personNum equal to friends[personNum] to continue the search
            personNum = friends[personNum];
        }
        
        return personNum;
    }

    public int findCircleNum(int[][] M) {
        int[] friendGroups = new int[M.length];
        
        // friends[i] = the group that person i belongs to
        // Make i distinct friend groups first
        for (int i = 0; i < friendGroups.length; i++) {
            friendGroups[i] = i;
        }
        
        // Iterate over the matrix and perform a union wherever we see a 1 and wherever i and j are not equal
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(i, j, friendGroups);
                }
            }
        }
        
        int friendCircles = 0;
        
        for (int i = 0; i < friendGroups.length; i++) {
            // The number of friend circles will be the number of elements where friends[i] still remains i
            if (friendGroups[i] == i) {
                friendCircles++;
            }
        }
        
        return friendCircles;
    }
}
