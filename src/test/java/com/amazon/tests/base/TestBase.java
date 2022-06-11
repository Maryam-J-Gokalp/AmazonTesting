package com.amazon.tests.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {


    @BeforeMethod
    public void setup(){

    }

    @AfterMethod
    public void tearDown(){


    }
}
