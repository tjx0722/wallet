package com.woniu.dao;

import com.woniu.domain.Servicecharge;
import com.woniu.domain.ServicechargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServicechargeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table servicecharge
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int countByExample(ServicechargeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table servicecharge
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int deleteByExample(ServicechargeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table servicecharge
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int deleteByPrimaryKey(Integer servicechargeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table servicecharge
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int insert(Servicecharge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table servicecharge
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int insertSelective(Servicecharge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table servicecharge
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    List<Servicecharge> selectByExample(ServicechargeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table servicecharge
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    Servicecharge selectByPrimaryKey(Integer servicechargeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table servicecharge
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByExampleSelective(@Param("record") Servicecharge record, @Param("example") ServicechargeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table servicecharge
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByExample(@Param("record") Servicecharge record, @Param("example") ServicechargeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table servicecharge
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByPrimaryKeySelective(Servicecharge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table servicecharge
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByPrimaryKey(Servicecharge record);
}