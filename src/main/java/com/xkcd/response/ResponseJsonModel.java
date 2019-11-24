package com.xkcd.response;

/**
 * This class provides a responsa model that allows easy
 * reading and validation of data received from the server.
 */
public class ResponseJsonModel {

    private String month;
    private int num;
    private String link;
    private String year;
    private String news;
    private String safeTitle;
    private String transcript;
    private String alt;
    private String img;
    private String title;
    private String day;

    public String getMonth() {
        return month;
    }

    public int getNum() {
        return num;
    }

    public String getLink() {
        return link;
    }

    public String getYear() {
        return year;
    }

    public String getNews() {
        return news;
    }

    public String getSafeTitle() {
        return safeTitle;
    }

    public String getTranscript() {
        return transcript;
    }

    public String getAlt() {
        return alt;
    }

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getDay() {
        return day;
    }


}
