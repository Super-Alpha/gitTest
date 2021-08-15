package AVL;

/*
 * ����һ�����У���������Ӧ��ƽ�������
 * */
public class AVLTreeDemo {
	public static void main(String[] args) {
		//int[] arr = {4,3,6,5,7,8};
		//int[] arr = {10,12,8,9,7,6};
		
		int[] arr = {10,11,7,6,8,9};		
		//����һ��AVLTree����
		AVLTree avlTree=new AVLTree();
		//��ӽڵ�
		for (int i=0;i<arr.length;i++) {
			avlTree.add(new Node(arr[i]));
		}
		
		//�������
		System.out.println("�������");
		avlTree.infixOrder();
		
		System.out.println("���ĸ߶ȣ�" + avlTree.getRoot().height());
		System.out.println("�����������߶ȣ�" + avlTree.getRoot().left.height());
		System.out.println("�����������߶ȣ�" + avlTree.getRoot().right.height());
		System.out.println("��ǰ���ڵ��ֵ��" + avlTree.getRoot().value);

		
	}

}


//����AVL��
class AVLTree{
	private Node root;
	
	//���Ҹ��ڵ�
	public Node getRoot() {
		return root;
		
	}
	
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


//�����ڵ�
class Node{
	int value;
	Node left;
	Node right;
	public Node(int value) {
		this.value=value;
	}
	
	//�����������ĸ߶�
	public int leftHeight() {
		if (left==null) {
			return 0;
		}
		return left.height();
	}
	
	//�����������ĸ߶�
	public int rightHeight() {
		if (right==null) {
			return 0;
		}
		return right.height();
	}
	
	
	//���ص�ǰ�ڵ�ĸ߶ȣ��Ըýڵ�Ϊ���ڵ�����ĸ߶�
	public int height() {
		return Math.max(left==null? 0 : left.height(), right==null? 0 : right.height())+1;
	}
	
	
	//��������
	private void leftRotate() {
		//�����µĽڵ㣬�Ե�ǰ���ڵ��ֵ
		Node newNode = new Node(value);
		//���µĽڵ�����������óɵ�ǰ�ڵ��������
		newNode.left = left;
		//�ѵ�ǰ�ڵ������������������Ϊ�½ڵ��������
		newNode.right = right.left;
		//�ѵ�ǰ�ڵ��ֵ�滻�����ӽڵ��ֵ
		value = right.value;
		//�ѵ�ǰ�ڵ�����������ó�Ϊ��ǰ�ڵ���������������
		right=right.right;
		//���½ڵ�����Ϊ��ǰ�ڵ�����ӽڵ�
		left=newNode;
	}
	
	//��������
	private void rightRotate() {
		//�Ե�ǰ���ڵ��ֵ��Ϊ�ڵ�ֵ�������µĽڵ�
		Node newNode = new Node(value);
		//�ѵ�ǰ�ڵ����������Ϊ�½ڵ��������
		newNode.right = right;
		//�ѵ�ǰ�ڵ������������������Ϊ�½ڵ��������
		newNode.left = left.right;
		//�����ӽڵ��ֵ��Ϊ��ǰ�ڵ��ֵ
		value = left.value;
		//�ѵ�ǰ�ڵ������������������Ϊ��ǰ�ڵ��������
		left = left.left;
		//���½ڵ�����Ϊ��ǰ�ڵ��������
		right = newNode;
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
		
		//�������һ���ڵ�֮����������������߶�-�������߶ȣ�>1,���������ת
		if ((rightHeight()-leftHeight())>1) {
			//�����ǰ�ڵ�����������������߶ȴ��ڵ�ǰ�ڵ����������������߶�
			if(right != null && right.leftHeight()>right.rightHeight()) {
				//�ȶԵ�ǰ�ڵ�����ӽڵ��������ת
				right.rightRotate();
				//�ٶԵ�ǰ�ڵ��������ת
				leftRotate();
			}else {
				//ֱ�ӽ�������ת
				leftRotate();
			}
			return;//�жϺ������������
		}
		
		//����������ĸ߶�-�������ĸ߶�>1
		if ((leftHeight()-rightHeight())>1) {
			//�����ǰ�ڵ�����������������߶ȴ��ڵ�ǰ�ڵ����������������߶�
			if(left != null && left.rightHeight() > left.leftHeight()){
				//�ȶԵ�ǰ�ڵ����ڵ㣨����������������ת
				left.leftRotate();
				//�ٶԵ�ǰ�ڵ��������ת
				rightRotate();
			}else {
				//ֱ�ӽ�������ת����
				rightRotate();
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
