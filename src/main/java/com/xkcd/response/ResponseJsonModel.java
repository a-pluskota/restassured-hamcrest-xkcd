package com.xkcd.response;

/**
 * This class provides a responsa model that allows easy
 * reading and validation of data received from the server.
 */
public class ResponseJsonModel {

    private int num;
    private String day;
    private String month;
    private String year;
    private String safe_title;
    private String alt;
    private String img;
    private String title;
    private String link;
    private String news;
    private String transcript;

    public ResponseJsonModel() {
    }

    public ResponseJsonModel(
            int num,
            String day,
            String month,
            String year,
            String safe_title,
            String alt,
            String img,
            String title,
            String link,
            String news,
            String transcript
    ) {
        this.num = num;
        this.day = day;
        this.month = month;
        this.year = year;
        this.safe_title = safe_title;
        this.alt = alt;
        this.img = img;
        this.title = title;
        this.link = link;
        this.news = news;
        this.transcript = transcript;
    }

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
        return safe_title;
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
