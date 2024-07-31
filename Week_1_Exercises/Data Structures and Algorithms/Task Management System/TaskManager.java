class TaskNode {
    Task task;
    TaskNode next;

    TaskNode(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManager {
    private TaskNode head;

    public TaskManager() {
        this.head = null;
    }

    // Add a task
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by taskId
    public Task searchTask(String taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by taskId
    public void deleteTask(String taskId) {
        if (head == null) {
            return;
        }

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }

        TaskNode current = head;
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public static void main(String[] args) {
        // Example usage
        TaskManager manager = new TaskManager();

        // Adding tasks
        manager.addTask(new Task("T1", "Task 1", "Pending"));
        manager.addTask(new Task("T2", "Task 2", "In Progress"));
        manager.addTask(new Task("T3", "Task 3", "Completed"));

        // Traversing tasks
        System.out.println("All Tasks:");
        manager.traverseTasks();

        // Searching for a task
        System.out.println("\nSearching for task T2:");
        Task task = manager.searchTask("T2");
        System.out.println(task);

        // Deleting a task
        System.out.println("\nDeleting task T1:");
        manager.deleteTask("T1");

        // Traversing tasks again
        System.out.println("\nAll Tasks after deletion:");
        manager.traverseTasks();
    }
}