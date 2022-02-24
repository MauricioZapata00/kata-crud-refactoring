package RetoFinal.back.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "todo_lists")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long toDoListId;

    @Column(name = "todo_list_name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "toDoLists")
    private Set<ToDo> toDos = new HashSet<>();

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

    public Set<ToDo> getToDos() {
        return this.toDos;
    }

    public void setToDos(Set<ToDo> toDos) {
        this.toDos = toDos;
    }
}
