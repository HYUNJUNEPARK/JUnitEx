
---

0.Build
-안드로이드 프로젝트에서 Unit/UI Test 프레임워크(Junit, Espresso)가 기본적으로 탑재되어있음

```kotlin
dependencies {
    //tes implementation
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
}
```

---

1.JUnit
-메소드, 클래스 등 단위(Unit) 테스트를 실행하는 프레임워크 중 하나로 단정문(ex. 'assertEquals')으로 케이스의 수행 결과를 판별
-간결한 Annotation 을 지원
cf.Mockito, PowerMock

1.1.ExampleUnitTest(Test)
-안드로이드 프레임워크 종속 항목이 없거나 모의로 구현할 수 있는 데이터 및 동작에 대해 단위 테스트를 작성
-로컬 JVM 에서 실행할 수 있는 테스트

1.2.JUnit Annotation
-@Before : @Test 시작하기 전 사전에 진행해야 할 동작. @Test가 시작되기 전 항상 호출됨(단위 테스트 포함)
-@Test : @Before 가 완료되면 실제 코드 테스트를 진행
-@Test(timeout=) : @Test 룰에 대한 timeout 을 지정.
 ㄴtimeout 안에 테스트가 완료되지 않으면 fail 이 되며, time은 milliseconds 으로만 사용. ex) @Test(timeout=500)
-@Test(expected=RuntimeException.class) : 테스트 메서드가 RuntimeException 이 발생해야 성공, 그렇지 않으면 실패
-@After : 모든 테스트가 종료되면 호출됨. 메모리에서 resource 를 release 할 수 있음
-@Rule : 해당 Test class 에서 사용하게 될 ActivityTestRule 과 ServiceTestRule 에 대해 정의
-@BeforeClass, @AfterClass : public static method 로 정의하여야 하며, @Before, @After 와 동일하게 해당 테스트 클래스에서 한 번씩만 실행됨
-@RequiresDevice : 에뮬레이터를 사용하지 않고 기기만 사용
-@SdkSupress : minSdkVersion을 지정
-@SmallTest, @MediumTest, @LargeTest : 테스트 성격을 구분하여 테스트

1.3.JUnit 단정문 종류
-assertArrayEquals(a,b) : 배열 a와 b가 일치함을 확인
-assertEquals(a,b) : 객체 a 와 b의 값이 같은지 확인
-assertSame(a,b) : 객체 a 와 b가 같은 객체인지 확인
-assertNotNull(a) : a 객체가 null 이 아님을 확인

```kotlin
//테스트 코드 : Given - When - Then 패턴 예시
@Test
fun calculateArea_radiusGiven_setAreaLiveData_returnPassedResult() {
 //Given : 테스트를 준비하는 과정. 테스트에 사용하는 변수, 입력 값 등을 정의하거나 Mock 객체를 정의하는 구문 등이 포함된다.
 val radius = 2.1
 val expectedArea = "13.8474"

 //When : 실제로 테스트를 실행하는 과정.
 calculatorViewModel.calculateArea(radius)

 //Then : 테스트를 검증하는 과정.
 val actualArea = calculatorViewModel.area.value
 assertEquals(expectedArea, actualArea)
}
```


---

2.Espresso
-버튼 클릭, 테스트 입력, 스크롤 등 사용자와의 UI 인터랙션을 검증
cf. UIAutomator, Robotium, Calabash, Robolectric

2.1 ExampleInstrumentedTest(androidTest)
-실제 안드로이드 기기를 통한 테스트 방법
-앱의 생명주기 및 이벤트를 제어하는 기능을 갖춘 통합 테스트 코드를 작성
-Instrumentation API 에 엑세스할 수 있으며 테스트하는 앱의 정보(ex. Context)에 엑세스할 권한을 개발자에게 제공
-자체 AndroidManifest.xml 파일이 있어야하지만 Gradle 이 빌드 과정에서 이 파일을 자동으로 생성하므로 파일은 프로젝트 소스 세트에 표시되진 않음
 ㄴ필요한 경우 자체 Manifest 파일을 추가해 minSdkVersion 에 다른 값을 지정하거나 테스트 전용 실행 리스너를 등록


---

JUnit 단정문 문서
https://junit.sourceforge.net/javadoc/org/junit/Assert.html

Android UnitTest 정리
https://youngest-programming.tistory.com/492

Android UnitTest, JUnit을 이용한 유닛 테스트
https://www.crocus.co.kr/1544

앱 테스트
https://developer.android.com/studio/test

*Espresso 부분 다시 참고
JUnit4, Espresso를 이용한 테스트 코드 작성
https://thdev.tech/androiddev/2016/05/04/Android-Test-Example/

Mockito-inline version
https://search.maven.org/artifact/org.mockito/mockito-inline
