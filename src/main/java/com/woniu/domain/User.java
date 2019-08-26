package com.woniu.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private List trees;
	
	private List roles;
	
    private Integer userid;

    private String account;

    private String password;

    private String phone;

    private String email;

    private Userinfo userinfo;
    @JsonBackReference
    public Userinfo getUserinfo() {
		return userinfo;
	}
    
    @JsonBackReference
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public List getTrees() {
		return trees;
	}

	public void setTrees(List trees) {
		this.trees = trees;
	}

	public List getRoles() {
		return roles;
	}

	public void setRoles(List roles) {
		this.roles = roles;
	}

    private Boolean isdelete;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

	@Override
	public String toString() {
		return "User [userid=" + userid + ", account=" + account + ", password=" + password + ", phone=" + phone
				+ ", email=" + email + ", role=" + roles +", trees="+ trees+ "]";
	}
    
    
    
}