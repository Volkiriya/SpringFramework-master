package controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class NewsControllers {

    @PostMapping("/news/{id}/delete")
    public String delete(@PathVariable int id) {
        return "redirect:/news/" + id;
    }
}
