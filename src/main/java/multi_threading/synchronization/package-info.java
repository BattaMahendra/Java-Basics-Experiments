package multi_threading.synchronization;

/*
* Thread synchronization basically refers to The concept of one thread execute at a time and the rest of the threads are in waiting state.
*  This process is known as thread synchronization.
* It prevents the thread interference and inconsistency problem.

Synchronization is build using locks or monitor.
*  In Java, a monitor is an object that is used as a mutually exclusive lock.
*  Only a single thread at a time has the right to own a monitor.
*  When a thread gets a lock then all other threads will get suspended which are trying to acquire the locked monitor.
* So, other threads are said to be waiting for the monitor, until the first thread exits the monitor.
* In a simple way, when a thread request a resource then that resource gets locked so that no other thread can work or do any modification until the resource gets released.
*
*
* */