package com.example.pavan.recyclerview;

public class Holder {

    int profileImage, contentImage;
    private String name, caption;

    public Holder(String name, int profileImage, int contentImage, String caption) {
        this.name = name;
        this.profileImage = profileImage;
        this.contentImage = contentImage;
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getContentImage() {
        return contentImage;
    }

    public void setContentImage(int contentImage) {
        this.contentImage = contentImage;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
