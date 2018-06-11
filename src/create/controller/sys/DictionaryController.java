package create.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import create.controller.core.BaseController;
import create.controller.core.page.Page;
import create.model.system.Dictionary;
import create.model.system.Dictionarydata;
import create.service.system.DictionaryDataService;
import create.service.system.DictionaryService;

/**
 * @author guohaihang
 */
@Controller
@RequestMapping("/dictionaryController")
public class DictionaryController extends BaseController {
	
	protected final Logger logger = Logger.getLogger(this.getClass());

	private DictionaryService dictionaryService;

	private DictionaryDataService dictionaryDataService;

	@RequestMapping("/queryDictionaryList")
	public String queryDictionaryList(Dictionary dictionary,
			HttpServletRequest request) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			String pageNow = request.getParameter("pageNow");
			List<Dictionary> dictionaryInfoList = null;
			// 查询条件
			if (dictionary.getDictName() != null
					&& !"".equals(dictionary.getDictName())) {
				params.put("dictName", dictionary.getDictName());
			}
			if (dictionary.getDescribe_dict() != null
					&& !"".equals(dictionary.getDescribe_dict())) {
				params.put("describe_dict", dictionary.getDescribe_dict());
			}
			if (dictionary.getCreatedby() != null
					&& !"".equals(dictionary.getCreatedby())) {
				params.put("createdby", dictionary.getCreatedby());
			}
			// 获取总条数
			Long totalCount = this.dictionaryService.pageCounts(params);
			// 设置分页对象
			Page page = executePage(request, totalCount);
			// 设置分页页面信息
			params.put("startIndex", page.getBeginIndex());
			params.put("endIndex", page.getEndinIndex());
			// 如排序
			if (page.isSort()) {
				params.put("orderName", page.getSortName());
				params.put("descAsc", page.getSortState());
			} else {
				// 没有进行排序,默认排序方式
				params.put("orderName", "age");
				params.put("descAsc", "asc");
			}
			dictionaryInfoList = dictionaryService.pageListByParamMap(params);
			request.setAttribute("dictionaryInfoList", dictionaryInfoList);
			request.setAttribute("page", page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "system/dictionaryList";
	}

	@RequestMapping("/toAddDictionary")
	public String toAddDictionary(HttpServletRequest request) {
		return "system/toAddDictionary";
	}

	@RequestMapping("/toDictionaryOperation")
	public String toDictionaryOperation(HttpServletRequest request, String id,
			String dotype) {
		// 字典值
		request.setAttribute("dictValue", dictionaryService.getMaxId());
		// 字典值
		Dictionary dictionary = dictionaryService.selectByPrimaryKey(Integer
				.valueOf(id));
		request.setAttribute("dictionary", dictionary);
		// 新增dotype=0 ,修改 dotype=1,查看dotype=2
		request.setAttribute("dotype", dotype);
		return "system/toDictionaryOperation";
	}

	@RequestMapping("/upDateDictionary")
	public ModelAndView upDateDictionary(HttpServletRequest request,
			Dictionary dictionary) {
		dictionaryService.updateDictionaryInfoByPrimaryKeySelective(dictionary);
		return new ModelAndView(
				"redirect:/dictionaryController/queryDictionaryList.go");
	}

	@RequestMapping("/saveDictionary")
	public ModelAndView saveDictionary(Dictionary dictionary,
			HttpServletRequest request) {
		dictionary.setIsdeleted("1");
		dictionaryService.insertDictionarySelective(dictionary);
		return new ModelAndView(
				"redirect:/dictionaryController/queryDictionaryList.go");
	}

	@RequestMapping("/toAddDictionaryData")
	public String toAddDictionaryData(HttpServletRequest request,
			String dictValue) {
		// 字典值
		request.setAttribute("dictValue", dictValue);
		return "system/toAddDictionaryData";
	}

	// 跳转到新增、修改、查看页面
	@RequestMapping("/toDictionaryOperationData")
	public String toDictionaryOperationData(HttpServletRequest request,
			String id, String dotype, String dictValue) {
		if (id != null && !"".equals(id)) {
			// 字典值
			Dictionarydata dictionarydata = dictionaryDataService
					.selectByPrimaryKey(Integer.valueOf(id));
			request.setAttribute("dictionarydata", dictionarydata);
		}
		request.setAttribute("dictValue", dictValue);
		// 新增dotype=0 ,修改 dotype=1,查看dotype=2
		request.setAttribute("dotype", dotype);
		return "system/toDictionaryDataOperation";
	}

	@RequestMapping("/saveDictionaryData")
	public ModelAndView saveDictionaryData(Dictionarydata dictionarydata,
			HttpServletRequest request) {
		// 0标志表示未删除
		dictionarydata.setIsfixed(Integer.valueOf(0));
		dictionaryDataService.insertDictionaryDataSelective(dictionarydata);
		return new ModelAndView(
				"redirect:/dictionaryController/queryDictionaryDataList.go?dictValue="
						+ dictionarydata.getDictValue());
	}

	@RequestMapping("/upDateDictionaryData")
	public ModelAndView upDateDictionaryData(HttpServletRequest request,
			Dictionarydata dictionarydata) {
		dictionaryDataService
				.updateDictionaryDataInfoByPrimaryKeySelective(dictionarydata);
		return new ModelAndView(
				"redirect:/dictionaryController/queryDictionaryDataList.go?dictValue="
						+ dictionarydata.getDictValue());
	}

	@RequestMapping("/queryDictionaryDataList")
	public String queryDictionaryDataList(Dictionarydata dictionarydata,
			HttpServletRequest request) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			String pageNow = request.getParameter("pageNow");
			List<Dictionarydata> dictionaryDataInfoList = null;
			// 查询条件
			if (dictionarydata.getDictValue() != null) {
				params.put("dictValue", dictionarydata.getDictValue());
			}
			// 获取总条数
			Long totalCount = this.dictionaryService.pageCounts(params);
			// 设置分页对象
			Page page = executePage(request, totalCount);
			// 设置分页页面信息
			params.put("startIndex", page.getBeginIndex());
			params.put("endIndex", page.getEndinIndex());
			// 如排序
			if (page.isSort()) {
				params.put("orderName", page.getSortName());
				params.put("descAsc", page.getSortState());
			} else {
				// 没有进行排序,默认排序方式
				params.put("orderName", "age");
				params.put("descAsc", "asc");
			}
			dictionaryDataInfoList = dictionaryDataService
					.pageListByParamMap(params);
			request.setAttribute("dictionaryDataInfoList",
					dictionaryDataInfoList);
			request.setAttribute("dictionarydata", dictionarydata);
			request.setAttribute("page", page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "system/dictionaryDataList";
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	@Autowired
	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public DictionaryDataService getDictionaryDataService() {
		return dictionaryDataService;
	}

	@Autowired
	public void setDictionaryDataService(
			DictionaryDataService dictionaryDataService) {
		this.dictionaryDataService = dictionaryDataService;
	}

}
