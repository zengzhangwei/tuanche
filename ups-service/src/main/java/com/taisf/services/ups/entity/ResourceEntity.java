package com.taisf.services.ups.entity;


import com.jk.framework.base.entity.BaseEntity;

import java.util.Date;

/**
 * 
 * <p>权限菜单实体类</p>
 * 
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 * 
 * @author bushujie
 * @since 1.0
 * @version 1.0
 */
public class ResourceEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7144560472384025171L;

	/**
	 * 自增id
	 * to the database column t_sys_resource.id
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	private Integer id;

	/**
	 * 逻辑fid
	 * the database column t_sys_resource.fid
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	private String fid;
	
	/**
	 * 系统fid
	 */
	private String systemsFid;

	/**
	 *菜单名称
	 *
	 * the database column t_sys_resource.res_name
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	private String resName;


	/**
	 * 样式名称
	 * the database column t_sys_resource.class_name
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	private String className;

	/**
	 * 请求地址
	 * the database column t_sys_resource.res_url
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	private String resUrl;

	/**
	 * 是否叶子节点 0：否，1：是
	 * 
	 * the database column t_sys_resource.is_leaf
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	private Integer isLeaf;

	/**
	 * 排序号
	 * the database column t_sys_resource.order_code
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	private Integer orderCode;

	/**
	 * 父级fid
	 * the database column t_sys_resource.parent_fid
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	private String parentFid;

	/**
	 * 菜单层级
	 * the database column t_sys_resource.res_level
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	private Integer resLevel;

	/**
	 * 菜单类型 0：非功能点，1：功能点菜单，2：功能按钮
	 * the database column t_sys_resource.res_type
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	private Integer resType;

	/**
	 * 是否删除 0：否，1：是
	 * the database column t_sys_resource.is_del
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	private Integer isDel;

	/**
	 * 创建时间
	 * the database column t_sys_resource.create_date
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	private Date createDate;

	/**
	 * 最后更新时间
	 * the database column t_sys_resource.last_modify_date
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	private Date lastModifyDate;

	/**
	 * 创建人fid
	 * the database column t_sys_resource.create_fid
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	private String createFid;

	/**
	 * 菜单状态
	 */
	private  Integer resState ;
	
	/**
	 * 菜单权限类型  0:普通权限  1=特权菜单
	 */
	private Integer  menuAuth;

	/**
	 * @return the menuAuth
	 */
	public Integer getMenuAuth() {
		return menuAuth;
	}

	/**
	 * @param menuAuth the menuAuth to set
	 */
	public void setMenuAuth(Integer menuAuth) {
		this.menuAuth = menuAuth;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_sys_resource.id
	 *
	 * @return the value of t_sys_resource.id
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_sys_resource.id
	 *
	 * @param id
	 *            the value for t_sys_resource.id
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_sys_resource.fid
	 *
	 * @return the value of t_sys_resource.fid
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public String getFid() {
		return fid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_sys_resource.fid
	 *
	 * @param fid
	 *            the value for t_sys_resource.fid
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public void setFid(String fid) {
		this.fid = fid == null ? null : fid.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_sys_resource.res_name
	 *
	 * @return the value of t_sys_resource.res_name
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public String getResName() {
		return resName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_sys_resource.res_name
	 *
	 * @param resName
	 *            the value for t_sys_resource.res_name
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public void setResName(String resName) {
		this.resName = resName == null ? null : resName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_sys_resource.class_name
	 *
	 * @return the value of t_sys_resource.class_name
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_sys_resource.class_name
	 *
	 * @param className
	 *            the value for t_sys_resource.class_name
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public void setClassName(String className) {
		this.className = className == null ? null : className.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_sys_resource.res_url
	 *
	 * @return the value of t_sys_resource.res_url
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public String getResUrl() {
		return resUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_sys_resource.res_url
	 *
	 * @param resUrl
	 *            the value for t_sys_resource.res_url
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public void setResUrl(String resUrl) {
		this.resUrl = resUrl == null ? null : resUrl.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_sys_resource.is_leaf
	 *
	 * @return the value of t_sys_resource.is_leaf
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public Integer getIsLeaf() {
		return isLeaf;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_sys_resource.is_leaf
	 *
	 * @param isLeaf
	 *            the value for t_sys_resource.is_leaf
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_sys_resource.order_code
	 *
	 * @return the value of t_sys_resource.order_code
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public Integer getOrderCode() {
		return orderCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_sys_resource.order_code
	 *
	 * @param orderCode
	 *            the value for t_sys_resource.order_code
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public void setOrderCode(Integer orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_sys_resource.parent_fid
	 *
	 * @return the value of t_sys_resource.parent_fid
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public String getParentFid() {
		return parentFid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_sys_resource.parent_fid
	 *
	 * @param parentFid
	 *            the value for t_sys_resource.parent_fid
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public void setParentFid(String parentFid) {
		this.parentFid = parentFid == null ? null : parentFid.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_sys_resource.res_level
	 *
	 * @return the value of t_sys_resource.res_level
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public Integer getResLevel() {
		return resLevel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_sys_resource.res_level
	 *
	 * @param resLevel
	 *            the value for t_sys_resource.res_level
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public void setResLevel(Integer resLevel) {
		this.resLevel = resLevel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_sys_resource.res_type
	 *
	 * @return the value of t_sys_resource.res_type
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public Integer getResType() {
		return resType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_sys_resource.res_type
	 *
	 * @param resType
	 *            the value for t_sys_resource.res_type
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public void setResType(Integer resType) {
		this.resType = resType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_sys_resource.is_del
	 *
	 * @return the value of t_sys_resource.is_del
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public Integer getIsDel() {
		return isDel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_sys_resource.is_del
	 *
	 * @param isDel
	 *            the value for t_sys_resource.is_del
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_sys_resource.create_date
	 *
	 * @return the value of t_sys_resource.create_date
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_sys_resource.create_date
	 *
	 * @param createDate
	 *            the value for t_sys_resource.create_date
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_sys_resource.last_modify_date
	 *
	 * @return the value of t_sys_resource.last_modify_date
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public Date getLastModifyDate() {
		return lastModifyDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_sys_resource.last_modify_date
	 *
	 * @param lastModifyDate
	 *            the value for t_sys_resource.last_modify_date
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column t_sys_resource.create_fid
	 *
	 * @return the value of t_sys_resource.create_fid
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public String getCreateFid() {
		return createFid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column t_sys_resource.create_fid
	 *
	 * @param createFid
	 *            the value for t_sys_resource.create_fid
	 *
	 * @mbggenerated Thu Mar 10 21:35:59 CST 2016
	 */
	public void setCreateFid(String createFid) {
		this.createFid = createFid == null ? null : createFid.trim();
	}
	public Integer getResState() {
		return resState;
	}

	public void setResState(Integer resState) {
		this.resState = resState;
	}
	
	/**
	 * @return the systemsFid
	 */
	public String getSystemsFid() {
		return systemsFid;
	}

	/**
	 * @param systemsFid the systemsFid to set
	 */
	public void setSystemsFid(String systemsFid) {
		this.systemsFid = systemsFid;
	}
}
