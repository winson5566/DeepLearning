package tech.winson.event.normal;

import org.springframework.context.ApplicationEvent;

/**
 * 定义用户注册事件
 */
public class UserRegisterEvent2 extends ApplicationEvent {
    public UserRegisterEvent2(String name) { //name即source
        super(name);
    }
}
