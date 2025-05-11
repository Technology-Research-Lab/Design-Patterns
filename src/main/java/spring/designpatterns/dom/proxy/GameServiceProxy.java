package spring.designpatterns.dom.proxy;

public class GameServiceProxy implements GameService {

    private GameService gameService;

    public GameServiceProxy() {
    }

    public GameServiceProxy(BaseGameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void startGame() {
        long start = System.currentTimeMillis();
        if (this.gameService == null) {
            this.gameService = new BaseGameService();
        }
        gameService.startGame();
        System.out.println("걸린시간: " + (System.currentTimeMillis() - start));
    }
}
