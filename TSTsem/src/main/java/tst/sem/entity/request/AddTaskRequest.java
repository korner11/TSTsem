package tst.sem.entity.request;

/**
 * Created by Michal on 27.03.2017.
 */
public class AddTaskRequest {

    private String name;

    private String description;

    private String taskDate;

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

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }
}
