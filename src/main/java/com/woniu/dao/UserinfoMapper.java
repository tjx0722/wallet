package com.woniu.dao;

import com.woniu.domain.Userinfo;
import com.woniu.domain.UserinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserinfoMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table userinfo
	 * @mbggenerated  Mon Aug 26 15:13:07 CST 2019
	 */
	int countByExample(UserinfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table userinfo
	 * @mbggenerated  Mon Aug 26 15:13:07 CST 2019
	 */
	int deleteByExample(UserinfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table userinfo
	 * @mbggenerated  Mon Aug 26 15:13:07 CST 2019
	 */
	int deleteByPrimaryKey(Integer userinfoid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table userinfo
	 * @mbggenerated  Mon Aug 26 15:13:07 CST 2019
	 */
	int insert(Userinfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table userinfo
	 * @mbggenerated  Mon Aug 26 15:13:07 CST 2019
	 */
	int insertSelective(Userinfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table userinfo
	 * @mbggenerated  Mon Aug 26 15:13:07 CST 2019
	 */
	List<Userinfo> selectByExample(UserinfoExample example);
	List<Userinfo> selectByExample(UserinfoExample example,RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table userinfo
	 * @mbggenerated  Mon Aug 26 15:13:07 CST 2019
	 */
	Userinfo selectByPrimaryKey(Integer userinfoid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table userinfo
	 * @mbggenerated  Mon Aug 26 15:13:07 CST 2019
	 */
	int updateByExampleSelective(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table userinfo
	 * @mbggenerated  Mon Aug 26 15:13:07 CST 2019
	 */
	int updateByExample(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table userinfo
	 * @mbggenerated  Mon Aug 26 15:13:07 CST 2019
	 */
	int updateByPrimaryKeySelective(Userinfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table userinfo
	 * @mbggenerated  Mon Aug 26 15:13:07 CST 2019
	 */
	int updateByPrimaryKey(Userinfo record);

	void deleteBatch(Integer[] userinfoid);
}