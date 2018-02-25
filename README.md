# ZipcodeProcessor
Java maven application to merge the zipcode ranges 

----------------------------------------------------------------------------------------------------------------------
# Problem Statement: 
BACKGROUND
Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. For example if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

PROBLEM
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

NOTES
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

EXAMPLES:
If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399] 
Then the output should be = [94133,94133] [94200,94399]

Evaluation Guidelines:
Your work will be evaluated against the following criteria:
- Successful implementation
- Efficiency of the implementation
- Design choices and overall code organization
- Code quality and best practices

---------------------------------------------------------------------------------------------------------------------

# Assumptions made:
1) Assumed input to come as String
For instance input [94133,94133] [94200,94299] [94600,94699] as whole under a string.

# DataStructures uded:
1) LinkedList - For now, used 2 linkedlist, one for storing the input and the other for storing the output. Future work will be to use only one LinkedList for doing merge operation.
2) Created maven project to help entension of this project for future work

# Java File Description:
1) App.java --> Main driver than reads the input and drives the zipcode processor
2) Zipcode.java --> Data model to store the lower bound and upper bound of zipcode
3) ZipcodeComparator.java --> To sort based on the lower bound of zipcode from the list
4) ZipcodeProcessor.java --> Helps validating the input and load them to linkedlist
5) ZipcodeMerger.java --> Main logic that merges the zipcode ranges and returns the final list

# Tests:
1) Used DataFactory to generate data sets
2) Wrote Junit tests to validate different scenarios  of input

# Sample outputs:

  ![alt text](Screenshot from 2018-02-25 12-38-26.png)
  
