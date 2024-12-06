# To Do List 모바일 웹 개발

### 개발 환경
- SpringBoot JDBC Thymeleaf
- HTML CSS JavaScript
- MySQL

##### 배포 후 직접 사용하는 것이 목표 !!!

### DB 설계
![엔티티](https://github.com/khr316/todolist/blob/main/DB%EC%84%A4%EA%B3%84.PNG)
- 회원
  - id 회원 고유번호 | int primary key auto_increment
  - name 회원 이름 | varchar(10)
  - nickname 회원 닉네임 (중복불가) | varchar(20)
  - email 회원 이메일 (중복불가) | varchar(30)
  - password 회원 비밀번호 (8자 이상 30자 이하) varchar(30)
- 투두리스트
  - id 고유번호 | int primary key auto_increment
  - tododate 등록 일자 | date default (curdate())
  - deadline 마감 일자 | datetime
  - tododesc 투두 내용 | text
  - complete 완료 여부 | default 0 (0 미완료, 1 완료)
  - userid 등록한 회원 번호 | int
```
FOREIGN KEY (userid) REFERENCES users(id) ON DELETE CASCADE
회원 삭제 시 연관 투두리스트 삭제
```
