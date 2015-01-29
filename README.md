# CrowdSourcing
Extract Geo-Tweets, alienate Swarm check-ins in those tweets, Generate HeatMap of those checkins in Google Map API

Using Twitter-4j and developer keys, tweets can be extracted from a particular region in twitter. In this project, a sample set of
tweets related to food - Coffee,Pizza are collected using the hashtags as such from twitter.

These tweets contain check-ins made by the users when they visit a restaraunt or a coffee shop. This project considers Swarm check
-ins (Swarm is the recent app used by the foursquare users for check-ins).

From these Check-in tweets, the Geo-locations values are extracted. In addition the usernames are also attached. Now, basing on 
the number of check-ins a user has contributed & No. of distinct check-ins a user has made, these tweets are sorted in Top-k 
fashion and a heat map is generated to visualize Top-5 locations in considered time period. Also top-10 map and All value map is
included in this project.
