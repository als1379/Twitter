package com.codebind;

import java.util.ArrayList;

public class User {

    public String name;
    public String username;
    public String password;
    public String email;
    public String bio = "";
    public int followersnum;
    public int followingNum;
    public int id;
    public ArrayList<Integer> followers = new ArrayList<>();
    public ArrayList<Integer> following = new ArrayList<>();
    public ArrayList<Integer> tweets = new ArrayList<>();
    public ArrayList<Integer> timeline = new ArrayList<>();
    public ArrayList<Integer> retweets = new ArrayList<>();


    public User(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        id = Twitter.users.size();
        Twitter.users.add(this);
    }

    public String getPass() {
        return this.password;
    }

    public void setTimeline(ArrayList<Integer> timeline) {
        this.timeline = timeline;
    }

    public void setTweets(ArrayList<Integer> tweets) {
        this.tweets = tweets;
    }

    public void setReTweets(ArrayList<Integer> retweets) {
        this.retweets = retweets;
    }

    public void setFollowers(ArrayList<Integer> followers) {
        this.followers = followers;
    }

    public void setFollowing(ArrayList<Integer> following) {
        this.following = following;
    }

    public void setFollowersnum(int followersnum) {
        this.followersnum = followersnum;
    }

    public void setFollowingNum(int followingNum) {
        this.followingNum = followingNum;
    }

    public void setBio(String text) {
        this.bio = text;
    }

    public void tweet(String text) {
        Tweet tweet = new Tweet(this, text);
        this.timeline.add(tweet.id);
        this.tweets.add(tweet.id);
        for (Integer follower : this.followers) {
            Twitter.users.get(follower).timeline.add(tweet.id);
            //System.out.println(Twitter.users.get(follower).username);
        }

    }

    public void like(Tweet t) {
        boolean flag = true;
        Tweet tweet;
        if (t instanceof ReTweet) {
            tweet = Twitter.tweets.get(((ReTweet) t).pTweet);
        } else {
            tweet = t;
        }
        for (int i = 0; i < tweet.likes.size(); i++) {
            if (Twitter.users.get(tweet.likes.get(i)).username.equals(this.username)) {
                flag = false;
            }
        }
        if (flag) {
            for (int i = 0; i < tweet.reTweets.size(); i++) {
                Twitter.tweets.get(tweet.reTweets.get(i)).likesnum++;
                Twitter.tweets.get(tweet.reTweets.get(i)).likes.add(this.id);
            }
            for (int i = 0; i < tweet.likes.size(); i++) {
                if (tweet.likes.get(i) == this.id) {
                    tweet.likes.remove(i);
                }
            }
            tweet.likesnum++;
            tweet.likes.add(this.id);
            for (int i = 0; i < tweet.likes.size(); i++) {
                //System.out.println(Twitter.users.get(tweet.likes.get(i)).username);
            }
        } else {
            //System.out.println("hello");
            tweet.likesnum--;
            for (int i = 0; i < tweet.likes.size(); i++) {
                if (tweet.likes.get(i) == this.id) {
                    tweet.likes.remove(i);
                }
            }
            //System.out.println("hello");
            for (int i = 0; i < tweet.reTweets.size(); i++) {
                Twitter.tweets.get(tweet.reTweets.get(i)).likesnum--;
                for (int j = 0; j < Twitter.tweets.get(tweet.reTweets.get(i)).likes.size(); j++) {
                    if (Twitter.tweets.get(tweet.reTweets.get(i)).likes.get(j) == this.id) {
                        Twitter.tweets.get(tweet.reTweets.get(i)).likes.remove(j);
                    }
                }
            }

        }

    }

    public void follow(User user) {
        boolean flag = true;
        for (int i = 0; i < following.size(); i++) {
            if (Twitter.users.get(following.get(i)).equals(user)) {
                flag = false;
                following.remove(i);
                for (int j = 0; j < user.followers.size(); j++) {
                    if (Twitter.users.get(user.followers.get(j)).equals(this)) {
                        removeTweets(user);
                        user.followers.remove(j);
                        this.followingNum--;
                        user.followersnum--;
                    }
                }
                break;
            }
        }
        if (flag) {
            if (user.tweets.size() != 0) {
                addTweets(user);
            }
            this.following.add(user.id);
            user.followers.add(this.id);
            this.followingNum++;
            user.followersnum++;
        }
    }

    public void retweet(Tweet t) {
        Tweet tweet;
        boolean flag = true;
        if (t instanceof ReTweet) {
            tweet = Twitter.tweets.get(((ReTweet) t).pTweet);
        } else {
            tweet = t;
        }
        for (int i = 0; i < tweet.retweeters.size(); i++) {
            if (Twitter.users.get(tweet.retweeters.get(i)).equals(this)) {
                flag = false;
            }
        }
        if (flag) {
            tweet.retweetsnum++;
            for (int i = 0; i < tweet.reTweets.size(); i++) {
                Twitter.tweets.get(i).retweetsnum++;
            }
            ReTweet rtweet = new ReTweet(this, tweet.user, tweet);
            this.timeline.add(rtweet.id);
            this.retweets.add(tweet.id);
            this.tweets.add(rtweet.id);
            tweet.reTweets.add(rtweet.id);
            tweet.retweeters.add(this.id);
        } else {
            tweet.retweetsnum--;
            for (int i = 0; i < tweet.reTweets.size(); i++) {
                if (((ReTweet) (Twitter.tweets.get((tweet.reTweets.get(i))))).retweeter.equals(this.id)) {
                    for (int j = 0; j < this.timeline.size(); j++) {
                        if (this.timeline.get(j) == Twitter.tweets.get(tweet.reTweets.get(i)).id) {
                            this.timeline.remove(j - 1 + 1);
                            break;
                        }
                    }

                    for (int j = 0; j < this.retweets.size(); j++) {
                        if (this.retweets.get(j) == Twitter.tweets.get(tweet.reTweets.get(i)).id) {
                            this.retweets.remove(j - 1 + 1);
                            break;
                        }
                    }

                    for (int j = 0; j < this.tweets.size(); j++) {
                        if (this.tweets.get(j) == Twitter.tweets.get(tweet.reTweets.get(i)).id) {
                            this.tweets.remove(j - 1 + 1);
                            break;
                        }
                    }
                    tweet.reTweets.remove(i - 1 + 1);
                }
            }
            for (int i = 0; i < tweet.retweeters.size(); i++) {
                //System.out.println(Twitter.users.get(tweet.retweeters.get(i)).username);
                if (Twitter.users.get(tweet.retweeters.get(i)).equals(this)) {
                    //System.out.println(tweet.retweeters.size());
                    tweet.retweeters.remove(i);
                    //System.out.println(tweet.retweeters.size());
                    break;
                }
            }
        }
    }

    public void addTweets(User user) {
        int i = 0, j = 0;
        if (this.timeline.size() == 0) {
            for (int k = 0; k < user.tweets.size(); k++) {
                this.timeline.add(user.tweets.get(k));
            }
        } else {
            while (j < user.tweets.size()) {
                if (Twitter.tweets.get(user.tweets.get(j)).id < Twitter.tweets.get(this.timeline.get(i)).id) {
                    this.timeline.add(i, Twitter.tweets.get((user.tweets.get(j))).id);
                    j++;
                } else {
                    i++;
                }
                if (i == this.timeline.size() && j < user.tweets.size()) {
                    while (j < user.tweets.size()) {
                        this.timeline.add(Twitter.tweets.get(user.tweets.get(j)).id);
                        j++;
                    }
                    break;
                }

            }
        }
    }

    public void removeTweets(User user) {
        int i = 0;
        while (i < timeline.size()) {
            boolean flag = false;
            for (int j = 0; j < user.tweets.size(); j++) {
                if (this.timeline.get(i) == user.tweets.get(j)) {
                    this.timeline.remove(i);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                i++;
            }

        }
    }

    public boolean equals(User user) {
        if (this.username.equals(user.username)) return true;
        return false;
    }
}
