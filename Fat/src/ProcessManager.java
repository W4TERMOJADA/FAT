import java.util.*;
public class ProcessManager {
    private Map<String, Thread> processes = new LinkedHashMap<>();
    public void launch(String name, Runnable task) {
        Thread t = new Thread(task, name);
        processes.put(name, t);
        t.start();
    }
    public void kill(String name) {
        Thread t = processes.remove(name);
        if(t != null) t.interrupt();
    }
    public void list() {
        System.out.println("Processes:");
        processes.keySet().forEach(n -> System.out.println(" - " + n));
    }
}


