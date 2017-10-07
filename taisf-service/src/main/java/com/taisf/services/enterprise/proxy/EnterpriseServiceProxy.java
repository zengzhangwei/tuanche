package com.taisf.services.enterprise.proxy;

import com.jk.framework.base.entity.DataTransferObject;
import com.jk.framework.base.utils.Check;
import com.taisf.services.enterprise.api.EnterpriseService;
import com.taisf.services.enterprise.entity.EnterpriseEntity;
import com.taisf.services.enterprise.manager.EnterpriseManagerImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>企业接口实现</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author afi on on 2017/10/6.
 * @version 1.0
 * @since 1.0
 */
@Component("enterprise.enterpriseServiceProxy")
public class EnterpriseServiceProxy implements EnterpriseService {

    @Resource(name = "enterprise.enterpriseManagerImpl")
    private EnterpriseManagerImpl enterpriseManager;



    /**
     * 获取企业基本信息
     * @param enterpriseCode
     * @return
     */
    @Override
    public DataTransferObject<EnterpriseEntity> getEnterpriseByCode(String enterpriseCode){
        DataTransferObject<EnterpriseEntity> dto = new DataTransferObject<>();

        if (Check.NuNStr(enterpriseCode)){
            dto.setErrorMsg("参数异常");
            return dto;
        }
        EnterpriseEntity entity = enterpriseManager.getEnterpriseByCode(enterpriseCode);
        if (entity == null){
            dto.setErrorMsg("当前企业不存在");
        }
        dto.setData(entity);
        return dto;
    }

}
