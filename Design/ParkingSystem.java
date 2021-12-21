// LeetCode 1603: Design Parking System
// https://leetcode.com/problems/design-parking-system/

public class ParkingSystem {
    private int numBigSlots;
    private int numMediumSlots;
    private int numSmallSlots;

    public ParkingSystem(int big, int medium, int small) {
        numBigSlots = big;
        numMediumSlots = medium;
        numSmallSlots = small;
    }
    
    public boolean addCar(int carType) {
        if (carType == 1 && numBigSlots > 0){
            numBigSlots--;
            return true;
        } else if (carType == 2 && numMediumSlots > 0) {
            numMediumSlots--;
            return true;
        } else if (carType == 3 && numSmallSlots > 0) {
            numSmallSlots--;
            return true;
        } else {
            return false;
        }
    }
}
