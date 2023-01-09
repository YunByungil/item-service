# item-service
### 스프링 부트를 이용한 상품 관리

- 프로젝트 선택
  - Project: Gradle Project
  - Language: Java
  - Spring Boot: 2.7.7
- Project Metadata
  - Group: hello
  - Artifact: <b>item-service</b>
  - Name: item-service
  - Package name: <b>hello.itemservice</b>
  - Packaging: <b>Jar (주의!)</b>
  - Java: 11
  - Dependencies: <b>Spring Web, Thymeleaf, Lombok</b>
---
### 요구사항 분석
##### 상품을 관리할 수 있는 서비스를 만들어보자.
- 상품 도메인 모델
  - 상품 ID
  - 상품명
  - 가격
  - 수량
- 상품 관리 기능
  - 상품 목록
  - 상품 상세
  - 상품 등록
  - 상품 수정

### 요구사항 추가
#### 타임리프를 사용해서 폼에서 체크박스, 라디오 버튼, 셀렉트 박스를 편리하게 사용하는 방법을 학습해보자.
기존 상품 서비스에 다음 요구사항이 추가되었다.
- 판매 여부
  - 판매 오픈 여부
  - 체크 박스로 선택할 수 있다.
- 등록 지역
  - 서울, 부산, 제주
  - 체크 박스로 다중 선택할 수 있다.
- 상품 종류
  - 도서, 식품, 기타
  - 라디오 버튼으로 하나만 선택할 수 있다.
- 배송 방식
  - 빠른 배송
  - 일반 배송
  - 느린 배송
  - 셀렉트 박스로 하나만 선택할 수 있다.
