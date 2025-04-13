package spring.designpatterns.dom.template.beverage;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Log4j2
public class CoffeeWithHook extends CaffeineBeverageWithHook {

    @Override
    public boolean customerWantsCondiments() {
        System.out.println("커피에 우유와 설탕을 넣어 드릴까요? (y/n) ");
        String answer = getUserInput();
        return answer.toLowerCase().startsWith("y");
    }

    private String getUserInput(){
        String answer;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (answer == null)
            return "no";
        return answer;
    }

    @Override
    void addCondiments(){
        System.out.println("설탕과 우유 추가하기");
    }

    @Override
    void brew() {
        System.out.println("필터에 커피 거르기");
    }
}
