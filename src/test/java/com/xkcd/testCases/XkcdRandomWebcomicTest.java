package com.xkcd.testCases;

import com.xkcd.XkcdResponseParametersTests;
import com.xkcd.XkcdWebcomicImageResponseParametersTests;

import java.util.Random;

public class XkcdRandomWebcomicTest extends XkcdWebcomicImageResponseParametersTests {

    private static final int randomWebcomicID = new Random()
            .nextInt((new XkcdResponseParametersTests()
                    .validateXkcdResponseJsonModel()
                    .getNum() - 117) + 117);

    public XkcdRandomWebcomicTest() {

        super(randomWebcomicID);
    }
}
