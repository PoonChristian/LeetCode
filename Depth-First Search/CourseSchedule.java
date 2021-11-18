// LeetCode 207: Course Schedule
// https://leetcode.com/problems/course-schedule/

// Algorithm: Create an adjacency list and perform a depth-first search to detect a cycle in a graph (if a node has been visited twice)
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>(numCourses);
        
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        // adjacencyList.get(i) is a list of courses that are prerequisites for course i
        for (int i = 0; i < prerequisites.length; i++) {
            adjacencyList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        // We must check for all courses since the graph might not be completely connected
        for (int i = 0; i < numCourses; i++) {
            // If at any point, a course cannot be completed, then immediately return false
            if (!canTakeAllCourses(adjacencyList, new HashSet<>(), i)) {
                return false;
            }
        }
        
        // Otherwise return true to denote that we can take all the courses
        return true;
    }
    
    // Depth-First Search function that traverses the adjacency list and returns whether or not all nodes were visited
    private boolean canTakeAllCourses(List<List<Integer>> adjacencyList, Set<Integer> visited, int course) {     
        // Base Case 1: A cycle has been detected since a course has been visited twice. Return false  
        if (visited.contains(course)) {
            return false;
        }
        
        // Base Case 2: There are no prerequisites for the course, which means we can take that course. Return true
        if (adjacencyList.get(course).size() == 0) {
            return true;
        }
        
        // Take the course by adding it to the visited set
        visited.add(course);
        
        // Check all prerequisites for the course
        for (int prereq : adjacencyList.get(course)) {
            // If we cannot take all courses, then return false
            if (!canTakeAllCourses(adjacencyList, visited, prereq)) {
                return false;
            }
        }
        
        // We remove the course because we're done taking it
        visited.remove(course);

        // We can clear the prerequisites for this course because we know for a fact that this course can be completed with the given prerequisites
        adjacencyList.get(course).clear();
        
        // Return true to denote that we can take all the courses
        return true;
    }
}
