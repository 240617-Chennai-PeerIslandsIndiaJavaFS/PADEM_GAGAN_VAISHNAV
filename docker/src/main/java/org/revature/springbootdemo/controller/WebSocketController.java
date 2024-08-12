//package org.revature.springbootdemo.controller;
//
//import org.revature.springbootdemo.models.Projects;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class WebSocketController {
//
//    @MessageMapping("/notify")
//    @SendTo("/topic/projects")
//    public Projects notify(Projects projects) {
//        return projects;
//    }
//}
