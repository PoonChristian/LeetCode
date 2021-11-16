// LeetCode 547: Number of Provinces
// https://leetcode.com/problems/number-of-provinces/

public class NumberOfProvinces {
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

    public int findCircleNum(int[][] isConnected) {
        // Initialize a parents array where parents[i] is the parent node of node i
        // In other words, if parents[i] is the representative of the province that node i belongs to
        int[] parents = new int[isConnected.length];

        // Make each node its own parent first
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        
        // Initialize a ranks array to perform union by rank
        // ranks[i] is the number of children that parent i has
        // We will give priority to parents with higher rank when performing a union to lessen computation
        // In other words, the parent with the higher rank will be the greater parent when deciding how to union nodes
        // Set each rank equal to 1 first since no union was made yet
        int[] ranks = new int[isConnected.length];
        Arrays.fill(ranks, 1);
    
        // numProvinces will store the number of provinces (disjoint sets) that we'll find after performing unions on all the nodes
        int numProvinces = parents.length;
        
        // Iterate over the matrix and perform a union wherever we see a 1 and wherever i and j are not equal
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                // If the ith city is connected to the jth city, meaning isConnected[i][j] is 1, and they aren't the same city
                // Then perform a union and decrement from the number of provinces
                // 0 means no union was done. 1 means a union was done, which effectively decrements the number of provinces by 1
                if (isConnected[i][j] == 1 && i != j) {
                    numProvinces -= union(parents, ranks, i, j);
                }
            }
        }
        
        // Return numProvinces
        return numProvinces;
    }

    private int find(int[] parents, int node) {
        // If the value of parents[node] does not match the index node, then we must find the parent
        while (node != parents[node]) {
            // This line performs path compression by setting the parent of the node to its grandparent
            // This would make the chain shorter by setting the parent of the node's parent to the grandparent
            // If there is no grandparent, this line will basically do nothing
            parents[node] = parents[parents[node]];

            // This line allows node to travel to its parent until it reaches the greatest parent
            node = parents[node];
        }
        
        return node;
    }

    private int union(int[] parents, int[] ranks, int i, int j) {
        int parent1 = find(parents, i);
        int parent2 = find(parents, j);
        
        // If both parents are the same, then return 0 to denote that a union was not performed
        if (parent1 == parent2) {
            return 0;
        }
        
        // Since we're implementing union by rank, we want to determine the parent depending on which one has more children

        // If parent2 has more children than parent1, then make parent2 the parent by pointing the value at parent1's index to parent2
        // Update the rank of parent2 by adding the rank of parent1 to it
        if (ranks[parent2] > ranks[parent1]) {
            parents[parent1] = parent2;
            ranks[parent2] += ranks[parent1];
        } else {
            // Otherwise if parent1 has more children than parent2, then make set the parent of parent2 to be parent1
            // Update the rank of parent1 by adding the rank of parent2 to it
            parents[parent2] = parent1;
            ranks[parent1] += ranks[parent2];
        }
        
        // Return 1 to denote that the union is complete
        return 1;
    }
}
