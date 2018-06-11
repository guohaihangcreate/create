package create.dao.hrm;

import create.model.hrm.XinziDetail;

public interface XinziDetailMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(XinziDetail record);

    int insertSelective(XinziDetail record);

    XinziDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XinziDetail record);

    int updateByPrimaryKey(XinziDetail record);
}