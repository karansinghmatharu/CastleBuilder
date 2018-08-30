# CastleBuilder

Let’s say you have an array of integers that describes a stretch of land, where each integer represents the
current height of the land. Can you write a function that reads that array and returns the number of
castles that Aequilibrium should build on that stretch of land? You can write this solution in whatever
language you like.

You can make the following assumptions:

● You can always build a castle at the start of the array, provided it is non-empty

● We only want to build one castle per peak or valley.

● A peak is an integer or series of integers that is above the immediately preceding and following
ints. For example, in the sequence [2,6,6,6,3] the sequence of 3 6s is a peak.

● A valley is an integer or series of integers that is below the immediately preceding and
following ints. For example, in the sequence [6,1,4] the "1" would be a valley.

# Solution:-

Method readFromTerrain() is used for inputting hard coded values to the land array.

Method readFromScanner() is used for taking input from Scanner 

	- First input as a Size of land array 
	
	- Second input as the array
	

Assumptions:- 

- If array is of size null or 0 it returns 0 castles built.

- If array is non-empty the elements are judged if they are peak or a valley on the basis of their value from preceding and following ints.

- Total is added with +1 for non- empty array as the Castle can be built at first position, as per the rules.
