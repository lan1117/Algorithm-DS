package 二刷;
import java.util.*;

public class ThreeFiftyfive_DesignTwitter {
	class Tweet{
		int time;
		int id;
		Tweet(int time, int id){
			this.time = time;
			this.id = id;
		}
	}
	Map<Integer, Set<Integer>> fans = new HashMap<>(); //who fans him
	Map<Integer, LinkedList<Tweet>> tweets = new HashMap<>(); //the tweets he posted
	int cnt = 0;
	public ThreeFiftyfive_DesignTwitter(){
		
	}
	public void postTweet(int userId, int tweetId){
		if(!fans.containsKey(userId)) fans.put(userId, new HashSet<>());
		fans.get(userId).add(userId);
		if(!tweets.containsKey(userId)) tweets.put(userId, new LinkedList<>());
		tweets.get(userId).addFirst(new Tweet(cnt++, tweetId));
	}
	public List<Integer> getNewsFeed(int userId){
		if(!fans.containsKey(userId)) return new LinkedList<>();
		Comparator<Tweet> cmp = new Comparator<Tweet>(){
			public int compare(Tweet t1, Tweet t2){
				return t2.time - t1.time;
			}
		};
		PriorityQueue<Tweet> feed = new PriorityQueue<Tweet>(cmp);
		fans.get(userId).stream().filter(f -> tweets.containsKey(f)).forEach(f -> tweets.get(f).forEach(feed :: add));
		List<Integer> res= new LinkedList<>();
		while(feed.size() > 0 && res.size() < 10) res.add(feed.poll().id);
		return res;
	}
	public void follow(int followerId, int followeeId){
		if(!fans.containsKey(followerId)) fans.put(followerId, new HashSet<>());
		fans.get(followerId).add(followeeId);
	}
	public void unfollow(int followerId, int followeeId){
		if(fans.containsKey(followerId) && followeeId != followerId) fans.get(followerId).remove(followeeId);
	}
	
}
