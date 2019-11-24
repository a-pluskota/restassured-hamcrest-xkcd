package com.xkcd;

import com.jayway.restassured.response.ValidatableResponse;
import com.xkcd.request.RequestBuilder;
import com.xkcd.response.ResponseJsonModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class XkcdRequestParametersTests {

    private ValidatableResponse responseFormXkcd;

    public XkcdRequestParametersTests() {

        this.responseFormXkcd = new RequestBuilder()
                .sendRequestForXkcdWebcomic()
                .then()
                .assertThat();
    }

    @BeforeEach
    public void beforeEachXkcdRequestParametersTest() {

        responseFormXkcd
                .log()
                .all(true);
    }

    protected ResponseJsonModel validateXkcdResponseJsonModel() {

        return responseFormXkcd
                .extract()
                .as(ResponseJsonModel.class);
    }

    @Test
    public void testXkcdResponseHttpStatusCode(){

        responseFormXkcd
                .statusCode(200);
    }

    @Test
    public void testXkcdResponseContentType(){

        responseFormXkcd
                .contentType("application/json");
    }

    @Test
    public void testResponseXkcdBodyStructureAndDataTypes() {

        validateXkcdResponseJsonModel();
    }

}
