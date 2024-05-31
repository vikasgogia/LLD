package entities.task;

public class Task {
    protected static int idCounter = 0;
    protected int id;
    protected String name;
    protected TaskStatus status;

    public Task() {}

    public Task(String name) {
        this.name = name;
        this.id = ++idCounter;
        this.status = TaskStatus.OPEN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
