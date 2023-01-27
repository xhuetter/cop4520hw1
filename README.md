# cop4520 Assignment 1

# Compiling and Running
To compile and run the program, open the command terminal to the file location of the repository.
Once in the repository, run the command "javac FindPrime.java Sieve.java Counter.java".
After that command, run "java FindPrime".

# General Approach and Reasoning
To find the primes, I used an implementation of the Sieve of Eratosthenes in java. In my implementation, I use a boolean array to keep track of whether all the numbers from 2 to a given maximum are prime. When beginning, the boolean array is instantiated, with every number unmarked. After the array is instantiated, 8 threads are spawned to perform the process of marking non-prime numbers. Each thread uses a shared counter to prevent any repeating numbers among them. This also allows each thread to perform around the same amount of work, as threads that take less time to mark for their prime numbers will end up performing the sieve procedure on more prime numbers overall. When all threads have completed, each step of the Sieve of Eratosthenes will have been performed, leaving only prime numbers unmarked in the boolean array. Afterwards, the array can be used to add all prime numbers, which are unmarked, into a list.

# Correctness and Efficiency Testing
For testing the efficiency of my approach, I ran a single-threaded version of my application and compared the runtime to my multi-threaded implementation. My multi-threaded approach was significantly faster than the single-threaded approach. To test the correctness of my program, I ran test cases of much smaller values for the given maximum, making sure that the list of primes was correct. After that, I ran the program on a larger set to make sure that the threads were completing in similar times.
