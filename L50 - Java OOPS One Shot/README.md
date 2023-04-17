Java OOPS One Shot
=======================================
### Introduction
Java is an object-oriented programming (OOP) language. OOP is a programming paradigm that uses objects to represent and manipulate data. Java OOPs is the foundation of Java programming and is an essential part of Java development.

### Class
A class is a user-defined data type that acts as a blueprint for objects. It contains data members (variables) and member functions (methods) that define the behavior of the objects. In other words, a class is a template for creating objects. The data members can be of any data type, including primitive types like int and float or user-defined types like objects.

#### Class Creation
To create a `class`, you use the class keyword followed by the class name. Here's an example:
```java
public class MyClass {
// data members and member functions go here
}
```

### Object
An object is an instance of a class. When you create an object, you allocate memory for it and initialize its data members. In Java, objects have default values if you don't initialize them explicitly.

### Scope
Scope determines the visibility of a variable or method. In Java, there are four levels of scope: class level, package level, function level, and block level.

#### Same Package
Variables and methods declared as public are visible to all classes within the same package.

#### Class Inside Functions
You can also declare a class inside a function. This is known as a local inner class, and it has access to the variables and methods of the enclosing function.

#### Pass by Reference
Java is a pass-by-value language, which means that when you pass an argument to a method, a copy of the argument is passed, and any changes made to the copy do not affect the original. However, if the argument is an object reference, then the reference is passed by value. This means that changes made to the object's data members will be reflected outside the method.

### Access modifiers
Access modifiers determine the accessibility of a variable or method. In Java, there are four access modifiers:

#### Private
Variables and methods declared as private are only accessible within the class they are declared in.
#### Default
Variables and methods declared without an access modifier (i.e., no modifier is specified) are only accessible within the same package.
#### Public
Variables and methods declared as public are accessible to all classes in all packages.
#### Protected
Variables and methods declared as protected are accessible within the same package and by subclasses outside the package.

### Getter and Setter
Getter and setter methods are used to access and modify private variables in a class. Getter methods return the value of the private variable, while setter methods are used to modify the value of the private variable.

### this
The keyword 'this' is a reference variable that refers to the current object in a class. It is used to refer to the instance variable of a class, to invoke the constructor of the same class, and to pass the current object as a parameter to another method.

### Constructor
A constructor is a special method that is used to initialize objects. It is called when an object of a class is created. Constructors can have parameters or no parameters. If no constructor is defined in a class, Java will provide a default constructor.

### final
The keyword "final" is used in Java to denote that a variable, method, or class cannot be changed. A final variable cannot be reassigned, a final method cannot be overridden, and a final class cannot be extended.

### static
The keyword "static" is used in Java to create class-level variables and methods. A static variable or method belongs to the class rather than an instance of the class. It can be accessed without creating an object of the class.

### Fraction Class:
```java
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public double toDecimal() {
        return (double) numerator / denominator;
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction other) {
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }
}
```

### Make your own ArrayList
```java
public class MyArrayList<T> {
    private T[] array;
    private int size;

    public MyArrayList() {
        array = (T[]) new Object[10];
        size = 0;
    }

    public void add(T element) {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size] = element;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        array[size] = null;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }
}
```