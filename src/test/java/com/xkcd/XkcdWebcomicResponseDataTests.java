package com.xkcd;

import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.*;

public class XkcdWebcomicResponseDataTests extends XkcdWebcomicImageResponseParametersTests {

    private ExpectedDataForSelectedComics expectedDataForSelectedComic;
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

    public XkcdWebcomicResponseDataTests(
            ExpectedDataForSelectedComics expectedDataForSelectedComics
    ) {

        super(expectedDataForSelectedComics.getNum());

        this.expectedDataForSelectedComic = expectedDataForSelectedComics;
        this.num = validateXkcdResponseJsonModel().getNum();
        this.day = validateXkcdResponseJsonModel().getDay();
        this.month = validateXkcdResponseJsonModel().getMonth();
        this.year = validateXkcdResponseJsonModel().getYear();
        this.safeTitle = validateXkcdResponseJsonModel().getSafeTitle();
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

        System.out.println(safeTitle);

        assertThat(safeTitle, notNullValue());
        assertThat(safeTitle, isA(String.class));
        assertThat(safeTitle.length(), lessThanOrEqualTo(255));
        assertThat(safeTitle, is(expectedDataForSelectedComic.getSafeTitle()));

    }
}
