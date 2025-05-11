package spring.designpatterns.dom.proxy.aop;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * <p>스프링의 AOP는 프록시 패턴을 기반으로 동작한다.
 *    동적 proxy.reflext를 이용하여, 런타임 도중 실행 메서드의 앞 뒤로 로직을 추가할 수 있다.
 *    스프링에서는 에노테이션으로 이를 핸들링할 수 있다. @Aspect, @Around 등이 있다.
 *    Interface를 기준으로 동적으로 reflect 프록시를 만들지만, Interface가 아닌
 *    클래스일 경우는 CGLIB 라이브러리를 이용하여, 해당 클래스를 구현한 자식 클래스를 생성하여
 *    사용한다.</p>
 */

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //App.class를 기반으로 스프링 애플리케이션 인스턴스를 생성합니다.\
        //SpringApplication.run(...)을 호출하는 대신 커스터마이징을 하기 위해 인스턴스를 변수로 만듭니다.
        SpringApplication app = new SpringApplication(App.class);
        //WebApplicationType.SERVLET: 기본값 (Tomcat 실행)
        //WebApplicationType.REACTIVE: WebFlux
        //WebApplicationType.NONE: 웹 서버 없이 실행 (콘솔 앱 등)
        app.setWebApplicationType(WebApplicationType.NONE);
        //스프링 애플리케이션을 실행시킵니다.
        //모든 빈 등록, @ComponentScan, @Bean, @Configuration, @PostConstruct 등을 수행합니다.
        app.run(args);
    }

    @Bean
    public ApplicationRunner applicationRunner(AopGameService gameService) {
        return args -> gameService.startGame();
    }
}
