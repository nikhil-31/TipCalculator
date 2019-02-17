package com.example.tipcalculator.viewmodel

import android.app.Application
import android.databinding.BaseObservable
import android.util.Log
import com.example.tipcalculator.R
import com.example.tipcalculator.model.Calculator
import com.example.tipcalculator.model.TipCalculator

class CalculatorViewModel(val app: Application, val calculator: Calculator = Calculator()) : BaseObservable() {

    // Inputs
    var inputCheckAmount = ""
    var inputCheckPercentage = ""

    // Outputs
    var outputCheckAmount = ""
    var outputTipAmount = ""
    var outputGrandTotal = ""

    init {
        updateOutputs(TipCalculator())
    }

    private fun updateOutputs(tc: TipCalculator) {
//        Log.d(" Update outputs " , "${tc.checkAmount} ${tc.tipAmount} ${tc.tipPct} ${tc.grandTotal}")

        outputCheckAmount = app.getString(R.string.dollar, tc.checkAmount)
        outputTipAmount = app.getString(R.string.dollar,tc.tipAmount)
        outputGrandTotal = app.getString(R.string.dollar,tc.grandTotal)
    }

    fun calculateTip() {

        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val checkPct = inputCheckPercentage.toIntOrNull()

        if (checkAmount != null && checkPct != null) {
            updateOutputs(calculator.calculateTip(checkAmount, checkPct))
            notifyChange()
        }


    }

    private fun clearInputs() {
        inputCheckAmount = "0.00"
        inputCheckPercentage = "0"
        notifyChange()
    }


}