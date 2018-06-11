package create.model.hrm;

import java.util.List;

public class Treenodes {

	private Integer id;

	private Integer pid;

	private String name;

	private String url;

	private String title;

	private String target;

	private String icon;

	private Integer sort;

	private String fontstylename;

	private String iconopen;

	private Boolean open;
	
	private Integer type;
	
	private Integer selected;

	private List<Treenodes> sunTreeNodes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target == null ? null : target.trim();
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getFontstylename() {
		return fontstylename;
	}

	public void setFontstylename(String fontstylename) {
		this.fontstylename = fontstylename == null ? null : fontstylename
				.trim();
	}

	public String getIconopen() {
		return iconopen;
	}

	public void setIconopen(String iconopen) {
		this.iconopen = iconopen == null ? null : iconopen.trim();
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public List<Treenodes> getSunTreeNodes() {
		return sunTreeNodes;
	}

	public void setSunTreeNodes(List<Treenodes> sunTreeNodes) {
		this.sunTreeNodes = sunTreeNodes;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSelected() {
		return selected;
	}

	public void setSelected(Integer selected) {
		this.selected = selected;
	}

	
}