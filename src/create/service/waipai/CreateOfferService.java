package create.service.waipai;

import create.model.waipai.Createoffer;

public interface CreateOfferService {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Createoffer record);

    int insertSelective(Createoffer record);

    Createoffer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Createoffer record);

    int updateByPrimaryKey(Createoffer record);

}
