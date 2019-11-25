package com.xkcd;

import com.jayway.restassured.response.ValidatableResponse;
import com.xkcd.request.RequestBuilder;
import com.xkcd.response.ResponseJsonModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class ResponseParametersTests {

    public static final String TEST_CASE_TO_RUN = "TEST_CASES";
    protected ValidatableResponse responseFormXkcd;
    private int expectedHttpStatusCode;

    public ResponseParametersTests() {

        this.responseFormXkcd = new RequestBuilder()
                .sendRequestForXkcdWebcomic()
                .then()
                .assertThat();

        this.expectedHttpStatusCode = 200;
    }

    public ResponseParametersTests(
            int webcomicId
    ){

        this.responseFormXkcd = new RequestBuilder(webcomicId)
                .sendRequestForXkcdWebcomic()
                .then()
                .assertThat();

        this.expectedHttpStatusCode = 200;
    }

    public ResponseParametersTests(
            int webcomicId,
            int expectedHttpStatusCode
    ){

        this.responseFormXkcd = new RequestBuilder(webcomicId)
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

    public ResponseJsonModel validateXkcdResponseJsonModel() {

        return responseFormXkcd
                .extract()
                .as(ResponseJsonModel.class);
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
