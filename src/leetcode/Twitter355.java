package leetcode;
import java.util.*;
public class Twitter355 {

    private class Pair{
        int id;
        int time;
        public Pair(int id,int time){
            this.id=id;
            this.time=time;
        }
    }

    Set<Integer> inited=new HashSet<>();
    Map<Integer,Set<Integer>> follows=new HashMap<>();
    Map<Integer,TreeSet<Pair>> tweet=new HashMap<>();
    Map<Integer,TreeSet<Pair>> self=new HashMap<>();
    int time=0;
    /** Initialize your data structure here. */
    public Twitter355() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!inited.contains(userId)) init(userId);
        Pair tweet=new Pair(tweetId,time++);
        TreeSet<Pair> selfs=self.get(userId);
        selfs.add(tweet);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if(!inited.contains(userId)) init(userId);
        pull(userId);
        TreeSet<Pair> pairs=tweet.get(userId);
        List<Integer> list=new ArrayList<>();
        int count=0;
        for(Pair pair:pairs){
            if(count==10) break;
            list.add(pair.id);
            count++;
        }
        return list;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!inited.contains(followerId)) init(followerId);
        if(!inited.contains(followeeId)) init(followeeId);
        Set<Integer> set=follows.get(followerId);
        set.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!inited.contains(followerId)) init(followerId);
        if(!inited.contains(followeeId)) init(followeeId);
        if(followerId==followeeId) return;
        Set<Integer> set=follows.get(followerId);
        set.remove(followeeId);
    }

    public void pull(int userId){
        Set<Integer> set=follows.get(userId);
        TreeSet<Pair> pairs=tweet.get(userId);
        pairs.clear();
        for(int num:set){
            pairs.addAll(self.get(num));
        }
    }

    public void init(int userId){
        Set<Integer> follow=new HashSet<>();
        follow.add(userId);
        follows.put(userId,follow);
        TreeSet<Pair> pair=new TreeSet<Pair>((a,b)->b.time-a.time);
        tweet.put(userId,pair);
        inited.add(userId);
        TreeSet<Pair> inner=new TreeSet<Pair>((a,b)->b.time-a.time);
        self.put(userId,inner);
    }

    public static void main(String[] args) {

    }
}

