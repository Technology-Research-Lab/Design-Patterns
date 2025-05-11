package spring.designpatterns.dom.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInJava {

    public static void main(String[] args) {
        ProxyInJava proxyInJava = new ProxyInJava();
        proxyInJava.dynamicProxy();

    }

    private void dynamicProxy() {
        GameService gameServiceProxy = getGameServiceProxy(new BaseGameService());
        gameServiceProxy.startGame();
    }

    private GameService getGameServiceProxy(GameService target) {
        return (GameService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
        new Class[]{GameService.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long start = System.currentTimeMillis();
                        System.out.println("Hello dynamic proxy");
                        method.invoke(target, args);
                        System.out.println("걸린시간: " + (System.currentTimeMillis() - start));
                        System.out.println(target);
                        return null;
                    }
                });

    }
}
