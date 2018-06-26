package tech.winson.event.normal;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class UserService2 implements ApplicationEventPublisherAware {
    public void register(String name) {
        System.out.println("用户：" + name + " 已注册！");
        applicationEventPublisher.publishEvent(new UserRegisterEvent2(name));
    }

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) { // <2>
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
