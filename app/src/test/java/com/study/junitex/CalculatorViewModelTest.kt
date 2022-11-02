package com.study.junitex

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito


/*
Cannot mock/spy class com.study.junitex.Calculator
Mockito cannot mock/spy because :
- final class
-> Mockito가 final class를 Mock으로 만드려고 했기 때문입니다. kotlin은 기본적으로 클래스가 final 설정되기 때문에 open 키워드로 클래스를 만들지 않았다면 이런 에러가 발생할 수 있습니다.
->간단한 해결방법은 build.gralde에 기존에 사용했었던 org.mockito:mockito-core를 제거하고 org.mockito:mockito-inline를 정의하는 것입니다.
 */
class CalculatorViewModelTest {
    private lateinit var calculatorViewModel: CalculatorViewModel
    private lateinit var calculator: Calculator

    //백그라운드 작업과 연관된 모든 아키텍처 컴포넌트들을 같은(한개의) 스레드에서 실행되게 해서 테스트 결과들이 동기적으로 실행
    //모든 작업들을 동기적(synchronous) 하게 해주어 동기화에 신경쓰지 않게 해주어 좋고 LiveData 테스트시 필수로 사용
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        //Mocking 할 클래스를 먼저 mock()
        calculator = Mockito.mock(Calculator::class.java)
        //Mocking 한 클래스에서 호출할 함수를 when()에 전달
        //thenReturn()에는 내가 when()과 같은 함수 호출 시 반환할 값을 명시
        Mockito.`when`(calculator.calculateArea(2.1)).thenReturn(13.8474)
        Mockito.`when`(calculator.calculateCircumference(1.0)).thenReturn(6.28)

        //Calculator mock 을 파라미터로 전달
        calculatorViewModel = CalculatorViewModel(calculator)
    }

    @Test
    fun getRadius() {

    }

    @Test
    fun setRadius() {

    }

    @Test
    fun getArea() {

    }

    @Test
    fun getCircumference() {

    }

    @Test
    fun calculate() {
        calculatorViewModel.calculate(2.1)
        val areaResult = calculatorViewModel.area.value
        val circumferenceResult = calculatorViewModel.circumference.value
        assertEquals("13.8474", areaResult)
        assertEquals("6.28", circumferenceResult)
    }

    @Test
    fun calculateArea() {
        calculatorViewModel.calculateArea(2.1)
        val result = calculatorViewModel.area.value
        assertEquals("13.8474", result)
    }

    @Test
    fun calculateCircumference() {
        calculatorViewModel.calculateCircumference(1.0)
        val result = calculatorViewModel.circumference.value
        assertEquals("6.28", result)
    }
}