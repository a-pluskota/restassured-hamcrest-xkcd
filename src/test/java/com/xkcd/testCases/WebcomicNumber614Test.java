package com.xkcd.testCases;

import com.xkcd.ResponseDetailsTests;
import com.xkcd.response.ExpectedDataForSelectedXkcdWebcomics;
import org.junit.jupiter.api.Tag;

import static com.xkcd.ResponseParametersTests.TEST_CASE_TO_RUN;

@Tag(TEST_CASE_TO_RUN)
public class WebcomicNumber614Test extends ResponseDetailsTests {


    public WebcomicNumber614Test() {

        super(ExpectedDataForSelectedXkcdWebcomics
                .getExpectedDataForXkcdWebcomicNumber614());
    }
}
