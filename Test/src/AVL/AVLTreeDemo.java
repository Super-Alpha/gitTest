package AVL;

/*
 * 给定一个数列，创建出对应的平衡二叉树
 * */
public class AVLTreeDemo {
	public static void main(String[] args) {
		//int[] arr = {4,3,6,5,7,8};
		//int[] arr = {10,12,8,9,7,6};
		
		int[] arr = {10,11,7,6,8,9};		
		//创建一个AVLTree对象
		AVLTree avlTree=new AVLTree();
		//添加节点
		for (int i=0;i<arr.length;i++) {
			avlTree.add(new Node(arr[i]));
		}
		
		//中序遍历
		System.out.println("中序遍历");
		avlTree.infixOrder();
		
		System.out.println("树的高度：" + avlTree.getRoot().height());
		System.out.println("树的左子树高度：" + avlTree.getRoot().left.height());
		System.out.println("树的右子树高度：" + avlTree.getRoot().right.height());
		System.out.println("当前根节点的值：" + avlTree.getRoot().value);

		
	}

}


//创建AVL树
class AVLTree{
	private Node root;
	
	//查找根节点
	public Node getRoot() {
		return root;
		
	}
	
	//查找要删除的节点
	public Node search(int value) {
		if (root==null) {
			return null;
		}else {
			return root.search(value);
		}
	}
	
	//查找要删除节点的父节点
	public Node searchParent(int value) {
		if (root==null) {
			return null;
		}else {
			return root.searchParent(value);
		}
	}
	
	
	//返回以node为根节点的二叉排序树的最小节点的值，并删除最小节点
	public int delRightTreeMin(Node node) {
		Node target = node;
		//循环寻找最小值节点
		while(target.left!=null) {
			target=target.left;
		}
		//这时target就指向了最小节点
		delNode(target.value);//删除
		return target.value;
	}
	
	
	//删除节点
	public void delNode(int value) {
		if (root==null) {
			return;
		}else {
			//寻找目标节点
			Node targetNode = search(value);
			//若没有找到要删除的节点
			if (targetNode==null) {
				return;
			}
			//若当前二叉树只有一个节点
			if(root.left==null && root.right==null) {
				root = null;
				return;
			}
			//寻找父节点
			Node parent = searchParent(value);
			
			//(1)如果删除的节点是叶子节点
			if(targetNode.left==null && targetNode.right==null) {
				//判断tergetNode是parent的左子节点还是右子节点
				if(parent.left != null && parent.left.value == value) {
					parent.left = null;
				}else if(parent.right!=null && parent.right.value==value){
					parent.right = null;
				}
			//(2)如果删除有两颗子树的节点
			}else if(targetNode.left!=null && targetNode.right!=null){
				int minVal = delRightTreeMin(targetNode.right);
				targetNode.value = minVal;
			//(3)如果删除只有一棵子树的节点
			}else {
				//如果删除的节点有一棵左子节点
				if(targetNode.left!=null) {
					if (parent!=null) {
						//如果targetNode是parent的左子节点
						if(parent.left.value==value) {
							parent.left=targetNode.left;
						}else {
							//如果targetNode是parent的右子节点
							parent.right=targetNode.left;
						}
					}else {
						root = targetNode.left;
					}
				}else {//如果删除的节点有右子节点
					if (parent!=null) {
						//如果targetNode是parent的左子节点
						if(parent.left.value==value) {
							parent.left=targetNode.right;
						}else {
							//如果targetNode是parent的右子节点
							parent.right=targetNode.right;
						}
					}else {
						root = targetNode.right;
					}
				}
				
			}
		}
	}
	
	
	//在二叉树中添加节点
	public void add(Node node) {
		if (root==null) {
			root=node;
		}else {
			root.add(node);
		}
	}
	
	public void infixOrder() {
		if (root!=null) {
			root.infixOrder();
		}else {
			System.out.println("BST is null,not be found!");
		}
	}
}


//创建节点
class Node{
	int value;
	Node left;
	Node right;
	public Node(int value) {
		this.value=value;
	}
	
	//返回左子树的高度
	public int leftHeight() {
		if (left==null) {
			return 0;
		}
		return left.height();
	}
	
	//返回右子树的高度
	public int rightHeight() {
		if (right==null) {
			return 0;
		}
		return right.height();
	}
	
	
	//返回当前节点的高度，以该节点为根节点的树的高度
	public int height() {
		return Math.max(left==null? 0 : left.height(), right==null? 0 : right.height())+1;
	}
	
	
	//左旋方法
	private void leftRotate() {
		//创建新的节点，以当前根节点的值
		Node newNode = new Node(value);
		//把新的节点的左子树设置成当前节点的左子树
		newNode.left = left;
		//把当前节点的右子树的左子树作为新节点的右子树
		newNode.right = right.left;
		//把当前节点的值替换成右子节点的值
		value = right.value;
		//把当前节点的右子树设置成为当前节点右子树的右子树
		right=right.right;
		//把新节点设置为当前节点的左子节点
		left=newNode;
	}
	
	//右旋方法
	private void rightRotate() {
		//以当前根节点的值作为节点值，创建新的节点
		Node newNode = new Node(value);
		//把当前节点的右子树作为新节点的右子树
		newNode.right = right;
		//把当前节点的左子树的右子树作为新节点的左子树
		newNode.left = left.right;
		//把左子节点的值作为当前节点的值
		value = left.value;
		//把当前节点的左子树的左子树作为当前节点的左子树
		left = left.left;
		//把新节点设置为当前节点的右子树
		right = newNode;
	}
	
	
	/*
	 * 寻找给定值的节点
	 */
	public Node search(int value) {
		if (value==this.value) {
			return this;
		}else if (value<this.value) {
			if (this.left==null) {
				return null;
			}
			return this.left.search(value);
		}else {
			if (this.right==null) {
				return null;
			}
			return this.right.search(value);
		}
	}
	
	/*
	 * 寻找给定值节点的父节点
	 */
	public Node searchParent(int value) {
		if ((this.left!=null && this.left.value==value)||(this.right!=null && this.right.value==value)) {
				return this;
		}else {
			if (value<this.value && this.left!=null) {
				return this.left.searchParent(value);
			}else if(value>=this.value && this.right!=null) {
				return this.right.searchParent(value);
			}else {
				return null;
			}
		}
	}
	
	//添加节点
	public void add(Node node) {
		
		if (node==null) {
			return;
		}
		if (node.value<this.value) {
			if (this.left == null) {
				this.left=node;
			}else {
				this.left.add(node);
			}
		}else {
			if (this.right==null) {
				this.right=node;
			}else {
				this.right.add(node);
			}
		}
		
		//当添加完一个节点之后，如果：（右子树高度-左子树高度）>1,则进行左旋转
		if ((rightHeight()-leftHeight())>1) {
			//如果当前节点的右子树的左子树高度大于当前节点右子树的右子树高度
			if(right != null && right.leftHeight()>right.rightHeight()) {
				//先对当前节点的右子节点进行右旋转
				right.rightRotate();
				//再对当前节点进行左旋转
				leftRotate();
			}else {
				//直接进行左旋转
				leftRotate();
			}
			return;//中断后续代码的运行
		}
		
		//如果左子树的高度-右子树的高度>1
		if ((leftHeight()-rightHeight())>1) {
			//如果当前节点的左子树的右子树高度大于当前节点左子树的左子树高度
			if(left != null && left.rightHeight() > left.leftHeight()){
				//先对当前节点的左节点（左子树）进行左旋转
				left.leftRotate();
				//再对当前节点进行右旋转
				rightRotate();
			}else {
				//直接进行右旋转即可
				rightRotate();
			}
		}
	}
	//中序遍历
	public void infixOrder() {
		if (this.left!=null) {
			this.left.infixOrder();
		}
		System.out.printf("%d ",this.value);
		if (this.right!=null) {
			this.right.infixOrder();
		}	
	}
}
