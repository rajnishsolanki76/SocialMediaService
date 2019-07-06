SocialMediaService is built using spring boot web starter project. Service consist below operations 

1. create(userId,postId,content)
2. getNewFeed(userId)
3. follow(followerId,followeeId)
4. unfollow(followerId,followeeId)

You can start running the service by running ServiceApp class as normal java applicatiom. ServiceApp class is main class to start the service. Please build the project before starting the service.

create(userId,postId,content) 
It is post method which addeds new post in data collection. Method - POST
End point - http://localhost:8080/post/create/
Use Form Data as
userId - 
postId - 
content - 

getNewFeed(userId)
To get new feed either of userId mentioned or his followees. Method - GET
Endpoint - http://localhost:8080/post/newfeeds/{userId}

follow(followerId,followeeId)
Method - PUT
Endpoint - http://localhost:8080/fol/{followerId}/follow/{followeeId}

follow(followerId,followeeId)
Method - PUT
Endpoint - http://localhost:8080/fol/{followerId}/unfollow/{followeeId}
