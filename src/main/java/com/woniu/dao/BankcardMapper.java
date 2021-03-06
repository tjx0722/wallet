package com.woniu.dao;

import com.woniu.domain.Bankcard;
import com.woniu.domain.BankcardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BankcardMapper {
	List findBankcardByWalletid1(Integer walletid);
	void deleteBatch(Integer[] bankcardid);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int countByExample(BankcardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int deleteByExample(BankcardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int deleteByPrimaryKey(Integer bankcardid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int insert(Bankcard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int insertSelective(Bankcard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    List<Bankcard> selectByExample(BankcardExample example,RowBounds rb);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    Bankcard selectByPrimaryKey(Integer bankcardid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByExampleSelective(@Param("record") Bankcard record, @Param("example") BankcardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByExample(@Param("record") Bankcard record, @Param("example") BankcardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByPrimaryKeySelective(Bankcard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    int updateByPrimaryKey(Bankcard record);
}