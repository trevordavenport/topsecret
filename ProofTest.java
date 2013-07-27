import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;


public class ProofTest {
	//	ArrayList<String> ops = new ArrayList<String>();
	//	ops.add("this");
	//	ops.add("show");
	//	ops.add("repeat");
	//	ops.add("assume");
	//	ops.add("ic");
	//	ops.add("mt");
	//	ops.add("mp");
	//	ops.add("co");
	//	ops.add("print");
	
	/* GENERAL TEST CASES */
	
	// Assert than an IllegalLineException is thrown when
	// line does not hold anything but whitespace
	@Test
	public void extendProofWhiteSpaceWithoutReason() {
		String err = "";
		
		Proof proof = new Proof(new TheoremSet());
		
		try {
			proof.extendProof(" ");
		} catch(IllegalLineException e) {
			err = e.getMessage();
		}
		assertTrue(err.equals("<error message from IllegalLineException"));
	}
	
	/* SHOW-SPECIFIC TEST CASES */

	// Tests that an IllegalLineException is thrown when
	// <expr> is not properly formatted for show
	// show syntax: show <expr>
	@Test
	public void extendProofBadExprTestShowTest() {
		String err = "";
		
		Proof proof = new Proof(new TheoremSet());
		
		try {
			proof.extendProof("show badexpr");
		} catch(IllegalLineException e) {
			err = e.getMessage();
		}
		assertTrue(err.equals("<error message from IllegalLineException"));
	}
	
	// Test that an IllegalLineException is thrown when
	// show and <expr> have no whitespace between
	@Test
	public void extendProofNoWhiteSpaceShowTest() {
		String err = "";
		
		Proof proof = new Proof(new TheoremSet());
		
		try {
			proof.extendProof("showexpr");
		} catch(IllegalLineException e) {
			err = e.getMessage();
		}
		assertTrue(err.equals("<error message from IllegalLineException"));
		
	}
	
	// Assert that an IllegalLineException is thrown when
	// line has too many arguments for "show"
	@Test
	public void extendProofTooManyArgsShowTest() {
		String err = "";
		
		Proof proof = new Proof(new TheoremSet());
		
		try {
			proof.extendProof("show <expr> <expr>");
		} catch(IllegalLineException e) {
			err = e.getMessage();
		}
		assertTrue(err.equals("<error message from IllegalLineException"));
	}
	
	// Assert that an IllegalLineException is thrown when
	// line has too few arguments for "show"
	@Test
	public void extendProofTooFewArgsShowTest() {
		String err = "";
		
		Proof proof = new Proof(new TheoremSet());
		
		try {
			proof.extendProof("show ");
		} catch(IllegalLineException e) {
			err = e.getMessage();
		}
		assertTrue(err.equals("<error message from IllegalLineException"));
	}
	
	/* ASSUME-SPECIFIC TEST CASES */
	
	// Assert that an IllegalLineException is thrown when
	// line has too many arguments for "assume"
	@Test
	public void extendProofTooManyArgsAssumeTest() {
		String err = "";
		
		Proof proof = new Proof(new TheoremSet());
		
		try {
			proof.extendProof("assume <expr> <expr>");
		} catch(IllegalLineException e) {
			err = e.getMessage();
		}
		assertTrue(err.equals("<error message from IllegalLineException"));
	}
	
	// Assert that an IllegalLineException is thrown when
	// line has too few arguments for assume
	@Test
	public void extendProofTooFewArgsAssumeTest() {
		String err = "";
		
		Proof proof = new Proof(new TheoremSet());
		
		try {
			proof.extendProof("assume ");
		} catch(IllegalLineException e) {
			err = e.getMessage();
		}
		assertTrue(err.equals("<error message from IllegalLineException"));
	}
	
	// Test that an IllegalLineException is thrown when
	// assume 
	@Test
	public void extendProofBadExprAssumeTest() {
		String err = "";
		
		Proof proof = new Proof(new TheoremSet());
		
		try {
			proof.extendProof("assume badexpr");
		} catch(IllegalLineException e) {
			err = e.getMessage();
		}
		assertTrue(err.equals("<error message from IllegalLineException"));
	}
	
	// Test that an IllegalLineException is thrown when
	// assume and <expr> have no whitespace between
	@Test
	public void extendProofNoWhiteSpaceAssumeTest() {
		String err = "";
		
		Proof proof = new Proof(new TheoremSet());
		
		try {
			proof.extendProof("assumeexpr");
		} catch(IllegalLineException e) {
			err = e.getMessage();
		}
		assertTrue(err.equals("<error message from IllegalLineException"));
		
	}
	
	/* REPEAT-SPECIFIC TEST CASES */
	
	// Test that an IllegalLineException is thrown when
	// Repeat has too few arguments <repeat " "> 
	@Test
	public void extendProofRepeatTooFewArgsTest() {
		String err = "";
		
		Proof proof = new Proof(new TheoremSet());
		
		try {
			proof.extendProof("repeat ");
		} catch(IllegalLineException e) {
			err = e.getMessage();
		}
		assertTrue(err.equals("<error message from IllegalLineException"));
		
	}	
	
	// Test that an IllegalLineException is thrown when
	// Repeat has too many arguments <repeat linenumber <expr> <expr> <expr>> 
	@Test
	public void extendProofRepeatTooManyArgsTest() {
		String err = "";
		
		Proof proof = new Proof(new TheoremSet());
		
		try {
			proof.extendProof("repeat linenumber <expr> <expr> <expr>");
		} catch(IllegalLineException e) {
			err = e.getMessage();
		}
		assertTrue(err.equals("<error message from IllegalLineException"));
		
	}
	

}
