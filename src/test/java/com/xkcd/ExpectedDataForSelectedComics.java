package com.xkcd;

public enum ExpectedDataForSelectedComics {

    WEBCOMIC_NUMBER_614(
            614,
            "24",
            "7",
            "2009",
            "Woodpecker",
            "If you don't have an extension cord I can get that too.  Because we're friends!  Right?",
            "https://imgs.xkcd.com/comics/woodpecker.png",
            "Woodpecker",
            "",
            "",
            ""),

    WEBCOMIC_NUMBER_624(
            614,
            "24",
            "7",
            "2009",
            "Woodpecker",
            "If you don't have an extension cord I can get that too.  Because we're friends!  Right?",
            "https://imgs.xkcd.com/comics/woodpecker.png",
            "Woodpecker",
            "",
            "",
            "");

    private int num;
    private String day;
    private String month;
    private String year;
    private String safeTitle;
    private String alt;
    private String img;
    private String title;
    private String link;
    private String news;
    private String transcript;

    ExpectedDataForSelectedComics(
            int num,
            String day,
            String month,
            String year,
            String safeTitle,
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
        this.safeTitle = safeTitle;
        this.alt = alt;
        this.img = img;
        this.title = title;
        this.link = link;
        this.news = news;
        this.transcript = transcript;
    }

    public int getNum() {
        return num;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getSafeTitle() {
        return safeTitle;
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

    public String getLink() {
        return link;
    }

    public String getNews() {
        return news;
    }

    public String getTranscript() {
        return transcript;
    }
}
