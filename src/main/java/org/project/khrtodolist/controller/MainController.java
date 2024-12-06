package org.project.khrtodolist.controller;

import jakarta.servlet.http.HttpSession;
import org.project.khrtodolist.dao.MainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    // mainDao 연결
    @Autowired
    MainDao mainDao;

    // 메인 페이지
    @GetMapping("/")
    public String main(HttpSession session, Model model){
        if(session.getAttribute("userid") == null){
            return "main";
        }
        String userid = session.getAttribute("userid").toString();
        session.setAttribute("userid",userid);
        System.out.println(userid+"  메인=======================================================");
        model.addAttribute("userid",userid);
        return "main";
    }

    // todolist 추가
    @PostMapping("/todo/add")
    public String todoAdd(@RequestParam String tododesc,
                          @RequestParam String deadline,
                          @RequestParam String userid,
                          HttpSession session){
        // DB 저장
        mainDao.insertTodo(tododesc,deadline,userid);
        return "redirect:/";
    }
}
