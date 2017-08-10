
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
