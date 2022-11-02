package com.study.junitex

class Calculator {
    private val pi = 3.14

    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun sub(a: Int, b: Int): Int {
        return a - b
    }

    fun calculateCircumference(radius: Double): Double {
        return 2 * pi * radius
    }

    fun calculateArea(radius: Double): Double {
        return pi * radius * radius
    }
}