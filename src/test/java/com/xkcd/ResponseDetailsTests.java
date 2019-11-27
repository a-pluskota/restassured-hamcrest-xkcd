package com.xkcd;

import com.xkcd.response.ResponseJsonModel;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.*;

public class ResponseDetailsTests extends ImageResponseParametersTests {

    private ResponseJsonModel expectedDataForSelectedComic;
    private ResponseJsonModel responseJsonModel;
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

    public ResponseDetailsTests(
            ResponseJsonModel expectedDataForSelectedComic
    ) {

        super(expectedDataForSelectedComic
                .getNum());

        this.expectedDataForSelectedComic = expectedDataForSelectedComic;
        this.responseJsonModel = extractXkcdResponseJsonModel();
        this.num = responseJsonModel.getNum();
        this.day = responseJsonModel.getDay();
        this.month = responseJsonModel.getMonth();
        this.year = responseJsonModel.getYear();
        this.safeTitle = responseJsonModel.getSafeTitle();
        this.alt = responseJsonModel.getAlt();
        this.img = responseJsonModel.getImg();
        this.title = responseJsonModel.getTitle();
        this.link = responseJsonModel.getLink();
        this.news = responseJsonModel.getNews();
        this.transcript = responseJsonModel.getTranscript();
    }


    @Test
    public void testXkcdWebcomicResponseNumField(){

        assertThat(num, notNullValue());
        assertThat(num, isA(Integer.TYPE));
        assertThat(num, is(greaterThan(0)));
        assertThat(num, is(expectedDataForSelectedComic.getNum()));

    }

    @Test
    public void testXkcdWebcomicResponseDayField(){

        assertThat(day, notNullValue());
        assertThat(day, isA(String.class));
        assertThat(Integer.valueOf(day), is(greaterThan(0)));
        assertThat(Integer.valueOf(day), is(lessThanOrEqualTo(31)));
        assertThat(day, is(expectedDataForSelectedComic.getDay()));

    }

    @Test
    public void testXkcdWebcomicResponseMonthField(){

        assertThat(month, notNullValue());
        assertThat(month, isA(String.class));
        assertThat(Integer.valueOf(month), is(greaterThan(0)));
        assertThat(Integer.valueOf(month), is(lessThanOrEqualTo(12)));
        assertThat(month, is(expectedDataForSelectedComic.getMonth()));

    }

    @Test
    public void testXkcdWebcomicResponseYearField(){

        assertThat(year, notNullValue());
        assertThat(year, isA(String.class));
        assertThat(Integer.valueOf(year), is(greaterThanOrEqualTo(2006)));
        assertThat(Integer.valueOf(year), is(lessThanOrEqualTo(Year.now().getValue())));
        assertThat(year, is(expectedDataForSelectedComic.getYear()));

    }

    @Test
    public void testXkcdWebcomicResponseSafeTitleField(){

        assertThat(safeTitle, notNullValue());
        assertThat(safeTitle, isA(String.class));
        assertThat(safeTitle.length(), lessThanOrEqualTo(255));
        assertThat(safeTitle, is(expectedDataForSelectedComic.getSafeTitle()));

    }

    @Test
    public void testXkcdWebcomicResponseAltField(){

        assertThat(alt, notNullValue());
        assertThat(alt, isA(String.class));
        assertThat(alt.length(), lessThanOrEqualTo(255));
        assertThat(alt, is(expectedDataForSelectedComic.getAlt()));

    }

    @Test
    public void testXkcdWebcomicResponseImgField(){

        assertThat(img, notNullValue());
        assertThat(img, isA(String.class));
        assertThat(img.length(), lessThanOrEqualTo(255));
        assertThat(img, endsWith(".png"));
        assertThat(img, startsWith("https://imgs.xkcd.com/comics/"));
        assertThat(img, is(expectedDataForSelectedComic.getImg()));

    }

    @Test
    public void testXkcdWebcomicResponseTitleField(){

        assertThat(title, notNullValue());
        assertThat(title, isA(String.class));
        assertThat(title.length(), lessThanOrEqualTo(255));
        assertThat(title, is(expectedDataForSelectedComic.getTitle()));

    }

    @Test
    public void testXkcdWebcomicResponseLinkField(){

        assertThat(link, notNullValue());
        assertThat(link, isA(String.class));
        assertThat(link, is(expectedDataForSelectedComic.getLink()));

    }

    @Test
    public void testXkcdWebcomicResponseNewsField(){

        assertThat(news, notNullValue());
        assertThat(news, isA(String.class));
        assertThat(news, is(expectedDataForSelectedComic.getNews()));

    }

    @Test
    public void testXkcdWebcomicResponseTranscriptField(){

        assertThat(transcript, notNullValue());
        assertThat(transcript, isA(String.class));
        assertThat(transcript, is(expectedDataForSelectedComic.getTranscript()));

    }
}
