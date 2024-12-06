package org.project.khrtodolist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TodoDao {
    @Autowired
    JdbcTemplate jdbc;

    // 할 일 불러오기
    public List<Map<String,Object>> selectTodo(String date){
        String sql = "select * from todolist where tododate = ?";
        return jdbc.queryForList(sql, date);
    }
}
