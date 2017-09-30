package com.taisf.services.common.valenum;

/**
 * <p>订单状态</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author afi on on 2017/5/20.
 * @version 1.0
 * @since 1.0
 */
public enum OrdersStatusEnum {

    //10:待支付 11:部分支付 30:取消 40.已经退款 50.已支付 60.已配送 70.已签收


    NO_PAY("待支付", 10,OrdersStatusShowEnum.NOPAYED),
    PART_PAY("部分支付", 11,OrdersStatusShowEnum.NOPAYED),
    CANCEL("取消", 30,OrdersStatusShowEnum.CANCLED),

    REFUND("退款", 40,OrdersStatusShowEnum.REFUND),
    HAS_PAY("已支付", 50,OrdersStatusShowEnum.HAS_PAYED),
    SEND("配送", 60,OrdersStatusShowEnum.HAS_SEND),

    RECEIVE("签收", 70,OrdersStatusShowEnum.FINISH);
    // 成员变量
    private String name;
    private int code;
    private OrdersStatusShowEnum foreignType;
    public String getName() {
        return name;
    }
    public int getCode() {
        return code;
    }
    public OrdersStatusShowEnum getForeignType() {
		return foreignType;
	}
	// 构造方法
    private OrdersStatusEnum(String name, int code, OrdersStatusShowEnum foreignType) {
        this.name = name;
        this.code = code;
        this.foreignType = foreignType;
    }
    // 普通方法
    public static OrdersStatusEnum getByCode(int code) {
        for (OrdersStatusEnum c : OrdersStatusEnum.values()) {
            if (c.code == code) {
                return c;
            }
        }
        return null;
    }
    /**
     * 校验是否可以取消
     * @return
     */
    public boolean checkCancel(){
        return true;
    }

}