package com.xkcd;

import com.jayway.restassured.response.ValidatableResponse;
import com.xkcd.request.RequestBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ImageResponseParametersTests extends ResponseParametersTests {

    private String xkcdWebcomicImageUrl;
    private ValidatableResponse xkcdWebcomicImageValidatableResponse;

    public ImageResponseParametersTests() {

        this.xkcdWebcomicImageUrl = validateXkcdResponseJsonModel()
                .getImg();
    }

    public ImageResponseParametersTests(int webcomicId) {

        super(webcomicId);

        this.xkcdWebcomicImageUrl = validateXkcdResponseJsonModel()
                .getImg();
    }

    @BeforeEach
    public void beforeEachXkcdWebcomicImageRequestParametersTest() {

        this.xkcdWebcomicImageValidatableResponse = new RequestBuilder(xkcdWebcomicImageUrl)
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
