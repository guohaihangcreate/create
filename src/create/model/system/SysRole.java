package create.model.system;

import java.io.Serializable;
import java.util.Date;


public class SysRole implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer roleId;

    private String roleName;

    private String roleMark;

    private Integer parentTrId;

    private Date genTime;

    private String description;

    private Integer createby;

    private Integer state;
    
    private String aoth_list;
    //	角色成员
    private String role_list;
    //角色权限列表
    private String right_list;
    
    private Integer  user_member;
    
    

    public String getAoth_list() {
		return aoth_list;
	}

	public void setAoth_list(String aoth_list) {
		this.aoth_list = aoth_list;
	}

	public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleMark() {
        return roleMark;
    }

    public void setRoleMark(String roleMark) {
        this.roleMark = roleMark == null ? null : roleMark.trim();
    }

    public Integer getParentTrId() {
        return parentTrId;
    }

    public void setParentTrId(Integer parentTrId) {
        this.parentTrId = parentTrId;
    }

    public Date getGenTime() {
        return genTime;
    }

    public void setGenTime(Date genTime) {
        this.genTime = genTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	public String getRole_list() {
		return role_list;
	}

	public void setRole_list(String role_list) {
		this.role_list = role_list;
	}

	public String getRight_list() {
		return right_list;
	}

	public void setRight_list(String right_list) {
		this.right_list = right_list;
	}

	public Integer getUser_member() {
		return user_member;
	}

	public void setUser_member(Integer user_member) {
		this.user_member = user_member;
	}
}