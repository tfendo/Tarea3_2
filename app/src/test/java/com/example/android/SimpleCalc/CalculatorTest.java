/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalc;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNumbersNegative() {
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }

    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111f, 1.111d);
        assertThat(resultAdd, is(closeTo(2.222, 0.01)));
    }

    @Test
    public void restarDosNumeros() {
        double resultado = mCalculator.sub(8d, 5d);
        assertThat(resultado, is(equalTo(3d)));
    }

    @Test
    public void restarNegativos() {
        double resultado = mCalculator.sub(-2d, -5d);
        assertThat(resultado, is(equalTo(3d)));
    }

    @Test
    public void multiplicaDosNumeros() {
        double resultado = mCalculator.mul(5d, 4d);
        assertThat(resultado, is(equalTo(20d)));
    }

    @Test
    public void multiplicaNegativos() {
        double resultado = mCalculator.mul(532d, -325d);
        assertThat(resultado, is(equalTo(-172900d)));
    }

    @Test
    public void divideDosNumeros() {
        double resultado = mCalculator.div(25d, 5d);
        assertThat(resultado, is(equalTo(5d)));
    }

    @Test
    public void divideEntreCero() {
        double resultado = mCalculator.div(9d, 0d);
        assertThat(resultado, is(equalTo(Double.POSITIVE_INFINITY)));
    }
}