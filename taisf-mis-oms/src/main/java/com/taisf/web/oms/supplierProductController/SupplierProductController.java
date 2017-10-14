package com.taisf.web.oms.supplierProductController;

import com.jk.framework.base.entity.DataTransferObject;
import com.jk.framework.base.page.PagingResult;
import com.jk.framework.base.utils.Check;
import com.jk.framework.base.utils.JsonEntityTransform;
import com.jk.framework.log.utils.LogUtil;
import com.taisf.services.base.entity.EmployeeSupplierEntity;
import com.taisf.services.base.service.EmployeeSupplierService;
import com.taisf.services.permission.entity.EmployeeEntity;
import com.taisf.services.product.api.ProductService;
import com.taisf.services.product.dto.ProductListRequest;
import com.taisf.services.product.entity.ProductEntity;
import com.taisf.services.supplier.api.SupplierProductService;
import com.taisf.services.supplier.entity.SupplierProductEntity;
import com.taisf.web.oms.common.constant.LoginConstant;
import com.taisf.web.oms.common.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("supplierProduct/")
public class SupplierProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private SupplierProductService supplierProductService;

    @Autowired
    private EmployeeSupplierService rmployeeSupplierService;

    /**
     * @author:zhangzhengguang
     * @date:2017/10/11
     * @description:菜单录入列表
     **/
    @RequestMapping("list")
    public String list(HttpServletRequest request) {
        return "supplierProduct/supplierProductList";
    }

    /**
     * @author:zhangzhengguang
     * @date:2017/10/11
     * @description:分页查询商品列表数据
     **/
    @RequestMapping("pageList")
    @ResponseBody
    public PageResult pageList(HttpServletRequest request, ProductListRequest productListRequest) {
        PageResult pageResult = new PageResult();
        try {
            DataTransferObject<PagingResult<ProductEntity>> dto = productService.pageListProduct(productListRequest);
            //查询出当前供餐商下所有菜品信息
            HttpSession session = request.getSession();
            EmployeeEntity employeeEntity = (EmployeeEntity) session.getAttribute(LoginConstant.SESSION_KEY);
            if (!Check.NuNObj(dto.getData())) {
                List<SupplierProductEntity> entityList = supplierProductService.getSupplierProductByUserId(employeeEntity.getUserId()).getData();
                if (!Check.NuNCollection(entityList)) {
                    dto.getData().getList().stream().forEach((x) -> {
                        entityList.stream().forEach((y) -> {
                            if (x.getId() == y.getProductCode()) {
                                x.setIsDel(1);
                            }
                        });
                    });
                }
                pageResult.setRows(dto.getData().getList());
                pageResult.setTotal(dto.getData().getTotal());
            }
        } catch (Exception e) {
            LogUtil.info(LOGGER, "params:{}", JsonEntityTransform.Object2Json(productListRequest));
            LogUtil.error(LOGGER, "error:{}", e);
            return new PageResult();
        }
        return pageResult;
    }

    /**
     * @author:zhangzhengguang
     * @date:2017/10/11
     * @description:撤回
     **/
    @RequestMapping("revocation")
    @ResponseBody
    public DataTransferObject<Void> revocation(HttpServletRequest request, Integer id) {
        DataTransferObject<Void> dto = new DataTransferObject<>();
        if (Check.NuNObj(id)) {
            dto.setErrCode(DataTransferObject.ERROR);
            dto.setErrorMsg("参数异常");
            return dto;
        }
        try {
            HttpSession session = request.getSession();
            EmployeeEntity employeeEntity = (EmployeeEntity) session.getAttribute(LoginConstant.SESSION_KEY);
            dto = supplierProductService.deleteByUserIdAndProudctId(employeeEntity.getUserId(), id);
        } catch (Exception e) {
            LogUtil.error(LOGGER, "error:{}", e);
            dto.setErrCode(DataTransferObject.ERROR);
            dto.setErrorMsg("系统错误");
            return dto;
        }
        return dto;
    }

    /**
     * @author:zhangzhengguang
     * @date:2017/10/13
     * @description:添加菜品
     **/
    @RequestMapping("addSupplierProduct")
    @ResponseBody
    public DataTransferObject<Void> addSupplierProduct(HttpServletRequest request, Integer id) {
        DataTransferObject<Void> dto = new DataTransferObject<>();
        if (Check.NuNObj(id)) {
            dto.setErrCode(DataTransferObject.ERROR);
            dto.setErrorMsg("参数异常");
            return dto;
        }
        try {
            HttpSession session = request.getSession();
            EmployeeEntity employeeEntity = (EmployeeEntity) session.getAttribute(LoginConstant.SESSION_KEY);
            ProductEntity productEntity = productService.getProductById(id).getData();
            SupplierProductEntity supplierProductEntity = new SupplierProductEntity();
            //根据userId 得到 商家code
            EmployeeSupplierEntity employeeSupplierEntity = rmployeeSupplierService.getByUserId(employeeEntity.getUserId());
            //1商家code
            supplierProductEntity.setSupplierCode(employeeSupplierEntity.getSupplierCode());
            //2商品code
            supplierProductEntity.setProductCode(productEntity.getId());
            //3商品价格
            supplierProductEntity.setProductPrice(productEntity.getPriceSale());
            //4商品类型 product_type
            supplierProductEntity.setProductType(productEntity.getProductType());
            //5创建时间
            supplierProductEntity.setCreateTime(new Date());
            //6.执行保存
            dto = supplierProductService.saveSupplierProduct(supplierProductEntity);
        } catch (Exception e) {
            LogUtil.error(LOGGER, "error:{}", e);
            dto.setErrCode(DataTransferObject.ERROR);
            dto.setErrorMsg("系统错误");
            return dto;
        }
        return dto;
    }

    /**
     * @author:zhangzhengguang
     * @date:2017/10/13
     * @description:查询菜单
     **/
    @RequestMapping("findList")
    public String findList(HttpServletRequest request) {
        return "supplierProduct/findSupplierProductList";
    }

    /**
     * @author:zhangzhengguang
     * @date:2017/10/11
     * @description:分页查询商品列表数据
     **/
    @RequestMapping("findPageList")
    @ResponseBody
    public PageResult findPageList(HttpServletRequest request, ProductListRequest productListRequest) {
        PageResult pageResult = new PageResult();
        try {
            DataTransferObject<PagingResult<ProductEntity>> dto = supplierProductService.pageListProduct(productListRequest);
            //查询出当前供餐商下所有菜品信息
            if (!Check.NuNObj(dto.getData())) {
                pageResult.setRows(dto.getData().getList());
                pageResult.setTotal(dto.getData().getTotal());
            }
        } catch (Exception e) {
            LogUtil.info(LOGGER, "params :{}", JsonEntityTransform.Object2Json(productListRequest));
            LogUtil.error(LOGGER, "error :{}", e);
            return new PageResult();
        }
        return pageResult;
    }

}