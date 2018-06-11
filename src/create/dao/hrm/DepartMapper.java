package create.dao.hrm;

import java.util.List;

import create.model.hrm.Depart;

public interface DepartMapper {
	
    int deleteByPrimaryKey(Integer deptId);

    int insert(Depart record);

    int insertSelective(Depart record);

    Depart selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(Depart record);
	
    List<Depart> searchDepartByProperty(Depart dept);

    int updateByPrimaryKey(Depart record);
}