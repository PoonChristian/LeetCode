// LeetCode 1396: Design Underground System
// https://leetcode.com/problems/design-underground-system/

public class UndergroundSystem {

    private final String DELIMETER = "->";
    private Map<Integer, CheckinData> checkIns;
    private Map<String, Route> routeData;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routeData = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        // Do not check in if the customer is already checked in 
        if (checkIns.containsKey(id)) {
            return;
        }
        
        // If the customer hasn't checked in, then add the check-in data to the checkIns map
        checkIns.put(id, new CheckinData(id, stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        // Do not check out if the customer hasn't even checked in anywhere
        if (!checkIns.containsKey(id)) {
            return;
        }
        
        // Extract the check-in time and the check-in station
        int checkInTime = checkIns.get(id).time;
        String checkInStation = checkIns.get(id).stationName;

        // Remove the customer from the checkIns map to simulate the customer checking out
        checkIns.remove(id);
        
        // Create a route string with the delimiter "->" 
        String route = checkInStation + DELIMETER + stationName;
        
        // If this route doesn't exist in the routeData map yet, then add it
        if (!routeData.containsKey(route)) {
            routeData.put(route, new Route());
        }
        
        // Get the route and then add the travel time (t - checkInTime) to the routeData
        routeData.get(route).addTotalTravelTime(t - checkInTime);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        // All the work to populate the route data was done in the checkOut function
        // So we all need to do here is get the route and call getAverageTravelTime()
        return routeData.get(startStation + DELIMETER + endStation).getAverageTravelTime();
    }
    
    private class CheckinData {
        int id;
        String stationName;
        int time;
        
        public CheckinData(int id, String stationName, int time) {
            this.id = id;
            this.stationName = stationName;
            this.time = time;
        }
    }
    
    private class Route {
        int numTrips;
        double totalTravelTime;
        
        public Route() {
            numTrips = 0;
            totalTravelTime = 0;
        }
        
        public void addTotalTravelTime(int travelTime) {
            totalTravelTime += travelTime;
            numTrips++;
        }
        
        public double getAverageTravelTime() {
            return totalTravelTime / numTrips;
        }
    }
}
