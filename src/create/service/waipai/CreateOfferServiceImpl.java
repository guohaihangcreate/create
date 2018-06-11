package create.service.waipai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.waipai.CreateofferMapper;
import create.model.waipai.Createoffer;
@Service("CreateOfferServiceImpl")
public class CreateOfferServiceImpl implements CreateOfferService {
	
	private CreateofferMapper createOffermaper;

	public CreateofferMapper getCreateOffermaper() {
		return createOffermaper;
	}
	@Autowired
	public void setCreateOffermaper(CreateofferMapper createOffermaper) {
		this.createOffermaper = createOffermaper;
	}

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Createoffer record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(Createoffer record) {
		// TODO Auto-generated method stub
		return createOffermaper.insertSelective(record);
	}

	public Createoffer selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByPrimaryKey(Createoffer record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKeySelective(Createoffer record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
