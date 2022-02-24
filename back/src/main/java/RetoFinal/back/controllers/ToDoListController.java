package RetoFinal.back.controllers;

import RetoFinal.back.models.ToDoList;
import RetoFinal.back.services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/apiToDoList")
public class ToDoListController {

    @Autowired
    ToDoListService toDoListService;

    @GetMapping(path = "/all/ToDoList")
    public ArrayList<ToDoList> showAllToDoLists(){
        return this.toDoListService.findAllToDoLists();
    }

    @PostMapping(path = "/save/ToDoList")
    public ToDoList insertToDoList(@RequestBody ToDoList toDoList){
        return this.toDoListService.saveToDoList(toDoList);
    }

    @DeleteMapping(path = "/delete/ToDoList/{id}")
    public void eraseToDoList(@PathVariable("id") Long id){
        this.toDoListService.deleteToDoList(id);
    }
}
