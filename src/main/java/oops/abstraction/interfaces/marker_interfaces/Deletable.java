package oops.abstraction.interfaces.marker_interfaces;


// custom marker interface
public interface Deletable {
    // It is empty!
}

 class User implements Deletable {
    // Class details
}

 class Admin {
    // Admin does NOT implement Deletable
}

 class DatabaseService {
    public void deleteEntity(Object entity) {

        // marker interface is very useful in these cases.
        if (entity instanceof Deletable) {
            System.out.println("Permission granted. Deleting entity...");
            // deletion logic here
        } else {
            System.out.println("Error: This entity cannot be deleted!");
        }
    }
}
