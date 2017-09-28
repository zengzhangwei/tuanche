package com.taisf.services.enterprise.dao;

import com.jk.framework.base.utils.Check;
import com.taisf.services.common.dao.BaseDao;
import com.taisf.services.enterprise.entity.EnterpriseAddressEntity;
import com.taisf.services.order.entity.CartEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>企业地址</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author afi on on 2017/9/13.
 * @version 1.0
 * @since 1.0
 */
@Repository("enterprise.enterpriseAddressDao")
public class EnterpriseAddressDao extends BaseDao {

    private String SQLID = "enterprise.enterpriseAddressDao.";

    /**
     * 日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(EnterpriseAddressDao.class);


    /**
     * 获取当前的企业地址列表
     * @author afi
     * @param enterpriseCode
     * @return
     */
    public List<EnterpriseAddressEntity> getEnterpriseAddressByCode(String enterpriseCode){
        return mybatisDaoContext.findAll(SQLID+"getEnterpriseAddressByCode", EnterpriseAddressEntity.class, enterpriseCode);
    }

    /**
     * 增加地址
     * @author afi
     * @param record
     * @return
     */
    public int saveEnterpriseAddress(EnterpriseAddressEntity record){

        return mybatisDaoContext.save(SQLID + "saveEnterpriseAddress", record);
    }
    /**
     * 修改地址信息
     * @author afi
     * @param record
     * @return
     */
    public int updateEnterpriseAddress(EnterpriseAddressEntity record){
        return mybatisDaoContext.update(SQLID + "updateEnterpriseAddress", record);
    }

}