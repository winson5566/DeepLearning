package tech.winson.event.annotation;

import org.springframework.context.ApplicationEvent;

/**
 * 用于注册的事件 继承Application
 */
public class UserRegisterEvent extends ApplicationEvent {
    public UserRegisterEvent(String name) { //name即source
        super(name);
    }
}