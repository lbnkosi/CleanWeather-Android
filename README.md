# CleanWeather-Android
I’ve had quite a bit of free time on my hands over the long weekend so I decided, for old times sake, why not pull up a list of APIs, pick the best one and get started on a new Android project...

I developed a simple weather app that can tell you what the weather is today and the forecast for the rest of the week. I used REST APIs from OpenWeatherMap to achieve this which you can check out here, https://openweathermap.org/api.

The app is called CleanWeather. This is because the application was architected using Uncle Bob’s clean architecture approach. It was also developed using Kotlin. Sorry Java lovers :)

Clean architecture is a software engineering development architecture created by Robert C. Martin or more popularely known as Uncle Bob. The essence of this architecture is the separation of concerns. Of course clean architecture will not be appropriate for every project, certainly not one of this size, but the idea behind applying this architecture for this mini project was to create an example that not only I could reference, but other developers as well.

The app has 3 layers, namely the app, domain and data layer. The app layer makes use of the Android Framework and is used to create all of our UI components to display inside of the Weather Fragment. The domain layer responsibility is to simply contain the UseCase instance used to retrieve data from the Data layer and pass it onto the App layer. And, finally, the Data layer is our access point to external data layers and is used to fetch data from multiple sources (the cache and network in my case).

You can have a look at the repository and tell me what you think. Feel free to fork and play around with it, suggest improvements and collaborate. Side note, I tried to keep the UI as basic as possible.

Repository Link: https://github.com/lbnkosi/CleanWeather-Android

To get going you’ll have to create an account and obtain an API key. Visit https://openweathermap.org/ for more information on how to do that.
