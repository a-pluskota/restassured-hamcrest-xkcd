package com.xkcd.testCases;

import com.xkcd.ResponseParametersTests;
import org.junit.jupiter.api.Tag;

import static com.xkcd.ResponseParametersTests.TEST_CASE_TO_RUN;

@Tag(TEST_CASE_TO_RUN)
public class WebcomicWithNonExistentIdTest extends ResponseParametersTests {

    public WebcomicWithNonExistentIdTest() {

        super(
                new ResponseParametersTests()
                        .extractXkcdResponseJsonModel()
                        .getNum() + 1,
                404);
    }
}
