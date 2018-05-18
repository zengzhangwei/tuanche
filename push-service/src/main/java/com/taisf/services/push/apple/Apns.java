package com.taisf.services.push.apple;

import com.jk.framework.base.entity.BaseEntity;
import com.jk.framework.base.utils.JsonEntityTransform;

import java.util.Map;

/**
 * <p>TODO</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author afi on on 2018/5/18.
 * @version 1.0
 * @since 1.0
 */
public class Apns extends BaseEntity{

    private Object customContent;


    private Map aps;


    public String trans2par(){
        aps.put("mutable-content", "1");
        return JsonEntityTransform.Object2Json(this);
    }

    public Object getCustomContent() {
        return customContent;
    }

    public void setCustomContent(Object customContent) {
        this.customContent = customContent;
    }

    public Map getAps() {
        return aps;
    }

    public void setAps(Map aps) {
        this.aps = aps;
    }
}
