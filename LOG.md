
# The log

This is essentially a mind dump. Each paragraph is written in chronological order.

## Entry 0 - Language; Reddit API vs Web scraping;

My first goal to (hopefully) reach the final product is to create a tool that outputs the listings of the images. The tool should be made in such a way that it can be used as a standalone tool.

This tool will receive some parameters (see below), access reddit and return with the list of image links (for direct download).

The goal is to have N image entries from the Y page.

I decided to use Python to implement either the scrapper or for using the reddit API. In the case of the scrapper I will probably use [Scrapy](https://scrapy.org/).

The reddit API is the best course of action and after a bit of exploring, I'm starting to question if building this standalone tool is a good idea. The ideal thing would be to integrate the API usage logic directly into the app. That way I wouldn't need to have my own server to essentially mirror information thats easily available online. 


### Links
 - [React Native](https://facebook.github.io/react-native/)
 - [Using React Native: One Year Later](https://blog.discordapp.com/using-react-native-one-year-later-91fd5e949933)
 - [Reddit API](https://www.reddit.com/dev/api)
 - [Flux](https://facebook.github.io/flux/)
 - [JSON output from reddit](https://www.reddit.com/r/EarthPorn/hot.json)
 - [Android Developers](https://developer.android.com/)


## Entry 1 - Android project started

I started by creating drawing a prototype in [proto.io](https://proto.io/)of the release version. I tried making it as simple as possible, therefore the home view will have a list that is populated with the preview, title, subreddit and user of the image. Upon tapping a list item, a larger preview pops up, with some info and two buttons: one to download the full sized image and another to access the comments from the thread.

I am not a designer, so for now I will try to be as simple as possible to provide the basic functionality and make the app usable.

I proceeded to create a project in Android Studio. Then I created a new layout xml file to describe the list elements, with the parent layout being ConstraintLayout.

