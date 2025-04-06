package spring.designpatterns.dom.adaptor.duck;

public class WildTurkey implements Turkey{

    @Override
    public void gobble() {
        System.out.println("gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }

    public void wildTurkeySound(){
        System.out.println("wild turkey sound");
    }
}
