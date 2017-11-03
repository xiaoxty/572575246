package cn.ffcs.uom.rolePermission.dao;

import java.util.List;

import cn.ffcs.uom.common.dao.BaseDao;
import cn.ffcs.uom.common.vo.PageInfo;
import cn.ffcs.uom.rolePermission.model.RbacPermissionExtAttr;

public interface RbacPermissionExtAttrDao extends BaseDao {

	/**
	 * 分页取类信息
	 * 
	 * @param rbacPermissionExtAttr
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageInfo queryPageInfoRbacPermissionExtAttr(
			RbacPermissionExtAttr rbacPermissionExtAttr, int currentPage,
			int pageSize);

	public List<RbacPermissionExtAttr> queryRbacPermissionExtAttrList(
			RbacPermissionExtAttr rbacPermissionExtAttr);

	public RbacPermissionExtAttr queryRbacPermissionExtAttr(
			RbacPermissionExtAttr rbacPermissionExtAttr);

}