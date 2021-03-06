package com.woniu.dao;

import com.woniu.domain.Repay;
import com.woniu.domain.RepayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepayMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int countByExample(RepayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int deleteByExample(RepayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int deleteByPrimaryKey(Integer repayid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int insert(Repay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int insertSelective(Repay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    List<Repay> selectByExample(RepayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    Repay selectByPrimaryKey(Integer repayid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByExampleSelective(@Param("record") Repay record, @Param("example") RepayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByExample(@Param("record") Repay record, @Param("example") RepayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByPrimaryKeySelective(Repay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByPrimaryKey(Repay record);
}