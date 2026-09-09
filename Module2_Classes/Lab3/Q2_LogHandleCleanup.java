// Program demonstrating object lifecycle and cleanup-on-garbage-collection
public class Q2_LogHandleCleanup {
    public static void main(String[] args) {

        // Create a few LogHandle objects inside a loop
        for (int i = 1; i <= 3; i++) {
            LogHandle handle = new LogHandle("Session-" + i);
            handle = null; // drop the only reference so it becomes eligible for GC
        }

        // Request garbage collection — this is only a REQUEST, not a guarantee
        System.gc();

        // Note: the "cleanup" messages from finalize() may print at any time,
        // in any order, or not at all before the program ends, because the
        // JVM decides when (and whether) to actually run the garbage collector
        // and invoke finalize(). This unpredictability is exactly why finalize()
        // is deprecated since Java 9 — modern code should instead implement
        // AutoCloseable and use try-with-resources for deterministic cleanup.
        System.out.println("main() finished — cleanup timing is not guaranteed.");
    }
}

class LogHandle {
    String sessionName;

    public LogHandle(String sessionName) {
        this.sessionName = sessionName;
        System.out.println("Session started: " + sessionName);
    }

    // Overriding finalize() to print a message when the object is collected.
    // (Deprecated since Java 9 — shown here for the exercise; prefer close()
    // with AutoCloseable in real modern code.)
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Cleaning up handle: " + sessionName);
        super.finalize();
    }

    // Modern equivalent that gives deterministic, on-demand cleanup instead
    // of relying on the unpredictable garbage collector:
    void close() {
        System.out.println("Closed handle (deterministic): " + sessionName);
    }
}
