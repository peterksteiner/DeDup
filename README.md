Submitted by: Peter Steiner  
Consulting Firm:  
Contact Info: petersteiner@mac.com  

1.	Given the following class, write 3 methods that can be used to print out an array that has no duplicates. 
 
        public class DeDup {
        
            public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
                                           20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
                                           13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   
        
            public static void main(String [] args) {
        
            }
        }
        
        Please find solution in source code repository.
2.	You should define a method signature that you feel is appropriate to the problem.  

        public void printDeduplicatedIntArray(int[] intArray) { .. }
        public void printDeduplicatedIntArrayWithInsertionOrder(int[] intArray) {..}
        public void printDeduplicatedIntArrayWithSortedOrder(int[] intArray) {...}
3.	We would prefer to see three implementations (one that should take into consideration #4 below) 
and an explanation of what use-cases are suitable to each implementation  
 
        Set is the appropriate data structure for a collection with no duplicates. 
        1. The first method uses a HashSet. This does not have any guarentees on iteration order of 
        the Set.  
        2. The second method uses LinkedHashSet to maintain insertion order.  
        3. The third method uses TreeSet to maintain natural ordering of the Set elements.
4.	What if we need to retain the original order?  

        Use LinkedHashSet to retain the original order of insertion.
5.	What are the positives and negatives of your solution?

        Positives:
        - Uses java.util.Set implementations to achieve program requirements. No reason to reinvent.
        - Uses Apache Commons-lang for building toString to return int [] to be printed
        - Encapsulates Set<Integer> from modification.
        - Constructor for creating a new IntSet is package protected. A Factory is provided to
        create new IntSet objects.
        - IntSet is immutable because there is no reason to allow changes to the data.
        - Demonstrates programming to interfaces  
        - Printing the results in a different format or medium can easily be refactored with a 
        different implementation of PrintService interface.
        - Test coverage = 100%
        Negatives:
        - This implementation was done to satisfy the problem statement. This utility library would
        be more useful if it focused on arrays of Objects rather than arrays of primatives.
        - The problem statement wasn't specific about the print out requirements. Could be improved.
        - IntSet.toIntArray() is only required by JUnit test to assert we have no duplicates in 
        array.
6.	Can you implement it another way so as to avoid the negatives?

        Yes, we could make this utility library more interesting by changing the problem statement
        to print out an array of Integers. I've *prototyped* a Generics version in 
        com.petersteiner.dedup.generics.DeDupGenerics, showing dedup of Integer[], Long[], String[].  
        Suggest better definition of the reporting requirements or information about how this 
        library might be consumed. I've made the printing feature an Interface so that the simple 
        solution to use System.out is easy to replace. 

7.	Your solution should be “production ready.”  

        Maven project file is provided. JUnit test coverage is 100%.
        
        $ mvn exec:java
        [INFO] Scanning for projects...
        [INFO]                                                                         
        [INFO] ------------------------------------------------------------------------
        [INFO] Building dedup 1.0-SNAPSHOT
        [INFO] ------------------------------------------------------------------------
        [INFO] 
        [INFO] --- exec-maven-plugin:1.4.0:java (default-cli) @ dedup ---
        int [] with duplicates: [{1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11}]
        deduplicated int []: [{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,10000,16,17,18,19,20,85,86,25,26,34,43,45}]
        deduplicated int [], insertion order: [{1,2,34,25,45,3,26,85,4,86,43,10000,11,16,19,18,9,20,17,8,15,6,5,10,14,12,13,7}]
        deduplicated int [], sorted order: [{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,25,26,34,43,45,85,86,10000}]
        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------
        [INFO] Total time: 0.630s
        [INFO] Finished at: Mon Jan 11 20:16:26 EST 2016
        [INFO] Final Memory: 7M/155M
        [INFO] ------------------------------------------------------------------------
