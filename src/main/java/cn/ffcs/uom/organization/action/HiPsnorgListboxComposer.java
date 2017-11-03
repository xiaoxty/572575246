package cn.ffcs.uom.organization.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Components;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.IdSpace;
import org.zkoss.zkplus.databind.BindingListModelList;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModel;

import cn.ffcs.uom.common.util.ApplicationContextUtil;
import cn.ffcs.uom.common.util.IPortletInfoProvider;
import cn.ffcs.uom.common.util.ListboxUtils;
import cn.ffcs.uom.common.util.NumericUtil;
import cn.ffcs.uom.common.vo.PageInfo;
import cn.ffcs.uom.organization.action.bean.HiPsnorgListboxBean;
import cn.ffcs.uom.organization.manager.HiPsnorgManager;
import cn.ffcs.uom.organization.model.HanaHiPsnorg;
import cn.ffcs.uom.organization.model.UnitedDirectory;

/**
 * 集团统一目录查询
 * 
 * @version Revision 1.0.0
 */
@Controller
@Scope("prototype")
public class HiPsnorgListboxComposer extends Div implements IdSpace {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6336139345149041445L;

	/**
	 * bean.
	 */
	private HiPsnorgListboxBean bean = new HiPsnorgListboxBean();

	private HiPsnorgManager hiPsnorgManager = (HiPsnorgManager) ApplicationContextUtil
			.getBean("hiPsnorgManager");

	/**
	 * zul.
	 */
	private final String zul = "/pages/organization/hi_psnorg_listbox.zul";

	/**
	 * 查询HiPsnorg.
	 */
	private HanaHiPsnorg qryHiPsnorg;

	@Getter
	@Setter
	private IPortletInfoProvider portletInfoProvider;

	/**
	 * 页面标志
	 */
	@Getter
	@Setter
	private String pagePosition;

	public HiPsnorgListboxComposer() {
		Executions.createComponents(this.zul, this, null);
		Components.wireVariables(this, bean);
		Components.addForwards(this, this, '$');
	}

	public void onCreate() throws Exception {
		this.bean.getDate().setValue(new java.sql.Date(new Date().getTime()));
	}

	/**
	 * 分页响应事件
	 * 
	 * @throws Exception
	 *             异常
	 */
	public void onListboxPaging() throws Exception {
		this.queryHiPsnorg();
	}

	/**
	 * 查询
	 * 
	 * @throws Exception
	 *             异常
	 */
	private void queryHiPsnorg() throws Exception {
		qryHiPsnorg = new HanaHiPsnorg();
		String monthId = new SimpleDateFormat("yyyyMM").format(this.bean
				.getDate().getValue());
		qryHiPsnorg.setMonthId(Long.parseLong(monthId));

		ListboxUtils.clearListbox(bean.getHiPsnorgListbox());
		PageInfo pageInfo = hiPsnorgManager.queryPageInfoByHiPsnorg(
				qryHiPsnorg,
				this.bean.getHiPsnorgListPaging().getActivePage() + 1,
				this.bean.getHiPsnorgListPaging().getPageSize());
		ListModel dataList = new BindingListModelList(pageInfo.getDataList(),
				true);
		this.bean.getHiPsnorgListbox().setModel(dataList);
		this.bean.getHiPsnorgListPaging().setTotalSize(
				NumericUtil.nullToZero(pageInfo.getTotalCount()));
	}

	/**
	 * 查询按钮
	 * 
	 * @throws Exception
	 */
	public void onQuery() throws Exception {
		this.bean.getHiPsnorgListPaging().setActivePage(0);
		this.queryHiPsnorg();
	}

	/**
	 * 重置按钮
	 * 
	 * @throws Exception
	 */
	public void onReset() throws Exception {
		this.bean.getDate().setValue(new java.sql.Date(new Date().getTime()));
	}
}
