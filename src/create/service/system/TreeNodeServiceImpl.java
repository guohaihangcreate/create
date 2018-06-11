package create.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.hrm.TreenodesMapper;
import create.model.hrm.Treenodes;
import create.model.tree.BaseTreeNode;
import create.service.hrm.UserService;

@Service("treeNodeService")
public class TreeNodeServiceImpl implements TreeNodeService {

	String tempStr = "";

	private TreenodesMapper treenodesMapper;

	private Treenodes treenodes;

	public TreenodesMapper getTreenodesMapper() {
		return treenodesMapper;
	}

	@Autowired
	public void setTreenodesMapper(TreenodesMapper treenodesMapper) {
		this.treenodesMapper = treenodesMapper;
	}
	
	
	public Treenodes selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return treenodesMapper.selectByPrimaryKey(id);
	}

	public int editeTreeNodes(Treenodes treenodes) {
		// TODO Auto-generated method stub
		return treenodesMapper.updateByPrimaryKeySelective(treenodes);
	}

	public int insertTreenodes(Treenodes treenodes) {
		// TODO Auto-generated method stub
		return treenodesMapper.insertSelective(treenodes);
	}

	public boolean iSparent(Integer treeId) {
		boolean isparent = false;
		if (treenodesMapper.isParent(treeId) > 0) {
			isparent = true;
		}
		return isparent;
	}

	public String selectEasyUiDateTree(String treeId) {
		String s = "[";
		Treenodes node = null;
		List<Treenodes> children = null;
		if (treeId == null || "".equals(treeId)) {
			children = treenodesMapper.selectByPid(Integer.valueOf(0));
			s += "{\"id\":" + 0 + ",\"text\":" + "\"系统菜单\"";
		}
		s += ",\"children\":[";
		if (children != null && children.size() > 0) {
			for (Treenodes d : children) {
				// 添加children节点
				s += "{\"id\":" + d.getId() + ",\"text\":\"" + d.getName()
						+ "\"";
				List<Treenodes> nodechildren = treenodesMapper.selectByPid(d
						.getId());
				if (nodechildren != null && nodechildren.size() > 0) {
					s += ",\"children\":[";
					for (Treenodes dr : nodechildren) {
						// 添加children节点
						List<Treenodes> nods = treenodesMapper.selectByPid(dr
								.getId());
						if (nods != null && nods.size() > 0) {
							s += "{\"id\":" + dr.getId() + ",\"text\":\""
							+ dr.getName() + "\",";
							s += "\"children\":[";
							for (Treenodes des : nods) {
								s += "{\"id\":" + des.getId() + ",\"text\":\""
										+ des.getName() + "\"},";
							}
							s = s.subSequence(0, s.lastIndexOf(",")) + "]},";
						}else{
							s += "{\"id\":" + dr.getId() + ",\"text\":\""
							+ dr.getName() + "\"},";
						}
					}
					s = s.subSequence(0, s.lastIndexOf(",")) + "]},";
				}
			}
		}
		s = s.subSequence(0, s.lastIndexOf(",")) + "]}]";
		return s;
	}

	public List<Treenodes> selectTreeDateForList() {
		// TODO Auto-generated method stub
		return treenodesMapper.selectTreeDateForList();
	}

	public String getChild(String treeId) {
		// TODO Auto-generated method stub
		String s = "[";
		List<Treenodes> children = treenodesMapper.selectByPid(Integer
				.valueOf(treeId));
		for (Treenodes node : children) {
			s += "{\"id\":\"" + node.getId() + "\",\"name\":\""
					+ node.getName() + "\",\"url\":\"" + node.getUrl()
					+ "\",\"isParent\":" + iSparent(node.getId())
					+ ",\"nocheck\":" + false + "},";
		}
		s = s.substring(0, s.length() - 1);
		s += "]";
		return s;
	}

	public String getRoot(String treeId) {
		// TODO Auto-generated method stub
		String s = "";
		Treenodes node = treenodesMapper.selectByPrimaryKey(Integer
				.valueOf(treeId));
		s = "[";
		s += "{\"id\":\"" + node.getId() + "\",\"name\":\"" + node.getName()
				+ "\",\"isParent\":"
				+ treenodesMapper.isParent(Integer.valueOf(treeId)) + "}";
		s = s.substring(0, s.length() - 1);
		s += "]";
		return s;
	}

	public int deleteTreeNodes(Integer id) {
		// TODO Auto-generated method stub
		return treenodesMapper.deleteByPrimaryKey(id);
	}

	public List<Treenodes> selectByPid(Integer pid) {
		// TODO Auto-generated method stub
		return treenodesMapper.selectByPid(pid);
	}

	public List<Treenodes> findTreenodes(Integer roleId) {
		// TODO Auto-generated method stub
		return treenodesMapper.findTreenodes(roleId);
	}

	public Treenodes selectByPrimaryKeyAndPid(Integer id) {
		// TODO Auto-generated method stub
		return treenodesMapper.selectByPrimaryKeyAndPid(id);
	}

	public List<Treenodes> selectTreenodesByMap(Map paraMap) {
		// TODO Auto-generated method stub
		return treenodesMapper.selectTreenodesByMap(paraMap);
	}

}
