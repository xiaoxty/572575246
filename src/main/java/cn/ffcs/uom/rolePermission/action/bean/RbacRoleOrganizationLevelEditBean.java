package cn.ffcs.uom.rolePermission.action.bean;

import lombok.Getter;
import lombok.Setter;

import org.zkoss.zul.Button;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Window;

import cn.ffcs.uom.common.treechooser.component.TreeChooserBandbox;
import cn.ffcs.uom.organization.component.OrganizationBandboxExt;
import cn.ffcs.uom.rolePermission.component.RbacRoleRelationTreeBandboxExt;

public class RbacRoleOrganizationLevelEditBean {

	@Getter
	@Setter
	private Window rbacRoleOrganizationLevelEditWindow;

	@Getter
	@Setter
	private Longbox rbacRoleOrgLevelId;

	@Getter
	@Setter
	private TreeChooserBandbox relaCd;

	@Getter
	@Setter
	private OrganizationBandboxExt organizationBandboxExt;

	@Getter
	@Setter
	private RbacRoleRelationTreeBandboxExt rbacRoleRelationTreeBandboxExt;

	@Getter
	@Setter
	private Longbox rbacLowerLevel;

	@Getter
	@Setter
	private Longbox rbacHigherLevel;

	@Getter
	@Setter
	private Button saveBtn;

	@Getter
	@Setter
	private Button cancelBtn;

}