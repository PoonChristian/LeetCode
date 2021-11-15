// LeetCode 705: Design HashSet
// https://leetcode.com/problems/design-hashset/

// HashSet with rehashing implemented
// Collisions are handled with a 2D list
public class MyHashSet {
    private int size;
    private int capacity;
    private double loadFactor = 0.75;
    private List<List<Integer>> buckets;

    public MyHashSet() {
        size = 0;
        capacity = 10;
        // buckets[i] contains a list of elements whose keys hash to index i
        buckets = new ArrayList<>(capacity);
        // Initialize every value of the list to be null so then we can call buckets.get on every index without errors
        for (int i = 0; i < capacity; i++) {
            buckets.add(null);
        }
    }
    
    public void add(int key) {
        // If the set already contains the given key, then return out 
        if (contains(key)) {
            return;
        }
        
        // Resize and rehash all the keys in the HashMap load factor (size / capacity) is greater than 0.75
        if (size / capacity > loadFactor) {
            rehash();
        }
        
        // Get the corresponding index by taking the key MOD capacity
        int index = key % capacity;

        // Get the list of elements residing in the bucket at the index
        List<Integer> bucketList = buckets.get(index);
        
        // If there is no list at the index
        if (bucketList == null) {
            // Create a new list
            List<Integer> list = new LinkedList<>();

            // Add the key to the list
            list.add(key);

            // Set the list at buckets[index]
            buckets.set(index, list);
        } else {
            // Otherwise if there is a list, then just add the key to the list
            bucketList.add(key);
        }
    }
    
    public void remove(int key) {
        // Get the corresponding index by taking the key MOD capacity
        int index = key % capacity;

        // Get the list of elements residing in the bucket at the index
        List<Integer> bucketList = buckets.get(index);

        // If there is a list at the index, then remove the key from the list
        if (bucketList != null) {
            // When converting the key to a boxable Integer type, the remove() function looks for that value and removes it, rather than the index
            // remove(int index) -> Removes the element at the specified position in this list.
            // remove(Object o) -> Removes the first occurrence of the specified element from this list, if it is present. (We want to use this one).
            bucketList.remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        // Get the corresponding index by taking the key MOD capacity
        int index = key % capacity;

        // Get the list of elements residing in the bucket at the index
        List<Integer> bucketList = buckets.get(index);

        // Return if the list is not null and contains the key
        return bucketList != null && bucketList.contains(key);
    }
    
    private void rehash() {
        // Get the new capacity by doubling the original capacity and then adding 1
        int newCapacity = capacity * 2 + 1;

        // Create a new list of buckets with the new capacity
        List<List<Integer>> rehashedBuckets = new ArrayList<>(newCapacity);
        
        // Initialize every value of the new list to be null so then we can call buckets.get on every index without errors
        for (int i = 0; i < newCapacity; i++) {
            rehashedBuckets.add(null);
        }
        
        // Iterate over the original capacity to get all the buckets that need to be rehashed
        for (int i = 0; i < capacity; i++) {
            List<Integer> bucket = buckets.get(i);
            
            // If the bucket at index i is not null, then that means there are nodes to reassign into the new rehashed buckets list
            if (bucket != null) {
                // Iterate through the bucket to rehash all the keys inside
                for (int oldKey : bucket) {
                    // Get the new index by taking the key MOD newCapacity
                    int index = oldKey % newCapacity;

                    List<Integer> newBucketList = rehashedBuckets.get(index);
                    
                    // If there is no list at the index yet, then create a new list, add the key to the list, and set the list at buckets[index]
                    if (newBucketList == null) {
                        List<Integer> list = new LinkedList<>();
                        list.add(oldKey);
                        rehashedBuckets.set(index, list);
                    } else {
                        // Otherwise, just add the key to the new list
                        newBucketList.add(oldKey);
                    }
                }
            }
        }

        // Set the new capacity and new buckets
        capacity = newCapacity;
        buckets = rehashedBuckets;
    }
}
