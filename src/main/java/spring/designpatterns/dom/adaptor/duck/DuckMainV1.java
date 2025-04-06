package spring.designpatterns.dom.adaptor.duck;

public class DuckMainV1 {
    public static void main(String[] args) {
        Duck duck = new MaxillaryDuck();
        testDuck(duck);

        /**
         * 오리가 부족해 칠면조를 덕으로 위장시켜야한느 경우 발생!!
         */
        Turkey turkey = new WildTurkey();
        DuckAdaptor AdaptedTurkey = new DuckAdaptor(turkey);
        testDuck(AdaptedTurkey);
        //강제로 집어넣음.. 다운캐스팅 위험..
        AdaptedTurkey.wildTurkeySound();
    }

    /**
     * 핵심은 testDuck()이 칠면조와 오리를 전혀 구분하지 못한다는 점이다!
     */
    public static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
