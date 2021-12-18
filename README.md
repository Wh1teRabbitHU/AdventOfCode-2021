# AdventOfCode - 2021 - Java solutions

## Description

This repository contains the solution for 2021's [Advent of Code](https://adventofcode.com/2021) challenges using java
and maven to import some useful packages. It's a simple command line application, the entry class is under the following
path: ```hu.tamasruszka.adventofcode.AdventOfCodeApplication```.

## Execution

If you want to execute it, you can either run it from an IDE starting the main method from
the ```AdventOfCodeApplication``` class or run the following command from a command line application: (Check the
version)

```shell
mvn clean compile assembly:single
cd target
java -jar advent-of-code-2021-jar-with-dependencies.jar
```

## Sources

If you want to check out the solutions, you can find each day's under the ```hu.tamasruszka.adventofcode.solution```
package.

Links to each solution:

- [Day 1](blob/master/src/main/java/hu/tamasruszka/adventofcode/solution/Day01.java)
- [Day 2](blob/master/src/main/java/hu/tamasruszka/adventofcode/solution/Day02.java)