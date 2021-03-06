package com.woniu.dao;

import com.woniu.domain.Tree;
import com.woniu.domain.TreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TreeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int countByExample(TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int deleteByExample(TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int deleteByPrimaryKey(Integer treeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int insert(Tree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int insertSelective(Tree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    List<Tree> selectByExample(TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    Tree selectByPrimaryKey(Integer treeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByExampleSelective(@Param("record") Tree record, @Param("example") TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByExample(@Param("record") Tree record, @Param("example") TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByPrimaryKeySelective(Tree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByPrimaryKey(Tree record);
}