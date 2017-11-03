package cn.ffcs.uom.hisQuery.action.bean;

import lombok.Getter;
import lombok.Setter;

import org.zkoss.zul.Datebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 *岗位编辑Bean
 *@author 
 * 
**/
public class PositionDetailBean {
    /**
    *window.
    **/
    @Getter
    @Setter
    private Window                     positionDetailWindow;
    /**
    *岗位编码.
    **/
    @Getter
    @Setter
    private Textbox                    positionCode;
    /**
    *岗位类型.
    **/
    @Getter
    @Setter
    private Listbox                    positionType;
    /**
    *岗位描述.
    **/
    @Getter
    @Setter
    private Textbox                    positionDesc;
    /**
    *岗位名称.
    **/
    @Getter
    @Setter
    private Textbox                    positionName;
     /**
      *生效时间.
      **/
      @Getter
      @Setter
     private Datebox                    effDate;
}