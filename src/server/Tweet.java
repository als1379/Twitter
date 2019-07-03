package server;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Tweet {
    public String text;
    public int id;
    public User user;
    public int likesnum = 0;
    public int retweetsnum = 0;
    public String time;
    public ArrayList<Integer> likes = new ArrayList<>();
    public ArrayList<Integer> retweeters = new ArrayList<>();
    public ArrayList<Integer> reTweets = new ArrayList<>();
    public Date date = new Date();
    public Calendar calendar = Calendar.getInstance(); // creates a new calendar instance

    Tweet(User user, String text) {
        this.user = user;
        this.text = text;
        id = Server.tweets.size();
        Server.tweets.add(this);
        if (!(this instanceof ReTweet)) {
            calendar.setTime(date);   // assigns calendar to given date
            calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
            calendar.get(Calendar.HOUR);        // gets hour in 12h format
            calendar.get(Calendar.MONTH);       // gets month number, NOTE this is zero based!
            time = calendar.get(Calendar.YEAR) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.DAY_OF_MONTH);
        }
    }

    public boolean equals(Tweet tweet) {
        return (tweet.id == this.id);
    }
}
