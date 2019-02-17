package com.example.tipcalculator.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    lateinit var calculatorTest: Calculator

    @Before
    fun setUp() {
        calculatorTest = Calculator()
    }

    @Test
    fun testCalculatorTip() {

        val baseTc = TipCalculator(checkAmount = 10.00)

        val array = listOf(
            baseTc.copy(tipPct = 10, tipAmount = 1.0, grandTotal = 11.0),
            baseTc.copy(tipPct = 15, tipAmount = 1.5, grandTotal = 11.50),
            baseTc.copy(tipPct = 18, tipAmount = 1.8, grandTotal = 11.80)
        )

        array.forEach {
            Assert.assertEquals(it, calculatorTest.calculateTip(it.checkAmount, it.tipPct))
        }
    }

    @Test
    fun testWithSingleExpectedResult() {
        val checkInput = 10.00
        val tipPctInput = 25

        val expectedTipResult = TipCalculator(
            checkAmount = checkInput,
            tipPct = tipPctInput,
            tipAmount = 2.50,
            grandTotal = 12.50
        )

        Assert.assertEquals(expectedTipResult, calculatorTest.calculateTip(checkInput, tipPctInput))
    }


}