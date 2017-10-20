package com.taisf.api.order.controller;

import com.jk.framework.base.entity.DataTransferObject;
import com.jk.framework.base.head.Header;
import com.jk.framework.base.page.PagingResult;
import com.jk.framework.base.rst.ResponseDto;
import com.jk.framework.base.utils.Check;
import com.jk.framework.base.utils.JsonEntityTransform;
import com.jk.framework.log.utils.LogUtil;
import com.taisf.api.common.abs.AbstractController;
import com.taisf.services.order.api.OrderService;
import com.taisf.services.order.dto.CreateOrderRequest;
import com.taisf.services.order.dto.FinishOrderRequest;
import com.taisf.services.order.dto.OrderInfoRequest;
import com.taisf.services.order.vo.OrderDetailVO;
import com.taisf.services.order.vo.OrderInfoVO;
import com.taisf.services.order.vo.OrderSaveInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>订单相关</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author afi
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping("/knight")
public class KnightController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KnightController.class);

    @Autowired
    private OrderService ordersService;

    /**
     * 结束订单
     * @author afi
      * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/finishOrder", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto initOrder(HttpServletRequest request, HttpServletResponse response) {
        Header header = getHeader(request);
        if (Check.NuNObj(header)) {
            return new ResponseDto("头信息为空");
        }
        //获取当前参数
        FinishOrderRequest paramRequest = getEntity(request, FinishOrderRequest.class);
        paramRequest.setOpId(getUserId(request));
        if (Check.NuNObj(paramRequest)) {
            return new ResponseDto("参数异常");
        }

        LogUtil.info(LOGGER, "传入参数:{}", JsonEntityTransform.Object2Json(paramRequest));
        try {

            DataTransferObject<Void> dto =ordersService.finishOrder(paramRequest);
            return dto.trans2Res();
        } catch (Exception e) {
            LogUtil.error(LOGGER, "【结束订单】错误,par:{}, e={}",JsonEntityTransform.Object2Json(paramRequest), e);
            return new ResponseDto("未知错误");
        }

    }

    /**
     * 待签收
     * @author afi
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDto list(HttpServletRequest request, HttpServletResponse response,String userUid) {
        Header header = getHeader(request);
        if (Check.NuNObj(header)) {
            return new ResponseDto("头信息为空");
        }
        if (Check.NuNStr(userUid)) {
            return new ResponseDto("参数异常");
        }

        LogUtil.info(LOGGER, "传入参数:{}", JsonEntityTransform.Object2Json(userUid));
        try {

            DataTransferObject<List<OrderInfoVO>> dto =ordersService.getOrderInfoWaitingList(userUid);
            return dto.trans2Res();
        } catch (Exception e) {
            LogUtil.error(LOGGER, "【待签收列表】错误,par:{}, e={}",JsonEntityTransform.Object2Json(userUid), e);
            return new ResponseDto("未知错误");
        }

    }


    /**
     * 配送记录
     * @author afi
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/history", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto history(HttpServletRequest request, HttpServletResponse response) {
        Header header = getHeader(request);
        if (Check.NuNObj(header)) {
            return new ResponseDto("头信息为空");
        }
        //获取当前参数
        OrderInfoRequest paramRequest = getEntity(request, OrderInfoRequest.class);
        paramRequest.setKnightUid(getUserId(request));
        if (Check.NuNObj(paramRequest)) {
            return new ResponseDto("异常参数");
        }
        LogUtil.info(LOGGER, "传入参数:{}", JsonEntityTransform.Object2Json(paramRequest));
        try {
            DataTransferObject<PagingResult<OrderInfoVO>> dto =ordersService.getOrderInfoPage(paramRequest);
            return dto.trans2Res();
        } catch (Exception e) {
            LogUtil.error(LOGGER, "【查询配送记录】错误,par:{}, e={}",JsonEntityTransform.Object2Json(paramRequest), e);
            return new ResponseDto("未知错误");
        }
    }

}