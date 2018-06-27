package tech.winson.pattern.behavior.observer;

/**
 * 具体观察者(ConcreteObserver)角色：存储与主题的状态自恰的状态。
 * 具体观察者角色实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题的状态 像协调。
 * 如果需要，具体观察者角色可以保持一个指向具体主题对象的引用。
 */
public class ConcreteObserver implements Observer {


    //观察者的状态
    private String observerState;

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String state) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = state;
        System.out.println(name+"==>状态为："+observerState);
    }

}