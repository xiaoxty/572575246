package cn.ffcs.uom.organization.model;

// Generated 2017-6-28 17:55:45 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.math.BigDecimal;

import cn.ffcs.uom.common.dao.BaseDao;
import cn.ffcs.uom.common.util.ApplicationContextUtil;

/**
 * MdmSupplierCreate generated by hbm2java
 */
public class MdmSupplierCreate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 143194386300004935L;
	
	private Long id;
	private String status;
	private Long zsqdId;
	private String lifnr;
	private String ktokk;
	private String name1;
	private String name2;
	private String sort1;
	private String street;
	private String pstlz;
	private String city1;
	private String land1;
	private String langu;
	private String telf1;
	private String telf2;
	private String telfx;
	private String smtpAddr;
	private String brsch;
	private String vbund;
	private String zregno;
	private String zprop;
	private String zlglid;
	private String zorgco;
	private String zcop;
	private String zleglRep;
	private String zregco;
	private String zregio;
	private String zcont;
	private String zregcap;
	private String zregcy;
	private String ztxptp;
	private String ztxpid;
	private String zsfgl;
	private String zvatProxy;
	private String zvatAmountLimit;
	private String zvatQtyLimit;
	private String zvatPayProxy;
	private String zbusiness;
	private String ztaxerNum;
	private String zdxhzywlxfw;
	private String zrlwbslx;
	private String msgid;

	/**
	 * 构造方法
	 */
	public MdmSupplierCreate() {
		super();
	}

	/**
	 * 创建对象实例.
	 * 
	 * @return MdmSupplierCreate
	 */
	public static MdmSupplierCreate newInstance() {
		return new MdmSupplierCreate();
	}

	/**
	 * 获取dao
	 * 
	 * @return
	 */
	public static BaseDao repository() {
		return (BaseDao) ApplicationContextUtil.getBean("baseDao");
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getZsqdId() {
		return this.zsqdId;
	}

	public void setZsqdId(Long zsqdId) {
		this.zsqdId = zsqdId;
	}

	public String getLifnr() {
		return this.lifnr;
	}

	public void setLifnr(String lifnr) {
		this.lifnr = lifnr;
	}

	public String getKtokk() {
		return this.ktokk;
	}

	public void setKtokk(String ktokk) {
		this.ktokk = ktokk;
	}

	public String getName1() {
		return this.name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return this.name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getSort1() {
		return this.sort1;
	}

	public void setSort1(String sort1) {
		this.sort1 = sort1;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPstlz() {
		return this.pstlz;
	}

	public void setPstlz(String pstlz) {
		this.pstlz = pstlz;
	}

	public String getCity1() {
		return this.city1;
	}

	public void setCity1(String city1) {
		this.city1 = city1;
	}

	public String getLand1() {
		return this.land1;
	}

	public void setLand1(String land1) {
		this.land1 = land1;
	}

	public String getLangu() {
		return this.langu;
	}

	public void setLangu(String langu) {
		this.langu = langu;
	}

	public String getTelf1() {
		return this.telf1;
	}

	public void setTelf1(String telf1) {
		this.telf1 = telf1;
	}

	public String getTelf2() {
		return this.telf2;
	}

	public void setTelf2(String telf2) {
		this.telf2 = telf2;
	}

	public String getTelfx() {
		return this.telfx;
	}

	public void setTelfx(String telfx) {
		this.telfx = telfx;
	}

	public String getSmtpAddr() {
		return this.smtpAddr;
	}

	public void setSmtpAddr(String smtpAddr) {
		this.smtpAddr = smtpAddr;
	}

	public String getBrsch() {
		return this.brsch;
	}

	public void setBrsch(String brsch) {
		this.brsch = brsch;
	}

	public String getVbund() {
		return this.vbund;
	}

	public void setVbund(String vbund) {
		this.vbund = vbund;
	}

	public String getZregno() {
		return this.zregno;
	}

	public void setZregno(String zregno) {
		this.zregno = zregno;
	}

	public String getZprop() {
		return this.zprop;
	}

	public void setZprop(String zprop) {
		this.zprop = zprop;
	}

	public String getZlglid() {
		return this.zlglid;
	}

	public void setZlglid(String zlglid) {
		this.zlglid = zlglid;
	}

	public String getZorgco() {
		return this.zorgco;
	}

	public void setZorgco(String zorgco) {
		this.zorgco = zorgco;
	}

	public String getZcop() {
		return this.zcop;
	}

	public void setZcop(String zcop) {
		this.zcop = zcop;
	}

	public String getZleglRep() {
		return this.zleglRep;
	}

	public void setZleglRep(String zleglRep) {
		this.zleglRep = zleglRep;
	}

	public String getZregco() {
		return this.zregco;
	}

	public void setZregco(String zregco) {
		this.zregco = zregco;
	}

	public String getZregio() {
		return this.zregio;
	}

	public void setZregio(String zregio) {
		this.zregio = zregio;
	}

	public String getZcont() {
		return this.zcont;
	}

	public void setZcont(String zcont) {
		this.zcont = zcont;
	}

	public String getZregcap() {
		return this.zregcap;
	}

	public void setZregcap(String zregcap) {
		this.zregcap = zregcap;
	}

	public String getZregcy() {
		return this.zregcy;
	}

	public void setZregcy(String zregcy) {
		this.zregcy = zregcy;
	}

	public String getZtxptp() {
		return this.ztxptp;
	}

	public void setZtxptp(String ztxptp) {
		this.ztxptp = ztxptp;
	}

	public String getZtxpid() {
		return this.ztxpid;
	}

	public void setZtxpid(String ztxpid) {
		this.ztxpid = ztxpid;
	}

	public String getZsfgl() {
		return this.zsfgl;
	}

	public void setZsfgl(String zsfgl) {
		this.zsfgl = zsfgl;
	}

	public String getZvatProxy() {
		return this.zvatProxy;
	}

	public void setZvatProxy(String zvatProxy) {
		this.zvatProxy = zvatProxy;
	}

	public String getZvatAmountLimit() {
		return this.zvatAmountLimit;
	}

	public void setZvatAmountLimit(String zvatAmountLimit) {
		this.zvatAmountLimit = zvatAmountLimit;
	}

	public String getZvatQtyLimit() {
		return this.zvatQtyLimit;
	}

	public void setZvatQtyLimit(String zvatQtyLimit) {
		this.zvatQtyLimit = zvatQtyLimit;
	}

	public String getZvatPayProxy() {
		return this.zvatPayProxy;
	}

	public void setZvatPayProxy(String zvatPayProxy) {
		this.zvatPayProxy = zvatPayProxy;
	}

	public String getZbusiness() {
		return this.zbusiness;
	}

	public void setZbusiness(String zbusiness) {
		this.zbusiness = zbusiness;
	}

	public String getZtaxerNum() {
		return this.ztaxerNum;
	}

	public void setZtaxerNum(String ztaxerNum) {
		this.ztaxerNum = ztaxerNum;
	}

	public String getZdxhzywlxfw() {
		return this.zdxhzywlxfw;
	}

	public void setZdxhzywlxfw(String zdxhzywlxfw) {
		this.zdxhzywlxfw = zdxhzywlxfw;
	}

	public String getZrlwbslx() {
		return this.zrlwbslx;
	}

	public void setZrlwbslx(String zrlwbslx) {
		this.zrlwbslx = zrlwbslx;
	}

	public String getMsgid() {
		return this.msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

}