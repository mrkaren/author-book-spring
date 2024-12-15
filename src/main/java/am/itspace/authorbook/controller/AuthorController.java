package am.itspace.authorbook.controller;

import am.itspace.authorbook.entity.Author;
import am.itspace.authorbook.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

//    private final List<AuthorService> authorServices;

//    private final Map<String, AuthorService> authorServiceMap;

    @GetMapping
    public String authorPage(ModelMap modelMap) {
        List<Author> all = authorService.findAll();
        modelMap.put("authors", all);
        return "author/authors";
    }

    @GetMapping("/add")
    public String addAuthorPage() {
        return "author/addAuthor";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/delete")
    public String deleteAuthor(@RequestParam("id") int id) {
        authorService.deleteById(id);
        return "redirect:/authors";
    }

    @GetMapping("/edit")
    public String editAuthorPage(@RequestParam("id") int id, ModelMap modelMap) {
        Author author = authorService.findById(id);
        if (author != null) {
            modelMap.put("author", author);
            return "author/editAuthor";
        }
        return "redirect:/authors";
    }

    @PostMapping("/edit")
    public String editAuthor(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/authors";
    }

}
