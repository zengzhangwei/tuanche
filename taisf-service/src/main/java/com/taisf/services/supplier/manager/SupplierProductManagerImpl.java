package com.taisf.services.supplier.manager;

import com.jk.framework.base.utils.Check;
import com.taisf.services.product.entity.ProductEntity;
import com.taisf.services.supplier.dao.SupplierPackageDao;
import com.taisf.services.supplier.dao.SupplierProductDao;
import com.taisf.services.supplier.dto.SupplierProductRequest;
import com.taisf.services.supplier.entity.SupplierPackageEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>供应商的商品信息</p>
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
@Service("supplier.supplierProductManagerImpl")
public class SupplierProductManagerImpl {

	@Resource(name = "supplier.supplierProductDao")
	private SupplierProductDao supplierProductDao;


	@Resource(name = "supplier.supplierPackageDao")
	private SupplierPackageDao supplierPackageDao;



	/**
	 * 获取礼包列表
	 * @author afi
	 * @param list
	 * @return
	 */
	public List<SupplierPackageEntity> getSupplierPackageByList(List<Integer> list){
		if (Check.NuNCollection(list)){
			return new ArrayList<>();
		}
		return supplierPackageDao.getSupplierPackageByList(list);
	}

	/**
	 * 获取礼包map
	 * @author afi
	 * @param list
	 * @return
	 */
	public Map<String,SupplierPackageEntity> getSupplierPackageByMap(List<Integer> list){
		Map<String,SupplierPackageEntity> map = new HashMap<>();
		if (Check.NuNCollection(list)){
			return map;
		}
		List<SupplierPackageEntity> listPackage = supplierPackageDao.getSupplierPackageByList(list);
		if (!Check.NuNCollection(listPackage)){
			for (SupplierPackageEntity packageEntity : listPackage) {
				map.put(packageEntity.getId()+"",packageEntity);
			}
		}
		return map;
	}



	/**
	 * 根据供应商获取其菜单信息
	 * @author afi
	 * @param supplierProductRequest
	 * @return
	 */
	public List<ProductEntity> getProductListBySupplierAndType(SupplierProductRequest supplierProductRequest){
		//获取商品列表
		return supplierProductDao.getProductListBySupplierAndType(supplierProductRequest);
	}


	/**
	 * 获取当前的供应商打包信息
	 * @author afi
	 * @param supplierCode
	 * @return
	 */
	public List<SupplierPackageEntity> getSupplierPackageByCode(String supplierCode){
		//获取当前的推荐列表
		return supplierPackageDao.getSupplierPackageByCode(supplierCode);
	}





}
