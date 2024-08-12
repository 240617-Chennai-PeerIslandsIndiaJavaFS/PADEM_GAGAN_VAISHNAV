//package org.revature.springbootdemo.config;
//
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//public class MyHandler extends TextWebSocketHandler {
//    @Override
//    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        System.out.println("Received message: " + message.getPayload());
//        session.sendMessage(new TextMessage("Hello, this is a response"));
//    }
//}
