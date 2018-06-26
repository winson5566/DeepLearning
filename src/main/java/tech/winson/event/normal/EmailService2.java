package tech.winson.event.normal;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service("emailService2") //事件订阅者的服务同样需要托管于Spring容器
public class EmailService2 implements ApplicationListener<UserRegisterEvent2> {
    @Override
    public void onApplicationEvent(UserRegisterEvent2 userRegisterEvent) {
        System.out.println("邮件服务接到通知，给 " + userRegisterEvent.getSource() + " 发送邮件...");
    }
}