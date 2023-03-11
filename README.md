# 게시판 서비스 - 패스트캠퍼스, 10개 프로젝트로 완성하는 백엔드 웹개발

가장 기본적이고 보편적인 게시판 기능을 둘러볼 수 있는 서비스입니다. 2022년 6월 기준 가장 최신의 스프링 부트와 관련 기술들, 자바 17 기능들, 개발 도구들을 경험할 수 있도록 만들어졌습니다.

이 서비스는 [패스트캠퍼스](https://fastcampus.co.kr/)의 [10개 프로젝트로 완성하는 백엔드 웹개발(Java/Spring) 초격차 패키지 Online](https://fastcampus.co.kr/dev_online_befinal) 강의의 강의용 프로젝트로 사용되었습니다.

## 개발 환경

* Intellij IDEA Ultimate 2022.1.1 ~ 2022.1.3
* Java 17
* Gradle 7.4.1
* Spring Boot 2.7.0

## 기술 세부 스택

Spring Boot

* Spring Boot Actuator
* Spring Web
* Spring Data JPA
* Rest Repositories
* Rest Repositories HAL Explorer
* Thymeleaf
* Spring Security
* H2 Database
* MySQL Driver
* Lombok
* Spring Boot DevTools
* Spring Configuration Processor

그 외

* QueryDSL 5.0.0
* Bootstrap 5.2.0-Beta1
* Heroku

### 변경사항
* Heroku 관련하여 2022년 11월 28일 부로 무료 플랜에 대한 서비스 제공의 중단으로 인해 Heroku를 통한 배로를 활용하지 않음
  * Heroku 미사용에 대한 이유
    1. 무료로 배포를 하여 서비스를 웹상에서 확인할 수 있는 이점이 없어짐
    2. AWS등과 동일하게 비용이 들어가는 경우 서버 running 측면에서 헤로쿠가 느림
    3. 실무에서 사용하기에도 Heroku보다는 AWS를 사용하는 경우의 수가 많음
    4. AWS를 Docker를 통해 배포하는 것에 대한 기술을 익힌 후 해당 클라우드 서버로 배포 예정 
