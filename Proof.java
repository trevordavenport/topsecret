import java.util.*;

public class Proof {
	
	LineNumber lastLineNumber;
	LlinkedList myLinkedList;
	
	private HashMap<LineNumber, LinkedList> myLineNumbers = new HashMap<LineNumber, LinkedList>();
	
  public Proof (TheoremSet theorems) {
	}

	 
	public LineNumber nextLineNumber ( ) { 
		LineNumber valueholder = nextline_helper(myLineNumbers.get(lastLineNumber).getFirst(), myLineNumbers.get(lastLineNumber).getLast());
		lastLineNumber = valueholder;
		return valueholder;
	}

	//Send the input string into a basic parser that should grab the different elements and add them into a linked list. 
	//The parser should also check for basic syntax errors, and will make the expression string part into an expression object
	//before returning.
	
	//Then add to the hashmap the linenumber with a linked list value that holds the elements from the line. 
	
	public void extendProof (String x) throws IllegalLineException, IllegalInferenceException {
	//add the parsed expression to the hashmap at the key of "lastLineNumber"
	}

	public String toString ( ) {
		return "";
	}

	public boolean isComplete ( ) {
		return true;
	}
}
