## Inheritance

- It is inheriting the properties of parent class into the child class.
- Inheritance is the procedure by which one object acquires all the properties and behaviors of a parent object.

### Is-A relationship :

Sparrow Is-A Bird : here Bird is the parent class and Sparrow is the Child class of Bird.

### Advantages :

- code reusability
- it promotes runtime polymorphism by allowing method overriding.

### Disadvantages :

- the classes are tightly coupled in inheritance. If you do change in the parent class then that will affect the all child classes.

### Types of Inheritance :

1. Single (A -> B)
2. Multi level (A -> B -> C)
3. Hierarchical (A -> B, C)
4. Multiple (A,B -> C) : not possible in Java
5. Hybrid (A -> B,C -> D) : not possible in Java

### Why Multiple and Hybrid Inheritance is not possible in java ?

Suppose there are 2 classes A and B and they have a single child C. (A,B -> C). Now if A and B contains same method then if I do objC.method() then which method will be called ? from the class A or class B ? The compiler confused. This is called Ambiguity (Daimond problem).

### Is all the things of the parent class is inherited to the child class ?

No, the child class does not inherit all things of the parent class.
The things that are not inherited :

1. Constructor
2. private members

### Which is the parent class of all the classes in java ?

Object class

### Why we apply relationship between multiple classes ? Advantages :

1. code reusability
2. cost cutting
3. Reduce Redundancy

### Types of Relationships b/w classes :

#### 1. Is-A (Inheritance)

- Tightly coupled with 'Extends' keyword
- blood relation
- Simple, Multi level, Hierarchical, Multiple, Hybrid

#### 2. Has-A (Association)

- not blood relation
- you can access the methods and attributes of other class using the object of that class. No need to apply 'Extends'.
  This will prevent the tightly coupled condition.

##### 1. Aggregation

##### 2. Composition
