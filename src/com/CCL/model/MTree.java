package com.CCL.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

public class MTree extends JTree
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3331152583299579341L;
	private JTree tree;
  public  JTree getTree() {
		return tree;
	}
public MTree()
  {
	super();
	DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(
	        "自行车");
	      DefaultMutableTreeNode childNode1 = new DefaultMutableTreeNode(
	        "前台收银管理");
	      DefaultMutableTreeNode childNode2 = new DefaultMutableTreeNode(
	        "会员卡管理");
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
	Icon ExpandedIcon=new ImageIcon("images/MJBtn/自行车.png");

	//句柄折叠时的图标
	Icon CollapsedIcon=new ImageIcon("images/MJBtn/自行车.png");

	//叶节点的图标，也就是下面没有子结点的节点图标
	Icon LeafIcon=new ImageIcon("images/MJBtn/自行车.png");

	//非叶节点关闭时的图标，也就是下面有子结点的节点图标
	Icon ClosedIcon=new ImageIcon("images/MJBtn/自行车.png");
	Icon OpenedIcon=new ImageIcon("images/MJBtn/自行车.png");

	//非叶节点打开时的图标
	DefaultTreeCellRenderer render=(DefaultTreeCellRenderer)(tree.getCellRenderer());render.setLeafIcon(LeafIcon);render.setClosedIcon(ClosedIcon);render.setOpenIcon(OpenedIcon);

	BasicTreeUI ui=(BasicTreeUI)(tree.getUI());

	ui.setCollapsedIcon(CollapsedIcon);

	ui.setExpandedIcon(ExpandedIcon);

    
//    setExpandedState(new TreePath(rootNode), true);//默认树展开
//    expandRow(0);
    
  }
}
