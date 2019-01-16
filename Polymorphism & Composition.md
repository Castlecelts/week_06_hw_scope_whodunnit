Polymorphism & Composition Homework - Quiz
Polymorphism

1. What does the word 'polymorphism' mean?

Many forms.

2. What does it mean when we apply polymorphism to OO design? Give a simple Java example.


3. What can we use to implement polymorphism in Java?

Interfaces.

4. How many 'forms' can an object take when using polymorphism?

theoretical maximum number of interfaces a class can implement, it's 65535.

5. Give an example of when you could use polymorphism.

Since you can't inherit from more than one class, there are interfaces. 
If there is a need to group different types of objects under one "form".

Composition
1. What do we mean by 'composition' in reference to object-oriented programming?

containing instances of other classes that implement the needed functionality.

2. When would you use composition? Provide a simple example in Java.

Most of the time.

Bear has salmons in its belly. Salmon is a different class, use "inside" of bear class to function as food.

3. What is/are the advantage(s) of using composition?

Composition is more flexible than inheritance. You can change implementation of class at run-time by changing included object,
thus changing behavior of it, but you can't do this with inheritance, you can't change behavior of base class at run-time.

Inheritance breaks encapsulation. While composition not.

4. What happens to the behaviours when the object composed of them is destroyed?

If theey are not refered anywhere else, they get garbage collected i.e. deleted.
