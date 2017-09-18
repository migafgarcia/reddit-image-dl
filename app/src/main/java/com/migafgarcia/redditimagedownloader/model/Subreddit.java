package com.migafgarcia.redditimagedownloader.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Subreddit extends Data {

    @SerializedName("user_is_contributor")
    @Expose
    private boolean userIsContributor;
    @SerializedName("banner_img")
    @Expose
    private String bannerImg;
    @SerializedName("user_flair_text")
    @Expose
    private String userFlairText;
    @SerializedName("submit_text_html")
    @Expose
    private String submitTextHtml;
    @SerializedName("user_is_banned")
    @Expose
    private boolean userIsBanned;
    @SerializedName("wiki_enabled")
    @Expose
    private boolean wikiEnabled;
    @SerializedName("show_media")
    @Expose
    private boolean showMedia;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("submit_text")
    @Expose
    private String submitText;
    @SerializedName("user_can_flair_in_sr")
    @Expose
    private boolean userCanFlairInSr;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("header_img")
    @Expose
    private String headerImg;
    @SerializedName("description_html")
    @Expose
    private String descriptionHtml;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("collapse_deleted_comments")
    @Expose
    private boolean collapseDeletedComments;
    @SerializedName("user_has_favorited")
    @Expose
    private boolean userHasFavorited;
    @SerializedName("public_description")
    @Expose
    private String publicDescription;
    @SerializedName("over18")
    @Expose
    private boolean over18;
    @SerializedName("public_description_html")
    @Expose
    private String publicDescriptionHtml;
    @SerializedName("allow_videos")
    @Expose
    private boolean allowVideos;
    @SerializedName("spoilers_enabled")
    @Expose
    private boolean spoilersEnabled;
    @SerializedName("icon_size")
    @Expose
    private Object iconSize;
    @SerializedName("audience_target")
    @Expose
    private String audienceTarget;
    @SerializedName("suggested_comment_sort")
    @Expose
    private Object suggestedCommentSort;
    @SerializedName("active_user_count")
    @Expose
    private int activeUserCount;
    @SerializedName("icon_img")
    @Expose
    private String iconImg;
    @SerializedName("header_title")
    @Expose
    private Object headerTitle;
    @SerializedName("display_name_prefixed")
    @Expose
    private String displayNamePrefixed;
    @SerializedName("user_is_muted")
    @Expose
    private boolean userIsMuted;
    @SerializedName("submit_link_label")
    @Expose
    private String submitLinkLabel;
    @SerializedName("accounts_active")
    @Expose
    private int accountsActive;
    @SerializedName("public_traffic")
    @Expose
    private boolean publicTraffic;
    @SerializedName("header_size")
    @Expose
    private List<Integer> headerSize = null;
    @SerializedName("subscribers")
    @Expose
    private int subscribers;
    @SerializedName("user_flair_css_class")
    @Expose
    private String userFlairCssClass;
    @SerializedName("submit_text_label")
    @Expose
    private Object submitTextLabel;
    @SerializedName("key_color")
    @Expose
    private String keyColor;
    @SerializedName("user_sr_flair_enabled")
    @Expose
    private boolean userSrFlairEnabled;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("is_enrolled_in_new_modmail")
    @Expose
    private Object isEnrolledInNewModmail;
    @SerializedName("whitelist_status")
    @Expose
    private String whitelistStatus;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("user_flair_enabled_in_sr")
    @Expose
    private boolean userFlairEnabledInSr;
    @SerializedName("created")
    @Expose
    private double created;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("quarantine")
    @Expose
    private boolean quarantine;
    @SerializedName("hide_ads")
    @Expose
    private boolean hideAds;
    @SerializedName("created_utc")
    @Expose
    private double createdUtc;
    @SerializedName("banner_size")
    @Expose
    private Object bannerSize;
    @SerializedName("user_is_moderator")
    @Expose
    private boolean userIsModerator;
    @SerializedName("accounts_active_is_fuzzed")
    @Expose
    private boolean accountsActiveIsFuzzed;
    @SerializedName("advertiser_category")
    @Expose
    private String advertiserCategory;
    @SerializedName("user_sr_theme_enabled")
    @Expose
    private boolean userSrThemeEnabled;
    @SerializedName("link_flair_enabled")
    @Expose
    private boolean linkFlairEnabled;
    @SerializedName("allow_images")
    @Expose
    private boolean allowImages;
    @SerializedName("show_media_preview")
    @Expose
    private boolean showMediaPreview;
    @SerializedName("comment_score_hide_mins")
    @Expose
    private int commentScoreHideMins;
    @SerializedName("subreddit_type")
    @Expose
    private String subredditType;
    @SerializedName("submission_type")
    @Expose
    private String submissionType;
    @SerializedName("user_is_subscriber")
    @Expose
    private boolean userIsSubscriber;

    public boolean isUserIsContributor() {
        return userIsContributor;
    }

    public void setUserIsContributor(boolean userIsContributor) {
        this.userIsContributor = userIsContributor;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public String getUserFlairText() {
        return userFlairText;
    }

    public void setUserFlairText(String userFlairText) {
        this.userFlairText = userFlairText;
    }

    public String getSubmitTextHtml() {
        return submitTextHtml;
    }

    public void setSubmitTextHtml(String submitTextHtml) {
        this.submitTextHtml = submitTextHtml;
    }

    public boolean isUserIsBanned() {
        return userIsBanned;
    }

    public void setUserIsBanned(boolean userIsBanned) {
        this.userIsBanned = userIsBanned;
    }

    public boolean isWikiEnabled() {
        return wikiEnabled;
    }

    public void setWikiEnabled(boolean wikiEnabled) {
        this.wikiEnabled = wikiEnabled;
    }

    public boolean isShowMedia() {
        return showMedia;
    }

    public void setShowMedia(boolean showMedia) {
        this.showMedia = showMedia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubmitText() {
        return submitText;
    }

    public void setSubmitText(String submitText) {
        this.submitText = submitText;
    }

    public boolean isUserCanFlairInSr() {
        return userCanFlairInSr;
    }

    public void setUserCanFlairInSr(boolean userCanFlairInSr) {
        this.userCanFlairInSr = userCanFlairInSr;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    public void setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCollapseDeletedComments() {
        return collapseDeletedComments;
    }

    public void setCollapseDeletedComments(boolean collapseDeletedComments) {
        this.collapseDeletedComments = collapseDeletedComments;
    }

    public boolean isUserHasFavorited() {
        return userHasFavorited;
    }

    public void setUserHasFavorited(boolean userHasFavorited) {
        this.userHasFavorited = userHasFavorited;
    }

    public String getPublicDescription() {
        return publicDescription;
    }

    public void setPublicDescription(String publicDescription) {
        this.publicDescription = publicDescription;
    }

    public boolean isOver18() {
        return over18;
    }

    public void setOver18(boolean over18) {
        this.over18 = over18;
    }

    public String getPublicDescriptionHtml() {
        return publicDescriptionHtml;
    }

    public void setPublicDescriptionHtml(String publicDescriptionHtml) {
        this.publicDescriptionHtml = publicDescriptionHtml;
    }

    public boolean isAllowVideos() {
        return allowVideos;
    }

    public void setAllowVideos(boolean allowVideos) {
        this.allowVideos = allowVideos;
    }

    public boolean isSpoilersEnabled() {
        return spoilersEnabled;
    }

    public void setSpoilersEnabled(boolean spoilersEnabled) {
        this.spoilersEnabled = spoilersEnabled;
    }

    public Object getIconSize() {
        return iconSize;
    }

    public void setIconSize(Object iconSize) {
        this.iconSize = iconSize;
    }

    public String getAudienceTarget() {
        return audienceTarget;
    }

    public void setAudienceTarget(String audienceTarget) {
        this.audienceTarget = audienceTarget;
    }

    public Object getSuggestedCommentSort() {
        return suggestedCommentSort;
    }

    public void setSuggestedCommentSort(Object suggestedCommentSort) {
        this.suggestedCommentSort = suggestedCommentSort;
    }

    public int getActiveUserCount() {
        return activeUserCount;
    }

    public void setActiveUserCount(int activeUserCount) {
        this.activeUserCount = activeUserCount;
    }

    public String getIconImg() {
        return iconImg;
    }

    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
    }

    public Object getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(Object headerTitle) {
        this.headerTitle = headerTitle;
    }

    public String getDisplayNamePrefixed() {
        return displayNamePrefixed;
    }

    public void setDisplayNamePrefixed(String displayNamePrefixed) {
        this.displayNamePrefixed = displayNamePrefixed;
    }

    public boolean isUserIsMuted() {
        return userIsMuted;
    }

    public void setUserIsMuted(boolean userIsMuted) {
        this.userIsMuted = userIsMuted;
    }

    public String getSubmitLinkLabel() {
        return submitLinkLabel;
    }

    public void setSubmitLinkLabel(String submitLinkLabel) {
        this.submitLinkLabel = submitLinkLabel;
    }

    public int getAccountsActive() {
        return accountsActive;
    }

    public void setAccountsActive(int accountsActive) {
        this.accountsActive = accountsActive;
    }

    public boolean isPublicTraffic() {
        return publicTraffic;
    }

    public void setPublicTraffic(boolean publicTraffic) {
        this.publicTraffic = publicTraffic;
    }

    public List<Integer> getHeaderSize() {
        return headerSize;
    }

    public void setHeaderSize(List<Integer> headerSize) {
        this.headerSize = headerSize;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(int subscribers) {
        this.subscribers = subscribers;
    }

    public String getUserFlairCssClass() {
        return userFlairCssClass;
    }

    public void setUserFlairCssClass(String userFlairCssClass) {
        this.userFlairCssClass = userFlairCssClass;
    }

    public Object getSubmitTextLabel() {
        return submitTextLabel;
    }

    public void setSubmitTextLabel(Object submitTextLabel) {
        this.submitTextLabel = submitTextLabel;
    }

    public String getKeyColor() {
        return keyColor;
    }

    public void setKeyColor(String keyColor) {
        this.keyColor = keyColor;
    }

    public boolean isUserSrFlairEnabled() {
        return userSrFlairEnabled;
    }

    public void setUserSrFlairEnabled(boolean userSrFlairEnabled) {
        this.userSrFlairEnabled = userSrFlairEnabled;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Object getIsEnrolledInNewModmail() {
        return isEnrolledInNewModmail;
    }

    public void setIsEnrolledInNewModmail(Object isEnrolledInNewModmail) {
        this.isEnrolledInNewModmail = isEnrolledInNewModmail;
    }

    public String getWhitelistStatus() {
        return whitelistStatus;
    }

    public void setWhitelistStatus(String whitelistStatus) {
        this.whitelistStatus = whitelistStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUserFlairEnabledInSr() {
        return userFlairEnabledInSr;
    }

    public void setUserFlairEnabledInSr(boolean userFlairEnabledInSr) {
        this.userFlairEnabledInSr = userFlairEnabledInSr;
    }

    public double getCreated() {
        return created;
    }

    public void setCreated(double created) {
        this.created = created;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isQuarantine() {
        return quarantine;
    }

    public void setQuarantine(boolean quarantine) {
        this.quarantine = quarantine;
    }

    public boolean isHideAds() {
        return hideAds;
    }

    public void setHideAds(boolean hideAds) {
        this.hideAds = hideAds;
    }

    public double getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(double createdUtc) {
        this.createdUtc = createdUtc;
    }

    public Object getBannerSize() {
        return bannerSize;
    }

    public void setBannerSize(Object bannerSize) {
        this.bannerSize = bannerSize;
    }

    public boolean isUserIsModerator() {
        return userIsModerator;
    }

    public void setUserIsModerator(boolean userIsModerator) {
        this.userIsModerator = userIsModerator;
    }

    public boolean isAccountsActiveIsFuzzed() {
        return accountsActiveIsFuzzed;
    }

    public void setAccountsActiveIsFuzzed(boolean accountsActiveIsFuzzed) {
        this.accountsActiveIsFuzzed = accountsActiveIsFuzzed;
    }

    public String getAdvertiserCategory() {
        return advertiserCategory;
    }

    public void setAdvertiserCategory(String advertiserCategory) {
        this.advertiserCategory = advertiserCategory;
    }

    public boolean isUserSrThemeEnabled() {
        return userSrThemeEnabled;
    }

    public void setUserSrThemeEnabled(boolean userSrThemeEnabled) {
        this.userSrThemeEnabled = userSrThemeEnabled;
    }

    public boolean isLinkFlairEnabled() {
        return linkFlairEnabled;
    }

    public void setLinkFlairEnabled(boolean linkFlairEnabled) {
        this.linkFlairEnabled = linkFlairEnabled;
    }

    public boolean isAllowImages() {
        return allowImages;
    }

    public void setAllowImages(boolean allowImages) {
        this.allowImages = allowImages;
    }

    public boolean isShowMediaPreview() {
        return showMediaPreview;
    }

    public void setShowMediaPreview(boolean showMediaPreview) {
        this.showMediaPreview = showMediaPreview;
    }

    public int getCommentScoreHideMins() {
        return commentScoreHideMins;
    }

    public void setCommentScoreHideMins(int commentScoreHideMins) {
        this.commentScoreHideMins = commentScoreHideMins;
    }

    public String getSubredditType() {
        return subredditType;
    }

    public void setSubredditType(String subredditType) {
        this.subredditType = subredditType;
    }

    public String getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(String submissionType) {
        this.submissionType = submissionType;
    }

    public boolean isUserIsSubscriber() {
        return userIsSubscriber;
    }

    public void setUserIsSubscriber(boolean userIsSubscriber) {
        this.userIsSubscriber = userIsSubscriber;
    }

}
