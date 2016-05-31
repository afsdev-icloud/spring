package com.example.spa.service;

import java.util.List;

import com.example.spa.entity.SpaDataDto;

/**
 * 温泉情報 Service interface
 */
public interface SpaDataService {

    /**
     * 温泉情報の一覧検索
     *
     * @param spaGroup 温泉地
     * @return 温泉情報
     */
	public List<SpaDataDto> searchSpaData(String spaGroup);

	/**
	 * 温泉情報の検索
	 *
	 * @param spaGroup 温泉地
	 * @param spaName  施設名
     * @return 温泉情報
	 */
	public SpaDataDto selectSpaData(String spaGroup, String spaName);

	/**
	 * 温泉情報の登録
	 *
	 * @param spaData 温泉情報
	 * @return 真偽
	 * @throws Throwable 処理中に発生した例外
	 */
	public boolean insertSpaData(SpaDataDto spaData);

	/**
	 * 温泉情報の削除
	 *
	 * @param spaData 温泉情報
	 * @return 真偽
	 * @throws Throwable 処理中に発生した例外
	 */
	public boolean deleteSpaData(SpaDataDto spaData);

}
