package com.xkcd;

import com.jayway.restassured.response.ValidatableResponse;
import com.xkcd.request.XkcdWebcomicRequestBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class XkcdWebcomicImageResponseParametersTests extends XkcdResponseParametersTests {

    private String xkcdWebcomicImageUrl;
    private ValidatableResponse xkcdWebcomicImageValidatableResponse;

    public XkcdWebcomicImageResponseParametersTests() {

        this.xkcdWebcomicImageUrl = validateXkcdResponseJsonModel()
                .getImg();
    }

    public XkcdWebcomicImageResponseParametersTests(int webcomicId) {

        super(webcomicId);

        this.xkcdWebcomicImageUrl = validateXkcdResponseJsonModel()
                .getImg();
    }

    @BeforeEach
    public void beforeEachXkcdWebcomicImageRequestParametersTest() {

        this.xkcdWebcomicImageValidatableResponse = new XkcdWebcomicRequestBuilder(xkcdWebcomicImageUrl)
                .sendRequestForXkcdWebcomic()
                .then()
                .assertThat();
    }

    @Test
    public void testXkcdWebcomicImageResponseHttpStatusCode() {

        xkcdWebcomicImageValidatableResponse
                .statusCode(200);
    }

    @Test
    public void testXkcdWebcomicImageResponseContentType(){

        xkcdWebcomicImageValidatableResponse
                .contentType("image/png");
    }
}
