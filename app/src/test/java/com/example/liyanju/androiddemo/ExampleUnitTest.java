package com.example.liyanju.androiddemo;

import android.provider.Settings;
import android.test.AndroidTestCase;
import android.util.Log;

import com.example.liyanju.androiddemo.phone360.esb;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
      //  Log.v("xx", "xxxxxxxx");

        esb e1 = new esb();
        e1.a = 11;
        e1.b = "11";

        byte b[] = e1.f();

        System.out.println(" byte b : " + b.length);

//        assertEquals(4, 2 + 2);
    }
}