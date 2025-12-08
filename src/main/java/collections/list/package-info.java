package collections.list;

/**
 *
 * List
 *
 * 1. It is an interface which extends Collection interface
 *  List<E> is a subinterface of Collection that represents an ordered collection.
 *
 * Properties
 * 1. Ordered → maintains insertion order
 * 2. Allows Duplicates  (makes sense as it is a ordered collection )
 * 3. Allows null
 * 4. Allows retrieval and insertion based on index  --> Eg:   `E set(int index, E element)`
 *
 *
 * Important functions
 *
 * | Method                                                    | Purpose                 |
 * | --------------------------------------------------------- | ----------------------- |
 * | `E get(int index)`                                        | Retrieve element        |
 * | `E set(int index, E element)`                             | Replace element         |
 * | `void add(int index, E element)`                          | Insert at position      |
 * | `E remove(int index)`                                     | Remove by index         |
 * | `int indexOf(Object o)`                                   | First index of element  |
 * | `int lastIndexOf(Object o)`                               | Last index of element   |
 * | `List<E> subList(int from, int to)`                       | View of part of list    |
 * | `void sort(Comparator<? super E> c)`                      | Sort list               |
 * | `static <E> List<E> of(E... elements)`                    | Immutable list creation |
 * | `static <E> List<E> copyOf(Collection<? extends E> coll)` | Immutable copy          |
 *
 *
 * */

/**
 *
 * ArrayList - A list based on Array data structure
 *
 * Retrieval is very fast i.e arrayList.get(index) takes O(1)
 * Adding element takes amortized constant time O(1)
 * searching takes O(n)
 * Inserting or deleting takes O(n) as we need to reshuffle all the elements
 *
 * Disadvantages
 * 1. Not thread safe
 * 2. When capacity increases, all elements are reshuffled
 * 3. When an element inserted/deleted then all the elements are reshuffled.
 *
 *
 * When Should You Use It?
 * Use ArrayList when:
 * You need fast random access to elements.
 * Insertion/Deletion is mostly at the end of the list.
 * You don’t know the exact size in advance but expect it to grow.
 * You care about insertion order
 * Thread safety is not a primary concern (or you’ll wrap it with Collections.synchronizedList())
 *
 * */