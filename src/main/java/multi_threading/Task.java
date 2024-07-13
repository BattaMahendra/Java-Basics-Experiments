package multi_threading;

@FunctionalInterface
public interface Task {
    void execute(String threadName);
}