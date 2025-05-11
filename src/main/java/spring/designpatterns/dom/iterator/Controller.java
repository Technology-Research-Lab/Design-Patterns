package spring.designpatterns.dom.iterator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @PostMapping("/")
    public ResponseEntity<PersonDom> index(@RequestBody PersonDom personDom) {
        return ResponseEntity.ok(personDom);
    }

}
