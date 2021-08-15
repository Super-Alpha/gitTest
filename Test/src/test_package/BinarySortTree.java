package test_package;
/*
 * �����������Ĵ����ͱ����Լ�ɾ��
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


//��������������
class ConstructBST{
	
	private Node root;
	
	//����Ҫɾ���Ľڵ�
	public Node search(int value) {
		if (root==null) {
			return null;
		}else {
			return root.search(value);
		}
	}
	
	//����Ҫɾ���ڵ�ĸ��ڵ�
	public Node searchParent(int value) {
		if (root==null) {
			return null;
		}else {
			return root.searchParent(value);
		}
	}
	
	
	//������nodeΪ���ڵ�Ķ�������������С�ڵ��ֵ����ɾ����С�ڵ�
	public int delRightTreeMin(Node node) {
		Node target = node;
		//ѭ��Ѱ����Сֵ�ڵ�
		while(target.left!=null) {
			target=target.left;
		}
		//��ʱtarget��ָ������С�ڵ�
		delNode(target.value);//ɾ��
		return target.value;
	}
	
	
	//ɾ���ڵ�
	public void delNode(int value) {
		if (root==null) {
			return;
		}else {
			//Ѱ��Ŀ��ڵ�
			Node targetNode = search(value);
			//��û���ҵ�Ҫɾ���Ľڵ�
			if (targetNode==null) {
				return;
			}
			//����ǰ������ֻ��һ���ڵ�
			if(root.left==null && root.right==null) {
				root = null;
				return;
			}
			//Ѱ�Ҹ��ڵ�
			Node parent = searchParent(value);
			
			//(1)���ɾ���Ľڵ���Ҷ�ӽڵ�
			if(targetNode.left==null && targetNode.right==null) {
				//�ж�tergetNode��parent�����ӽڵ㻹�����ӽڵ�
				if(parent.left != null && parent.left.value == value) {
					parent.left = null;
				}else if(parent.right!=null && parent.right.value==value){
					parent.right = null;
				}
			//(2)���ɾ�������������Ľڵ�
			}else if(targetNode.left!=null && targetNode.right!=null){
				int minVal = delRightTreeMin(targetNode.right);
				targetNode.value = minVal;
			//(3)���ɾ��ֻ��һ�������Ľڵ�
			}else {
				//���ɾ���Ľڵ���һ�����ӽڵ�
				if(targetNode.left!=null) {
					if (parent!=null) {
						//���targetNode��parent�����ӽڵ�
						if(parent.left.value==value) {
							parent.left=targetNode.left;
						}else {
							//���targetNode��parent�����ӽڵ�
							parent.right=targetNode.left;
						}
					}else {
						root = targetNode.left;
					}
				}else {//���ɾ���Ľڵ������ӽڵ�
					if (parent!=null) {
						//���targetNode��parent�����ӽڵ�
						if(parent.left.value==value) {
							parent.left=targetNode.right;
						}else {
							//���targetNode��parent�����ӽڵ�
							parent.right=targetNode.right;
						}
					}else {
						root = targetNode.right;
					}
				}
				
			}
		}
	}
	
	
	//�ڶ���������ӽڵ�
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



//����node�ڵ�
class Node{
	
	int value;
	Node left ;
	Node right;
	
	public Node(int value) {
		
		this.value = value;
	}
	/*
	 * Ѱ�Ҹ���ֵ�Ľڵ�
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
	 * Ѱ�Ҹ���ֵ�ڵ�ĸ��ڵ�
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
	
	//��ӽڵ�
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
	//�������
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