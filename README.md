1. Unit Test 코드를 작성해야하는 이유
-앱 개발시 코드가 예상대로 실행되는지 테스트가 필요한데 매번 수동으로 테스트하게 되면 인력 소모가 심하고 정확하지 않은 테스트가 있을 수 있어 안정성이 떨어짐
-자동화 테스트를 진행하게 된다면 인력 소모를 줄일 수 있고 보다 정교하고 안정적인 테스트를 진행할 수 있음
-테스트 코드 작성은 작업이 귀찮을 수 있지만 다양한 테스트 케이스들을 고려해볼 수 있기 때문에 기능 추가, 변경, 코드 리팩토링에 있어서 강력한 이점을 지님
-안드로이드 프로젝트에서 Junit, Espresso Unit/UI Test 툴이 기본적으로 탑재되어있음
```kotlin
dependencies {
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
}
```

2. Test 종류
2.1 Unit Test
-메소드, 클래스 등 유닛 단위로 기능을 검증
ex) Junit, Mockito, PowerMock

2.2 UI Test
-버튼 클릭, 테스트 입력, 스크롤 등 사용자와의 UI 인터랙션을 검증
ex) Espresso, UIAutomator, Robotium, Calabash, Robolectric

3. JUnit
-단위 테스트 프레임워크 중 하나로 assertEquals 등의 단정문으로 케이스의 수행 결과를 판별
-간결한 Annotation 을 지원

3.1 ExampleInstrumentedTest
-실제 안드로이드 기기를 통한 테스트 방법
-앱의 생명주기 및 이벤트를 제어하는 기능을 갖춘 통합 테스트 코드를 작성
-Instrumentation API 에 엑세스할 수 있으며 테스트하는 앱의 정보(ex. Context)에 엑세스할 권한을 개발자에게 제공
-자체 AndroidManifest.xml 파일이 있어야하지만 Gradle 이 빌드 과정에서 이 파일을 자동으로 생성하므로 파일은 프로젝트 소스 세트에 표시되진 않음
ㄴ필요한 경우 자체 Manifest 파일을 추가해 minSdkVersion 에 다른 값을 지정하거나 테스트 전용 실행 리스너를 등록


3.2 ExampleUnitTest
-안드로이드 프레임워크 종속 항목이 없거나 모의로 구현할 수 있는 데이터 및 동작에 대해 단위 테스트를 작성
-로컬 JVM 에서 실행할 수 있는 테스트

3.3 Annotation 종류
@Before : @Test 시작하기 전 사전에 진행해야 할 동작. @Test가 시작되기 전 항상 호출됨(단위 테스트 포함)
@Test : @Before 가 완료되면 실제 코드 테스트를 진행
@Test(timeout=) : @Test 룰에 대한 timeout 을 지정. timeout 안에 테스트가 완료되지 않으면 fail 이 되며, tim e은 milliseconds 으로만 사용. ex) @Test(timeout=500)
@Test(expected=RuntimeException.class) : 테스트 메서드가 RuntimeException 이 발생해야 성공, 그렇지 않으면 실패
@After : 모든 테스트가 종료되면 호출됨. 메모리에서 resource 를 release 할 수 있음
@Rule : 해당 Test class 에서 사용하게 될 ActivityTestRule 과 ServiceTestRule 에 대해 정의
@BeforeClass, @AfterClass : public static method 로 정의하여야 하며, @Before, @After 와 동일하게 해당 테스트 클래스에서 한 번씩만 실행됨
@RequiresDevice : 에뮬레이터를 사용하지 않고 기기만 사용
@SdkSupress : minSdkVersion을 지정
@SmallTest, @MediumTest, @LargeTest : 테스트 성격을 구분하여 테스트


3.4 단정문 종류
assertArrayEquals(a,b) : 배열 a와 b가 일치함을 확인
assertEquals(a,b) : 객체 a 와 b의 "값이 같은지" 확인
assertSame(a,b) : 객체 a 와 b가 "같은 객체인지" 확인
assertNotNull(a) : a 객체가 null 이 아님을 확인


4. Mockito
-Test Double 중 하나
cf. Mock : 호출에 대한 기대를 명세하고, 해당 내용에 따라 동작하도록 프로그래밍 된 객체

4.1 Test Double
https://brunch.co.kr/@tilltue/55





---
Android UnitTest 정리
https://youngest-programming.tistory.com/492

Android UnitTest, JUnit을 이용한 유닛 테스트
https://www.crocus.co.kr/1544

안드로이드 테스트 코드 작성해보기
https://velog.io/@haero_kim/Android-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%BD%94%EB%93%9C-%EC%9E%91%EC%84%B1%ED%95%B4%EB%B3%B4%EA%B8%B0




앱 테스트
https://developer.android.com/studio/test

*Espresso 부분 다시 참고
JUnit4, Espresso를 이용한 테스트 코드 작성
https://thdev.tech/androiddev/2016/05/04/Android-Test-Example/

JUnit 단정문 문서
https://junit.sourceforge.net/javadoc/org/junit/Assert.html

Mockito-inline version
https://search.maven.org/artifact/org.mockito/mockito-inline
