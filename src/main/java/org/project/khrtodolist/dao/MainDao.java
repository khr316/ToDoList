package org.project.khrtodolist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MainDao {
    @Autowired
    JdbcTemplate jdbc;

    // todolist 추가
    public void insertTodo(String tododesc,
                           String deadline,
                           String userid){
        String sql = "insert into todolist(tododesc, deadline, userid) ";
        sql += "values(?,?,?)";
        jdbc.update(sql, tododesc,deadline,userid);
    }
}
