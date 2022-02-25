package RetoFinal.back.models;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
//https://stackoverflow.com/questions/55901477/how-to-pass-hashset-to-server-to-test-api-from-postman

@Entity
@Table(name = "todo_lists")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long toDoListId;

    @Column(name = "todo_list_name")
    private String name;

    @ElementCollection
    @Column(name = "todos")
    private Map<String, String> toDos = new HashMap<String, String>();

    public ToDoList() {
    }

    public ToDoList(String name) {
        this.name = name;
    }

    public long getToDoListId() {
        return this.toDoListId;
    }

    public void setToDoListId(long toDoListId) {
        this.toDoListId = toDoListId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getToDos() {
        return this.toDos;
    }

    public void setToDos(HashMap<String, String> toDos) {
        this.toDos = toDos;
    }

    public void insertToDo(String name, String completed){
        this.toDos.put(name, completed);
    }

    public void eraseToDo(String name){
        this.toDos.remove(name);
    }
}
