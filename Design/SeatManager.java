// LeetCode 1845: Seat Reservation Manager
// https://leetcode.com/problems/seat-reservation-manager/

// Implementation: Keep track of the next available seat using a PriorityQueue and an int variable
public class SeatManager {
    // Why use a PriorityQueue?
    // Because the PriorityQueue will automatically handle storing the smallest values at the beginning, which will denote the smallest unreserved seat number
    private PriorityQueue<Integer> minHeap;

    // nextAvailable will store the next available seat if the PriorityQueue is empty (meaning there are no empty seats between the range [1, nextAvailable])
    private int nextAvailable;
    
    public SeatManager(int n) {
        // Initialize the PriorityQueue and set nextAvailable to 1
        minHeap = new PriorityQueue<>(n);
        nextAvailable = 1;
    }
    
    public int reserve() {
        // If the PriorityQueue is not empty, that means we unreserved a seat between [1, nextAvailable] at one point, so return the smallest seat within that range
        if (!minHeap.isEmpty()) {
            return minHeap.remove();
        }
        
        // Otherwise, return the seat number for nextAvailable and then increment it AFTER returning so that nextAvailable points to the next vacant seat
        return nextAvailable++;
    }
    
    public void unreserve(int seatNumber) {
        // When unreserving a seat, add the number to the PriorityQueue so that when we reserve again, we can ensure we're reserving the smallest seat number
        minHeap.add(seatNumber);
    }
}
