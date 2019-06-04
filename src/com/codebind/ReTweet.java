package com.codebind;

public class ReTweet extends Tweet{
    public Integer retweeter;
    public Integer pTweet;
    ReTweet(User retweeter,User user,Tweet tweet){
        super(user,tweet.text);
        this.pTweet=tweet.id;
        this.retweeter=retweeter.id;
        this.likesnum = tweet.likesnum;
        this.likes=tweet.likes;
        this.retweetsnum = tweet.retweetsnum;
        this.date=tweet.date;
        this.time=tweet.time;
    }

}
