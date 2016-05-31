package com.example.spa.form;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * 温泉情報の入力
 *
 */
public class SpaRegistForm implements Serializable {

	private static final long serialVersionUID = -1L;

	// 温泉地
	@NotNull
	private String spaGroup;

	// 施設名
	@NotNull
	private String spaName;

	// 県コード
	@NotNull
	@Digits(integer = 2, fraction = 0)
	private String stateCd;

	// 泉質
	private String hotType;

	// 泉温
	@Digits(integer = 3, fraction = 1)
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

}
