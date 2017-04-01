package tst.sem.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import tst.sem.Exceptions.UserNotFoundException;
import tst.sem.entity.Task;
import tst.sem.entity.User;
import tst.sem.repository.TaskRepository;
import tst.sem.repository.UserRepository;


import java.util.List;

/**
 * Created by Michal on 27.03.2017.
 */

@RestController
@RequestMapping("/{username}/tasks")
public class TaskUserController {

    private TaskRepository taskRepository;
    private UserRepository userRepository;

    @Autowired
    public TaskUserController(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository=userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Task> findAllTasksByUser(@PathVariable String username) {
        try {
            this.validateUser(username);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return this.taskRepository.findByUserName(username);
    }

    @RequestMapping(method = RequestMethod.POST)
    List<Task> add(@PathVariable String username, @RequestBody Task input) {
        try {
            this.validateUser(username);

            User user= userRepository.findByName(username);

            Task result = taskRepository.save(new Task(input.getName(),input.getDescription(), false ,input.getTaskTime(),input.getTaskDate(),user));

            return taskRepository.findByUserName(username);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
    @RequestMapping(method = RequestMethod.GET, value = "/{taskId}")
    Task readTask(@PathVariable String username, @PathVariable Long taskId) {
        try {
            this.validateUser(username);
            return this.taskRepository.findOne(taskId);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{taskId}")
    List<Task> deleteTask(@PathVariable String username, @PathVariable Long taskId) {
        try {
            this.validateUser(username);
            Task t = taskRepository.findOne(taskId);
            taskRepository.delete(t);
            return taskRepository.findByUserName(username);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
    @RequestMapping(method = RequestMethod.PATCH, value = "/{taskId}")
    Task updateTask(@PathVariable String username, @PathVariable Long taskId, @RequestBody Task input) {
        try {
            this.validateUser(username);
            Task task = taskRepository.findOne(taskId);

            if(input.getName() != null){
                task.setName(input.getName());
            }
            if(input.getDescription() != null){
                task.setDescription(input.getDescription());
            }
            if(input.isDone() == true){
                task.setDone(true);
            }
            if(input.getTaskDate() != null){
                task.setTaskDate(input.getTaskDate());
            }
            if(input.getTaskTime() != null){
                task.setTaskTime(input.getTaskTime());
            }
            taskRepository.save(task);

            return taskRepository.findOne(taskId);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void validateUser(String username) throws UserNotFoundException {

        if(this.userRepository.findByName(username)==null){
            throw new UserNotFoundException(username);
        }
    }
}
