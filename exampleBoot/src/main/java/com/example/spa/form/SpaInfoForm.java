package com.example.spa.form;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 検索条件の入力
 *
 */
public class SpaInfoForm implements Serializable {

	private static final long serialVersionUID = -1L;

	// 県コード
	@NotEmpty(message="{error.select.stateCd.NotEmpty.message}")
	private String stateCd;

	// 温泉地
	private String spaGroup;


	public String getStateCd() {
		return stateCd;
	}

	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	public String getSpaGroup() {
		return spaGroup;
	}

	public void setSpaGroup(String spaGroup) {
		this.spaGroup = spaGroup;
	}


    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }

}
