package com.study.junitex

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CalculatorViewModelUnitTest {
    private lateinit var calculatorViewModel: CalculatorViewModel
    private lateinit var calculator: Calculator

    /**
     * InstantTaskExecutorRule()
     * 백그라운드 작업과 연관된 모든 아키텍처 컴포넌트들을 단일 스레드에서 실행되게 해서 테스트 결과들이 동기적으로 실행
     * LiveData 테스트 시 필수로 사용
     */
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    /**
     * calculatorViewModel() 객체 초기화
     *
     * Cannot mock/spy class com.study.junitex.Calculator Mockito cannot mock/spy because : final class
     * Mockito 가 final class 를 Moc k으로 만드려고 했기 때문에 발생한 예외
     * 코틀린은 기본적으로 클래스가 final 설정되기 때문에 open 키워드로 클래스를 만들지 않았다면 이런 에러가 발생할 수 있다.
     * 해결 방법 : build.gradle (`org.mockito:mockito-core`->`org.mockito:mockito-inline`)
     */
    @Before
    fun setUp() {
        //Mocking 할 클래스 설정
        calculator = Mockito.mock(Calculator::class.java)

        //Mockito.`when`(Mocking 한 클래스에서 호출할 함수[테스트할 함수]).thenReturn([테스트할 함수 결과 예상 값])
        Mockito.`when`(calculator.calculateArea(2.1)).thenReturn(13.8474)
        Mockito.`when`(calculator.calculateCircumference(1.0)).thenReturn(6.28)

        //Mock 객체를 파라미터로 전달
        calculatorViewModel = CalculatorViewModel(calculator)
    }

    @Test
    fun testCalculate() {
        calculatorViewModel.calculate(2.1)

        val area = calculatorViewModel.area.value
        val radius = calculatorViewModel.radius.value
        val circumference = calculatorViewModel.circumference.value

        assertNotNull(area)
        assertNotNull(radius)
        assertNotNull(circumference)
    }

    @Test
    fun testCalculateArea() {
        calculatorViewModel.calculateArea(2.1)
        val area = calculatorViewModel.area.value
        assertEquals("13.8474", area)
    }

    @Test
    fun calculateCircumference() {
        calculatorViewModel.calculateCircumference(1.0)
        val circumference = calculatorViewModel.circumference.value
        assertEquals("6.281", circumference)
    }
}