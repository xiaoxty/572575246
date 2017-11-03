package cn.ffcs.uom.restservices.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
public class BizZoneCustomAttrInParam {

	@Setter
	@Getter
	@XmlElement(name = "BIZ_ZONE_NBR")
	private String bizZoneNbr;

	@Setter
	@Getter
	@XmlElementWrapper(name = "ATTR_ITEMS")
	@XmlElement(name = "ATTR_ITEM")
	private List<AttrItemInParam> attrItems;

}