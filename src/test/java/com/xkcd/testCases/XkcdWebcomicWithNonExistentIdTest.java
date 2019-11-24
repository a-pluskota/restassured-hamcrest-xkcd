package com.xkcd.testCases;

import com.xkcd.XkcdResponseParametersTests;

public class XkcdWebcomicWithNonExistentIdTest extends XkcdResponseParametersTests {

    public XkcdWebcomicWithNonExistentIdTest() {

        super(
                new XkcdResponseParametersTests()
                        .validateXkcdResponseJsonModel()
                        .getNum() + 1,
                404);
    }
}
