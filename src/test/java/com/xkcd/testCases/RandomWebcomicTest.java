package com.xkcd.testCases;

import com.xkcd.ResponseParametersTests;
import com.xkcd.ImageResponseParametersTests;
import org.junit.jupiter.api.Tag;

import java.util.Random;

import static com.xkcd.ResponseParametersTests.TEST_CASE_TO_RUN;

@Tag(TEST_CASE_TO_RUN)
public class RandomWebcomicTest extends ImageResponseParametersTests {

    private static final int RANDOM_WEBCOMIC_ID = new Random()
            .nextInt((new ResponseParametersTests()
                    .extractXkcdResponseJsonModel()
                    .getNum() - 117) + 117);

    public RandomWebcomicTest() {

        super(RANDOM_WEBCOMIC_ID);
    }
}
