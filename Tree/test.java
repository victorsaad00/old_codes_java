package Tree;

public class test {
	public static void main(String[] args) throws Exception{
		Tree tree = new Tree();
		
		tree.add(10);
		tree.add(1011);
		tree.add(110);
		tree.add(1043);
		tree.add(140);
		tree.add(103);
		tree.add(220);
		tree.add(232);
		tree.add(20);
		tree.add(30);
		tree.add(50);
		
		System.out.println(tree.calcularAlturaNode(140));
		
	}
}
