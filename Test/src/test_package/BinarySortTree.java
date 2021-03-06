package test_package;
/*
 * 二叉排序树的创建和遍历以及删除
 * */
public class BinarySortTree {

	public static void main(String[] args) {
		
		int[] arr = {7,3,10,12,5,1,9,2};
		ConstructBST constructbst=  new ConstructBST();
		for (int i=0;i<arr.length;i++) {
			constructbst.add(new Node(arr[i]));
		}	
		constructbst.infixOrder();
		
		constructbst.delNode(7);
		constructbst.delNode(9);
		
		constructbst.infixOrder();
	}
}


//构建二叉搜索树
class ConstructBST{
	
	private Node root;
	
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



//创建node节点
class Node{
	
	int value;
	Node left ;
	Node right;
	
	public Node(int value) {
		
		this.value = value;
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