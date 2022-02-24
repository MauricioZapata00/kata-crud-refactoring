package RetoFinal.back.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "todo_lists")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long toDoListId;

    @Column(name = "todo_list_name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "toDoLists")
    private ArrayList<ToDo> toDos = new ArrayList<>();

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

    public ArrayList<ToDo> getToDos() {
        return this.toDos;
    }

    public void setToDos(ArrayList<ToDo> toDos) {
        this.toDos = toDos;
    }
}
