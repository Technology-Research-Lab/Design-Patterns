package spring.designpatterns.dom.proxy.virtual_proxy;

import lombok.Getter;

import static spring.designpatterns.dom.ThreadSleep.sleep;

@Getter
public class CandyShop {

    private String candy;

    public void makeCandy(){
        sleep(1000);
        candy = "candy";
    }
}
