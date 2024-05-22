package oops.polymorphism.pictures;

/*

1. Please read about access specifiers and method overriding

In case of Method Overriding the access modifier can be same as declared in super class or can be of higher visibility.

2. please read about exception handling and method overriding

private Method cannot be Overridden , because it cannot be inherited.
Final method can be inherited but cannot be overridden.
The purpose of method overriding is to achieve Runtime Polymorphism.
Note: we can Overload main method , but we cannot override main method because it is static.

Rules for method overriding
       I. The return type of method must be same as declared in super class.
       (please read about co-varient return types in java)
      II. Method name must be same as declared in super class.
      III. Signature must be same as declared as in super class. Logic can be different.
      Note: we can optionally use an annotation @Override.


Q. Can we declare static methods as final in java ?

In Java, you can't declare static methods as final because static methods are not overridden,
they are hidden. The final keyword is used to prevent a method from being overridden in a subclass,
but since static methods belong to the class itself and not to any particular instance,
they can't be overridden.
However, you can declare a static method in a class declared as final to prevent any subclass from
hiding that method with a method of the same name.
But it's not necessary to use the final keyword with static methods since they can't be overridden anyway.

Q. Is runtime polymorphism applicable to data members along with methods ?
A method is overridden, not the data members,
 so runtime polymorphism can't be achieved by data members.
 plz refer this : https://www.geeksforgeeks.org/parent-and-child-classes-having-same-data-member-in-java/

How to do downcasting of a object in java ?

for example we have Parent class and a Child class which extends Parent class

We can't assign
Child c = new Parent();   // results in compilation error

Child c = (Child) new Parent();   // compiles successfully but gives runtime error as class cast exception

we can do that by

Parent p = new Parent();
Child c = (Child) p;  // compiles and run successfully

we can also use instanceOf operator to enhance downcasting and achieve loose coupling
please refer : https://www.javatpoint.com/downcasting-with-instanceof-operator
* */

