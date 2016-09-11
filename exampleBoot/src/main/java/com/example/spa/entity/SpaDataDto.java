package com.example.spa.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 温泉情報 DTO
 */
public class SpaDataDto implements Serializable {

	// 温泉地
	private String spaGroup;

	// 施設名
	private String spaName;

	// 県コード
	private String stateCd;

	// 県名
	private String stateName;

	// 泉質
	private String hotType;

	// 泉温
	private String hotTemp;

	// 住所
	private String spaAddr;

	// メモ
	private String spaMemo;


	public String getSpaGroup() {
		return spaGroup;
	}

	public void setSpaGroup(String spaGroup) {
		this.spaGroup = spaGroup;
	}

	public String getSpaName() {
		return spaName;
	}

	public void setSpaName(String spaName) {
		this.spaName = spaName;
	}

	public String getStateCd() {
		return stateCd;
	}

	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getHotType() {
		return hotType;
	}

	public void setHotType(String hotType) {
		this.hotType = hotType;
	}

	public String getHotTemp() {
		return hotTemp;
	}

	public void setHotTemp(String hotTemp) {
		this.hotTemp = hotTemp;
	}

	public String getSpaAddr() {
		return spaAddr;
	}

	public void setSpaAddr(String spaAddr) {
		this.spaAddr = spaAddr;
	}

	public String getSpaMemo() {
		return spaMemo;
	}

	public void setSpaMemo(String spaMemo) {
		this.spaMemo = spaMemo;
	}

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }

}
