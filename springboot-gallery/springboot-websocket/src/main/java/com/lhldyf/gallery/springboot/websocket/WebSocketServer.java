package com.lhldyf.gallery.springboot.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author lhldyf
 * @date 2020-04-08 18:48
 */
@ServerEndpoint("/websocket")
@Component
@Slf4j
public class WebSocketServer {
    /**
     * 存放所有在线的客户端
     */
    private static Map<String, Session> clients = new ConcurrentHashMap<>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        log.info("建立连接，id:{}", session.getId());
        clients.put(session.getId(), session);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        log.info("连接关闭, id:{}", session.getId());
        clients.remove(session.getId());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("{}收到客户端消息:{}", session.getId(), message);
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("{} 异常", session.getId(), error);
    }

    private void sendAll(String message) {
        log.info("给所有连接推送消息:{}", message);
        for (Map.Entry<String, Session> sessionEntry : clients.entrySet()) {
            sessionEntry.getValue().getAsyncRemote().sendText(message);
        }
    }

    @PostConstruct
    public void init() {
        new Thread(() -> {
            while (true) {
                this.sendAll("current time:" + System.currentTimeMillis());
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
