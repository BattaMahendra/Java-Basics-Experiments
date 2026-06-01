package java8.Java_Streams;

/*
WHAT ARE STREAMS ?

* Simply put, streams are wrappers around a data source, allowing us to operate with that data source and making bulk processing convenient and fast.
* A stream does not store data and, in that sense, is not a data structure.
* It also never modifies the underlying data source unless we explicitly code.
* Streams are single-use only. Once a terminal operation is performed, the stream is closed and cannot be reused.
  Attempting to reuse it will throw an IllegalStateException.
* Streams support internal iteration, meaning the iteration logic is handled by the library,
  unlike external iteration (e.g., for-loops) where the developer controls the iteration.
* Streams can be sequential or parallel. Parallel streams leverage multi-core architectures for faster processing of large datasets.

WHY STREAMS ?
     1. Improved Readability: More readable and maintainable code using declarative approach instead of imperative loops.
     
     2. Functional Approach: Streams support functional programming paradigms by allowing operations like map, filter, reduce, etc.,
        which encourage immutability and statelessness, making your code less error-prone and easier to reason about.
     
     3. Lazy Evaluation: Streams perform operations on elements of a collection only when necessary. This laziness can lead to 
        better performance by avoiding unnecessary computations. Operations are only executed when a terminal operation is invoked.
     
     4. Chainability (Fluent API): Stream operations can be chained together, allowing you to compose complex data transformations
        in a single readable expression without intermediate collections.
     
     5. Parallelization Support: Streams can leverage multi-core processors through parallel() without explicit thread management,
        making concurrent operations safer and easier to implement.
     
     6. Null Safety: Streams handle empty collections gracefully, reducing NullPointerException risks compared to traditional loops.
     
     7. Performance Optimization: The framework can optimize operations internally (e.g., short-circuit evaluation with findFirst(),
        filtering before mapping) without developer intervention.

 */