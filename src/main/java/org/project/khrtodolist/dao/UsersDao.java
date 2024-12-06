package org.project.khrtodolist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDao {
    @Autowired
    JdbcTemplate jdbc;

    // 회원가입 정보 저장
    public void insertUser(String email,
                           String name,
                           String nickname,
                           String password){
        String sql = "insert into users(email,name,nickname,password) ";
        sql += "values(?,?,?,?)";
        jdbc.update(sql, email,name,nickname,password);
    }

    // 회원 정보 비교
    public int selectUser(String email, String password){
        String sql = "select count(*) from users where email = ? and password = ?";
        return jdbc.queryForObject(sql, int.class ,email, password);
    }

    // 로그인 한 회원의 회원 번호
    public String selectId(String email, String password){
        String sql = "select id from users where email = ? and password = ?";
        return jdbc.queryForObject(sql, String.class, email, password);
    }
}
