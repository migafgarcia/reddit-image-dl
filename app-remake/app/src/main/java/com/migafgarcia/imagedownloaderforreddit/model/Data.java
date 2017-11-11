package com.migafgarcia.imagedownloaderforreddit.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("secure_media")
	private Object secureMedia;

	@SerializedName("saved")
	private boolean saved;

	@SerializedName("over_18")
	private boolean over18;

	@SerializedName("hide_score")
	private boolean hideScore;

	@SerializedName("subreddit")
	private String subreddit;

	@SerializedName("subreddit_id")
	private String subredditId;

	@SerializedName("suggested_sort")
	private Object suggestedSort;

	@SerializedName("score")
	private int score;

	@SerializedName("num_comments")
	private int numComments;

	@SerializedName("whitelist_status")
	private String whitelistStatus;

	@SerializedName("can_gild")
	private boolean canGild;

	@SerializedName("spoiler")
	private boolean spoiler;

	@SerializedName("id")
	private String id;

	@SerializedName("post_hint")
	private String postHint;

	@SerializedName("locked")
	private boolean locked;

	@SerializedName("created_utc")
	private double createdUtc;

	@SerializedName("likes")
	private Object likes;

	@SerializedName("banned_at_utc")
	private Object bannedAtUtc;

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("downs")
	private int downs;

	@SerializedName("edited")
	private boolean edited;

	@SerializedName("created")
	private double created;

	@SerializedName("author")
	private String author;

	@SerializedName("report_reasons")
	private Object reportReasons;

	@SerializedName("brand_safe")
	private boolean brandSafe;

	@SerializedName("approved_by")
	private Object approvedBy;

	@SerializedName("is_video")
	private boolean isVideo;

	@SerializedName("subreddit_name_prefixed")
	private String subredditNamePrefixed;

	@SerializedName("media_embed")
	private MediaEmbed mediaEmbed;

	@SerializedName("domain")
	private String domain;

	@SerializedName("approved_at_utc")
	private Object approvedAtUtc;

	@SerializedName("name")
	private String name;

	@SerializedName("ups")
	private int ups;

	@SerializedName("permalink")
	private String permalink;

	@SerializedName("preview")
	private Preview preview;

	@SerializedName("author_flair_css_class")
	private Object authorFlairCssClass;

	@SerializedName("num_reports")
	private Object numReports;

	@SerializedName("pinned")
	private boolean pinned;

	@SerializedName("mod_reports")
	private List<Object> modReports;

	@SerializedName("hidden")
	private boolean hidden;

	@SerializedName("gilded")
	private int gilded;

	@SerializedName("removal_reason")
	private Object removalReason;

	@SerializedName("media")
	private Object media;

	@SerializedName("title")
	private String title;

	@SerializedName("author_flair_text")
	private Object authorFlairText;

	@SerializedName("archived")
	private boolean archived;

	@SerializedName("num_crossposts")
	private int numCrossposts;

	@SerializedName("thumbnail_width")
	private int thumbnailWidth;

	@SerializedName("can_mod_post")
	private boolean canModPost;

	@SerializedName("secure_media_embed")
	private SecureMediaEmbed secureMediaEmbed;

	@SerializedName("is_self")
	private boolean isSelf;

	@SerializedName("link_flair_css_class")
	private Object linkFlairCssClass;

	@SerializedName("selftext_html")
	private Object selftextHtml;

	@SerializedName("selftext")
	private String selftext;

	@SerializedName("link_flair_text")
	private Object linkFlairText;

	@SerializedName("subreddit_type")
	private String subredditType;

	@SerializedName("user_reports")
	private List<Object> userReports;

	@SerializedName("is_crosspostable")
	private boolean isCrosspostable;

	@SerializedName("distinguished")
	private Object distinguished;

	@SerializedName("clicked")
	private boolean clicked;

	@SerializedName("url")
	private String url;

	@SerializedName("thumbnail_height")
	private int thumbnailHeight;

	@SerializedName("parent_whitelist_status")
	private String parentWhitelistStatus;

	@SerializedName("stickied")
	private boolean stickied;

	@SerializedName("visited")
	private boolean visited;

	@SerializedName("quarantine")
	private boolean quarantine;

	@SerializedName("banned_by")
	private Object bannedBy;

	@SerializedName("view_count")
	private Object viewCount;

	@SerializedName("contest_mode")
	private boolean contestMode;

	@SerializedName("is_reddit_media_domain")
	private boolean isRedditMediaDomain;

	public void setSecureMedia(Object secureMedia){
		this.secureMedia = secureMedia;
	}

	public Object getSecureMedia(){
		return secureMedia;
	}

	public void setSaved(boolean saved){
		this.saved = saved;
	}

	public boolean isSaved(){
		return saved;
	}

	public void setOver18(boolean over18){
		this.over18 = over18;
	}

	public boolean isOver18(){
		return over18;
	}

	public void setHideScore(boolean hideScore){
		this.hideScore = hideScore;
	}

	public boolean isHideScore(){
		return hideScore;
	}

	public void setSubreddit(String subreddit){
		this.subreddit = subreddit;
	}

	public String getSubreddit(){
		return subreddit;
	}

	public void setSubredditId(String subredditId){
		this.subredditId = subredditId;
	}

	public String getSubredditId(){
		return subredditId;
	}

	public void setSuggestedSort(Object suggestedSort){
		this.suggestedSort = suggestedSort;
	}

	public Object getSuggestedSort(){
		return suggestedSort;
	}

	public void setScore(int score){
		this.score = score;
	}

	public int getScore(){
		return score;
	}

	public void setNumComments(int numComments){
		this.numComments = numComments;
	}

	public int getNumComments(){
		return numComments;
	}

	public void setWhitelistStatus(String whitelistStatus){
		this.whitelistStatus = whitelistStatus;
	}

	public String getWhitelistStatus(){
		return whitelistStatus;
	}

	public void setCanGild(boolean canGild){
		this.canGild = canGild;
	}

	public boolean isCanGild(){
		return canGild;
	}

	public void setSpoiler(boolean spoiler){
		this.spoiler = spoiler;
	}

	public boolean isSpoiler(){
		return spoiler;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPostHint(String postHint){
		this.postHint = postHint;
	}

	public String getPostHint(){
		return postHint;
	}

	public void setLocked(boolean locked){
		this.locked = locked;
	}

	public boolean isLocked(){
		return locked;
	}

	public void setCreatedUtc(double createdUtc){
		this.createdUtc = createdUtc;
	}

	public double getCreatedUtc(){
		return createdUtc;
	}

	public void setLikes(Object likes){
		this.likes = likes;
	}

	public Object getLikes(){
		return likes;
	}

	public void setBannedAtUtc(Object bannedAtUtc){
		this.bannedAtUtc = bannedAtUtc;
	}

	public Object getBannedAtUtc(){
		return bannedAtUtc;
	}

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setDowns(int downs){
		this.downs = downs;
	}

	public int getDowns(){
		return downs;
	}

	public void setEdited(boolean edited){
		this.edited = edited;
	}

	public boolean isEdited(){
		return edited;
	}

	public void setCreated(double created){
		this.created = created;
	}

	public double getCreated(){
		return created;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setReportReasons(Object reportReasons){
		this.reportReasons = reportReasons;
	}

	public Object getReportReasons(){
		return reportReasons;
	}

	public void setBrandSafe(boolean brandSafe){
		this.brandSafe = brandSafe;
	}

	public boolean isBrandSafe(){
		return brandSafe;
	}

	public void setApprovedBy(Object approvedBy){
		this.approvedBy = approvedBy;
	}

	public Object getApprovedBy(){
		return approvedBy;
	}

	public void setIsVideo(boolean isVideo){
		this.isVideo = isVideo;
	}

	public boolean isIsVideo(){
		return isVideo;
	}

	public void setSubredditNamePrefixed(String subredditNamePrefixed){
		this.subredditNamePrefixed = subredditNamePrefixed;
	}

	public String getSubredditNamePrefixed(){
		return subredditNamePrefixed;
	}

	public void setMediaEmbed(MediaEmbed mediaEmbed){
		this.mediaEmbed = mediaEmbed;
	}

	public MediaEmbed getMediaEmbed(){
		return mediaEmbed;
	}

	public void setDomain(String domain){
		this.domain = domain;
	}

	public String getDomain(){
		return domain;
	}

	public void setApprovedAtUtc(Object approvedAtUtc){
		this.approvedAtUtc = approvedAtUtc;
	}

	public Object getApprovedAtUtc(){
		return approvedAtUtc;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUps(int ups){
		this.ups = ups;
	}

	public int getUps(){
		return ups;
	}

	public void setPermalink(String permalink){
		this.permalink = permalink;
	}

	public String getPermalink(){
		return permalink;
	}

	public void setPreview(Preview preview){
		this.preview = preview;
	}

	public Preview getPreview(){
		return preview;
	}

	public void setAuthorFlairCssClass(Object authorFlairCssClass){
		this.authorFlairCssClass = authorFlairCssClass;
	}

	public Object getAuthorFlairCssClass(){
		return authorFlairCssClass;
	}

	public void setNumReports(Object numReports){
		this.numReports = numReports;
	}

	public Object getNumReports(){
		return numReports;
	}

	public void setPinned(boolean pinned){
		this.pinned = pinned;
	}

	public boolean isPinned(){
		return pinned;
	}

	public void setModReports(List<Object> modReports){
		this.modReports = modReports;
	}

	public List<Object> getModReports(){
		return modReports;
	}

	public void setHidden(boolean hidden){
		this.hidden = hidden;
	}

	public boolean isHidden(){
		return hidden;
	}

	public void setGilded(int gilded){
		this.gilded = gilded;
	}

	public int getGilded(){
		return gilded;
	}

	public void setRemovalReason(Object removalReason){
		this.removalReason = removalReason;
	}

	public Object getRemovalReason(){
		return removalReason;
	}

	public void setMedia(Object media){
		this.media = media;
	}

	public Object getMedia(){
		return media;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setAuthorFlairText(Object authorFlairText){
		this.authorFlairText = authorFlairText;
	}

	public Object getAuthorFlairText(){
		return authorFlairText;
	}

	public void setArchived(boolean archived){
		this.archived = archived;
	}

	public boolean isArchived(){
		return archived;
	}

	public void setNumCrossposts(int numCrossposts){
		this.numCrossposts = numCrossposts;
	}

	public int getNumCrossposts(){
		return numCrossposts;
	}

	public void setThumbnailWidth(int thumbnailWidth){
		this.thumbnailWidth = thumbnailWidth;
	}

	public int getThumbnailWidth(){
		return thumbnailWidth;
	}

	public void setCanModPost(boolean canModPost){
		this.canModPost = canModPost;
	}

	public boolean isCanModPost(){
		return canModPost;
	}

	public void setSecureMediaEmbed(SecureMediaEmbed secureMediaEmbed){
		this.secureMediaEmbed = secureMediaEmbed;
	}

	public SecureMediaEmbed getSecureMediaEmbed(){
		return secureMediaEmbed;
	}

	public void setIsSelf(boolean isSelf){
		this.isSelf = isSelf;
	}

	public boolean isIsSelf(){
		return isSelf;
	}

	public void setLinkFlairCssClass(Object linkFlairCssClass){
		this.linkFlairCssClass = linkFlairCssClass;
	}

	public Object getLinkFlairCssClass(){
		return linkFlairCssClass;
	}

	public void setSelftextHtml(Object selftextHtml){
		this.selftextHtml = selftextHtml;
	}

	public Object getSelftextHtml(){
		return selftextHtml;
	}

	public void setSelftext(String selftext){
		this.selftext = selftext;
	}

	public String getSelftext(){
		return selftext;
	}

	public void setLinkFlairText(Object linkFlairText){
		this.linkFlairText = linkFlairText;
	}

	public Object getLinkFlairText(){
		return linkFlairText;
	}

	public void setSubredditType(String subredditType){
		this.subredditType = subredditType;
	}

	public String getSubredditType(){
		return subredditType;
	}

	public void setUserReports(List<Object> userReports){
		this.userReports = userReports;
	}

	public List<Object> getUserReports(){
		return userReports;
	}

	public void setIsCrosspostable(boolean isCrosspostable){
		this.isCrosspostable = isCrosspostable;
	}

	public boolean isIsCrosspostable(){
		return isCrosspostable;
	}

	public void setDistinguished(Object distinguished){
		this.distinguished = distinguished;
	}

	public Object getDistinguished(){
		return distinguished;
	}

	public void setClicked(boolean clicked){
		this.clicked = clicked;
	}

	public boolean isClicked(){
		return clicked;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setThumbnailHeight(int thumbnailHeight){
		this.thumbnailHeight = thumbnailHeight;
	}

	public int getThumbnailHeight(){
		return thumbnailHeight;
	}

	public void setParentWhitelistStatus(String parentWhitelistStatus){
		this.parentWhitelistStatus = parentWhitelistStatus;
	}

	public String getParentWhitelistStatus(){
		return parentWhitelistStatus;
	}

	public void setStickied(boolean stickied){
		this.stickied = stickied;
	}

	public boolean isStickied(){
		return stickied;
	}

	public void setVisited(boolean visited){
		this.visited = visited;
	}

	public boolean isVisited(){
		return visited;
	}

	public void setQuarantine(boolean quarantine){
		this.quarantine = quarantine;
	}

	public boolean isQuarantine(){
		return quarantine;
	}

	public void setBannedBy(Object bannedBy){
		this.bannedBy = bannedBy;
	}

	public Object getBannedBy(){
		return bannedBy;
	}

	public void setViewCount(Object viewCount){
		this.viewCount = viewCount;
	}

	public Object getViewCount(){
		return viewCount;
	}

	public void setContestMode(boolean contestMode){
		this.contestMode = contestMode;
	}

	public boolean isContestMode(){
		return contestMode;
	}

	public void setIsRedditMediaDomain(boolean isRedditMediaDomain){
		this.isRedditMediaDomain = isRedditMediaDomain;
	}

	public boolean isIsRedditMediaDomain(){
		return isRedditMediaDomain;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"secure_media = '" + secureMedia + '\'' + 
			",saved = '" + saved + '\'' + 
			",over_18 = '" + over18 + '\'' + 
			",hide_score = '" + hideScore + '\'' + 
			",subreddit = '" + subreddit + '\'' + 
			",subreddit_id = '" + subredditId + '\'' + 
			",suggested_sort = '" + suggestedSort + '\'' + 
			",score = '" + score + '\'' + 
			",num_comments = '" + numComments + '\'' + 
			",whitelist_status = '" + whitelistStatus + '\'' + 
			",can_gild = '" + canGild + '\'' + 
			",spoiler = '" + spoiler + '\'' + 
			",id = '" + id + '\'' + 
			",post_hint = '" + postHint + '\'' + 
			",locked = '" + locked + '\'' + 
			",created_utc = '" + createdUtc + '\'' + 
			",likes = '" + likes + '\'' + 
			",banned_at_utc = '" + bannedAtUtc + '\'' + 
			",thumbnail = '" + thumbnail + '\'' + 
			",downs = '" + downs + '\'' + 
			",edited = '" + edited + '\'' + 
			",created = '" + created + '\'' + 
			",author = '" + author + '\'' + 
			",report_reasons = '" + reportReasons + '\'' + 
			",brand_safe = '" + brandSafe + '\'' + 
			",approved_by = '" + approvedBy + '\'' + 
			",is_video = '" + isVideo + '\'' + 
			",subreddit_name_prefixed = '" + subredditNamePrefixed + '\'' + 
			",media_embed = '" + mediaEmbed + '\'' + 
			",domain = '" + domain + '\'' + 
			",approved_at_utc = '" + approvedAtUtc + '\'' + 
			",name = '" + name + '\'' + 
			",ups = '" + ups + '\'' + 
			",permalink = '" + permalink + '\'' + 
			",preview = '" + preview + '\'' + 
			",author_flair_css_class = '" + authorFlairCssClass + '\'' + 
			",num_reports = '" + numReports + '\'' + 
			",pinned = '" + pinned + '\'' + 
			",mod_reports = '" + modReports + '\'' + 
			",hidden = '" + hidden + '\'' + 
			",gilded = '" + gilded + '\'' + 
			",removal_reason = '" + removalReason + '\'' + 
			",media = '" + media + '\'' + 
			",title = '" + title + '\'' + 
			",author_flair_text = '" + authorFlairText + '\'' + 
			",archived = '" + archived + '\'' + 
			",num_crossposts = '" + numCrossposts + '\'' + 
			",thumbnail_width = '" + thumbnailWidth + '\'' + 
			",can_mod_post = '" + canModPost + '\'' + 
			",secure_media_embed = '" + secureMediaEmbed + '\'' + 
			",is_self = '" + isSelf + '\'' + 
			",link_flair_css_class = '" + linkFlairCssClass + '\'' + 
			",selftext_html = '" + selftextHtml + '\'' + 
			",selftext = '" + selftext + '\'' + 
			",link_flair_text = '" + linkFlairText + '\'' + 
			",subreddit_type = '" + subredditType + '\'' + 
			",user_reports = '" + userReports + '\'' + 
			",is_crosspostable = '" + isCrosspostable + '\'' + 
			",distinguished = '" + distinguished + '\'' + 
			",clicked = '" + clicked + '\'' + 
			",url = '" + url + '\'' + 
			",thumbnail_height = '" + thumbnailHeight + '\'' + 
			",parent_whitelist_status = '" + parentWhitelistStatus + '\'' + 
			",stickied = '" + stickied + '\'' + 
			",visited = '" + visited + '\'' + 
			",quarantine = '" + quarantine + '\'' + 
			",banned_by = '" + bannedBy + '\'' + 
			",view_count = '" + viewCount + '\'' + 
			",contest_mode = '" + contestMode + '\'' + 
			",is_reddit_media_domain = '" + isRedditMediaDomain + '\'' + 
			"}";
		}
}