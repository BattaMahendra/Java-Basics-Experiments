package exceptions.code;
import java.util.ArrayList;
import java.util.List;

public class ErrorExample {

    public static void main(String[] args) {
        main(new String[6]);    // implementing stack overflow error
    }
}


class HeapOOM {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();

        while (true) {
            list.add(new byte[1024 * 1024]); // 1 MB each time  - outOfMemory Error - Heap is full
        }
    }
}
