import entities.Sprint;
import entities.User;
import entities.task.Task;
import entities.task.TaskStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskManager {

    private static TaskManager instance;
    private HashMap<Integer, List<Sprint>> userToSprint;
    private HashMap<Integer, List<Task>> sprintToTask;

    // singleton design pattern
    public static synchronized TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    private TaskManager() {
        this.userToSprint = new HashMap<>();
        this.sprintToTask = new HashMap<>();
    }

    // T.C. = O(1)
    public Sprint createSprint(User user, String name, int begin, int end) {
        int userId = user.getId();
        Sprint sprint = new Sprint(name, begin, end);
        List<Sprint> userSprints;

        if(userToSprint.containsKey(userId)) userSprints = userToSprint.get(userId);
        else userSprints = new ArrayList<>();

        userSprints.add(sprint);
        userToSprint.put(userId, userSprints);
        return sprint;
    }

    // T.C. = O(t)
    public void changeTaskStatus(User user, Sprint sprint, Task task, TaskStatus status) {
        int userId = user.getId(), sprintId = sprint.getId();

        if(userToSprint.containsKey(userId) && sprintToTask.containsKey(sprintId)) {
            List<Task> sprintTasks = sprintToTask.get(sprintId);
            for (Task sprintTask : sprintTasks) {
                if (sprintTask.equals(task)) sprintTask.setStatus(status);
            }
        }
    }

    // T.C. = O(1)
    public Task createTask(User user, Sprint sprint, String name) {
        int userId = user.getId(), sprintId = sprint.getId();
        List<Task> tasks;

        if(userToSprint.containsKey(userId) && sprintToTask.containsKey(sprintId)) tasks = sprintToTask.get(sprintId);
        else tasks = new ArrayList<>();

        Task task = new Task(name);
        tasks.add(task);
        sprintToTask.put(sprintId, tasks);
        return task;
    }

    // T.C. = O(t)
    public void removeTask(User user, Sprint sprint, Task task) {
        int userId = user.getId(), sprintId = sprint.getId();
        List<Task> tasks;

        if(userToSprint.containsKey(userId)) tasks = sprintToTask.get(sprintId);
        else return;

        tasks.remove(task);
        sprintToTask.put(sprintId, tasks);
    }

    // T.C. = O(s * t)
    public void printTasks(User user) {
        int userId = user.getId();
        if(!userToSprint.containsKey(userId)) return;

        List<Sprint> sprints = userToSprint.get(userId);
        for(Sprint sprint : sprints) {
            for(Task task: sprintToTask.get(sprint.getId())) {
                System.out.println(task.toString());
            }
        }
    }
}
