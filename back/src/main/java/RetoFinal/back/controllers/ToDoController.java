package RetoFinal.back.controllers;

import RetoFinal.back.models.ToDo;
import RetoFinal.back.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/apiToDo")
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @GetMapping(path = "/all")
    public ArrayList<ToDo> showAllToDos(){
        return this.toDoService.findAllToDos();
    }

    @PostMapping(path = "/save/ToDo")
    public ToDo insertToDo(@RequestBody ToDo toDo){
        return this.toDoService.saveToDo(toDo);
    }

    @DeleteMapping(path = "/delete/ToDo/{id}")
    public void eraseToDo(@PathVariable("id") Long id){
        this.toDoService.deleteToDo(id);
    }

}
