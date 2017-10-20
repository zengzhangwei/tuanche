package com.taisf.services.enterprise.manager;

import com.jk.framework.base.exception.BusinessException;
import com.jk.framework.base.page.PagingResult;
import com.jk.framework.base.utils.Check;
import com.jk.framework.base.utils.DateUtil;
import com.taisf.services.common.valenum.DayTypeEnum;
import com.taisf.services.enterprise.dao.EnterpriseAddressDao;
import com.taisf.services.enterprise.dao.EnterpriseConfigDao;
import com.taisf.services.enterprise.dao.EnterpriseDao;
import com.taisf.services.enterprise.dao.EnterpriseDayDao;
import com.taisf.services.enterprise.dto.EnterpriseDayRequest;
import com.taisf.services.enterprise.dto.EnterprisePageRequest;
import com.taisf.services.enterprise.entity.EnterpriseAddressEntity;
import com.taisf.services.enterprise.entity.EnterpriseConfigEntity;
import com.taisf.services.enterprise.entity.EnterpriseDayEntity;
import com.taisf.services.enterprise.entity.EnterpriseEntity;
import com.taisf.services.enterprise.vo.EnterpriseInfoVO;
import com.taisf.services.order.dao.CartDao;
import com.taisf.services.order.dto.CartBaseRequest;
import com.taisf.services.order.entity.CartEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


/**
 * <p>企业先关操作</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author afi on on 2017/9/23.
 * @version 1.0
 * @since 1.0
 */
@Service("enterprise.enterpriseManagerImpl")
public class EnterpriseManagerImpl {

	@Resource(name = "enterprise.enterpriseDao")
	private EnterpriseDao enterpriseDao;


	@Resource(name = "enterprise.enterpriseConfigDao")
	private EnterpriseConfigDao enterpriseConfigDao;

	@Resource(name = "enterprise.enterpriseDayDao")
	private EnterpriseDayDao enterpriseDayDao;

	@Resource(name = "enterprise.enterpriseAddressDao")
	private EnterpriseAddressDao enterpriseAddressDao;


	/**
	 * 获取企业列表信息
	 * @author afi
	 * @param request
	 * @return
	 */
	public PagingResult<EnterpriseEntity> getEnterpriseByPage(EnterprisePageRequest request){
		return enterpriseDao.getEnterpriseByPage(request);
	}

	/**
	 * 根据fid获取企业的信息
	 * @author afi
	 * @param fid
	 * @return
	 */
	public EnterpriseAddressEntity getEnterpriseAddressByFid(String fid){
		if (Check.NuNStr(fid)){
			return null;
		}
		return enterpriseAddressDao.getEnterpriseAddressByFid(fid);
	}



	/**
	 * 获取当前的企业地址列表
	 * @author afi
	 * @param enterpriseCode
	 * @return
	 */
	public List<EnterpriseAddressEntity> getEnterpriseAddressByCode(String enterpriseCode){
		if (Check.NuNStr(enterpriseCode)){
			return null;
		}
		return enterpriseAddressDao.getEnterpriseAddressByCode(enterpriseCode);
	}




	/**
	 * 获取当前的企业信息
	 * @author afi
	 * @param enterpriseCode
	 * @return
	 */
	public EnterpriseEntity getEnterpriseByCode(String enterpriseCode){
		//获取购物车列表
		return enterpriseDao.getEnterpriseByCode(enterpriseCode);
	}




	/**
	 * 获取当前的企业比较全的信息
	 * @author afi
	 * @param enterpriseCode
	 * @return
	 */
	public EnterpriseInfoVO getEnterpriseInfoByCode(String enterpriseCode){
		if (Check.NuNStr(enterpriseCode)){
			return null;
		}
		//获取购物车列表
		EnterpriseEntity entity =  enterpriseDao.getEnterpriseByCode(enterpriseCode);
		if (Check.NuNObj(entity)){
			return null;
		}

		EnterpriseInfoVO info = new EnterpriseInfoVO();
		//设置基本信息
		info.setEnterpriseEntity(entity);

		//获取当前的配置信息
		EnterpriseConfigEntity enterpriseConfig = enterpriseConfigDao.getEnterpriseConfigByCode(enterpriseCode);
		if (Check.NuNObj(enterpriseConfig)){
			throw new BusinessException("异常的配置信息");
		}
		info.setEnterpriseConfigEntity(enterpriseConfig);

		//设置配送时间
		List<EnterpriseDayEntity> days = this.dealEnterpriseDays(enterpriseCode);
		info.setList(days);
		return info;
	}


	public static void main(String[] args) {
		System.out.println(getMonthStart());
	}


	/**
	 * 获取当前月份的第一个周日
	 * @return
	 */
	private static Date getMonthStart(){
		Date firstDay = DateUtil.getFirstDayOfMonth(0);
		Date week = DateUtil.getFirstDayOfWeekDay(firstDay);
		return DateUtil.jumpDate(week,-1);
	}


	/**
	 * 删除
	 * @param enterpriseDayRequest
	 */
	public void  delEnterpriseDays(EnterpriseDayRequest enterpriseDayRequest){
		enterpriseDayDao.delEnterpriseDays(enterpriseDayRequest);
	}


	/**
	 * 获取对象
	 * @param enterpriseDayRequest
	 */
	public EnterpriseDayEntity  getEnterpriseDays(EnterpriseDayRequest enterpriseDayRequest){
		return enterpriseDayDao.getEnterpriseDays(enterpriseDayRequest);
	}
	/**
	 * 增加企业
	 * @author afi
	 * @param record
	 * @return
	 */
	public void saveEnterpriseDay(EnterpriseDayEntity record){
		enterpriseDayDao.saveEnterpriseDay(record);
	}
	/**
	 * 获取一段时间内的企业配送情况
	 * @author afi
	 * @param enterpriseCode
	 * @param firstDay
	 * @param lastDay
	 * @return
	 */
	private List<EnterpriseDayEntity> getEnterpriseDaysByTime(String enterpriseCode,Date  firstDay,Date lastDay){

		List<EnterpriseDayEntity> list = new ArrayList<>();

		Map<String,EnterpriseDayEntity> map = new HashMap<>();
		//获取当前的时间表格
		List<EnterpriseDayEntity> days = enterpriseDayDao.getEnterpriseDaysByTime(enterpriseCode, firstDay, lastDay);
		if (!Check.NuNCollection(days)){
			for (EnterpriseDayEntity day : days) {
				map.put(day.getDayTime(),day);
			}
		}
		while (firstDay.before(lastDay)){
			String key = DateUtil.intFormat(firstDay)+"";
			if (map.containsKey(key)){
				//DB包含直接过
				list.add(map.get(key));
				continue;
			}
			EnterpriseDayEntity day = new EnterpriseDayEntity();
			day.setDayTime(key);
			day.setEnterpriseCode(enterpriseCode);
			if (DateUtil.isWorkDay(firstDay)){
				//工作日添加
				day.setDayType(DayTypeEnum.SEND.getCode());
			}else {
				//非工作日不添加
				day.setDayType(DayTypeEnum.NO.getCode());
			}
			list.add(day);
			//明天
			firstDay = DateUtil.jumpDate(firstDay,1);
		}
		return list;

	}


	/**
	 * 获取月内时间节点信息
	 * @author afi
	 * @param enterpriseCode
	 */
	public List<EnterpriseDayEntity> dealEnterpriseDays(String enterpriseCode){
		return getEnterpriseDaysByTime(enterpriseCode,getMonthStart(),DateUtil.jumpDate(getMonthStart(),42));
	}


	/**
	 * 获取月内时间节点信息
	 * @author afi
	 * @param enterpriseCode
	 */
	public Map<String,EnterpriseDayEntity> dealEnterpriseMapDays(String enterpriseCode){
		Map<String,EnterpriseDayEntity> map = new HashMap<>();
		List<EnterpriseDayEntity>  list = getEnterpriseDaysByTime(enterpriseCode,getMonthStart(),DateUtil.jumpDate(getMonthStart(),42));
		if (!Check.NuNCollection(list)){
			for (EnterpriseDayEntity dayEntity : list) {
				map.put(dayEntity.getDayTime(),dayEntity);
			}
		}
		return map;
	}




}
