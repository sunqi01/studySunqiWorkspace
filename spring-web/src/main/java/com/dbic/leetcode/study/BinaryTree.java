package com.dbic.leetcode.study;

import java.util.ArrayList;
import java.util.List;

import com.sun.beans.editors.IntegerEditor;

public class BinaryTree {

	
	public class TreeNode {
		int val;
		TreeNode left;
      	TreeNode right;
      	TreeNode() {}
      	TreeNode(int val) { this.val = val; }
      	TreeNode(int val, TreeNode left, TreeNode right) {
      		this.val = val;
      		this.left = left;
      		this.right = right;
      	}
	}
	
	//前序遍历
	//前序是啥  先跟 再左 再右
	
	//非递归的 和 morris算法 还没看太明白 
	public List<Integer> preorderTraversal(TreeNode root) {
		
		//递归解法
		List<Integer> res = new ArrayList<>();
		preOrder(root,res);
		return res;
	}
	
	public void preOrder(TreeNode node,List<Integer> res)
	{
		if(node==null) {
			return;
		}
		res.add(node.val);
		preOrder(node.left, res);
		preOrder(node.right, res);
	}
	
	//中序遍历
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		inOrder(root,res);
		return res;
	}
	
	public void inOrder(TreeNode node,List<Integer> res)
	{
		if(node==null) {
			return;
		}
		inOrder(node.left, res);
		res.add(node.val);
		inOrder(node.right, res);
	}
}
