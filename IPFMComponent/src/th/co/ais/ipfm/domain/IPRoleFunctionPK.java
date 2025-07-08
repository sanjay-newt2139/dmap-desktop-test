package th.co.ais.ipfm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IPRoleFunctionPK implements Serializable{
	
	@Column(name="ROLE_ID", unique=true, nullable=false, length=10)
    private String roleId;
	
	@Column(name="FUNC_ID", length=10)
    private String funcId;

	public String getRoleId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleId
		return roleId;
	}

	public void setRoleId(String roleId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleId
		this.roleId = roleId;
	}

	public String getFuncId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFuncId
		return funcId;
	}

	public void setFuncId(String funcId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFuncId
		this.funcId = funcId;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        hash += (funcId != null ? funcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IPRoleFunctionPK)) {
            return false;
        }
        IPRoleFunctionPK other = (IPRoleFunctionPK) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        if ((this.funcId == null && other.funcId != null) || (this.funcId != null && !this.funcId.equals(other.funcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() { // DMAP Comment : Dead Code Detected - The Following Method has no reference toString
        return "th.co.ais.ipfm.domain.IPRoleFunctionPK[roleId=" + roleId + ", funcId=" + funcId + "]";
    }
}
