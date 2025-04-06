package spring.designpatterns.dom.facade;

import lombok.Data;
import spring.designpatterns.dom.facade.entity.*;

@Data
public class HomeTheatreFacade {
    Amplifier amp;
    Tuner tuner;
    CdPlayer dvd;
    Projector projector;
    TheaterLights lights;
    Screen screen;
    PopcornPopper popper;

    public HomeTheatreFacade(Amplifier amp, Tuner tuner, CdPlayer dvd, Projector projector, TheaterLights lights, Screen screen, PopcornPopper popper) {
        this.amp = amp;
        this.tuner = tuner;
        this.dvd = dvd;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }

    public HomeTheatreFacade watchMovie(String movie){
        System.out.println("Get ready to wathch a moive");
        popper.on();
        popper.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvd);
        amp.setSurroundSound();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
        return this;
    }

    public void endMovie(){
        System.out.println("Shutting movie theatre down...");
        popper.off();
        lights.off();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();
    }
}
