package spring.designpatterns.dom.proxy.virtual_proxy;

public class CandyShopMainV1 {
    public static void main(String[] args) {
        CandyShop candyShop = new VirtualProxyCandyShop();
        candyShop.makeCandy();
//
//        CandyShop candyShop = new VirtualProxyCandyShop(new CandyShop());
//        candyShop.makeCandy();

    }
}
