package com.study.junitex

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//ViewModel + LiveData + Mockito + Junit5
class CalculatorViewModel(private val calculator: Calculator): ViewModel() {
    var radius = MutableLiveData<String>()

    val area: LiveData<String>
        get() = _area
    private var _area = MutableLiveData<String>()

    val circumference: LiveData<String>
        get() = _circumference
    private var _circumference = MutableLiveData<String>()

    fun calculate() {
        try {
            val radiusDoubleValue = radius.value?.toDouble()
            if (radiusDoubleValue != null) {
                calculateArea(radiusDoubleValue)
                calculateCircumference(radiusDoubleValue)
            } else {
                _area.value = null
                _circumference.value = null
            }

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
            _area.value = null
            _circumference.value = null
        }
    }

    fun calculateArea(radius: Double) {
        val calculatedArea = calculator.calculateArea(radius)
        _area.value = calculatedArea.toString()
    }

    fun calculateCircumference(radius: Double) {
        val calculatedCircumference = calculator.calculateCircumference(radius)
        _circumference.value = calculatedCircumference.toString()
    }
}