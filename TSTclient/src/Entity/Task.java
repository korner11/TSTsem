/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.util.Date;

/**
 *
 * @author Michal
 */
public class Task {


   
    private long id;
    private String name;
    private String description;
    private boolean done;
    private Date taskTime;
    private Date taskDate;
   

    public Task() {
    }

    public Task(long id,String name, String description, boolean done, Date taskTime, Date taskDate) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.done = done;
        this.taskTime = taskTime;
        this.taskDate = taskDate;
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
}
