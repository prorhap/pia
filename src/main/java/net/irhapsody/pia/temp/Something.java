package net.irhapsody.pia.temp;

/**
 * Created by IntelliJ IDEA.
 * User: rhapsody
 * Date: 3/5/12
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Something {
    private Strategy strategy;

    public Something(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doSomething(){
        strategy.doSomethingConcrete();
    }

    public boolean validate(){
        return strategy.doValidate();
    }
}
