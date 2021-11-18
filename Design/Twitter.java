// LeetCode 355: Design Twitter
// https://leetcode.com/problems/design-twitter/

// Design: Use a Linked List to store all tweets, and make sure that followers and followees all exist in a follower HashMap to avoid null pointer exceptions
public class Twitter {
    // Key = Follower, Value = All users that the follower follows
    Map<Integer, Set<Integer>> followMap;

    // Linked List that stores all the tweets, adding tweets to the head
    Tweet head;

    public Twitter() {
        followMap = new HashMap<>();
        head = new Tweet(-1, -1);
    }
    
    // Add to the head of the linked list
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(userId, tweetId);
        Tweet mostRecent = head.next;
        head.next = newTweet;
        newTweet.next = mostRecent;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        Tweet curr = head;
        checkNewUser(userId);
        
        // Keep iterating until there are no more tweets or until we already added 10 tweets into our news feed
        while (curr != null && newsFeed.size() < 10) {
            if (userId == curr.userId || followMap.get(userId).contains(curr.userId)) {
                newsFeed.add(curr.tweetId);
            }
            
            curr = curr.next;
        }
        
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        checkNewUser(followerId);
        followMap.get(followerId).add(followeeId);
        checkNewUser(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        checkNewUser(followerId);
        followMap.get(followerId).remove(followeeId);
        checkNewUser(followeeId);
    }
    
    private void checkNewUser(int userId) {
        if (!followMap.containsKey(userId)) {
            followMap.put(userId, new HashSet<>());
        }
    }
    
    class Tweet {
        int userId;
        int tweetId;
        Tweet next;
        
        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }
}
