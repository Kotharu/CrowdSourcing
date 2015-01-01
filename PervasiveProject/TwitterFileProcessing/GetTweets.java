package com.jdwb.twitterapi;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class GetTweets {
	static String ckey = "3p1TyqiOSwEJmwD8mO3ww";
	static String cSecret = "UqiuEqgvwcKk31FQsQQydOzUql4yuSEOyvdyxYmmo";
	static String tKey = "2381275765-qUN0qBs8R4ITbuTBz4hUUVu1G9JefYx2obFothW";
	static String tSecret = "dBtiCvGYEFXqbQiCNEE3y00avlqT4hBaVZ1CHlNyblyPs";

	public static void main(String args[]) throws IOException {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(ckey)
				.setOAuthConsumerSecret(cSecret).setOAuthAccessToken(tKey)
				.setOAuthAccessTokenSecret(tSecret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		String token = "FLU";
		Query query = new Query(token);
		FileWriter outFile = new FileWriter("my.txt", true);
		int numberOfTweets = 2000;
		long lastID = Long.MAX_VALUE;
		long prev_last = Long.MAX_VALUE;
		
		query.setGeoCode(new GeoLocation(36.0024071, -78.9344783),50, "km");
		
		//query.setUntil("2014-02-29");
		ArrayList<Status> tweets = new ArrayList<Status>();
		while (tweets.size() < numberOfTweets) {
			prev_last = lastID;
			if (numberOfTweets - tweets.size() > 100)
				query.setCount(100);
			else
				query.setCount(numberOfTweets - tweets.size());
			try {
				QueryResult result = twitter.search(query);
				tweets.addAll(result.getTweets());
				System.out.println("Gathered " + tweets.size() + " tweets");
				for (Status t : tweets)
					if (t.getId() < lastID)
						lastID = t.getId();
			} catch (TwitterException te) {
				System.out.println("Couldn't connect: " + te);
			}
			;
			query.setMaxId(lastID - 1);
			if (prev_last == lastID)
				break;
		}
		PrintWriter out1 = new PrintWriter(outFile);
		for (int i = 0; i < tweets.size(); i++) {
			Status t = (Status) tweets.get(i);

			String screenName = t.getUser().getScreenName();
			Date date = t.getCreatedAt();
			String msg = t.getText();
			GeoLocation twitterGeo = t.getGeoLocation();
			String twittUserGeo = t.getUser().getLocation();
			Long tID = t.getId();
			String userName = t.getUser().getName();
			String source = t.getSource();
			Boolean status = t.getUser().isGeoEnabled();
			int followers_Count = t.getUser().getFollowersCount();
			int friends_count = t.getUser().getFriendsCount();

			// System.out.println(twitterGeo +""+twittUserGeo);
			// String time = "";

			System.out.println(tID + "||" + userName + "||"+ msg );
					out1.append(tID + "||" + userName + "||" + status + "||"
					+ screenName + "||" + date + "||" + twitterGeo + "||"
					+ twittUserGeo + "||" + msg + "||" + source + "||"
					+ followers_Count + "||" + friends_count + "||");
			out1.print("\n");
		}
		System.out.println("file write successfully");
	}
}