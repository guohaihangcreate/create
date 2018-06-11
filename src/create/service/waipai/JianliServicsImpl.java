package create.service.waipai;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import create.dao.waipai.JianLiMapper;
import create.model.waipai.JianLi;

@Service("jianliServicsImpl")
public class JianliServicsImpl implements JianliService {

	private JianLiMapper jianLiMapper;

	public JianLiMapper getJianLiMapper() {
		return jianLiMapper;
	}

	@Autowired
	public void setJianLiMapper(JianLiMapper jianLiMapper) {
		this.jianLiMapper = jianLiMapper;
	}

	public int insertJianLi(JianLi jl) {
		// TODO Auto-generated method stub
		return jianLiMapper.insert(jl);
	}

	public int updateJianLi(JianLi jl) {
		// TODO Auto-generated method stub
		return jianLiMapper.updateByPrimaryKeySelective(jl);
	}

	public List<JianLi> QueryJianLiList(JianLi jl) {
		// TODO Auto-generated method stub
		return this.jianLiMapper.selectByPropery(jl);
	}

	public JianLi selectByPrimaryKey(Integer pId) {
		// TODO Auto-generated method stub
		return jianLiMapper.selectByPrimaryKey(pId);
	}

	public List<JianLi> selectJianLisByProperyForPage(Integer startPos,
			Integer pageSize) {
		return jianLiMapper.selectJianLisByProperyForPage(startPos, pageSize);
	}

	public int getJianLisCount(JianLi jl) {
		return jianLiMapper.getJianLisCount(jl);
	}

	// 分页总条数
	public Long pageCounts(Map<String, Object> p) {
		return jianLiMapper.pageCounts(p);
	}

	public List<JianLi> pageList(Long startIndex, Long endIndex, JianLi jl) {
		return this.jianLiMapper.pageList(startIndex, endIndex, jl);
	}

	// 分页查询接受Map类型的参数
	public List<JianLi> pageListByParamMap(Map param) {
		return this.jianLiMapper.pageListByParamMap(param);
	}
	
//	通过拼接sql查询简历
	public List<JianLi> pageDataBySqlParamMap(Map param){
		return this.jianLiMapper.pageDataBySqlParamMap(param);
	}

	public Long pageCountsBySqlParamMap(Map param) {
		// TODO Auto-generated method stub
		return this.jianLiMapper.pageCountsBySqlParamMap(param);
	}
}
