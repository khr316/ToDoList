package org.project.khrtodolist.controller;

import jakarta.servlet.http.HttpSession;
import org.project.khrtodolist.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {
    // UsersDao 연결
    @Autowired
    UsersDao usersDao;

    // 회원가입 페이지 매핑
    @GetMapping("/signup")
    public String signup(){
        // return 회원가입 페이지 html
        return "signup";
    }
    // 회원가입 DB 저장
    @PostMapping("/signup")
    // form에서 보낸 값 받기
    public String signupAction(@RequestParam String email,
                               @RequestParam String name,
                               @RequestParam String nickname,
                               @RequestParam String password){
        // DB에 정보 저장
        usersDao.insertUser(email,name,nickname,password);

        // return 로그인 페이지 html
        return "redirect:/login";
    }

    // 로그인 페이지 매핑
    @GetMapping("/login")
    public String login(){
        // 로그인 페이지로 이동
        return "login";
    }
    // 로그인 DB 비교
    @PostMapping("/login")
    public String loginAction(@RequestParam String email,
                              @RequestParam String password,
                              HttpSession session, // session
                              Model model){ // html로 값 보낼 수 있음
        // 이메일과 비밀번호가 일치하는 회원이 있는 경우 로그인 성공
        if(usersDao.selectUser(email, password) > 0) {
            // 로그인 한 회원의 회원 번호를 session에 저장
            String userid = usersDao.selectId(email,password);
            session.setAttribute("userid",userid);
            System.out.println(userid+"  로그인=======================================================");
            // 메인 페이지로 이동
            return "redirect:/";
        }
        // 일치하는 회원이 없는 경우 로그인 실패
        // 로그인 페이지 머무르기
        return "login";
    }

    // 로그아웃 = session 종료
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
