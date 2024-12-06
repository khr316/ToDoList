# To Do List 모바일 웹 개발

##### 배포 후 직접 사용하는 것이 목표 !!!


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
   - **JPA (Java Persistence API)**

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

### DB 설계
![엔티티](https://github.com/khr316/todolist/blob/main/DB%EC%84%A4%EA%B3%84.PNG)
```
-- 회원(users) 테이블 생성
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,                -- 회원 번호 (Primary Key)
    name VARCHAR(10) NOT NULL,                        -- 회원 이름
    nickname VARCHAR(20) NOT NULL UNIQUE,             -- 회원 닉네임 (중복 불가)
    email VARCHAR(30) NOT NULL UNIQUE,                -- 회원 이메일 (중복 불가)
    password VARCHAR(30) NOT NULL                     -- 회원 비밀번호
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

## 참고 자료
- [웹사이트 스크린샷](https://khr316.tistory.com/entry/개인-ToDoList-웹-사이트-개발)



