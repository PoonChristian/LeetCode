// LeetCode 735: Asteroid Collision
// https://leetcode.com/problems/asteroid-collision/

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        // Initialize a stack to keep track of the state of the asteroids
        // Why use a stack?
        //      Because it keeps track of the asteroids at the end of the array, which we care about more when making comparisons against the current asteroid
        Stack<Integer> stack = new Stack<>();
        
        // Iterate over all the asteroids
        for (int asteroid : asteroids) {
            // Boolean flag that is true when the current asteroid is destroyed and false when it destroys the asteroid before it
            boolean destroyed = false;
            
            // Iterate under the following 4 conditions
            // 1. The stack is not empty (we have previous asteroids to compare against the current asteroid)
            // 2. The top value (last asteroid) of the stack is greater than 0
            // 3. The current asteroid is less than 0 (combined with conditioned 2, this means there will be a collision like this [+] --> <-- [-])
            // 4. The current asteroid is not destroyed (it will be destroyed if the stack's top asteroid is greater than or equal to it)
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0 && !destroyed) {
                // If the top asteroid is less than the current asteroid, then pop it
                // Destroyed will remain false because the current asteroid has not been destroyed yet, so this allows the while loop to potentially keep iterating
                // We negate the current asteroid to make it positive and ensure an accurate numeric comparison
                if (stack.peek() < -asteroid) {
                    stack.pop();
                } else if (stack.peek() == -asteroid) {
                    // If the top asteroid is equal to the current asteroid, then we destroy both asteroids by setting destroyed equal to true and popping the top value
                    destroyed = true;
                    stack.pop();
                } else {
                    // Otherwise, the top asteroid is greater than the current asteroid, so all we do is set destroyed equal to true
                    destroyed = true;
                }
            }
            
            // If the current asteroid hasn't been destroyed, then we can push it to the stack
            if (!destroyed) {
                stack.push(asteroid);
            }
        }
        
        // Initialize a state array to store the values of the stack
        int[] state = new int[stack.size()];
        
        // Iterate from the end to beginning to store the stack values in the proper order
        for (int i = stack.size() - 1; i >= 0; i--) {
            state[i] = stack.pop();
        }
        
        // Return state
        return state;
    }
}
