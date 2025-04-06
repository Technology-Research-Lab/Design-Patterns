package spring.designpatterns.dom.facade;

import spring.designpatterns.dom.facade.entity.*;

public class TheatreMainV1 {
    public static void main(String[] args) {
        HomeTheatreFacade homeTheatre = getHomeTheatreFacade();

        homeTheatre.watchMovie("Notting Hill");
        homeTheatre.endMovie();
    }

    private static HomeTheatreFacade getHomeTheatreFacade() {
        // 구성 요소 생성
        Amplifier amp = new Amplifier("Top Amplifier");
        StreamingPlayer streamingPlayer = new StreamingPlayer("Streaming Player", amp);
        Tuner tuner = new Tuner("FM/AM Tuner", amp);
        CdPlayer dvd = new CdPlayer("Blu-ray DVD Player", amp);
        Projector projector = new Projector("HD Projector", streamingPlayer);
        TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
        Screen screen = new Screen("Big Screen");
        PopcornPopper popper = new PopcornPopper("Popcorn Popper");

        // 퍼사드 생성
        return new HomeTheatreFacade(
                amp, tuner, dvd, projector, lights, screen, popper
        );
    }

}
