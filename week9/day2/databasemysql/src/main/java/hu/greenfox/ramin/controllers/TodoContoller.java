package hu.greenfox.ramin.controllers;


import hu.greenfox.ramin.models.Todo;
import hu.greenfox.ramin.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todo")
public class TodoContoller {

  @Autowired
  TodoRepository repository;

  @RequestMapping(value = {"/list", "/"}, method = RequestMethod.GET)
  public String list(Model model) {
    model.addAttribute("eachTodo", repository.findAll());
    return "todo";
  }

  @RequestMapping(value = "/done")
  public String done() {

    return "add";
  }

  @RequestMapping(value = "/add")
  public String addHtml(Model model) {
    model.addAttribute("todo", new Todo());
    return "add";
  }

  @PostMapping(value = "/submit")
  public String submit(Todo todo) {
    System.out.println(todo);
    repository.save(todo);
    return "redirect:/todo/";
  }

}
