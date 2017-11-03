package cn.ffcs.uom.position.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.zkoss.zk.ui.Components;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.IdSpace;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Button;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.api.Textbox;

import cn.ffcs.uom.common.treechooser.component.ICheckHasChildrenCallback;
import cn.ffcs.uom.common.treechooser.constants.Constants;
import cn.ffcs.uom.common.util.StrUtil;
import cn.ffcs.uom.common.zkplus.zul.tree.node.impl.TreeNodeImpl;
import cn.ffcs.uom.position.model.CtPositionNode;

/**
 * @author 曾臻
 * @date 2013-06-05
 */
@SuppressWarnings("serial")
public class CtPositionTreeBandbox extends Bandbox implements IdSpace {

	// -----------components-----------------
	private final String zul = "/pages/position/comp/ct_position_tree_bandbox.zul";
	private CtPositionTree ctPositionTree;
	private Button okButton;
	private Button cancelButton;
	private Button findButton;
	private Textbox keywordTextbox;
	// -----------输入参数------------------
	private String pattern;// 层次格式，格式为："a,b,c...",a/b/c为各层次所占字符数，如"2,2,2,6"
	private char fill;// 定长编码父节点所占字符以后的填充字符，默认为'0'
	private String mode;// 单选和多选两种模式
	private String range;// 只选择末级节点和任意选择节点两种模式
	// -----------返回结果--------------------
	private String returnType;// 用户是否作了选择，也即点即确定还是取消
	private String resultText;// 返回文本
	private List<Pair<String, String>> resultArr;// 选择节点列表,left=节点标识,right=节点中文名
	// -------------cache----------------------
	private CtPositionNodeCache cache;// 所有属性值的缓存，加快树加载速度

	public Textbox getKeywordTextbox() {
		return keywordTextbox;
	}

	public void setKeywordTextbox(Textbox keywordTextbox) {
		this.keywordTextbox = keywordTextbox;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public char getFill() {
		return fill;
	}

	public void setFill(char fill) {
		this.fill = fill;
	}

	public CtPositionTree getCtPositionTree() {
		return ctPositionTree;
	}

	public void setCtPositionTree(CtPositionTree attrValueTree) {
		this.ctPositionTree = attrValueTree;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getZul() {
		return zul;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getResultText() {
		return resultText;
	}

	public void setResultText(String resultText) {
		this.resultText = resultText;
	}

	public List<Pair<String, String>> getResultArr() {
		return resultArr;
	}

	public void setResultArr(List<Pair<String, String>> resultArr) {
		this.resultArr = resultArr;
	}

	public Button getOkButton() {
		return okButton;
	}

	public void setOkButton(Button okButton) {
		this.okButton = okButton;
	}

	public Button getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(Button cancelButton) {
		this.cancelButton = cancelButton;
	}

	public Button getFindButton() {
		return findButton;
	}

	public void setFindButton(Button findButton) {
		this.findButton = findButton;
	}

	public CtPositionTreeBandbox() {
		Executions.createComponents(this.zul, this, null);
		Components.wireVariables(this, this);
		Components.addForwards(this, this, '$');
		buildParams();
		ctPositionTree.setTreeChooserBandbox(this);
		cache = new CtPositionNodeCache(this);
	}

	public void onCreate() {
		//
		final CtPositionTreeBandbox _this = this;
		setReadonly(true);
		if (Constants.MODE_MULTIPLE.equals(this.mode)) {
			ctPositionTree.setMultiple(true);
			ctPositionTree.setCheckmark(true);
		} else {
			ctPositionTree.setMultiple(false);
			ctPositionTree.setCheckmark(true);
		}

		// events
		cancelButton.addEventListener(Events.ON_CLICK, new EventListener() {
			public void onEvent(Event event) throws Exception {
				_this.returnType = Constants.RETURN_TYPE_CANCEL;
				_this.close();
			}
		});
		okButton.addEventListener(Events.ON_CLICK, new EventListener() {
			public void onEvent(Event event) throws Exception {
				// /**
				// * 调用控件用来监听确定修改事件
				// */
				// Events.postEvent("onChooseOK", TreeChooserBandbox.this,
				// attrName);
				@SuppressWarnings("unchecked")
				Set<Treeitem> set = _this.ctPositionTree.getSelectedItems();
				List<CtPositionNode> nodes = new ArrayList<CtPositionNode>();
				for (Treeitem ti : set) {
					@SuppressWarnings("rawtypes")
					CtPositionNode node = (CtPositionNode) ((TreeNodeImpl) ti.getValue())
							.getEntity();
					nodes.add(node);
				}
				_this.returnType = Constants.RETURN_TYPE_OK;
				_this.buildResult(nodes);
				_this.close();
				/**
				 * 调用控件用来监听确定修改事件
				 */
				Events.postEvent("onChooseOK", CtPositionTreeBandbox.this,
						null);
			}
		});
		EventListener findListener = new EventListener() {
			public void onEvent(Event event) throws Exception {
				List<Treeitem> result = new ArrayList<Treeitem>();
				Collection<Treeitem> tis = ctPositionTree.getItems();
				String keyword = keywordTextbox.getValue();

				for (Treeitem ti : tis) {
					CtPositionNode node = (CtPositionNode) ((TreeNodeImpl) ti.getValue())
							.getEntity();
					Treecell cell = null;
					List list = ti.getTreerow().getChildren();
					if (list != null) {
						cell = (Treecell) list.get(0);
						cell.setStyle("font-weight:bold");
					}
					if (node.getPositionName().contains(keyword)) {
						if (cell != null) {
							cell.setStyle("font-weight:bold");
						}
					} else {
						if (cell != null) {
							cell.setStyle("font-weight:normal");
						}
					}
				}
			}
		};
		findButton.addEventListener(Events.ON_CLICK, findListener);
		keywordTextbox.addEventListener(Events.ON_OK, findListener);

		// ..实现初始化加载已选信息
		// TODO 加了监听box就会多出下面的空白
		// 写死高度像素值暂时解决
		this.addEventListener(Events.ON_OPEN, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				// set initial check state
				Set<String> selection = new HashSet<String>();
				if (resultArr != null) {
					for (Pair<String, String> pair : resultArr)
						selection.add(pair.getLeft());
				}

				Collection<Treeitem> tis = ctPositionTree.getItems();

				for (Treeitem ti : tis) {
					CtPositionNode node = (CtPositionNode) ((TreeNodeImpl) ti.getValue())
							.getEntity();
					if (selection.contains(node.getPositionCode()))
						ti.setSelected(true);
					else
						ti.setSelected(false);
				}
			}
		});
	}

	private void buildParams() {
		if (StringUtils.isEmpty(mode))
			mode = "single";
		if (StringUtils.isEmpty(range))
			range = "any";
		if (fill == '\0')
			fill = '0';
	}

	private void buildResult(List<CtPositionNode> nodes) {
		List<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
		String str = "";
		for (CtPositionNode node : nodes) {
			Pair<String, String> pair = Pair.of(node.getPositionCode(),
					node.getPositionName());
			list.add(pair);
			str += node.getPositionName() + ",";
		}
		this.resultText = StringUtils.removeEnd(str, ",");
		this.resultArr = list;
		this.setValue(resultText);
	}

	//
	public List<CtPositionNode> getAllNodes() {
		return cache.getAllNodes();
	}

	public boolean isHasChildren(String code, ICheckHasChildrenCallback callback) {
		return cache.isHasChildren(code, callback);
	}

	/**
	 * 添加获取attrValue的值，不获取attrValueNames .
	 * 
	 * @return
	 * @author wangyong 2013-6-13 wangyong
	 */
	public String getPositionCode() {
		if (null == resultArr || resultArr.isEmpty()) {
			return null;
		}
		Pair<String, String> pair = resultArr.get(0);
		return pair.getLeft();
	}

	/**
	 * 快速设置初始值
	 * 
	 * @author 曾臻
	 * @date 2013-6-19
	 * @param codeList
	 *            编码列表
	 */
	public void setInitialValue(List<String> codeList) {
		List<CtPositionNode> nodes = cache.getAllNodes();
		Map<String, String> map = new HashMap<String, String>();
		for (CtPositionNode node : nodes)
			map.put(node.getPositionCode(), node.getPositionCode());

		resultArr = new ArrayList<Pair<String, String>>();
		String str = "";
		for (String code : codeList) {
			String text = map.get(code);
			if (text == null)
				continue;
			str += text + ",";
			resultArr.add(Pair.of(code, text));
		}
		resultText = StringUtils.removeEnd(str, ",");
		this.setText(resultText);
	}

	/**
	 * 设置特殊节点的样式
	 * 
	 * @param codeList
	 *            ：attr_value
	 */
	public void setSpecialNodeStyle(List<String> positionCodeList, String style) {
		if (positionCodeList != null && positionCodeList.size() > 0) {
			for (String positionCode : positionCodeList) {
				Collection<Treeitem> tis = ctPositionTree.getItems();
				for (Treeitem ti : tis) {
					CtPositionNode node = (CtPositionNode) ((TreeNodeImpl) ti.getValue())
							.getEntity();
					Treecell cell = null;
					List list = ti.getTreerow().getChildren();
					if (list != null) {
						cell = (Treecell) list.get(0);
					}
					if (node.getPositionCode().contains(positionCode)) {
						if (cell != null) {
							if (StrUtil.isEmpty(style)) {
								cell.setStyle("color:blue");
							} else {
								cell.setStyle(style);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 设置固定的值
	 * 
	 * @param positionCodeList
	 *            可选择值的编码列表
	 */
	@SuppressWarnings("unchecked")
	public void setOptionNodes(List<String> positionCodeList) {
		if (positionCodeList != null && positionCodeList.size() > 0) {
			Collection<Treeitem> tis = ctPositionTree.getItems();
			for (Treeitem ti : tis) {
				ti.setDisabled(true);
				CtPositionNode node = (CtPositionNode) ((TreeNodeImpl) ti.getValue()).getEntity();
				for (String positionCode : positionCodeList) {
					if (node.getPositionCode().contains(positionCode)) {
						ti.setDisabled(false);
					}
				}
			}
		}
	}

	/**
	 * 设置固定的值
	 * 
	 * @param optionAttrValueList
	 *            不可选择值的编码列表
	 */
	@SuppressWarnings("unchecked")
	public void setDisabledOptionNodes(List<String> disabledOptionPositionCodeList) {
		if (disabledOptionPositionCodeList != null
				&& disabledOptionPositionCodeList.size() > 0) {
			Collection<Treeitem> tis = ctPositionTree.getItems();
			for (Treeitem ti : tis) {
				ti.setDisabled(false);
				CtPositionNode node = (CtPositionNode) ((TreeNodeImpl) ti.getValue()).getEntity();
				for (String positionCode : disabledOptionPositionCodeList) {
					if (node.getPositionCode().contains(positionCode)) {
						ti.setDisabled(true);
					}
				}
			}
		} else {
			Collection<Treeitem> tis = ctPositionTree.getItems();
			for (Treeitem ti : tis) {
				ti.setDisabled(true);
			}
		}
	}
}
