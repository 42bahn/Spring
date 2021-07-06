# 참고

* [WikiDocs - 스프링 MVC 하루만에 배우기](https://wikidocs.net/115235)

# Spring Framework 개발환경 설정

## JDK (Java Development Kit)

        java 컴파일러(javac) 등 개발에 필요한 도구들

        JVM, Java API, Java Tool, Java Compiler

## JRE (Java Runtime Environment)

        실제 Java코드가 실행될 때 필요한 라이브러리와 파일들을 가진 실행 환경

        JVM, Java API

## Java 버전별 특징

* ### Java SE 8

        2014년

        오라클 인수 후 첫번째 버전

        2개 버전으로 나뉨(Oracle JDK, OpenJDK)

        Lambda, new Date and Time API(LocalDateTime, …)

        interface default method

        Optional

        PermGen Area 제거

* ### Java SE 11

        2018.09

        Oracle JDK와 OpenJDK 통합

        Oracle JDK가 구독형 유료 모델로 전환

        서드파티 JDK 로의 이전 필요

        lambda 지역변수 사용법 변경

        (var x, var y) -> x.process(y)  =>  (x, y) -> x.process(y)

* ### Java SE 12

        2019년 3월 19일 공개. 
        
        문법적 Switch문 확장.

        이외에 가비지 컬렉터 개선, 마이크로 벤치마크 툴 추가, 성능 개선의 변경점.

* ### Java SE 13

        2019년 9월 17일 공개. 
        
        Java 12에서의 스위치 개선을 이어 yield 라는 예약어가 추가되었다.

* ### Java SE 16

        2021년 3월 16일 출시.

        [JEP 338: Vector API](https://openjdk.java.net/jeps/338)
        자바에서도 자동 병렬 프로세싱을 지원하는 자동 벡터 API가 추가될 예정이다.

        [JEP 347](https://openjdk.java.net/jeps/347): 자바 네이티브(JNI 등) 개발 시 C++14 규격을 지원하기 시작했다.

        OpenJDK 의 버전 관리가 Mercurial 이었으나, 이제 Git 로 바뀐다.

        이제 OpenJDK 소스를 GitHub 에서 볼 수 있다

        유닉스 도메인 소켓이 지원된다.

        Alpine Linux 리눅스 지원 추가

        ARM 64비트 윈도우 운영체제가 지원된다. MacOS의 경우 실리콘 맥 지원이 시험 빌드에서 네이티브 지원을 시작했다.

* ### Java SE 17

        자바 8, 11 버전을 이을 세 번째 LTS 버전이 한국시각 2021년 9월 15일 출시 예정이다.

        애플릿이 완전히 제거될 예정

        애플 M1 및 이후(MacOS/AArch64) 프로세서 탑재 컴퓨터 제품군에 대한 정식 지원 예정

        macOS 그래픽 렌더링 베이스를 OpenGL 에서 Metal 로 교체 예정

        [JEP 356](http://openjdk.java.net/jeps/356): 의사난수 생성기를 통해 예측하기 어려운 난수를 생성하는 API 제공 예정

## IDE - Eclipse 설치

        이클립스 2020-09 버전부터는 자바 버전 11이상을 필요로 한다.

        자바 버전 8 버전용으로는 마지막 버전인 2020-06 버전을 설치한다.

---

# Spring Framework

## Spring Tools 4 vs Spring Tools 3

![image](https://user-images.githubusercontent.com/57256332/123956808-10a6bb80-d9e6-11eb-836a-794aca16f996.png)

## MVC

![image](https://user-images.githubusercontent.com/57256332/124224448-9fc7e680-db40-11eb-89d7-e3d25942738f.png)

* ### Servelet

  * 자바를 사용하여 웹 페이지를 동적으로 생성하는 서버측 프로그램 혹은 그 사양.
  
  * HttpServlet 클래스를 상속한 클래스
  
  * 요청(Request)과 응답(Response) 즉, Http 웹 서버 기능 동작이 가능하다.
  
  * MVC 패턴에서 Controller를 담당한다.

* ### Dispatcher-Servelet

  * Servlet Container에서 HTTP프로토콜을 통해 들어오는 모든 요청을 프레젠테이션 계층의 제일 앞쪽으로 두어 중앙 집중형으로 처리해주는 Front Controller
         
  * 클라이언트로부터 어떠한 요청이 오면 Tomcat(톰캣)과 같은 서블릿컨테이너가 요청을 받는데, 이때 제일 앞에서 서버로 들어오는 모든 요청을 처리하는 Front Controller를 Spring에서 정의하였고, 이를 Dispatcher-Servlet이라고 한다.
  
  * 모든 요청(Request)을 받아 실제 작업은 다른 컴포넌트로 위임하는 DispatcherServlet 을 두어 Front Controller 패턴으로 디자인되었다.

![image](https://user-images.githubusercontent.com/57256332/124436755-46b2b980-ddb1-11eb-90fc-61f28ba75d1d.png)

## Configure File

* servlet-context.xml

  * 웹 어플리케이션에서 클라이언트의 요청을 받기 위한 컨텍스트 설정 XML 파일
  * 요청과 관련된 객체를 정의
  * URL과 관련된 Cotroller, @Annotation, ViewResolver, Intercepter, MultipartResolver 등을 설정한다.

* root-context.xml

  * servlet-context와는 반대로 View와 관련되지 않은 객체를 정의한다.
  * Service, Repository(DAO), DB 등 Business Logic과 관련된 설정을 한다.

* web.xml

  * 웹 어플리케이션 서버 WAS(ex.Apache Tomcat)가 최초로 구동될 때 각종 설정을 정의한다. 

* pom.xml

  * 프로젝트의 구조와 내용을 설명하고 있으며 pom.xml 파일에 프로젝트 관리 및 빌드에 필요한 환경 설정, 의존성 관리 등의 정보들을 기술합니다.
  * 프로젝트의 세부 메타데이터 정보 (버전 및 설정 관리, 빌드 환경, 라이브러리 저장소 및 의존성 등)를 포함한다.  

   Maven Plugin - [https://maven.apache.org/plugins/index.html](https://maven.apache.org/plugins/index.html)
  
   MavenRepository - [https://mvnrepository.com/](https://mvnrepository.com/)


