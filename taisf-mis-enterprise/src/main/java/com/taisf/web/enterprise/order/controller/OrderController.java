package com.taisf.web.enterprise.order.controller;

import com.jk.framework.base.page.PagingResult;
import com.jk.framework.base.utils.Check;
import com.jk.framework.base.utils.JsonEntityTransform;
import com.jk.framework.log.utils.LogUtil;
import com.taisf.services.enterprise.dto.EnterpriseListRequest;
import com.taisf.services.order.dto.OrderInfoRequest;
import com.taisf.services.order.dto.OrderProductListRequest;
import com.taisf.services.order.entity.OrderProductEntity;
import com.taisf.services.order.manager.OrderManagerImpl;
import com.taisf.services.order.vo.OrderInfoVO;
import com.taisf.services.order.vo.OrderListVo;
import com.taisf.services.ups.entity.EmployeeEntity;
import com.taisf.web.enterprise.common.constant.LoginConstant;
import com.taisf.web.enterprise.common.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("order/")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderManagerImpl orderManagerImpl;

    /**
     * @author:zhangzhengguang
     * @date:2017/10/16
     * @description:订单列表列表
     **/
    @RequestMapping("list")
    public String list(HttpServletRequest request) {
        return "order/orderList";
    }

    /**
     * @author:zhangzhengguang
     * @date:2017/10/16
     * @description:订单详情商品列表
     **/
    @RequestMapping("showOrderProduct")
    public String showOrderProduct(HttpServletRequest request,String orderSn) {
        request.setAttribute("orderSn",orderSn);
        return "order/orderProductList";
    }

    /**
     * @author:zhangzhengguang
     * @date:2017/10/16
     * @description:分页查询订单列表数据
     **/
    @RequestMapping("pageList")
    @ResponseBody
    public PageResult pageList(HttpServletRequest request, OrderInfoRequest orderInfoRequest) {
        PageResult pageResult = new PageResult();
        try {
            EmployeeEntity emp = (EmployeeEntity)request.getSession().getAttribute(LoginConstant.SESSION_KEY);
            orderInfoRequest.setBizCode(emp.getEmpBiz());
            PagingResult<OrderInfoVO> pagingResult = orderManagerImpl.pageListOrder(orderInfoRequest);
            if (!Check.NuNObj(pagingResult)) {
                pageResult.setRows(pagingResult.getList());
                pageResult.setTotal(pagingResult.getTotal());
            }
        } catch (Exception e) {
            LogUtil.info(LOGGER, "params:{}", JsonEntityTransform.Object2Json(orderInfoRequest));
            LogUtil.error(LOGGER, "error:{}", e);
            return new PageResult();
        }
        return pageResult;
    }

    /**
     * @author:zhangzhengguang
     * @date:2017/10/16
     * @description:分页查询订单列表数据
     **/
    @RequestMapping("orderProductPageList")
    @ResponseBody
    public PageResult orderProductPageList(HttpServletRequest request, OrderProductListRequest orderProductListRequest) {
        PageResult pageResult = new PageResult();
        try {
            PagingResult<OrderProductEntity> pagingResult = orderManagerImpl.getOrderProductPageList(orderProductListRequest);
            if (!Check.NuNObj(pagingResult)) {
                pageResult.setRows(pagingResult.getList());
                pageResult.setTotal(pagingResult.getTotal());
            }
        } catch (Exception e) {
            LogUtil.info(LOGGER, "params:{}", JsonEntityTransform.Object2Json(orderProductListRequest));
            LogUtil.error(LOGGER, "error:{}", e);
            return new PageResult();
        }
        return pageResult;
    }


    /**
     * @author:zhangzhengguang
     * @date:2017/10/17
     * @description:订单配送
     **/
    @RequestMapping("orderDispatching")
    public String orderDispatching(HttpServletRequest request) {
        return "order/orderDispatching";
    }

    /**
     * @author:zhangzhengguang
     * @date:2017/10/20
     * @description:配送记录页面
     **/
    @RequestMapping("toDistributionRecord")
    public String toDistributionRecord(HttpServletRequest request) {
        return "order/distributionRecordList";
    }


    /**
     * @author:zhangzhengguang
     * @date:2017/10/20
     * @description:配送记录
     **/
    @RequestMapping("distributionRecord")
    @ResponseBody
    public PageResult distributionRecord(HttpServletRequest request, EnterpriseListRequest enterpriseListRequest) {
        PageResult pageResult = new PageResult();
        try {
            EmployeeEntity emp = (EmployeeEntity)request.getSession().getAttribute(LoginConstant.SESSION_KEY);
            enterpriseListRequest.setSupplierCode(emp.getEmpBiz());
            PagingResult<OrderListVo> pagingResult = orderManagerImpl.findPageLsit(enterpriseListRequest);
            if (!Check.NuNObj(pagingResult)) {
                pageResult.setRows(pagingResult.getList());
                pageResult.setTotal(pagingResult.getTotal());
            }
        } catch (Exception e) {
            LogUtil.info(LOGGER, "params:{}", JsonEntityTransform.Object2Json(enterpriseListRequest));
            LogUtil.error(LOGGER, "error:{}", e);
            return new PageResult();
        }
        return pageResult;
    }
}