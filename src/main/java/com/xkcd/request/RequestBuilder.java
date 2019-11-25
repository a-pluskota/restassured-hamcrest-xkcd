package com.xkcd.request;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

/**
 * This class provides methods for building and sending requests to xkcd API.
 */
public class RequestBuilder {

    private String requestXkcdUrl;
    private static final String XKCE_URL = "https://xkcd.com";
    private static final String XKCD_API_ROUTE = "/info.0.json ";

    /**
     * The default constructor performs operations on the latest webcomic.
     */
    public RequestBuilder() {

        this.requestXkcdUrl = new StringBuilder()
                .append(XKCE_URL)
                .append(XKCD_API_ROUTE)
                .toString();
    }

    /**
     * When a comic id is specified when creating the object,
     * requests will be built for that webcomic.
     *
     * @param webcomicId
     */
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

    /**
     * When a comic url was specified when creating the object, r
     * equests will be built for that url.
     *
     * @param webcomicUrl
     */
    public RequestBuilder(
            String webcomicUrl
    ) {

        this.requestXkcdUrl = webcomicUrl;
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
     * @return Response with the data of the selected webcomic.
     */
    public Response sendRequestForXkcdWebcomic( ) {

        return bulidXkcdRequestSpecification()
                .when()
                .get(requestXkcdUrl);
    }

}
