# ga-convex-hull
The purpose of this project is to address the Convex Hull problem, using a Genetic Algorithm. In addition to this, a different project has been developed, the **genetic-algorithm-library** (it cawhich is actually imported as a dependency and provides an abstract implementation of a Genetic Algorithm tailored to the needs of any problem (and not only the Convex Hull). 

## Problem Description
In mathematics, **the convex hull or convex envelope or convex closure of a set X of points in the Euclidean plane or in a Euclidean space** (or, more generally, in an affine space over the reals) **is the smallest convex set that contains X**. For instance, when X is a bounded subset of the plane, the convex hull may be visualized as the shape enclosed by a rubber band stretched around X.

Formally, the convex hull may be defined either as the intersection of all convex sets containing X, or as the set of all convex combinations of points in X. With the latter definition, convex hulls may be extended from Euclidean spaces to arbitrary real vector spaces; they may also be generalized further, to oriented matroids.

The algorithmic problem of finding the convex hull of a finite set of points in the plane or other low-dimensional Euclidean spaces is one of the fundamental problems of computational geometry.

*Taken from WikiPedia*

The actual problem of finding the Convex Hull of a finite set of points, is purely a mathematical one and for that several exact algorithms have been proposed. However here the solution provided is more to understand the mechanics of a Genetic Algorithm, rather than provide a faster algorithm for the problem at hand.

## Technical Instructions
* Clone the **genetic-algorithm-library** project (it can be found [here](https://github.com/OrPolyzos/genetic-algorithm-library)) and run
```mvn clean install``` from a terminal in the root directory (where `pom.xml` is located). This will install the forementioned project in your local .m2 to be used/imported by this current project, as it is a required dependency.
* Clone the **ga-convex-hull** project (this one) and run the ChGeneticAlgorithmApplication.
