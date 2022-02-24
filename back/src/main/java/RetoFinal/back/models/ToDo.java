package RetoFinal.back.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "todos")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long toDoId;

    @Column(name = "todo_name")
    private String name;

    @Column(name = "todo_complete")
    private boolean complete;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "todo_lists",
            joinColumns = {@JoinColumn(name = "todo_id")},
            inverseJoinColumns = {@JoinColumn(name = "todos_list_id")}
    )
    private ArrayList<ToDoList> toDoLists = new ArrayList<>();

    public ToDo() {
    }

    public ToDo(String name, boolean complete) {
        this.name = name;
        this.complete = complete;
    }

    public long getToDoId() {
        return this.toDoId;
    }

    public void setToDoId(long toDoId) {
        this.toDoId = toDoId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public ArrayList<ToDoList> getToDoLists() {
        return this.toDoLists;
    }

    public void setToDoLists(ArrayList<ToDoList> toDoLists) {
        this.toDoLists = toDoLists;
    }
}
