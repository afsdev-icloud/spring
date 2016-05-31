package com.example.spa.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * 検索条件の入力
 *
 */
public class SpaInfoForm implements Serializable {

	private static final long serialVersionUID = -1L;

	// 温泉地
	@NotNull
	private String spaGroup;


	public String getSpaGroup() {
		return spaGroup;
	}

	public void setSpaGroup(String spaGroup) {
		this.spaGroup = spaGroup;
	}

}
