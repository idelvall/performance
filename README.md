# performance
Some Java performance numbers for myself, with the idea of having a sense on what the relative cost of certain operations is.

JIT has been disabled for these tests in order to avoid any code optimization.

- [performance](#performance)
  * [Cost of getting stack trace (ns)](#cost-of-getting-stack-trace-ns)


## Cost of getting stack trace (ns)

[source code](src/test/java/org/brutusin/StackTraceTest.java)

| Procedure | Stack length of 1 | Stack length of 10 | Stack length of 50 | Stack length of 100 | Stack length of 200 | Stack length of 400 | Stack length of 800 |
| - | - | - | - | - | - | - | - |
| Throwable | 3552 | 10819 | 44499 | 92509 | 184329 | 338808 | 713571 | 
| Filled | 2528 | 9229 | 45497 | 81678 | 161970 | 340909 | 682630 | 
| Thread | 3803 | 10156 | 46239 | 87887 | 160443 | 358918 | 672376 | 

