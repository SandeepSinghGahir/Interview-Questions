
//Question
/*
You are working for a telecommunications company that is trying to upgrade junction boxes all over Techlandia. Some of the junction boxes have already been upgraded, and other boxes have not. Your task is to identify the oldest boxes that need to be upgraded first but leaving the newer model boxes so that they will not be prioritized.

All the junction boxes are identified by an alphanumeric identifier, followed by space delimited version information. The older generation uses space delimited lowercase English strings to identify the version, but the newer generation uses space delimited positive integers to identify the version. Your task is to sort the junction boxes in the following order:

1. The older generation boxes with the earliest lexicographic version should come first.
2. If there are any ties in the older generation, ties should be broken by the alphanumeric identifier.
3. Finally, the newer generation boxes should also be returned, in the original order they were in the list.

Write a function or method to return the junction boxes in the specified order.

*/

import java.util.*;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{ 
    
    
    public static void main(String args[]){
        
        Solution sol = new Solution();
        List<String> input = sol.inputGenerator();
        List<String> result = sol.orderedJunctionBoxes(6,input);
        sol.display("Input",input);
        sol.display("Output",result);
        
    }
    public List<String> inputGenerator(){
        ArrayList<String> input = new ArrayList<String>();
        input.add("ykc 82 01");
        input.add("eo first qpx");
        input.add("09z cat hamster");
        input.add("06f 12 25 6");
        input.add("az0 first qpx");
        input.add("236 cat dog rabbit snake");
        return input;
    }
    
    public void display(String type,List<String> passedBoxes){
        System.out.println(type+" : ");
        for (String eachBox : passedBoxes){
            System.out.println(eachBox);
        }
        System.out.println("");
    }
        
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> orderedJunctionBoxes(int numberOfBoxes, 
	                                         List<String> boxList) 
	{
		// WRITE YOUR CODE HERE
		List<String> newList = new ArrayList<>();
		List<String> oldList = new ArrayList<>();
		List<String> sortedList = new ArrayList<>();
		List<String> upgradedList = new ArrayList<>();
		
		for(int i = 0; i < boxList.size(); i++) {
		    String col2 = boxList.get(i).split(" ")[1];
		    if (col2.matches("\\d+")) 
		        newList.add(boxList.get(i));
		    else
		        oldList.add(boxList.get(i));
		}
		for(int i = 0; i < oldList.size(); i++) {
		    String tobeSorted =  oldList.get(i).split(" ",2)[1] +" "
		    +oldList.get(i).split(" ")[0];
		    sortedList.add(tobeSorted);
		}
		//Sort the old junction boxes list lexographically
		Collections.sort(sortedList);
		
		for(int i = 0; i < sortedList.size(); i++) {
		    int len  =  sortedList.get(i).split(" ").length;
		    int index =  sortedList.get(i).lastIndexOf(" ");
		    String lastpart = sortedList.get(i).substring(0,index);
		    String frontPart = sortedList.get(i).split(" ")[len-1];
		    String upgradedLabel = frontPart + " " + lastpart;
		    upgradedList.add(upgradedLabel);
		}
		//Merging old boxes list after sorting with new boxes list as it is
		upgradedList.addAll(newList);
		return upgradedList;
	}
	// METHOD SIGNATURE ENDS
}