package com.woniu.dao;

import com.woniu.domain.Debttransferdisplay;
import com.woniu.domain.DebttransferdisplayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DebttransferdisplayMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debttransferdisplay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int countByExample(DebttransferdisplayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debttransferdisplay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int deleteByExample(DebttransferdisplayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debttransferdisplay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int deleteByPrimaryKey(Integer debttransferdisplay);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debttransferdisplay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int insert(Debttransferdisplay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debttransferdisplay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int insertSelective(Debttransferdisplay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debttransferdisplay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    List<Debttransferdisplay> selectByExample(DebttransferdisplayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debttransferdisplay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    Debttransferdisplay selectByPrimaryKey(Integer debttransferdisplay);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debttransferdisplay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByExampleSelective(@Param("record") Debttransferdisplay record, @Param("example") DebttransferdisplayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debttransferdisplay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByExample(@Param("record") Debttransferdisplay record, @Param("example") DebttransferdisplayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debttransferdisplay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByPrimaryKeySelective(Debttransferdisplay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debttransferdisplay
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByPrimaryKey(Debttransferdisplay record);
}