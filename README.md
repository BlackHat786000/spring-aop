Spring AOP
-----------

What is AOP ?

AOP is a programming paradigm that aims to increase the modularity by allowing the seperation of cross-cutting concerns like logging, authentication/authorization, sanitizing the data, transaction management etc.

Process of applying services or external services such as transaction management or logging to our application classes without modifying
the code.


Important Terminology
----------------------

1. Aspect: An aspect is a modularization of concern that cuts across multiple classes.

2. JoinPoint: Join point is any point in your program like method execution, exception handling, field access etc. Spring supports only method execution joint point.

3. Advice: Advice represent an action taken by an aspect at particular joint point.

4. Pointcut: It is an expression of AOP that matches joint point.