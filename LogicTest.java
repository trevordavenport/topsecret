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
	
	// This test asserts that Logic.treeEqualsHelper returns TRUE when
	// both of its arguments are null
	@Test
	public void treeEqualsHelperTwoNullArgsTest() {
		Logic log = new Logic();
		TreeNode tree1 = null;
		TreeNode tree2 = null;
		assertTrue(log.treeEqualsHelper(tree1, tree2));
	}
	
	// This test asserts that Logic.treeEqualsHelper returns FALSE when
	// its arguments' myItems are not equal
	@Test
	public void treeEqualsHelperUnequalItemsTest() {
		Logic log = new Logic();
		TreeNode tree1 = new TreeNode("a");
		TreeNode tree2 = new TreeNode("b");
		assertFalse(log.treeEqualsHelper(tree1, tree2));
	}
	
	// This test asserts that Logic.treeEqualsHelper returns TRUE when
	// its arguments' children and myItems are equal
	@Test
	public void treeEqualsHelperEquivalentTwoGenerationTreesTest() {
		Logic log = new Logic();
		TreeNode tree1 = new TreeNode("a", new TreeNode("b"), new TreeNode("c"));
		TreeNode tree2 = new TreeNode("a", new TreeNode("b"), new TreeNode("c"));
		assertTrue(log.treeEqualsHelper(tree1, tree2));
	}
	
	// This test asserts that Logic.treeEqualsHelper returns FALSE when
	// its arguments myItems are equal but its children are not
	@Test
	public void treeEqualsHelperUnequalChildrenTest() {
		Logic log = new Logic();
		TreeNode tree1 = new TreeNode("a", new TreeNode("b"), new TreeNode("c"));
		TreeNode tree2 = new TreeNode("a", new TreeNode("b"), new TreeNode("d"));
		assertFalse(log.treeEqualsHelper(tree1, tree2));
	}
	
	// This tests asserts that Logic.treeEqualsHelper returns TRUE when
	// its arguments are two equivalent, three-generation trees
	@Test
	public void treeEqualsHelperEquivalentThreeGenerationTest() {
		Logic log = new Logic();
		TreeNode tree1 = new TreeNode("a", tree3, tree5);
		TreeNode tree2 = new TreeNode("a", tree4, tree6);
		TreeNode tree3 = new TreeNode("d", new TreeNode("e"), new TreeNode("f"));
		TreeNode tree4 = new TreeNode("d", new TreeNode("e"), new TreeNode("f"));
		TreeNode tree5 = new TreeNode("g", new TreeNode("h"), new TreeNode("i"));
		TreeNode tree6 = new TreeNode("g", new TreeNode("h"), new TreeNode("i"));
		assertTrue(log.treeEqualsHelper(tree1, tree2));
	}
	
	// This tests asserts that Logic.treeEqualsHelper returns TRUE when
	// its arguments are two equivalent, unbalanced, three-generation trees
	@Test
	public void treeEqualsHelperEquivalentUnbalancedThreeGenerationTest() {
		Logic log = new Logic();
		TreeNode tree1 = new TreeNode("a", tree3, tree5);
		TreeNode tree2 = new TreeNode("a", tree4, tree6);
		TreeNode tree3 = new TreeNode("d", new TreeNode("e"), new TreeNode("f"));
		TreeNode tree4 = new TreeNode("d", new TreeNode("e"), new TreeNode("f"));
		TreeNode tree5 = new TreeNode("g", new TreeNode("h"), null);
		TreeNode tree6 = new TreeNode("g", new TreeNode("h"), null);
		assertTrue(log.treeEqualsHelper(tree1, tree2));
	}
	
	
	
}
