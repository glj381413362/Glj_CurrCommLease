package com.CCL.model;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

public class MTree_fuzhuang extends JTree
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3331152583299579341L;
	private JTree tree;
  public  JTree getTree() {
		return tree;
	}
public MTree_fuzhuang()
  {
	super();
	  DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(
		        "服装");
		      DefaultMutableTreeNode childNode1 = new DefaultMutableTreeNode(
		        "1管理");
		      DefaultMutableTreeNode childNode2 = new DefaultMutableTreeNode(
		        "2管理");
		      DefaultMutableTreeNode childNode3 = new DefaultMutableTreeNode(
		        "系统管理");
		      DefaultMutableTreeNode childNode4 = new DefaultMutableTreeNode(
		  	        "系统维护");
		      DefaultMutableTreeNode childNode5 = new DefaultMutableTreeNode(
		        "帮助");
		      rootNode.add(childNode1);
		      rootNode.add(childNode2);
		      rootNode.add(childNode3);
		      rootNode.add(childNode4);
		      rootNode.add(childNode5);
    
    setExpandedState(new TreePath(rootNode), true);//默认树展开
    expandRow(0);
    this.tree = new JTree(rootNode);
    //句柄展开时的图标
  	Icon ExpandedIcon=new ImageIcon("images/MJBtn/tree自行车.png");

  	//句柄折叠时的图标
  	Icon CollapsedIcon=new ImageIcon("images/MJBtn/tree自行车.png");

  	//叶节点的图标，也就是下面没有子结点的节点图标
  	Icon LeafIcon=new ImageIcon("images/MJBtn/tree自行车.png");

  	//非叶节点关闭时的图标，也就是下面有子结点的节点图标
  	Icon ClosedIcon=new ImageIcon("images/MJBtn/tree自行车.png");
  //非叶节点打开时的图标
  	Icon OpenedIcon=new ImageIcon("images/MJBtn/tree收银.png");

  	
  	DefaultTreeCellRenderer render=(DefaultTreeCellRenderer)(tree.getCellRenderer());render.setLeafIcon(LeafIcon);render.setClosedIcon(ClosedIcon);render.setOpenIcon(OpenedIcon);
  //设置树节点字体
  	tree.setFont(new Font("楷体", Font.ITALIC, 13));
  	BasicTreeUI ui=(BasicTreeUI)(tree.getUI());
  //重新刷新树
//  	tree.updateUI();
  }
}
