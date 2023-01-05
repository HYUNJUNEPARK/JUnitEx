package com.study.testingex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel(private val calculator: Calculator): ViewModel() {
    var radius = MutableLiveData<Double>()

    val area: LiveData<String>
        get() = _area
    private var _area = MutableLiveData<String>()

    val circumference: LiveData<String>
        get() = _circumference
    private var _circumference = MutableLiveData<String>()

    /**
     * LiveData(radius, area, circumference) 초기화
     */
    fun calculate(rad: Double) {
        try {
            radius.value = rad
            calculateArea(rad)
            calculateCircumference(rad)
        } catch (e: Exception) {
            _area.value = null
            _circumference.value = null
        }
    }

    /**
     * area 초기화
     */
    fun calculateArea(rad: Double) {
        val calculatedArea = calculator.calculateArea(rad)
        _area.value = calculatedArea.toString()
    }

    /**
     * circumference 초기화
     */
    fun calculateCircumference(rad: Double) {
        val calculatedCircumference = calculator.calculateCircumference(rad)
        _circumference.value = calculatedCircumference.toString()
    }
}