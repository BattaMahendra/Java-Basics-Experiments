package multi_threading;

/*
* Multithreading in Java is a process of executing multiple threads simultaneously.

A thread is a lightweight sub-process, the smallest unit of processing.
* Multiprocessing and multithreading, both are used to achieve multitasking.

However, we use multithreading than multiprocessing because threads use a shared memory area.
* They don't allocate separate memory area so saves memory,
* and context-switching between the threads takes less time than process.
*
* THREAD
*
* A thread is a lightweight subprocess, the smallest unit of processing.
* It is a separate path of execution.
* Threads are group of subprocesses which work for a bigger process
* that is why they share the same address space
* and that is why it is easy to communicate between threads

Threads are independent.
* If there occurs exception in one thread, it doesn't affect other threads.
*  It uses a shared memory area.
*
* ADVANTAGES OF JAVA MULTITHREADING
*
1) It doesn't block the user because threads are independent, and you can perform multiple operations at the same time.
2) You can perform many operations together, so it saves time.
3) Threads are independent, so it doesn't affect other threads if an exception occurs in a single thread.
*
* Questions
*
* 1. Why the wait() and notify() are always used in synchronized method or block ?
* 2. Why wait() method is always inside while loop rather than if statement ?
* 3. How to stop a thread in java ?
*   - a. we can use a boolean flag and while loop .
*   - b. We can use Thread.interrupted method to stop  a thread in java
*   - c. THere is stop() method in java , which we should avoid to use as it causes problems and it is also deprecated.
* 4. Difference between wait() and sleep() in java?
* 5. Difference between yield() and wait() methods in java ?
* */