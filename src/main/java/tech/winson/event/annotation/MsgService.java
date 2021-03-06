package tech.winson.event.annotation;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * 监听器，使用@EventListener注解，参数为ApplicationEvent的子类
 */
@Service
public class MsgService {
    @EventListener
    public void listenUserRegisterEvent(UserRegisterEvent userRegisterEvent) {
        System.out.println("消息服务接到通知，给 " + userRegisterEvent.getSource() + " 发送消息...");
    }
}
