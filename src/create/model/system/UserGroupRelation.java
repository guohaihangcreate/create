package create.model.system;
//用户和角色表
public class UserGroupRelation {
	
    private Integer tugId;
  //用户id
    private Integer tuId;
  //角色id
    private Integer tgId;

    public Integer getTugId() {
        return tugId;
    }

    public void setTugId(Integer tugId) {
        this.tugId = tugId;
    }

    public Integer getTuId() {
        return tuId;
    }

    public void setTuId(Integer tuId) {
        this.tuId = tuId;
    }

    public Integer getTgId() {
        return tgId;
    }

    public void setTgId(Integer tgId) {
        this.tgId = tgId;
    }
}