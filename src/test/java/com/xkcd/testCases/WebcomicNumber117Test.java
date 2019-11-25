package com.xkcd.testCases;

import com.xkcd.ResponseDataTests;
import com.xkcd.response.ExpectedDataForSelectedXkcdWebcomics;
import org.junit.jupiter.api.Tag;

import static com.xkcd.ResponseParametersTests.TEST_CASE_TO_RUN;

@Tag(TEST_CASE_TO_RUN)
public class WebcomicNumber117Test extends ResponseDataTests {


    public WebcomicNumber117Test() {

        super(ExpectedDataForSelectedXkcdWebcomics
                .getExpectedDataForXkcdWebcomicNumber117());
    }
}
