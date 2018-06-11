package create.model.crm;

import java.util.Date;

public class CustomerInfo {
	
	private String s_province;
	
	private String s_city;
	
	private String s_county;
	//销售人员
	private String sale;
	//显示销售人员
	private String sale_view;
	
    private Integer id;

    private String area;

    private String address;

    private String website;

    private Integer creditrating;

    private Integer customrate;

    private Integer customerproperty;

    private String business;

    private String needproducts;

    private String industry;

    private String customername;

    private String isdeleted;

    private String deletedby;

    private Date deletetime;

    private String createdby;

    private Date createtime;

    private String lastmodify;

    private Date lastmodifytime;

    private String att1;

    private String att2;

    private String att3;

    private String att4;

    private String att5;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public Integer getCreditrating() {
        return creditrating;
    }

    public void setCreditrating(Integer creditrating) {
        this.creditrating = creditrating;
    }

    public Integer getCustomrate() {
        return customrate;
    }

    public void setCustomrate(Integer customrate) {
        this.customrate = customrate;
    }

    public Integer getCustomerproperty() {
        return customerproperty;
    }

    public void setCustomerproperty(Integer customerproperty) {
        this.customerproperty = customerproperty;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business == null ? null : business.trim();
    }

    public String getNeedproducts() {
        return needproducts;
    }

    public void setNeedproducts(String needproducts) {
        this.needproducts = needproducts == null ? null : needproducts.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername == null ? null : customername.trim();
    }

    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted == null ? null : isdeleted.trim();
    }

    public String getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(String deletedby) {
        this.deletedby = deletedby == null ? null : deletedby.trim();
    }

    public Date getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby == null ? null : createdby.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getLastmodify() {
        return lastmodify;
    }

    public void setLastmodify(String lastmodify) {
        this.lastmodify = lastmodify == null ? null : lastmodify.trim();
    }

    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public String getAtt1() {
        return att1;
    }

    public void setAtt1(String att1) {
        this.att1 = att1 == null ? null : att1.trim();
    }

    public String getAtt2() {
        return att2;
    }

    public void setAtt2(String att2) {
        this.att2 = att2 == null ? null : att2.trim();
    }

    public String getAtt3() {
        return att3;
    }

    public void setAtt3(String att3) {
        this.att3 = att3 == null ? null : att3.trim();
    }

    public String getAtt4() {
        return att4;
    }

    public void setAtt4(String att4) {
        this.att4 = att4 == null ? null : att4.trim();
    }

    public String getAtt5() {
        return att5;
    }

    public void setAtt5(String att5) {
        this.att5 = att5 == null ? null : att5.trim();
    }

	public String getS_county() {
		return s_county;
	}

	public void setS_county(String s_county) {
		this.s_county = s_county;
	}

	public String getS_province() {
		return s_province;
	}

	public void setS_province(String s_province) {
		this.s_province = s_province;
	}

	public String getS_city() {
		return s_city;
	}

	public void setS_city(String s_city) {
		this.s_city = s_city;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public String getSale_view() {
		return sale_view;
	}

	public void setSale_view(String sale_view) {
		this.sale_view = sale_view;
	}
}