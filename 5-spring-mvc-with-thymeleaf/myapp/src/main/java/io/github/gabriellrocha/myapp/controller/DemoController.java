package io.github.gabriellrocha.myapp.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class DemoController {

    /* Model - Objeto do Spring MVC usado para transportar dados do controller p/ a view
    *   1. Spring injeta o Model
    *   2. adicionamos atributos .addAtribute()
    *   3. Os dados ficam disponíveis no template (Thymeleaf, JSP, etc)
    * Não é persistido nem compartilhado entre requests..
    * */

    @GetMapping("/hello")
    public String sayHello(Model model, HttpServletResponse response) {

        // E.g config cookies
        Cookie cookie = new Cookie("myCookie", "123");
        cookie.setPath("/");
        response.addCookie(cookie);

        model.addAttribute("theDate", LocalDateTime.now());
        return "hello.html";
    }
}
