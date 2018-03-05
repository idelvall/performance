# performance
Some Java performance numbers for myself, with the idea of having a sense on what the relative cost of certain operations is.

JIT has been disabled for these tests in order to do not apply any optimization.

## Cost of getting stack trace (ns) ([source code](src/test/java/org/brutusin/StackTraceTest.java))

| Procedure | Stack length of 1 | Stack length of 10 | Stack length of 50 | Stack length of 100 | Stack length of 200 | Stack length of 400 | Stack length of 800 |
| - | - | - | - | - | - | - | - |
| Throwable | 4046 | 10612 | 41631 | 88745 | 168322 | 322019 | 668278 | 
| Filled | 2586 | 8736 | 36679 | 72597 | 158548 | 294444 | 620728 | 
| Thread | 4373 | 10191 | 42923 | 78147 | 157562 | 301731 | 603897 | 

