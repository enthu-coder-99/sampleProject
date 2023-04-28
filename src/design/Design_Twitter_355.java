package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Design_Twitter_355 {

  List<Integer> tweets;
  Map<Integer, Set<Integer>> followerTOfolloweeMap;
  Map<Integer, LinkedList<Integer>> userToTweets;
  int max_tweets = 10;

  public static void main(String[] args) {
    Design_Twitter_355 twitter = new Design_Twitter_355();
    twitter.postTweet(1, 5);
    System.out.println(twitter.getNewsFeed(1));//[5]
    twitter.follow(1, 2);
    twitter.postTweet(2, 6);
    System.out.println(twitter.getNewsFeed(1));//[6,5]
    twitter.unfollow(1, 2);
    System.out.println(twitter.getNewsFeed(1));//[5]
    System.out.println("----Set-2-----");
    //Set-2
    twitter = new Design_Twitter_355();
    twitter.postTweet(1, 5);
    twitter.postTweet(1, 3);
    System.out.println(twitter.getNewsFeed(1));//[3,5]
  }

  public Design_Twitter_355() {
    followerTOfolloweeMap = new HashMap();
    userToTweets = new HashMap();
    tweets = new ArrayList();
  }

  public void postTweet(int userId, int tweetId) {
    tweets.add(tweetId);
    int indexOfTweet = tweets.size() - 1;
    if (!userToTweets.containsKey(userId)) userToTweets.put(userId, new LinkedList());
    LinkedList<Integer> tweetListByUser = userToTweets.get(userId);
    tweetListByUser.add(0, indexOfTweet);
  }

  public List<Integer> getNewsFeed(int userId) {
    List<Integer> result = new ArrayList();
    LinkedList<Integer> userTweetIndexList = userToTweets.get(userId);
    Set<Integer> followeeSet = followerTOfolloweeMap.get(userId);
    List<List<Integer>> userAndFolloweeTweetIndexList = new ArrayList();
    userAndFolloweeTweetIndexList.add(userTweetIndexList);
    if (followeeSet != null && followeeSet.size() > 0) {
      for (int followeeUsedId : followeeSet) {
        userAndFolloweeTweetIndexList.add(userToTweets.get(followeeUsedId));
      }
    }
    return pickTopK(max_tweets, userAndFolloweeTweetIndexList);

  }

  public List<Integer> pickTopK(int k, List<List<Integer>> userAndFolloweeTweetIndexList) {
    List<Integer> result = new ArrayList();
    PriorityQueue<List<Integer>> pq = new PriorityQueue(
      (list1, list2) -> (((List<Integer>) list2).get(0) - ((List<Integer>) list1).get(0))
    );
    for (int i = 0; i < userAndFolloweeTweetIndexList.size(); i++) {
      List<Integer> list = userAndFolloweeTweetIndexList.get(i);
      if (list != null) pq.offer(List.of(list.get(0), i, 0));
    }
    while (pq.size() > 0) {
      List<Integer> pollList = pq.poll();
      result.add(tweets.get(pollList.get(0)));
      if (result.size() == k) break;
      int list_index = pollList.get(1);
      int list_index_index = pollList.get(2);
      List<Integer> tweetIndexList = userAndFolloweeTweetIndexList.get(list_index);
      if (list_index_index >= (tweetIndexList.size() - 1)) continue;
      pq.offer(List.of(tweetIndexList.get(list_index_index + 1), list_index, list_index_index + 1));
    }
    return result;
  }

  public void follow(int followerId, int followeeId) {
    if (!followerTOfolloweeMap.containsKey(followerId))
      followerTOfolloweeMap.put(followerId, new HashSet());
    boolean b = followerTOfolloweeMap.get(followerId).add(followeeId);
    System.out.println(followerId + "- Added from followeeId=" + followeeId + ", b=" + b);
  }

  public void unfollow(int followerId, int followeeId) {
    if (!followerTOfolloweeMap.containsKey(followerId)) return;
    boolean b = followerTOfolloweeMap.get(followerId).remove(followeeId);
    System.out.println(followerId + "- removed from followeeId=" + followeeId + ", b=" + b);
  }
}
