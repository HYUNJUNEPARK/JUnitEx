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

    fun calculate(rad: Double) {
        try {
            radius.value = rad.toString()
            val radiusDoubleValue = radius.value?.toDouble()
            if (radiusDoubleValue != null) {
                calculateArea(radiusDoubleValue)
                calculateCircumference(radiusDoubleValue)
                //Log.i("MYTAG", "1111")
            } else {
                //Log.i("MYTAG", "2222")
                _area.value = null
                _circumference.value = null
            }
        } catch (e: Exception) {
            _area.value = null
            _circumference.value = null
        }
    }

    fun calculateArea(rad: Double) {
        val calculatedArea = calculator.calculateArea(rad)
        _area.value = calculatedArea.toString()
    }

    fun calculateCircumference(rad: Double) {
        val calculatedCircumference = calculator.calculateCircumference(rad)
        _circumference.value = calculatedCircumference.toString()
    }
}