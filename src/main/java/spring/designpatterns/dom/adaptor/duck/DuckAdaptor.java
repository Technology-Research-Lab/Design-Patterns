package spring.designpatterns.dom.adaptor.duck;

public class DuckAdaptor implements Duck {
    Turkey turkey = null;

    public DuckAdaptor(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }

    public void wildTurkeySound(){
        if(turkey instanceof WildTurkey){
            ((WildTurkey) turkey).wildTurkeySound();
        }else System.out.println(" none ");
    }
}
