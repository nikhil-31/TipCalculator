package com.example.tipcalculator.viewmodel

import android.app.Application
import com.example.tipcalculator.R
import com.example.tipcalculator.model.Calculator
import com.example.tipcalculator.model.TipCalculator
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class CalculatorViewModelTest {

    lateinit var calculatorViewModel: CalculatorViewModel

    @Mock
    lateinit var mockCalculator: Calculator

    @Mock
    lateinit var mockApp: Application

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        stubResource(0.0, "$0.0")
        calculatorViewModel = CalculatorViewModel(mockApp, mockCalculator)
    }

    private fun stubResource(given: Double, returnStub: String) {
        `when`(mockApp.getString(R.string.dollar, given)).thenReturn(returnStub)
    }

    @Test
    fun testCalculateTip() {

        calculatorViewModel.inputCheckAmount = "10.0"
        calculatorViewModel.inputCheckPercentage = "15"

        val stub = TipCalculator(checkAmount = 10.00, tipAmount = 1.5, grandTotal = 11.5)
        `when`(mockCalculator.calculateTip(10.00, 15)).thenReturn(stub)

        stubResource(10.0, "$10.00")
        stubResource(1.5, "$1.50")
        stubResource(11.5, "$11.50")

        calculatorViewModel.calculateTip()

        assertEquals("$10.00", calculatorViewModel.outputCheckAmount)
        assertEquals("$1.50", calculatorViewModel.outputTipAmount)
        assertEquals("$11.50", calculatorViewModel.outputGrandTotal)

    }

    @Test
    fun testCalculatorTipBadTipPercent() {
        calculatorViewModel.inputCheckAmount = "10.0"
        calculatorViewModel.inputCheckPercentage = ""

        calculatorViewModel.calculateTip()

        // This checks that the mocked version of mockCalculator's method is never fun for bad inputs
        verify(mockCalculator, never()).calculateTip(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyInt())
    }

}