package org.project.khrtodolist.controller;

import org.project.khrtodolist.dao.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class TodoController {
    // TodoDao 연결
    @Autowired
    TodoDao todoDao;

    // 투두리스트
    @GetMapping("/todolist")
    public String todolist(@RequestParam String date,
                           Model model){
        List<Map<String, Object>> todolist = todoDao.selectTodo(date);
        model.addAttribute("todolist",todolist);
        return "todolist";
    }
}
