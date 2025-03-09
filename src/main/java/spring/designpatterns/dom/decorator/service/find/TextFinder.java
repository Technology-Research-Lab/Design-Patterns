package spring.designpatterns.dom.decorator.service.find;

import org.springframework.stereotype.Service;
import spring.designpatterns.dom.decorator.util.output.FileOutput;

import java.util.ArrayList;
import java.util.List;

@Service
public class TextFinder implements Finder {

    private FileFinder fileFinder;
    private FileOutput fileOutput;
    private List<String> outcome;

    public TextFinder(FileOutput fileOutput, FileFinder fileFinder) {
        this.fileFinder = fileFinder;
        this.fileOutput = fileOutput;
        outcome = new ArrayList<>();
    }

    @Override
    public void find(Object userId) {
        fileFinder.find(userId);
        List<String> files = (List<String>)fileFinder.getOutcome();

        for (String fileName : files) {
            outcome.add(fileOutput.readFile(fileName));
        }
    }

    @Override
    public Object getOutcome() {
        return outcome;
    }

}
