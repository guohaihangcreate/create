package create.service.system;


import java.util.List;
import java.util.Map;

import create.model.hrm.Treenodes;

public interface TreeNodeService {

	public int insertTreenodes(Treenodes treenodes);
	
	public  String getChild(String treeId);
	
	public  String getRoot(String treeId);
	
	public int editeTreeNodes(Treenodes treenodes);
	
	public int deleteTreeNodes(Integer id);
	
	public List<Treenodes> selectByPid(Integer pid);
	
	List<Treenodes> selectTreenodesByMap(Map paraMap);
	
	Treenodes selectByPrimaryKey(Integer id);
	
	public  String selectEasyUiDateTree(String treeId);
	
	public List<Treenodes> findTreenodes(Integer roleId);
	
	public List<Treenodes> selectTreeDateForList();
	
	Treenodes selectByPrimaryKeyAndPid(Integer id);
	
	
}
