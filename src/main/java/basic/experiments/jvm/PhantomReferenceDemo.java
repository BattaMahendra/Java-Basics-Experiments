package basic.experiments.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

class FileResource {
    private String filePath;

    // Constructor that initializes the FileResource with a file path
    public FileResource(String filePath) {
        this.filePath = filePath;
        System.out.println("File created at: " + filePath);
    }

    // Method to simulate deleting the file
    public void deleteFile() {
        System.out.println("Deleting file at: " + filePath);
    }
}

public class PhantomReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        // Create a ReferenceQueue that will hold the phantom references
        // after the garbage collector determines the object is eligible for finalization
        ReferenceQueue<FileResource> queue = new ReferenceQueue<>();

        // Create an instance of FileResource which represents a file
        FileResource fileResource = new FileResource("C:\\Users\\batta.chowdary\\IdeaProjects\\Java-Basics-Experiments\\src\\main\\resources\\files\\File3.txt");

        // Create a PhantomReference for the FileResource object and associate it with the ReferenceQueue
        // This PhantomReference doesn't prevent the object from being garbage collected
        PhantomReference<FileResource> phantomRef = new PhantomReference<>(fileResource, queue);

        // Dereference the FileResource object, making it eligible for garbage collection
        fileResource = null;

        // Suggest the JVM to run the garbage collector
        System.gc();

        // Wait until the PhantomReference is enqueued into the ReferenceQueue
        // This happens after the garbage collector determines the object is eligible for finalization
        PhantomReference<?> ref = (PhantomReference<?>) queue.remove();

        // When the phantom reference is enqueued, it means the associated FileResource object is finalized
        if (ref != null) {
            System.out.println("Phantom reference enqueued. Cleaning up...");
            
            // Perform the cleanup task, such as deleting the file
            // Note: ref.get() will always return null because PhantomReferences do not allow access to the object
        }
    }
}

/*
* Phantom references are useful for managing non-Java resources like files, native memory, or database connections, allowing you to clean them up after the object is finalized but before it is actually removed from memory.
*Unlike other references, you cannot access the object through a phantom reference; it's only a signal that the object is ready to be cleaned up.
* */
