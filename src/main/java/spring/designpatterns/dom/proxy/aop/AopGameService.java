package spring.designpatterns.dom.proxy.aop;

import org.springframework.stereotype.Service;

@Service
public class AopGameService {
    public void startGame(){
        System.out.println("이 자리에 오신 여러분을 진심으로 환영합니다.");
    }
}
