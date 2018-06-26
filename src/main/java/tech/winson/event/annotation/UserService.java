package tech.winson.event.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * 事件源，使用ApplicationEventPublisher。publishEvent发布事件
 */
@Service
public class UserService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void register(String name) {
        System.out.println("用户：" + name + " 已注册！");
        applicationEventPublisher.publishEvent(new UserRegisterEvent(name));
    }
}