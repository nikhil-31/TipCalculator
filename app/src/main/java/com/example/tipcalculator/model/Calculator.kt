package com.example.tipcalculator.model

import java.math.RoundingMode

class Calculator {

    /**
     * Method to calculate the value of a percentage based tip
     */
    fun calculateTip(checkInput: Double, tipPctInput: Int): TipCalculator {

        val tipAmount: Double = (checkInput * (tipPctInput / 100.00))
            .toBigDecimal()
            .setScale(2, RoundingMode.HALF_UP)
            .toDouble()

        val grandTotal: Double = checkInput + tipAmount
        return TipCalculator(checkInput, tipPctInput, tipAmount, grandTotal)
    }
}