# BFButCool

This is a brainfuck interpreter written a subset of Java.
It was adapted from [elPytel's interpreter](https://github.com/elPytel/BF_interpreter), which itself was based on work by
[@maxcountryman](https://github.com/maxcountryman), [@himehowareu](https://github.com/himehowareu), and [@D0tty](https://github.com/D0tty).

I took the idea for the control structure from something [@sunho](https://github.com/sunho) shared.

The crux of this program is a brainfuck interpreter written with only variables/arrays, basic arithmetic, and most importantly, a COOL :sunglasses: control structure.

```java
while([some variable or constant] <-- [some variable]){
  ...
}
while([some variable] --> [some variable or constant]){
  ...
}
```

This structure may look funny, because `<--` is not an operator in Java, or C and C++ for that matter. But this is valid Java code, because this is actually a combination of two 
operators, the decrement operator(`--`) and the comparison operator(`<`).

This control structure is the only control structure used in the `coolinterpret` method.

I wrote this because I wanted to show that this control structure, combined with some variables, arrays, and basic arithmetic formed a turing-complete language.
I had strong suspicions it could be done, as the [WHILE language](https://stackoverflow.com/questions/507310/the-while-language) is turing-complete.
To prove it beyond a shadow of a doubt, i wrote a brianfuck interpreter in it, which itself is turing-complete, making this subset of Java turing-complete.
