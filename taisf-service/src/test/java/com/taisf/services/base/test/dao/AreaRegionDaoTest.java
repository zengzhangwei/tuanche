package com.taisf.services.base.test.dao;

import com.jk.framework.base.utils.JsonEntityTransform;
import com.taisf.services.base.dao.AreaRegionDao;
import com.taisf.services.base.entity.AreaRegionEntity;
import com.taisf.services.common.dao.BaseDao;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * <p>TODO</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author afi on on 2017/9/11.
 * @version 1.0
 * @since 1.0
 */
public class AreaRegionDaoTest extends BaseDao{

    @Resource(name = "basedata.areaRegionDao")
    private AreaRegionDao areaRegionDao;


    @Test
    public void getAreaRegionByNameTest() {
        AreaRegionEntity aa=  areaRegionDao.getAreaRegionByName("1231");
        System.out.println(JsonEntityTransform.Object2Json(aa));
    }
}
