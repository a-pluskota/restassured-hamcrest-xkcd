package com.xkcd.request;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

public class RequestBuilder {

    private String requestXkcdUrl;
    private static final String XKCE_URL = "https://xkcd.com";
    private static final String XKCD_API_ROUTE = "/info.0.json ";

    public RequestBuilder() {

        this.requestXkcdUrl = new StringBuilder()
                .append(XKCE_URL)
                .append(XKCD_API_ROUTE)
                .toString();
    }

    public RequestBuilder(
            int webcomicId
    ) {

    this.requestXkcdUrl = new StringBuilder()
                .append(XKCE_URL)
                .append("/")
                .append(webcomicId)
                .append(XKCD_API_ROUTE)
                .toString();
    }

    private RequestSpecification bulidXkcdRequestSpecification() {

        return given()
                .contentType("application/json")
                .log()
                .all(true);
    }

    public Response sendRequestForXkcdWebcomic(
            String requestUrl
    ) {

        RestAssured.baseURI = requestXkcdUrl;

        return bulidXkcdRequestSpecification()
                .when()
                .get();
    }


}
