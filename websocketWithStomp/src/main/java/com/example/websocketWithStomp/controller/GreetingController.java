package com.example.websocketWithStomp.controller;

import com.example.websocketWithStomp.dto.Greeting;
import com.example.websocketWithStomp.dto.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


    // localhost:8080/index.html로 화면 접근
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {
        return new Greeting("Hello, "+ HtmlUtils.htmlEscape(message.name())+"!");
    }


}
