package com.xkcd;

import com.jayway.restassured.response.ValidatableResponse;
import com.xkcd.request.XkcdWebcomicRequestBuilder;
import com.xkcd.response.XkcdWebcomicResponseJsonModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class XkcdResponseParametersTests {

    protected ValidatableResponse responseFormXkcd;
    private int expectedHttpStatusCode;

    public XkcdResponseParametersTests() {

        this.responseFormXkcd = new XkcdWebcomicRequestBuilder()
                .sendRequestForXkcdWebcomic()
                .then()
                .assertThat();

        this.expectedHttpStatusCode = 200;
    }

    public XkcdResponseParametersTests(
            int webcomicId
    ){

        this.responseFormXkcd = new XkcdWebcomicRequestBuilder(webcomicId)
                .sendRequestForXkcdWebcomic()
                .then()
                .assertThat();

        this.expectedHttpStatusCode = 200;
    }

    public XkcdResponseParametersTests(
            int webcomicId,
            int expectedHttpStatusCode
    ){

        this.responseFormXkcd = new XkcdWebcomicRequestBuilder(webcomicId)
                .sendRequestForXkcdWebcomic()
                .then()
                .assertThat();

        this.expectedHttpStatusCode = expectedHttpStatusCode;
    }

    @BeforeEach
    public void beforeEachXkcdRequestParametersTest() {

        responseFormXkcd
                .log()
                .all(true);
    }

    public XkcdWebcomicResponseJsonModel validateXkcdResponseJsonModel() {

        return responseFormXkcd
                .extract()
                .as(XkcdWebcomicResponseJsonModel.class);
    }

    @Test
    public void testXkcdResponseHttpStatusCode(){

        responseFormXkcd
                .statusCode(expectedHttpStatusCode);
    }

    @Test
    public void testXkcdResponseContentType(){

        if (expectedHttpStatusCode == 200) {

            responseFormXkcd
                    .contentType("application/json");
            return;
        }

        responseFormXkcd
                .contentType("text/html");

    }

    @Test
    public void testResponseXkcdBodyStructureAndDataTypes() {

        assumeTrue(expectedHttpStatusCode == 200,
                "Expected http status code is different then 200. Test should have been aborted.");

        validateXkcdResponseJsonModel();
    }

}
