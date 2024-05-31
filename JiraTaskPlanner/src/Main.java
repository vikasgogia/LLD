import entities.Sprint;
import entities.User;
import entities.task.Task;
import entities.task.TaskStatus;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Vikas");
        User user2 = new User("sakiV");

        TaskManager taskManager = TaskManager.getInstance();

        Sprint sprint2u1 = taskManager.createSprint(user1, "Sprint2 for User 1", 16, 30);
        Sprint sprint1u1 = taskManager.createSprint(user1, "Sprint1 for User 1", 1, 15);

        Task task1s1 = taskManager.createTask(user1, sprint1u1, "Task 1.1");
        Task task2s2 = taskManager.createTask(user1, sprint2u1, "Task 2.1");

        taskManager.changeTaskStatus(user1, sprint2u1, task2s2, TaskStatus.IN_PROGRESS);
        taskManager.removeTask(user1, sprint1u1, task1s1);

        taskManager.printTasks(user2);
    }
}