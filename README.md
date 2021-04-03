# Project 2 -  The New York Times

**The New York Times** is an android app that allows a user to search for articles on web using simple filters. The app utilizes [New York Times Search API](http://developer.nytimes.com/docs/read/article_search_api_v2).

Time spent:  spent in total

## User Stories

The following **required** functionality is completed:

* [] User can **search for news article** by specifying a query and launching a search. Search displays a grid of image results from the New York Times Search API.
* [] User can click on "settings" which allows selection of **advanced search options** to filter results
* [] User can configure advanced search filters such as:
  * [] Begin Date (using a date picker)
  * [] News desk values (Arts, Fashion & Style, Sports)
  * [] Sort order (oldest or newest)
* [] Subsequent searches have any filters applied to the search results
* [] User can tap on any article in results to view the contents in an embedded browser.
* [ ] User can **scroll down to see more articles**. The maximum number of articles is limited by the API search.

The following **optional** features are implemented:

* [x] Implements robust error handling, [check if internet is available](http://guides.codepath.com/android/Sending-and-Managing-Network-Requests#checking-for-network-connectivity), handle error cases, network failures
* [] Used the **ActionBar SearchView** or custom layout as the query box instead of an EditText
* [] User can **share an article link** to their friends or email it to themselves
* [] Replaced Filter Settings Activity with a lightweight modal overlay

The following **bonus** features are implemented:

* [x] Use the [RecyclerView](http://guides.codepath.com/android/Using-the-RecyclerView) with the `StaggeredGridLayoutManager` to display improve the grid of image results
* [] Show different views for different news articles that only have text or only have images.
* [x] Use Parcelable instead of Serializable using the popular [Parceler library](http://guides.codepath.com/android/Using-Parceler).
* [] Leverages the [data binding support module](http://guides.codepath.com/android/Applying-Data-Binding-for-Views) to bind data into layout templates.
* [x] Replace all icon drawables and other static image assets with [vector drawables](http://guides.codepath.com/android/Drawables#vector-drawables) where appropriate.
* [x] Replace Picasso with [Glide](http://inthecheesefactory.com/blog/get-to-know-glide-recommended-by-google/en) for more efficient image rendering.
* [] Uses [retrolambda expressions](http://guides.codepath.com/android/Lambda-Expressions) to cleanup event handling blocks.
* [x] Leverages the popular [GSON library](http://guides.codepath.com/android/Using-Android-Async-Http-Client#decoding-with-gson-library) to streamline the parsing of JSON data.
* [x] Leverages the [Retrofit networking library](http://guides.codepath.com/android/Consuming-APIs-with-Retrofit) to access the New York Times API.
* [x] Replace the embedded `WebView` with [Chrome Custom Tabs](http://guides.codepath.com/android/Chrome-Custom-Tabs) using a custom action button for sharing.

The following **additional** features are implemented:

* [x] [MVP](https://medium.com/@cervonefrancesco/model-view-presenter-android-guidelines-94970b430ddf) - An architecture pattern design

## Video Walkthrough

## Notes

## Open-source libraries used



## License

    
