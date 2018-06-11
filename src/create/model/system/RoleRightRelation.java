package create.model.system;

public class RoleRightRelation {
	
    private Integer trrId;

    private Integer rightId;

    private Integer roleId;

    private Integer rightType;

    public Integer getTrrId() {
        return trrId;
    }

    public void setTrrId(Integer trrId) {
        this.trrId = trrId;
    }

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRightType() {
        return rightType;
    }

    public void setRightType(Integer rightType) {
        this.rightType = rightType;
    }
}