package com.migafgarcia.redditimagedownloader.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Subreddit extends Data {

//    @SerializedName("user_is_contributor")
//    @Expose
////    @DatabaseField(columnName = "user_is_contributor")
//    private boolean userIsContributor;

    @SerializedName("banner_img")
    @Expose
//    @DatabaseField(columnName = "banner_img")
    private String bannerImg;

//    @SerializedName("user_flair_text")
//    @Expose
////    @DatabaseField(columnName = "user_flair_text")
//    private String userFlairText;

//    @SerializedName("submit_text_html")
//    @Expose
////    @DatabaseField(columnName = "submit_text_html")
//    private String submitTextHtml;

//    @SerializedName("user_is_banned")
//    @Expose
////    @DatabaseField(columnName = "user_is_banned")
//    private boolean userIsBanned;

//    @SerializedName("wiki_enabled")
//    @Expose
////    @DatabaseField(columnName = "wiki_enabled")
//    private boolean wikiEnabled;

    @SerializedName("show_media")
    @Expose
//    @DatabaseField(columnName = "show_media")
    private boolean showMedia;

    @SerializedName("id")
    @Expose
//    @DatabaseField(id = true, columnName = "id")
    private String id;

    @SerializedName("description")
    @Expose
//    @DatabaseField(columnName = "description")
    private String description;

//    @SerializedName("submit_text")
//    @Expose
////    @DatabaseField(columnName = "submit_text")
//    private String submitText;

//    @SerializedName("user_can_flair_in_sr")
//    @Expose
////    @DatabaseField(columnName = "user_can_flair_in_sr")
//    private boolean userCanFlairInSr;

    @SerializedName("display_name")
    @Expose
//    @DatabaseField(columnName = "display_name")
    private String displayName;

    @SerializedName("header_img")
    @Expose
//    @DatabaseField(columnName = "header_img")
    private String headerImg;

//    @SerializedName("description_html")
//    @Expose
////    @DatabaseField(columnName = "description_html")
//    private String descriptionHtml;

    @SerializedName("title")
    @Expose
//    @DatabaseField(columnName = "title")
    private String title;

//    @SerializedName("collapse_deleted_comments")
//    @Expose
////    @DatabaseField(columnName = "collapse_deleted_comments")
//    private boolean collapseDeletedComments;

//    @SerializedName("user_has_favorited")
//    @Expose
////    @DatabaseField(columnName = "user_has_favorited")
//    private boolean userHasFavorited;

    @SerializedName("public_description")
    @Expose
//    @DatabaseField(columnName = "public_description")
    private String publicDescription;

    @SerializedName("over18")
    @Expose
//    @DatabaseField(columnName = "over18")
    private boolean over18;

//    @SerializedName("public_description_html")
//    @Expose
////    @DatabaseField(columnName = "public_description_html")
//    private String publicDescriptionHtml;

//    @SerializedName("allow_videos")
//    @Expose
////    @DatabaseField(columnName = "allow_videos")
//    private boolean allowVideos;

    @SerializedName("spoilers_enabled")
    @Expose
//    @DatabaseField(columnName = "spoilers_enabled")
    private boolean spoilersEnabled;

    @SerializedName("icon_size")
    @Expose
    private List<Integer> iconSize;

    @SerializedName("audience_target")
    @Expose
//    @DatabaseField(columnName = "audience_target")
    private String audienceTarget;

//    @SerializedName("suggested_comment_sort")
//    @Expose
////    @DatabaseField(columnName = "suggested_comment_sort")
//    private Object suggestedCommentSort;

//    @SerializedName("active_user_count")
//    @Expose
////    @DatabaseField(columnName = "active_user_count")
//    private int activeUserCount;

    @SerializedName("icon_img")
    @Expose
//    @DatabaseField(columnName = "icon_img")
    private String iconImg;

    @SerializedName("header_title")
    @Expose
//    @DatabaseField(columnName = "header_title")
    private String headerTitle;

    @SerializedName("display_name_prefixed")
    @Expose
//    @DatabaseField(columnName = "display_name_prefixed")
    private String displayNamePrefixed;

//    @SerializedName("user_is_muted")
//    @Expose
////    @DatabaseField(columnName = "user_is_muted")
//    private boolean userIsMuted;

//    @SerializedName("submit_link_label")
//    @Expose
////    @DatabaseField(columnName = "submit_link_label")
//    private String submitLinkLabel;

//    @SerializedName("accounts_active")
//    @Expose
////    @DatabaseField(columnName = "accounts_active")
//    private int accountsActive;

    @SerializedName("public_traffic")
    @Expose
//    @DatabaseField(columnName = "public_traffic")
    private boolean publicTraffic;

    @SerializedName("header_size")
    @Expose
    private List<Integer> headerSize = null;

    @SerializedName("subscribers")
    @Expose
//    @DatabaseField(columnName = "subscribers")
    private int subscribers;

//    @SerializedName("user_flair_css_class")
//    @Expose
////    @DatabaseField(columnName = "user_flair_css_class")
//    private String userFlairCssClass;

//    @SerializedName("submit_text_label")
//    @Expose
////    @DatabaseField(columnName = "submit_text_label")
//    private String submitTextLabel;

    @SerializedName("key_color")
    @Expose
//    @DatabaseField(columnName = "key_color")
    private String keyColor;

//    @SerializedName("user_sr_flair_enabled")
//    @Expose
////    @DatabaseField(columnName = "user_sr_flair_enabled")
//    private boolean userSrFlairEnabled;

    @SerializedName("lang")
    @Expose
//    @DatabaseField(columnName = "lang")
    private String lang;

//    @SerializedName("is_enrolled_in_new_modmail")
//    @Expose
////    @DatabaseField(columnName = "is_enrolled_in_new_modmail")
//    private Object isEnrolledInNewModmail;

//    @SerializedName("whitelist_status")
//    @Expose
////    @DatabaseField(columnName = "whitelist_status")
//    private String whitelistStatus;

    @SerializedName("name")
    @Expose
//    @DatabaseField(columnName = "name")
    private String name;

//    @SerializedName("user_flair_enabled_in_sr")
//    @Expose
////    @DatabaseField(columnName = "user_flair_enabled_in_sr")
//    private boolean userFlairEnabledInSr;

    @SerializedName("created")
    @Expose
//    @DatabaseField(columnName = "created")
    private double created;

    @SerializedName("url")
    @Expose
//    @DatabaseField(columnName = "url")
    private String url;

    @SerializedName("quarantine")
    @Expose
//    @DatabaseField(columnName = "quarantine")
    private boolean quarantine;

//    @SerializedName("hide_ads")
//    @Expose
////    @DatabaseField(columnName = "hide_ads")
//    private boolean hideAds;

    @SerializedName("created_utc")
    @Expose
//    @DatabaseField(columnName = "created_utc")
    private double createdUtc;

    @SerializedName("banner_size")
    @Expose
    private List<Integer> bannerSize;

//    @SerializedName("user_is_moderator")
//    @Expose
////    @DatabaseField(columnName = "user_is_moderator")
//    private boolean userIsModerator;

//    @SerializedName("accounts_active_is_fuzzed")
//    @Expose
////    @DatabaseField(columnName = "accounts_active_is_fuzzed")
//    private boolean accountsActiveIsFuzzed;

//    @SerializedName("advertiser_category")
//    @Expose
////    @DatabaseField(columnName = "advertiser_category")
//    private String advertiserCategory;

//    @SerializedName("user_sr_theme_enabled")
//    @Expose
////    @DatabaseField(columnName = "user_sr_theme_enabled")
//    private boolean userSrThemeEnabled;

//    @SerializedName("link_flair_enabled")
//    @Expose
////    @DatabaseField(columnName = "link_flair_enabled")
//    private boolean linkFlairEnabled;

    @SerializedName("allow_images")
    @Expose
//    @DatabaseField(columnName = "allow_images")
    private boolean allowImages;

    @SerializedName("show_media_preview")
    @Expose
//    @DatabaseField(columnName = "show_media_preview")
    private boolean showMediaPreview;

//    @SerializedName("comment_score_hide_mins")
//    @Expose
////    @DatabaseField(columnName = "comment_score_hide_mins")
//    private int commentScoreHideMins;

    @SerializedName("subreddit_type")
    @Expose
//    @DatabaseField(columnName = "subreddit_type")
    private String subredditType;

    @SerializedName("submission_type")
    @Expose
//    @DatabaseField(columnName = "submission_type")
    private String submissionType;

    @SerializedName("user_is_subscriber")
    @Expose
//    @DatabaseField(columnName = "user_is_subscriber")
    private boolean userIsSubscriber;

    public Subreddit() {

    }

    public String getBannerImg() {
        return bannerImg;
    }

    public boolean isShowMedia() {
        return showMedia;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public String getTitle() {
        return title;
    }

    public String getPublicDescription() {
        return publicDescription;
    }

    public boolean isOver18() {
        return over18;
    }

    public boolean isSpoilersEnabled() {
        return spoilersEnabled;
    }

    public List<Integer> getIconSize() {
        return iconSize;
    }

    public String getAudienceTarget() {
        return audienceTarget;
    }

    public String getIconImg() {
        return iconImg;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public String getDisplayNamePrefixed() {
        return displayNamePrefixed;
    }

    public boolean isPublicTraffic() {
        return publicTraffic;
    }

    public List<Integer> getHeaderSize() {
        return headerSize;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public String getKeyColor() {
        return keyColor;
    }

    public String getLang() {
        return lang;
    }

    public String getName() {
        return name;
    }

    public double getCreated() {
        return created;
    }

    public String getUrl() {
        return url;
    }

    public boolean isQuarantine() {
        return quarantine;
    }

    public double getCreatedUtc() {
        return createdUtc;
    }

    public List<Integer> getBannerSize() {
        return bannerSize;
    }

    public boolean isAllowImages() {
        return allowImages;
    }

    public boolean isShowMediaPreview() {
        return showMediaPreview;
    }

    public String getSubredditType() {
        return subredditType;
    }

    public String getSubmissionType() {
        return submissionType;
    }

    public boolean isUserIsSubscriber() {
        return userIsSubscriber;
    }

    @Override
    public String toString() {
        return getDisplayNamePrefixed();
    }
}
