package alvaradoSandoval;

public class Dictionary {
	//Attributes 
	private WordNode root; //can cause a lot of trouble if it is accidentally set
	

	//Constructor 
	public Dictionary() {
		root = null;
	}
	
	//Add node
	public void addword(String word){
		//task 1: create a new dictionary WordNode
		WordNode temp = new WordNode(word);
		
		//task 2: find the position for inserting the node 
		// scenario 1: this is the first word in the dictionary 
		if(root == null){
			assert(root == null): "Root is null so we reset the root to temp";
			root = temp;
		}
		
		//scenario 2: not the first word -- requires searching for the location
		else {
			insertAtLocation(root, temp);
		}
	}
	
	public void insertAtLocation(WordNode pntr, WordNode wordToAdd){
		//Begin the search by visiting each word node 
		
		//a negative integer: wordToAdd less than pntr
		//zero: wordToAdd equal to pntr 
		//positive integer: wordToAdd greater than pntr
		
		while(true) {
			//scenario 1: the word already exists in the dictionary
			 
			if (wordToAdd.word.compareToIgnoreCase(pntr.word) == 0) {
				break;
			}
			//scenario 2: travel to the left side 
			else if(wordToAdd.word.compareToIgnoreCase(pntr.word)< 0){
				if(pntr.left != null) {
					pntr = pntr.left;
				}
				else {
					pntr.left = wordToAdd;
					
					assert (pntr.left == null): "Unable to add node.";
					break;
				}
			}
			//scenario 3: travel to the right side
			else {
				if(pntr.right != null) {
					pntr = pntr.right;
				}
				else {
					pntr.right = wordToAdd;
					assert (pntr.right == null): "Unable to add node.";

					break;
				}
			}
		}
	}
	
	public void removeWord(String word) {
		
		WordNode wordToRemove = root;
		WordNode pntr = root;
		WordNode parent = null;
		WordNode child;
		
		boolean found = false;
		
		while(!found && wordToRemove != null) {
			if(word.equals(wordToRemove.word)) {
				found = true;
			} else {
				parent = wordToRemove;
				
				if (word.compareTo(wordToRemove.word) > 0) {
					wordToRemove = wordToRemove.right;
				} else {
					wordToRemove = wordToRemove.left;
				}
			}
			
		}
		
		if(!found) {
			assert(!found): "Value is not found in the dictionary";
			//System.out.println("Not found in dictionary.");
		}
		
		System.out.println(pntr.word);
		
		if(wordToRemove.left == null || wordToRemove.right == null) {
			if(wordToRemove.left == null) {
				child = wordToRemove.right;
			} 
			else {
				child = wordToRemove.left;
			}
			
			if(parent == null) {
				root = child;
			} 
			else if(parent.left == wordToRemove) {
				parent.left = child;
			} 
			else {
				parent.right = child;
			}
			
			return;
			
		}
			
			
			WordNode smallestParent = wordToRemove;
			WordNode smallest = wordToRemove.right;
			
			while(smallest.left != null) {
				smallestParent = smallest;
				smallest = smallest.left;
			}
			
			wordToRemove.word = smallest.word;
			
			if(smallestParent == wordToRemove) {
				smallestParent.right = smallest.right;
			}
			else 
			{
				smallestParent.left = smallest.left;
			}
			
		}
				
	
	
	//Traverse the tree: in order traversal for displaying the full dictionary 
	public void displayDictionary() {
		inOrderRecursive(root);
	}
	
	private void inOrderRecursive(WordNode pntr) {
		if (pntr!= null) {
			inOrderRecursive(pntr.left);
			System.out.println(pntr.word);
			inOrderRecursive(pntr.right);
		}
	}
}
