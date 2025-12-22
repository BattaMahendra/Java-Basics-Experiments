package basic.experiments.jvm.custom_class_loaders;

import java.nio.file.Files;
import java.nio.file.Path;

public class MyCustomClassLoader extends ClassLoader {

    private final String classDir;

    public MyCustomClassLoader(String classDir) {
        this.classDir = classDir;
    }

    /**
     * ⚠️ Learn about usage of findClass() vs loadClass() methods in custom class loaders
     * 🚨 Why we have overrided findClass() method below rather than loadClass()
     * */
    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            // Convert class name to file path
            String fileName = className + ".class";
            Path classPath = Path.of(classDir, fileName);

            // Read raw bytecode
            byte[] classBytes = Files.readAllBytes(classPath);

            // Convert bytecode → Class object
            return defineClass(className, classBytes, 0, classBytes.length);

        } catch (Exception e) {
            throw new ClassNotFoundException("Could not load class " + className, e);
        }
    }
}
