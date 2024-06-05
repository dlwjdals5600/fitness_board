# Spring Boot Toy Project

## Fitness 게시판 만들기

- 이전부터 생각해오던 건강 커뮤니티 + 판매사이트를 만들기 위한 준비단계로 Spring Boot를 이용한 게시판 만들기 프로젝트를 진행하고 있습니다.

### 개발 인원 및 기간

- 개발 기간 : 2024.05.24 ~ 2024.06.05(이후 계속 진행)
- 개발 인원 : 혼자


<br>
<br>
<br>


### IDE (통합 개발 환경)

#### STS4(Web 개발 툴)                      
- language : java
- build type : gradle-groovy
- JDK : JDK-21
- Packaging : JAR
- Spring Boot : 3.2.5
- Dependency : Spring Web <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Spring Boot DevTools <br>
               Thymeleaf <br>
               Spring Session <br>
               MySQL Driver <br>
               JDBC API <br>
               MyBatis Framework

<br>
<br>
<br>

## 사용 기술 및 구현 기능


### 사용 기술 및 tools
> - Front-End : <img src="https://img.shields.io/badge/ES6+-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white"/>&nbsp;<img src="https://img.shields.io/badge/jQuery-CA4245?style=for-the-badge&logo=jQuery&logoColor=white"/>&nbsp;<img src="https://img.shields.io/badge/Ajax-338000?style=for-the-badge&logo=AJAX&logoColor=white"/>&nbsp;<img src="https://img.shields.io/badge/HTML5-61DAFB?style=for-the-badge&logo=html5&logoColor=white"/>&nbsp;<img src="https://img.shields.io/badge/CSS-CC6699?style=for-the-badge&logo=css3&logoColor=white"/>
> - Back-End : <img src="https://img.shields.io/badge/Java-787878?style=for-the-badge&logo=java&logoColor=white"/>&nbsp;<img src="https://img.shields.io/badge/SpringBoot-338000?style=for-the-badge&logo=SpringBoot&logoColor=white"/>&nbsp;<img src="https://img.shields.io/badge/MYSQL 8.0-148CFF?style=for-the-badge&logo=MySQL&logoColor=white"/>&nbsp;
> - ETC : <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white"/>&nbsp;<img src="https://img.shields.io/badge/Github-181717?style=for-the-badge&logo=Github&logoColor=white"/>





### 구현 기능

#### User

- 회원가입, 로그인 기능 구현

#### Board

- `Session`을 이용해 로그인된 상태를 확인 후 게시판 페이지를 보여주도록 기능구현 (로그인이 안된 상태라면 게시판 페이지 -> 로그인페이지로 이동)
- 게시판 리스트, 게시판 상세 페이지 구현
- 게시판 읽기, 쓰기, 수정, 삭제 기능 구현
- 로그인한 아이디와 글쓴이 아이디를 매칭해서 일치하면 게시판 글을 수정, 삭제 할 수 있는 권한 기능 구현

#### Comment

- 게시판 상세 페이지 밑에 댓글 공간 구현
- 게시판 상세 페이지 로드가 완료되었을 때, jQuery를 이용한 Ajax를 통해 Comment Controller에서 데이터를 요청해 댓글들을 페이지에 보여주는 기능 구현
- 댓글의 수정 버튼을 눌렀을 시 모달창을 띄워 수정할 수 있는 textarea 화면을 보여주는 기능 구현
- 본인이 쓴 댓글만 수정, 삭제가 되도록 기능 구현
