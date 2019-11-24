package com.xkcd.request;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

/**
 * This class provides methods for building and sending requests to xkcd API.
 * The default constructor performs operations on the latest comic.
 * If a comic id was specified when creating the object, requests will be built for that comic.
 */
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

    /**
     * Uses RESTassured to send request to xkcd API.
     *
     * @return Response with the data of the selected comic.
     */
    public Response sendRequestForXkcdWebcomic( ) {

        RestAssured.baseURI = requestXkcdUrl;

        return bulidXkcdRequestSpecification()
                .when()
                .get();
    }


}
