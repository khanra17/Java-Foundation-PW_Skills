Javas in One shot
=======================================
### Introduction
In Java, a string is an object that represents a sequence of characters. It is a reference type and belongs to the java.lang package. A string is an array of characters, which means it can be treated like any other array in Java. However, the String class provides many useful methods for manipulating strings that are not available for arrays.

### Inputs
The Scanner class in Java is commonly used to read input from the console. When reading a string input, there are two methods available: `next()` and `nextLine()`. The `next()` method reads a single word, while the `nextLine()` method reads a whole line of text.

### Index
The String class provides many methods for accessing the characters in a string. The `length()` method returns the number of characters in the string. The `charAt()` method returns the character at a specified index in the string. The `indexOf()` method returns the index of the first occurrence of a specified character or substring in the string. It is important to note that the `length` property is available in an array but the `length()` function is used in a string. Additionally, accessing a character in a string using the square bracket notation, e.g. `myString[index]`, is not possible.

### Compare
Strings can be initialized using the `new String()` constructor or the more common method of simply using a string literal. When initializing a string using a string literal, the string is stored in the string pool in memory. When using the `new String()` constructor, the string is stored on the heap. It is important to note that the `==` operator compares the memory reference of two strings, while the `compareTo()` method compares the lexicographical order of two strings.

### String + int/char/String
Concatenating strings with other data types or strings can be done using the `+` operator or the `concat()` method. The `+` operator automatically converts non-string types to strings, while the `concat()` method only works with strings.

### Substring
The `substring()` method can be used to extract a portion of a string. The `substring(i)` method returns a new string that starts at index `i` and goes until the end of the original string. The `substring(i, j)` method returns a new string that starts at index `i` and goes until index `j-1` of the original string.

#### Question
Given a string s, print all the substrings of s.
**Input: `s = "abcd"` <br>
Output: `a, ab, abc, abcd, b, bc, bcd, c, cd, d`**

#### Answer
```java
public class Substrings {
    public static void main(String[] args) {
        String s = "abcd";
        int n = s.length();

        // loop to generate all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }
}
```

### Interning & new
In Java, strings can be created using the new operator or by using string literals. When a string literal is used, the Java Virtual Machine (JVM) checks if a string with the same value already exists in the string pool. If it does, a reference to that string is returned instead of creating a new string. This process is known as string interning.

Using string interning can save memory, as it avoids creating multiple instances of the same string. However, it is important to note that using new always creates a new instance of the string, even if the value is already in the string pool.

### Immutability of Strings
In Java, a string is immutable, which means we cannot change the value of a string once it is created. Any change to a string results in creating a new string object. When we modify a string, the JVM creates a new string object and copies the modified content to the new object.

We can compare two strings in Java using the `equals()` method, which compares the content of the strings. However, if we use the `==` operator, it compares the reference of the objects and not the content.

### Performance
As strings are immutable in Java, it is not recommended to modify strings frequently. This is because it results in creating new objects, which is a costly operation in terms of memory and performance.

### String Builder
To avoid the performance overhead of creating new string objects, we use the StringBuilder class in Java. The StringBuilder class is mutable, which means we can modify the content of the string without creating a new object.

We create an object of StringBuilder using its constructor. We can also pass an initial capacity to the constructor to specify the initial size of the StringBuilder object.

### StringBuilder Functions
The StringBuilder class provides various methods to modify the content of the string. Some of the commonly used methods are:

* `append()`: appends the specified string to the end of the current string.
* `insert(i,c)`: inserts the specified character at the specified index in the current string.
* `deleteCharAt(i)`: deletes the character at the specified index from the current string.
* `delete()`: deletes the characters between the specified indices from the current string.

In conclusion, strings are an essential part of Java programming, and understanding the nuances of working with strings is crucial for writing efficient code.


### Toggle String
Given a string, the task is to toggle all the characters of the string i.e to convert upper case to Lower case and vice versa.

**Input: `PhisICS` <br>
Output: `pHISics`**

#### Answer
```java
public class ToggleString {
    public static void main(String[] args) {
        String str = "PhisICS";
        String toggledString = toggleString(str);
        System.out.println(toggledString);
    }

    public static String toggleString(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i])) {
                charArray[i] = Character.toLowerCase(charArray[i]);
            } else if (Character.isLowerCase(charArray[i])) {
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
        }
        return new String(charArray);
    }
}
```

### Count Palindromic Substrings
Given a string s, return the number of palindromic substrings in it.

**Input: `abc` <br>
Output: `3`**

#### Answer
```java
public static int countPalindromicSubstrings(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
        for (int j = i; j < s.length(); j++) {
            if (isPalindromic(s.substring(i, j+1))) {
                count++;
            }
        }
    }
    return count;
}

public static boolean isPalindromic(String s) {
    int i = 0, j = s.length()-1;
    while (i < j) {
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        i++;
        j--;
    }
    return true;
}
```

### Reverse Words
Java program to reverse each word in String

**Input: `I am an educator` <br>
Output: `I ma na rotacude`**

#### Answer
```java
public class ReverseWords {
    public static void main(String[] args) {
        String input = "I am an educator";
        String[] words = input.split(" ");
        StringBuilder reversed = new StringBuilder();

        for (String word : words) {
            StringBuilder temp = new StringBuilder(word);
            reversed.append(temp.reverse() + " ");
        }
        System.out.println("Original string: " + input);
        System.out.println("Reversed string: " + reversed.toString().trim());
    }
}
```

### Compressing String Algorithm.
The string should be compressed such that consecutive duplicates of characters are replaces with the character and followed by the number of consecutive duplicates.

**Input: `aaabbbbccddde` <br>
Output: `a3b4c2d3e1`**

#### Answer
```java
public static String compressString(String str) {
    if (str == null || str.isEmpty()) {
        return str;
    }

    StringBuilder sb = new StringBuilder();
    char currentChar = str.charAt(0);
    int count = 1;

    for (int i = 1; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c == currentChar) {
            count++;
        } else {
            sb.append(currentChar).append(count);
            currentChar = c;
            count = 1;
        }
    }

    sb.append(currentChar).append(count);
    return sb.toString();
}
```