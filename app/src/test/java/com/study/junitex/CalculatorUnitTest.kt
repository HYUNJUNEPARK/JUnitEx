package com.study.junitex

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorUnitTest {
    private var calculator: Calculator? = null

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun 기본_덧셈() {
        val result = calculator?.add(5, 6)
        assertEquals(11, result)
    }

    @Test
    fun 음수끼리_덧셈() {
        val result = calculator?.add(-5, -4)
        assertEquals(-9, result)
    }

    @Test
    fun 기본_뺄셈() {
        val result = calculator?.sub(10, 5)
        assertEquals(5, result)
    }

    @Test
    fun 음수끼리_뺄셈() {
        val result = calculator?.sub(-5, -4)
        assertEquals(-1, result)
    }

    @Test
    fun calculateCircumference_radiusGiven_returnsCorrectResult(){
        val result = calculator?.calculateCircumference(2.1)
        assertEquals(13.188, result)
    }

    @Test
    fun calculateCircumference_zeroRadius_returnsCorrectResult(){
        val result = calculator?.calculateCircumference(0.0)
        assertEquals(0.0, result)
    }

    @Test
    fun calculateArea_radiusGiven_returnsCorrectResult(){
        val result = calculator?.calculateArea(2.1)
        assertEquals(13.8474, result)
    }

    @Test
    fun calculateArea_zeroRadius_returnsCorrectResult(){
        val result = calculator?.calculateCircumference(0.0)
        assertEquals(0.0, result)
    }
}