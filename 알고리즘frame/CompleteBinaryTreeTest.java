package 알고리즘frame;

public class CompleteBinaryTreeTest {
	
	public static void main(String[] args) {
		
		int size = 9;
		CompleteBinaryTree tree = new CompleteBinaryTree(size);
		
		for(int i=0; i<size; i++) {
			tree.add((char)(65+i));	// A,B,C,D,E..
		}
		
		tree.bfs();
		System.out.println();
		
		tree.bfs2();
		System.out.println();
		
		tree.dfsByPreOrder();
		System.out.println();
		
		tree.dfsByInOrder();
		System.out.println();
		
		tree.dfsByPostOrder();
		System.out.println();
		
	}
	
}
