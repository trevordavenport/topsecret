import static org.junit.Assert.*;

import org.junit.Test;

public class LogicTest {

	// This tests asserts that an IllegalArgumentException is
	// thrown when the first arg to Logic.treeEquals is null
	@Test
	public void treeEqualsLeftNullTest() {
		TreeNode tree1 = null;
		TreeNode tree2 = new TreeNode(1);
		String err = "";
		try {
			Logic.treeEquals(tree1, tree2);
		}
		catch(IllegalArgumentException e) {
			err = e.getMessage();
		}
		assertTrue(err.equals
				("<relevant error message from IllegalLineException"));
	}
	
	// This test asserts that an IllegalArgumentException is
	// thrown when the second arg to Logic.treeEquals is null
	@Test
	public void treeEqualsRightNullTest() {
		TreeNode tree1 = new TreeNode(1);
		TreeNode tree2 = null;
		String err = "";
		try {
			Logic.treeEquals(tree1, tree2);
		}
		catch(IllegalArgumentException e) {
			err = e.getMessage();
		}
		assertTrue(err.equals
				("<relevant error message from IllegalLineException"));
	}
	
}
