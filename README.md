# Mars Rover

This is an implementation of the [Mars Rover kata](http://technologyconversations.com/2014/10/17/java-tutorial-through-katas-mars-rover/) in Clojure.  I don't write a lot of Clojure, so viewer discretion is advised.

#### Tests

```lein midje```

#### Progress

- [x] You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
- [x] The rover receives a character array of commands.
- [x] Implement commands that move the rover forward/backward (f,b).
- [x] Implement commands that turn the rover left/right (l,r).
- [ ] Implement wrapping from one edge of the grid to another. (planets are spheres after all)
- [ ] Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle
