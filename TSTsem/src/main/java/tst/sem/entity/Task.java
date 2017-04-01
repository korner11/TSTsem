package tst.sem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Michal on 27.03.2017.
 */
@Entity
@Table(name = "task")
public class Task {


    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    private boolean done;

    @JsonFormat(pattern="HH:mm:ss")
    @Temporal(TemporalType.TIME)
    private Date taskTime;


    @Temporal(TemporalType.DATE)
    private Date taskDate;

    @JsonIgnore
    @ManyToOne
    private User user;

    public Task() {
    }

    public Task(String name, String description, boolean done, Date taskTime, Date taskDate, User user) {
        this.name = name;
        this.description = description;
        this.done = done;
        this.taskTime = taskTime;
        this.taskDate = taskDate;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(Date createDate) {
        this.taskTime = createDate;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
