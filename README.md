# restaurantbooking

Instructions
After you clone the repository. You have to run the following commands in the same folder as the pom.xml is ther.
-> mvn compile
-> mvn exec:java -Dexec.mainClass=com.carlos.restaurantbooking.RestaurantbookingApplication
Press Ctrl + C in order to terminate the app.


Once the server is up.. it has the following endpoints at  http://localhost:8080/api/

-> POST /v1/customer/booking
-> GET /v1/owner/booking

Documentation:
->API HTML: http://localhost:8080/api/api.html
->API JSON: http://localhost:8080/api/openapi.json
