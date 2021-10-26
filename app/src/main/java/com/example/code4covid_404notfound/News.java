package com.example.code4covid_404notfound;

public class News {
    private String mTitle;
    private String mAuthor;
    private String mUrl;
    private String mImageurl;

    public News(String title, String author , String url, String image) {
        this.mTitle = title;
        this.mAuthor = author;
        this.mUrl = url;
        this.mImageurl = image;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmUrl() {
        return mUrl;
    }

    public String getmImageurl() {
        return mImageurl;
    }
}
