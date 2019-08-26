package com.woniu.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Userinfo implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private User user;		//可以查到对应的user
    public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.userinfoid
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    private Integer userinfoid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.userid
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.username
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.currentaddress
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    private String currentaddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.nativeplace
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    private String nativeplace;

    private String usericon;

    private String nickname;

    private String userjob;

    private String degree;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private Boolean sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.salary
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    private Integer salary;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.ismarried
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    private Boolean ismarried;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.infochecked
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    private Boolean infochecked;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.userinfoid
     *
     * @return the value of userinfo.userinfoid
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public Integer getUserinfoid() {
        return userinfoid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.userinfoid
     *
     * @param userinfoid the value for userinfo.userinfoid
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setUserinfoid(Integer userinfoid) {
        this.userinfoid = userinfoid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.userid
     *
     * @return the value of userinfo.userid
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.userid
     *
     * @param userid the value for userinfo.userid
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.username
     *
     * @return the value of userinfo.username
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.username
     *
     * @param username the value for userinfo.username
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.currentaddress
     *
     * @return the value of userinfo.currentaddress
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public String getCurrentaddress() {
        return currentaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.currentaddress
     *
     * @param currentaddress the value for userinfo.currentaddress
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setCurrentaddress(String currentaddress) {
        this.currentaddress = currentaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.nativeplace
     *
     * @return the value of userinfo.nativeplace
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public String getNativeplace() {
        return nativeplace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.nativeplace
     *
     * @param nativeplace the value for userinfo.nativeplace
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.usericon
     *
     * @return the value of userinfo.usericon
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public String getUsericon() {
        return usericon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.usericon
     *
     * @param usericon the value for userinfo.usericon
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setUsericon(String usericon) {
        this.usericon = usericon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.nickname
     *
     * @return the value of userinfo.nickname
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.nickname
     *
     * @param nickname the value for userinfo.nickname
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.userjob
     *
     * @return the value of userinfo.userjob
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public String getUserjob() {
        return userjob;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.userjob
     *
     * @param userjob the value for userinfo.userjob
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setUserjob(String userjob) {
        this.userjob = userjob;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.degree
     *
     * @return the value of userinfo.degree
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public String getDegree() {
        return degree;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.degree
     *
     * @param degree the value for userinfo.degree
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.birthday
     *
     * @return the value of userinfo.birthday
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.birthday
     *
     * @param birthday the value for userinfo.birthday
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.sex
     *
     * @return the value of userinfo.sex
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.sex
     *
     * @param sex the value for userinfo.sex
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.salary
     *
     * @return the value of userinfo.salary
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.salary
     *
     * @param salary the value for userinfo.salary
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.ismarried
     *
     * @return the value of userinfo.ismarried
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public Boolean getIsmarried() {
        return ismarried;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.ismarried
     *
     * @param ismarried the value for userinfo.ismarried
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setIsmarried(Boolean ismarried) {
        this.ismarried = ismarried;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.infochecked
     *
     * @return the value of userinfo.infochecked
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public Boolean getInfochecked() {
        return infochecked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.infochecked
     *
     * @param infochecked the value for userinfo.infochecked
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setInfochecked(Boolean infochecked) {
        this.infochecked = infochecked;
    }
}