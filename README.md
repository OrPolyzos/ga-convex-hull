# ga-infinite-monkey-theorem
The sole purpose of this project is to demonstrate the use of the **genetic-algorithm-library** project and provide a sample implementation for it. 

## Problem Description
**The infinite monkey theorem states that a monkey hitting keys at random on a typewriter keyboard for an infinite amount of time will almost surely type a given text, such as the complete works of William Shakespeare**. In fact, the monkey would almost surely type every possible finite text an infinite number of times. However, the probability that monkeys filling the observable universe would type a complete work such as Shakespeare's Hamlet is so tiny that the chance of it occurring during a period of time hundreds of thousands of orders of magnitude longer than the age of the universe is extremely low (but technically not zero).

However, for physically meaningful numbers of monkeys typing for physically meaningful lengths of time the results are reversed. If there were as many monkeys as there are atoms in the observable universe typing extremely fast for trillions of times the life of the universe, the probability of the monkeys replicating even a single page of Shakespeare is unfathomably small.

Ignoring punctuation, spacing, and capitalization, a monkey typing letters uniformly at random has a chance of one in 26 of correctly typing the first letter of Hamlet. It has a chance of one in 676 (26 × 26) of typing the first two letters. Because the probability shrinks exponentially, at 20 letters it already has only a chance of one in 2620 = 19,928,148,895,209,409,152,340,197,376 (almost 2 × 1028). In the case of the entire text of Hamlet, the probabilities are so vanishingly small as to be inconceivable. The text of Hamlet contains approximately 130,000 letters. Thus there is a probability of one in 3.4 × 10183,946 to get the text right at the first trial. The average number of letters that needs to be typed until the text appears is also 3.4 × 10183,946, or including punctuation, 4.4 × 10360,783.

*Taken from WikiPedia*

So the actual problem, the ga-infinite-monkey-theorem is actually a "simulation" problem. Simulate the monkeys typing random characters in the keyboard, but using Genetic Algorithms as a way to evolve and arrive faster to a correct solution. Ofcourse we are not going to use the complete works of William Shakespeare for this demonstration. 

```to be or not to be that is the question``` will suffice for the actual purpose of this project

## Technical Instructions
* Clone the **genetic-algorithm-library** project (it can be found [here](https://github.com/OrPolyzos/genetic-algorithm-library)) and run
```mvn clean install``` from a terminal in the root directory (where `pom.xml` is located). This will install the forementioned project in your local .m2 to be used/imported by this current project, as it is a required dependency.
* Clone the **ga-infinite-monkey-theorem** project (this one) and run the ImtGeneticAlgorithmApplication.
