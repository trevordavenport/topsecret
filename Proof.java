import java.util.*;

public class Proof {
	
	LineNumber lastLineNumber;
	
  public Proof (TheoremSet theorems) {
	}

	public LineNumber nextLineNumber ( ) {
		LineNumber valueholder = nextline_helper(hashmap.get(lastLineNumber).first(), hashmap.get(lastLineNumber).last());
		lastLineNumber = valueholder;
		return valueholder;
	}

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
