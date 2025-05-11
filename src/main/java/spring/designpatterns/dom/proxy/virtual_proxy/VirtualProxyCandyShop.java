package spring.designpatterns.dom.proxy.virtual_proxy;

import lombok.Getter;

import static spring.designpatterns.dom.ThreadSleep.sleep;

@Getter
public class VirtualProxyCandyShop extends CandyShop {

    CandyShop candyShop;
    boolean flag = false;

    public VirtualProxyCandyShop() {
    }

    public VirtualProxyCandyShop(CandyShop candyShop) {
        this.candyShop = candyShop;
    }

    public void makeCandy() {
        if (candyShop != null) {
            candyShop.makeCandy();
            System.out.println("candy = " + candyShop.getCandy());
        } else {
            if (!flag) {
                flag = true;
                Thread waitingCandy = new Thread(() -> {
                    this.showAD();
                    CandyShop newCandyShop = new CandyShop();
                    newCandyShop.makeCandy();
                    System.out.println("candy = " + newCandyShop.getCandy());
                });
                waitingCandy.start();
            }
        }
    }

    private void showAD(){
        System.out.println("사탕 광고 중");
    }
}
