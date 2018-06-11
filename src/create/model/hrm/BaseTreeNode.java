package create.model.hrm;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseTreeNode implements Serializable {

	
	private static final long serialVersionUID = 1L;
	/**定义树控件公共属性*/
	
	/**树控件ID*/
	protected String treeId;
	/**树控件的名称*/
	protected String treeName;
	/**树控件的父ID*/
	protected String parentId;	
	/**是否为父项,或者说是否有子项*/
	protected boolean isParent;
	/**控件标题*/
	protected String treeTitle;
	
	public String getTreeId() {
		return treeId;
	}
	public BaseTreeNode setTreeId(String treeId) {
		this.treeId = treeId;
		return this;
	}
	public String getTreeName() {
		return treeName;
	}
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	
	public boolean isParent() {
		return isParent;
	}
	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}
	public String getTreeTitle() {
		return treeTitle;
	}
	public void setTreeTitle(String treeTitle) {
		this.treeTitle = treeTitle;
	}
	
	public BaseTreeNode() {
		
	}
	
	public BaseTreeNode(String treeId, String treeName, String parentId,boolean isParent) {		
		this.treeId = treeId;
		this.treeName = treeName;
		this.parentId = parentId;				
		this.isParent = isParent;
	}	
	
	
	public BaseTreeNode(String treeId, String treeName, String parentId,boolean isHasChild,String treeTitle) {
		this(treeId,treeName,parentId,isHasChild);	
		this.treeTitle = treeTitle;
		
	}	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
