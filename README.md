# To Do List 모바일 웹 개발

##### 배포 후 직접 사용하는 것이 목표 !!!
- AWS


## 기술 스택

### 1. **Back-End**
   - **Spring Boot**
   - **Spring Data JPA**
   - **Spring Web**
   - **Spring Boot DevTools**
   - **Spring Boot Starter Mail**
   - **Lombok**

### 2. **Database**
   - **MySQL**
   - **JDBC**

### 3. **Frontend**
   - **Thymeleaf**
   - **HTML/CSS**
   - **JavaScript**

### 4. **Build**
   - **Maven**

### 5. **Version Control**
   - **Git**
   - **GitHub**

### 6. **개발 도구**
   - **IntelliJ IDEA**
   - **Dbeaver**
<hr>

## DB 설계
![엔티티](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbbPcbd%2FbtsLbTtDSAi%2FVDpLjVGBJvpxgvBHFVpHok%2Fimg.png)
```
-- 이메일 찾기 질의응답
create table qna (
	id int auto_increment primary key,                -- QnA 번호 (Primary Key)
	question text                                     -- 질문
);

-- 회원(users) 테이블 생성
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,                -- 회원 번호 (Primary Key)
    name VARCHAR(10) NOT NULL,                        -- 회원 이름
    nickname VARCHAR(20) NOT NULL UNIQUE,             -- 회원 닉네임 (중복 불가)
    email VARCHAR(30) NOT NULL UNIQUE,                -- 회원 이메일 (중복 불가)
    password VARCHAR(30) NOT null,                    -- 회원 비밀번호
    question_id text not null,                        -- 이메일 찾기 질문 번호
    answer text not null                              -- 이메일 찾기 답변
);

-- 투두리스트(todolist) 테이블 생성
CREATE TABLE todolist (
    id INT AUTO_INCREMENT PRIMARY KEY,                -- 투두 번호 (Primary Key)
    tododate DATE DEFAULT (CURDATE()),                -- 투두 등록 날짜 (현재 날짜로 기본값 설정)
    deadline DATETIME NOT NULL,                       -- 투두 마감 날짜
    tododesc TEXT NOT NULL,                           -- 투두 내용
    complete INT DEFAULT 0,                           -- 완료 여부 (0: 미완료, 1: 완료)
    userid INT,                                       -- 등록한 회원 번호
    FOREIGN KEY (userid) REFERENCES users(id)         -- 회원 테이블과 연관
        ON DELETE CASCADE                             -- 회원 삭제 시 연관 투두 삭제
);

```

## 기능
- 사용자 로그인/회원가입
- 할 일 목록 CRUD 기능
- 임시 비밀번호 발급 (이메일)
- 마감기한 하루 전 안내 메일 발송


## 
1. 메인페이지
   - [로그인 전]
     - 회원가입
     - 로그인
     - 사이트 이용 설명
   - [로그인 후]
     - 비밀번호 변경
     - 로그아웃
     - 날짜 선택(dafult 오늘 날짜)
     - 할 일 추가
2. 회원가입 및 로그인 페이지
   - 회원가입) 이메일(중복체크), 이름, 닉네임(중복체크),<br>
     비밀번호(8~30 - 알파벳+숫자+특수문자 조합), 비밀번호 확인(비밀번호 입력창과 비교), 이메일 찾기에 필요한 질의응답
   - 로그인) 이메일, 비밀번호
   - 이메일 찾기 (이름,닉네임,질의응답으로 본인 확인 후 이메일 확인)
   - 비밀번호 찾기 (이메일,이름,닉네임으로 본인 확인 후 임시 비밀번호 발급)
3. 투두리스트 페이지
   - 할 일 목록
     - 미완료 => 완료 변경
     - 수정 => 할 일, 마감기한 수정
     - 삭제 => 해당 할 일 DB에서 삭제




## 참고 자료
- [웹사이트 스크린샷](https://khr316.tistory.com/entry/개인-ToDoList-웹-사이트-개발)



