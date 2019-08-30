package com.woniu.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.woniu.controller.UserinfoController;
import com.woniu.dao.InvestMapper;
import com.woniu.dao.LoanapplyMapper;
import com.woniu.dao.LoandisplayMapper;
import com.woniu.dao.RepayMapper;
import com.woniu.dao.UserinfoMapper;
import com.woniu.domain.Invest;
import com.woniu.domain.InvestExample;
import com.woniu.domain.InvestExample.Criteria;
import com.woniu.domain.Loanapply;
import com.woniu.domain.LoanapplyExample;
import com.woniu.domain.Loandisplay;
import com.woniu.domain.LoandisplayExample;
import com.woniu.domain.Loantime;
import com.woniu.domain.PageBean;
import com.woniu.domain.Repay;
import com.woniu.domain.Userinfo;
import com.woniu.domain.UserinfoExample;
import com.woniu.service.IInvestService;

@Service
public class InvestServiceImpl implements IInvestService {

	@Resource
	private LoandisplayMapper loandisplayMapper;
	@Resource
	private InvestMapper investMapper;
	@Resource
	private RepayMapper repayMapper;
	@Resource
	private UserinfoMapper userinfoMapper;
	@Resource
	private LoanapplyMapper loanapplyMapper;
	
	@Override
	public List<Loandisplay> findAllLoadDisplay(PageBean pb) {
		LoandisplayExample example=new LoandisplayExample();
		com.woniu.domain.LoandisplayExample.Criteria criteria = example.createCriteria();
		criteria.andIsfinishedEqualTo(false);
		criteria.andIsdeadEqualTo(false);
		pb.setCount(loandisplayMapper.countByExample(example));
		return loandisplayMapper.selectByExample(example,new RowBounds(pb.getOffset(), pb.getLimit()));
	}

	@Override
	public List<Loandisplay> findAllLoadDisplay(PageBean pb, String name, String value) {
		LoandisplayExample loandisplayexample=new LoandisplayExample();
		com.woniu.domain.LoandisplayExample.Criteria loandisplaycriteria = loandisplayexample.createCriteria();
		loandisplaycriteria.andIsfinishedEqualTo(false);
		loandisplaycriteria.andIsdeadEqualTo(false);
		
		//按筛选条件名进行筛选
		switch(name) {
			case "loanrate":
				//获取利率
				double loanrate=Double.valueOf(value);
				
				List<Integer> ids1=new ArrayList<Integer>();
 				List<Loandisplay> list1 = loandisplayMapper.selectByExample(loandisplayexample, new RowBounds(0, loandisplayMapper.countByExample(loandisplayexample)));
				for (Loandisplay loandisplay : list1) {
					double loanrate2 = loandisplay.getLoanapply().getLoanrate().getLoanrate()*100.0;
					loanrate2=Math.round(loanrate2*100)/100;
					if(loanrate2==loanrate) {
						ids1.add(loandisplay.getLoanapplyid());
					}
				}
				if(ids1.size()>0) {
					loandisplaycriteria.andLoanapplyidIn(ids1);
				}
				break;
			case "restcount":
				//获取剩余金额
				double restcount=Double.valueOf(value);
				
				List<Integer> ids2=new ArrayList<Integer>();
 				List<Loandisplay> list2 = loandisplayMapper.selectByExample(loandisplayexample, new RowBounds(0, loandisplayMapper.countByExample(loandisplayexample)));
				for (Loandisplay loandisplay : list2) {
					double investcount = loandisplay.getInvestcount();
					double loanamount = loandisplay.getLoanapply().getLoanamount();
					double restcount2=loanamount-investcount;
					if(restcount2==restcount) {
						ids2.add(loandisplay.getLoanapplyid());
					}
				}
				if(ids2.size()>0) {
					loandisplaycriteria.andLoanapplyidIn(ids2);
				}
				break;
			case "loanamount":
				//获取贷款金额
				double loanamount=Double.valueOf(value);
				
				List<Integer> ids3=new ArrayList<Integer>();
 				List<Loandisplay> list3 = loandisplayMapper.selectByExample(loandisplayexample, new RowBounds(0, loandisplayMapper.countByExample(loandisplayexample)));
				for (Loandisplay loandisplay : list3) {
					double loanamount2 = loandisplay.getLoanapply().getLoanamount();
					if(loanamount2==loanamount) {
						ids3.add(loandisplay.getLoanapplyid());
					}
				}
				if(ids3.size()>0) {
					loandisplaycriteria.andLoanapplyidIn(ids3);
				}
				break;
			case "repaytime":
				//获取偿还期数
				int repaytime=Integer.valueOf(value);
				
				List<Integer> ids4=new ArrayList<Integer>();
 				List<Loandisplay> list4 = loandisplayMapper.selectByExample(loandisplayexample, new RowBounds(0, loandisplayMapper.countByExample(loandisplayexample)));
				for (Loandisplay loandisplay : list4) {
					int loantime = loandisplay.getLoanapply().getLoantime().getLoantime();
					if(loantime==repaytime) {
						ids4.add(loandisplay.getLoanapplyid());
					}
				}
				if(ids4.size()>0) {
					loandisplaycriteria.andLoanapplyidIn(ids4);
				}
				break;
		}

		pb.setCount(loandisplayMapper.countByExample(loandisplayexample));
		return loandisplayMapper.selectByExample(loandisplayexample, new RowBounds(pb.getOffset(), pb.getLimit()));
	}

	@Override
	public List<Invest> findInvested(Integer userinfoid, PageBean pb) {
		InvestExample example = new InvestExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserinfoidEqualTo(userinfoid);
		criteria.andIstransferEqualTo(false);
		pb.setCount(investMapper.countByExample(example));
		return investMapper.selectByExample(example,new RowBounds(pb.getOffset(), pb.getLimit()));
	}

	@Override
	public List<Invest> findAllLoadDisplay(Integer userinfoid, PageBean pb, String sort, String order) {
		InvestExample example = new InvestExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserinfoidEqualTo(userinfoid);
		criteria.andIstransferEqualTo(false);
		pb.setCount(investMapper.countByExample(example));
		switch(sort) {
			case "paytime":
				example.setOrderByClause("deadtime "+order.toUpperCase());
				break;
			case "investamount":
				example.setOrderByClause("investamount "+order.toUpperCase());
				break;
		}
		return investMapper.selectByExample(example,new RowBounds(pb.getOffset(), pb.getLimit()));
	}

	@Override
	public void insert(Invest invest) {
		investMapper.insert(invest);
		Integer loandisplayid = invest.getLoandisplayid();
		Loandisplay loandisplay = loandisplayMapper.selectByPrimaryKey(loandisplayid);
		//先获取期数
		int loantime = loandisplay.getLoanapply().getLoantime().getLoantime();
		double investcount = loandisplay.getInvestcount();
		double loanamount = loandisplay.getLoanapply().getLoanamount();
		
		//判断是否募集够资金
		if(investcount==loanamount) {
			//设置loandisplay为已完成
			loandisplay.setIsfinished(true);
			loandisplayMapper.updateByPrimaryKey(loandisplay);
			
			//获取利率
			double loanrate = loandisplay.getLoanapply().getLoanrate().getLoanrate();
			
			//根据期数生成多个偿还表
			int loanapplyid=loandisplay.getLoanapplyid();
			int userinfoid = loandisplay.getLoanapply().getUserinfoid();
			double restamount=loanamount*(1.0+loanrate)/loantime;
			restamount = (double) Math.round(restamount * 100) / 100;
			Repay repay = new Repay();
			for (int i = 1; i <= loantime; i++) {
				repay.setLoanapplyid(loanapplyid);
				repay.setUserinfoid(userinfoid);
				repay.setRestamount(restamount);
				repay.setIsfinished(false);
				
				//设置以后每隔一月的还款期
				Calendar c = Calendar.getInstance();  
		        c.setTime(new Date());   //设置时间
		        c.add(Calendar.MONTH, i); //月份加1,Calendar.DATE(天),Calendar.HOUR(小时)  
		        Date date = c.getTime(); //结果  
				repay.setRepaytime(date);
				repay.setIsovertime(false);
				repayMapper.insert(repay);
			}
		}
	}

	@Override
	public Invest findOneInvest(int investId) {
		// TODO Auto-generated method stub
		return investMapper.selectByPrimaryKey(investId);
	}
	
	
	@Override
	public Loandisplay findLoandisplayById(Integer loandisplayid) {
		return loandisplayMapper.findInvestBydisplay(loandisplayid);
	}

	@Override
	public void transfer(int investId) {
		// TODO Auto-generated method stub
		Invest invest=new Invest();
		invest.setInvestid(investId);
		invest.setIstransfer(true);
		investMapper.updateByPrimaryKeySelective(invest);
	}

	@Override
	public void update(Invest invest) {
		// TODO Auto-generated method stub
		investMapper.updateByPrimaryKey(invest);
	}
	@Override
	public List findAllInvest(PageBean pageBean, int userinfoid) {
		// TODO Auto-generated method stub
		InvestExample example=new InvestExample();
		example.setOrderByClause("investid DESC");
		Criteria criteria=example.createCriteria();
		/* criteria.andIstransferEqualTo(false); */
		criteria.andUserinfoidEqualTo(userinfoid);
		pageBean.setCount((int)investMapper.countByExample(example));
		return investMapper.selectByExample(example, new RowBounds(pageBean.getOffset(), pageBean.getLimit()));
	}
	
	//admin

	@Override
	public List<Loandisplay> findAllLoanDisplayByadmin(PageBean pb) {
		pb.setCount(loandisplayMapper.countByExample(null));
		return loandisplayMapper.selectByExample(null,new RowBounds(pb.getOffset(), pb.getLimit()));
	}

	@Override
	public List<Loandisplay> findAllLoanDisplayByadmin(PageBean pb, String name, String value) {
		// TODO Auto-generated method stub
		LoandisplayExample loandisplayExample = new LoandisplayExample();
		com.woniu.domain.LoandisplayExample.Criteria criteria = loandisplayExample.createCriteria();
		
		List<Loandisplay> list = loandisplayMapper.selectByExample(null, new RowBounds(0, loandisplayMapper.countByExample(null)));
		List<Integer> ids=new ArrayList<Integer>();

		switch(name) {
			case "apply":
				//获取借贷人name
				String apply=value;
				for (Loandisplay loandisplay : list) {
					String username = loandisplay.getLoanapply().getUserinfo().getUsername();
					if(username.equalsIgnoreCase(apply)) {
						ids.add(loandisplay.getLoandisplayid());
					}
				}
				break;
			case "loanamount":
				double loanamount=Double.valueOf(value);
				for (Loandisplay loandisplay : list) {
					double loanamount2 = loandisplay.getLoanapply().getLoanamount();
					if(loanamount2==loanamount) {
						ids.add(loandisplay.getLoandisplayid());
					}
				}
				break;
			case "loanrate":
				double loanrate=Double.valueOf(value);
				for (Loandisplay loandisplay : list) {
					double loanrate2 = loandisplay.getLoanapply().getLoanrate().getLoanrate()*100.0;
					loanrate2=Math.round(loanrate2*100)/100;
					if(loanrate2==loanrate) {
						ids.add(loandisplay.getLoandisplayid());
					}
				}
				break;
			case "loaninvest":
				double loaninvest=Double.valueOf(value);
				for (Loandisplay loandisplay : list) {
					double investcount = loandisplay.getInvestcount();
					if(loaninvest==investcount) {
						ids.add(loandisplay.getLoandisplayid());
					}
				}
				break;
			case "restcount":
				double restcount=Double.valueOf(value);
				for (Loandisplay loandisplay : list) {
					double investcount = loandisplay.getInvestcount();
					double loanamount2 = loandisplay.getLoanapply().getLoanamount();
					double restcount2=loanamount2-investcount;
					if(restcount2==restcount) {
						ids.add(loandisplay.getLoandisplayid());
					}
				}
				break;
			case "repaytime":
				int repaytime=Integer.valueOf(value);
				for (Loandisplay loandisplay : list) {
					int loantime = loandisplay.getLoanapply().getLoantime().getLoantime();
					if(repaytime==loantime) {
						ids.add(loandisplay.getLoandisplayid());
					}
				}
				break;
		}
		
		criteria.andLoanapplyidIn(ids);
		if(ids.size()==0) {
			return null;
		}
		pb.setCount(loandisplayMapper.countByExample(loandisplayExample));
		return loandisplayMapper.selectByExample(loandisplayExample,new RowBounds(pb.getOffset(), pb.getLimit()));
	}

	@Override
	public List<Invest> findAllInvested(PageBean pb) {
		pb.setCount(investMapper.countByExample(null));
		return investMapper.selectByExample(null,new RowBounds(pb.getOffset(), pb.getLimit()));
	}
	
	@Override
	public List<Invest> findAllInvested(PageBean pb,String name,String value) {
		InvestExample investExample = new InvestExample();
		Criteria investcriteria = investExample.createCriteria();
		switch(name) {
			case "invest":
				//获取投资人name
				String investname=value;
				//根据name查到userinfoid
				UserinfoExample userinfoExample1 = new UserinfoExample();
				com.woniu.domain.UserinfoExample.Criteria usernifocriteria1 = userinfoExample1.createCriteria();
				usernifocriteria1.andUsernameEqualTo(investname);
				List<Userinfo> userinfolist1 = userinfoMapper.selectByExample(userinfoExample1);
				if(userinfolist1.size()>0) {
					Integer userinfoid1 = userinfolist1.get(0).getUserinfoid();
					investcriteria.andUserinfoidEqualTo(userinfoid1);
				}
				break;
			case "apply":
				//获取申请人name
				String applyname=value;
				
				List<Integer> ids1=new ArrayList<Integer>();
 				List<Invest> list = investMapper.selectByExample(null, new RowBounds(0, investMapper.countByExample(null)));
				for (Invest invest : list) {
					String username = invest.getLoandisplay().getLoanapply().getUserinfo().getUsername();
					if(username.equalsIgnoreCase(applyname)) {
						ids1.add(invest.getInvestid());
					}
				}
				if(ids1.size()>0) {
					investcriteria.andInvestidIn(ids1);
				}
				break;
			case "loanrate":
				//获取利率
				double loanrate=Double.valueOf(value)/100.0;

				List<Integer> ids2=new ArrayList<Integer>();
 				List<Invest> list2 = investMapper.selectByExample(null, new RowBounds(0, investMapper.countByExample(null)));
				for (Invest invest : list2) {
					double loanrate2 = invest.getLoandisplay().getLoanapply().getLoanrate().getLoanrate();
					if(loanrate==loanrate2) {
						ids2.add(invest.getInvestid());
					}
				}
				if(ids2.size()>0) {
					investcriteria.andInvestidIn(ids2);
				}
				break;
			case "repaytime":
				//获取偿还周期
				int repaytime=Integer.valueOf(value);

				List<Integer> ids3=new ArrayList<Integer>();
 				List<Invest> list3 = investMapper.selectByExample(null, new RowBounds(0, investMapper.countByExample(null)));
				for (Invest invest : list3) {
					int loantime = invest.getLoandisplay().getLoanapply().getLoantime().getLoantime();
					if(loantime==repaytime) {
						ids3.add(invest.getInvestid());
					}
				}
				if(ids3.size()>0) {
					investcriteria.andInvestidIn(ids3);
				}
				break;
			case "investamount":
				//获取投资金额
				double investamount=Double.valueOf(value);

				List<Integer> ids4=new ArrayList<Integer>();
 				List<Invest> list4 = investMapper.selectByExample(null, new RowBounds(0, investMapper.countByExample(null)));
				for (Invest invest : list4) {
					double investamount2 = invest.getInvestamount();
					if(investamount2==investamount) {
						ids4.add(invest.getInvestid());
					}
				}
				if(ids4.size()>0) {
					investcriteria.andInvestidIn(ids4);
				}
				break;
		}
		pb.setCount(investMapper.countByExample(investExample));
		return investMapper.selectByExample(investExample,new RowBounds(pb.getOffset(), pb.getLimit()));
	}

}
