The Two-pointer technique or Two-pointer approach is an algorithmic strategy used to solve various problems in computer science, particularly those involving arrays or linked lists. It involves using two pointers to iterate through a data structure, often to reduce the time complexity of the solution. Here's a more detailed definition:

Definition
The Two-pointer technique uses two distinct indices (pointers) to traverse the data structure. These pointers can move at different speeds or in different directions, depending on the problem requirements. The technique is particularly useful for problems involving searching, sorting, and partitioning.

Common Uses
Removing elements: Removing or modifying elements in an array based on certain conditions.
Partitioning arrays: Dividing arrays into sections that meet specific criteria.
Finding pairs: Finding pairs of elements that satisfy a particular condition (e.g., two-sum problem).
Merging arrays: Merging two sorted arrays or lists.
Example Usage
In the example problem you provided:

Problem: Remove all occurrences of a specific value val from an array nums and return the new length of the array without the value val.
Two-pointer solution:
Use one pointer (i) to iterate through the array.
Use another pointer (j) to keep track of the position where the next non-val element should be placed.
Algorithm Outline
Initialize two pointers, i and j. Set both to the beginning of the array.
Iterate with pointer i over each element of the array.
If nums[i] is not equal to val, assign nums[i] to nums[j] and increment j.
Continue this process until all elements have been checked.
The pointer j will now indicate the new length of the modified array, with all val elements removed.
Benefits
Efficiency: Often leads to more efficient solutions, both in terms of time and space complexity.
Simplicity: Provides a straightforward way to handle problems that involve comparing elements at different positions in a data structure.


 ```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for (int indexNums = 0; indexNums < nums.length; indexNums++) {
            if (nums[indexNums] != val) {
                nums[pointer] = nums[indexNums];
                pointer++;
            }
        }
        // return size - count   
        return pointer;
    }
}
 ```