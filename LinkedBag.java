/**
   @author Written and edited by Chi Tran 
*/
public class LinkedBag <T> implements BagInterface<T> 

{
	private Node firstNode; // Reference to first node of chain
	private int numberOfEntries;

	//default constructor
	public LinkedBag()
	{
	firstNode = null;
	numberOfEntries = 0;
	} // end default constructor
	

	/** Gets the current number of entries in this bag.
		 @return  The integer number of entries currently in the bag. */
	public int getCurrentSize() {
		return numberOfEntries;
	}
	
	/** Sees whether this bag is empty.
		 @return  True if the bag is empty, or false if not. */
	public boolean isEmpty() {
		return numberOfEntries==0;
		
	}
	
	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True if the addition is successful, or false if not. */
	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry);
		newNode.setNextNode(firstNode); // Make new node reference rest of chain
		firstNode = newNode; // firstNode is null if chain is empty
		numberOfEntries++; // new node is at beginning of chain
		return true; 
	}

	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal.
                was successful, or null. */
	public T remove() {
		// Remove the first node
		T result = null;
		if (!isEmpty()) {
			result = firstNode.getData();
			firstNode = firstNode.getNextNode();
			numberOfEntries--; 
		}
		return result; 
	}
   
	/** Removes one occurrence of a given entry from this bag.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
   public boolean remove(T anEntry){
	   boolean result = false;
	   Node nodeToRemove = getReferenceTo(anEntry);
	   if (nodeToRemove!=null) {
		   nodeToRemove.setData(firstNode.getData());
		   firstNode = firstNode.getNextNode();
		   numberOfEntries--; 
		   result = true;
	   }
	   return result; 
   }
	
	/** Removes all entries from this bag. */
	public void clear(){
		while (!isEmpty()){
			remove();
		}
	}
	
	/** Counts the number of times a given entry appears in this bag.
		 @param anEntry  The entry to be counted.
		 @return  The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry) {
		int frequency =0;
		Node currentNode = firstNode;
		int index =0;
		while  ((index <numberOfEntries) && (currentNode!=null)) {
			if(anEntry.equals(currentNode.getData()))
				frequency++;
				index++;
				currentNode = currentNode.getNextNode();
		}
		return frequency; 
		
	}
	
	/** Tests whether this bag contains a given entry.
		 @param anEntry  The entry to locate.
		 @return  True if the bag contains anEntry, or false if not. */
	public boolean contains(T anEntry){
		boolean found = false;
		/*Node currentNode = firstNode;
		while (!found && (currentNode!=null)){
			if(anEntry.equals(currentNode.getData()))
				found = true;
			else 
				currentNode = currentNode.getNextNode();
		}
		return found; */
		Node desiredNode = getReferenceTo(anEntry);
		if (desiredNode !=null)
			found = true;
		return found;
	}
   
	/** Retrieves all entries that are in this bag.
		 @return  A newly allocated array of all the entries in the bag.
                Note: If the bag is empty, the returned array is empty. */
	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		int index =0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode!=null)){
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		}
		return result; 	
	}
		   
	private Node getReferenceTo(T anEntry)
	{
	boolean found = false;
	Node currentNode = firstNode;
	
	while (!found && (currentNode != null))
	{
		if (anEntry.equals(currentNode.data))
		found = true;
		else
		currentNode = currentNode.next;
	} // end while
	
	return currentNode;
	} // end getReferenceTo
	
	 
	
	private class Node
	{
		private T data;
		private Node next;
		
		// Default Constructor
		private Node(T data){
			this(data, null);
		} 
		
		// Constructor
		private Node(T data, Node nextNode){
			this.data = data;
			this.next = nextNode;
		}
		
		// Setter 
		private void setData(T newData){
			data = newData;
		}
		
		private void setNextNode(Node nextNode){
			next = nextNode;
		}
		
		//Getter
		private T getData(){
			return data;
		}
		private Node getNextNode(){      
			return next;
		}
		
	}// end Node

 

}// end LinkedBag