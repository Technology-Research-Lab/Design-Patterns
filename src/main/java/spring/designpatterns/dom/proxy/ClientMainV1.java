package spring.designpatterns.dom.proxy;

public class ClientMainV1 {
    public static void main(String[] args) {
        GameService gameService = new GameServiceProxy();
        gameService.startGame();
    }
}
