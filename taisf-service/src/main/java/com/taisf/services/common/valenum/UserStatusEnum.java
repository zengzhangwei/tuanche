package com.taisf.services.common.valenum;

import com.jk.framework.base.utils.Check;

/**
 * <p>用户状态 1：可用 2：禁用</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author afi on on 2017/6/26.
 * @version 1.0
 * @since 1.0
 */
public enum UserStatusEnum {

    AVAILABLE(1,"可用","定义用户正常可用中"),
    FORBIDDEN(2,"禁用","定义用户已禁用");

    private int code;
    private String name;
    private String desc;
    private UserStatusEnum(int code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static UserStatusEnum getTypeByCode(Integer code) {
        if (Check.NuNObj(code)){
            return null;
        }
        UserStatusEnum[] enums = UserStatusEnum.values();
        for(UserStatusEnum enumtype:enums) {
            if(enumtype.getCode() == code) {
                return enumtype;
            }
        }
        return null;
    }
}
