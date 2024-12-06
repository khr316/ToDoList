# To Do List 모바일 웹 개발

### 개발 환경
- SpringBoot JDBC Thymeleaf
- HTML CSS JavaScript
- MySQL

##### 배포 후 직접 사용하는 것이 목표 !!!

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
