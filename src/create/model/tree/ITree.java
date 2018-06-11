package create.model.tree;

import java.util.List;


public interface ITree {
	
	void add(BaseTreeNode tree);
	void del(BaseTreeNode tree);
	void update(BaseTreeNode tree);
	BaseTreeNode get(BaseTreeNode tree);
	boolean isExpand(BaseTreeNode tree);
	List<BaseTreeNode> getChildTree(BaseTreeNode tree);
}
