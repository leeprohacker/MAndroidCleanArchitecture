package com.fernandocejas.android10.sample.data.entity.giphy;

import javax.annotation.Generated;

import com.fernandocejas.android10.sample.domain.giphy.DUser;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class User {

    @SerializedName("twitter")
    private String twitter;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("profile_url")
    private String profileUrl;

    @SerializedName("banner_url")
    private String bannerUrl;

    @SerializedName("display_name")
    private String displayName;

    @SerializedName("is_verified")
    private boolean isVerified;

    @SerializedName("username")
    private String username;

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public DUser transform() {
        DUser dUser = new DUser();
        dUser.setUsername(username);
        dUser.setDisplayName(displayName);
        dUser.setAvatarUrl(avatarUrl);
        dUser.setIsVerified(isIsVerified());
        return dUser;
    }
}
