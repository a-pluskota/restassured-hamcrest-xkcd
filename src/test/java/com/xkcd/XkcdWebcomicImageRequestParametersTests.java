package com.xkcd;

import com.jayway.restassured.response.ValidatableResponse;
import com.xkcd.request.RequestBuilder;
import org.junit.jupiter.api.Test;

public class XkcdWebcomicImageRequestParametersTests extends XkcdRequestParametersTests {

    private String xkcdWebcomicImageUrl;
    private ValidatableResponse xkcdWebcomicImageValidatableResponse;

    public XkcdWebcomicImageRequestParametersTests() {

        this.xkcdWebcomicImageUrl = validateXkcdResponseJsonModel()
                .getImg();

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
    public void testXkcdResponseContentType(){

        xkcdWebcomicImageValidatableResponse
                .contentType("image/png");
    }
}
