// LeetCode 981: Time Based Key-Value Store
// https://leetcode.com/problems/time-based-key-value-store/

public class TimeBasedKeyValueStore {

    private Map<String, List<Pair>> keyValueStore;

    public TimeMap() {
        keyValueStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!keyValueStore.containsKey(key)) {
            keyValueStore.put(key, new ArrayList<>());
        }
        
        keyValueStore.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!keyValueStore.containsKey(key)) {
            return "";
        }
        
        return binarySearch(keyValueStore.get(key), timestamp);
    }
    
    // We can leverage binary search in this problem since the set function will be called each time with strictly increasing timestamps
    private String binarySearch(List<Pair> timestampData, int timestamp) {
        // Store the result in a string variable
        String result = "";
        int left = 0;
        int right = timestampData.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // If the timestamp at mid is less than or equal to the target timestamp, then set the result to the corresponding value
            // Move left to mid + 1 in order to continue exploring for a closer timestamp to the target
            if (timestampData.get(mid).timestamp <= timestamp) {
                result = timestampData.get(mid).val;
                left = mid + 1;
            } else {
                // Otherwise, we know the only valid timestamp in our data is to the left, so move right to mid - 1
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    class Pair {
        String val;
        int timestamp;
        
        public Pair(String val, int timestamp) {
            this.val = val;
            this.timestamp = timestamp;
        }
    }

}
