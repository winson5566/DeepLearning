package tech.winson.pattern.behavior.observer;

/**
 * 抽象观察者(Observer)角色：为所有的具体观察者定义一个接口，在得到主题的通知时更新自己，这个接口叫做更新接口。
 */
public interface  Observer {
    /**
     * 更新接口
     * @param state    更新的状态
     */
    public void update(String state);
}