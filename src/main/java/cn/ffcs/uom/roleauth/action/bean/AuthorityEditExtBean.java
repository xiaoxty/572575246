package cn.ffcs.uom.roleauth.action.bean;

import lombok.Getter;
import lombok.Setter;

import org.zkoss.zul.Button;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class AuthorityEditExtBean {

	@Getter
	@Setter
	private Window authEditWindow;
	/**
	 * Panel.
	 **/
	@Getter
	@Setter
	private Panel authEditExtPanel;
	/**
	 * 名称.
	 **/
	@Getter
	@Setter
	private Textbox authName;
	/**
	 * 状态.
	 **/
	@Getter
	@Setter
	private Textbox statusCdName;
	/**
	 * 生效时间.
	 **/
	@Getter
	@Setter
	private Textbox effDateStr;
	/**
	 * 失效时间.
	 **/
	@Getter
	@Setter
	private Textbox expDateStr;
	/**
	 * 编辑按钮.
	 */
	@Getter
	@Setter
	private Button editButton;
	/**
	 * 保存按钮.
	 */
	@Getter
	@Setter
	private Button saveButton;
	/**
	 * 恢复按钮.
	 */
	@Getter
	@Setter
	private Button recoverButton;
	/**
	 * 确定按钮.
	 */
	@Getter
	@Setter
	private Button okButton;
	/**
	 * 取消按钮.
	 */
	@Getter
	@Setter
	private Button cancelButton;
}