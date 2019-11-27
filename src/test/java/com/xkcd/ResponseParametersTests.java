package com.xkcd;

import com.jayway.restassured.response.ValidatableResponse;
import com.xkcd.request.RequestBuilder;
import com.xkcd.response.ResponseJsonModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class ResponseParametersTests {

    public static final String TEST_CASE_TO_RUN = "TEST_CASES";
    protected ValidatableResponse validatableResponse;
    private int expectedHttpStatusCode;

    public ResponseParametersTests() {

        this.validatableResponse = new RequestBuilder()
                .sendRequestForXkcdWebcomic()
                .then()
                .assertThat();

        this.expectedHttpStatusCode = 200;
    }

    public ResponseParametersTests(
            int webcomicId
    ){

        this.validatableResponse = new RequestBuilder(webcomicId)
                .sendRequestForXkcdWebcomic()
                .then()
                .assertThat();

        this.expectedHttpStatusCode = 200;
    }

    public ResponseParametersTests(
            int webcomicId,
            int expectedHttpStatusCode
    ){

        this.validatableResponse = new RequestBuilder(webcomicId)
                .sendRequestForXkcdWebcomic()
                .then()
                .assertThat();

        this.expectedHttpStatusCode = expectedHttpStatusCode;
    }

    @BeforeEach
    public void beforeEachXkcdRequestParametersTest() {

        validatableResponse
                .log()
                .all(true);
    }

    public ResponseJsonModel extractXkcdResponseJsonModel() {

        return validatableResponse
                .extract()
                .as(ResponseJsonModel.class);
    }

    @Test
    public void testXkcdResponseHttpStatusCode(){

        validatableResponse
                .statusCode(expectedHttpStatusCode);
    }

    @Test
    public void testXkcdResponseContentType(){

        if (expectedHttpStatusCode == 200) {

            validatableResponse
                    .contentType("application/json");
            return;
        }

        validatableResponse
                .contentType("text/html");

    }

    @Test
    public void testResponseXkcdBodyStructureAndDataTypes() {

        assumeTrue(expectedHttpStatusCode == 200,
                "Expected http status code is different then 200. Test should have been aborted.");

        extractXkcdResponseJsonModel();
    }

}
