package com.example.spa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spa.dao.SpaMapper;
import com.example.spa.entity.SpaDataDto;

/**
 * 温泉情報 Service class
 */
@Service
@Transactional(readOnly = true)
public class SpaDataServiceImpl implements SpaDataService {

    @Autowired
    private SpaMapper spaMapper;

    /**
     * 温泉情報の一覧検索
     *
     */
	public List<SpaDataDto> searchSpaData(String spaGroup) {

		List<SpaDataDto> spaData = spaMapper.search(spaGroup);

	    return spaData;
	}

	/**
	 * 温泉情報の検索
	 *
	 */
	public SpaDataDto selectSpaData(String spaGroup, String spaName) {

		SpaDataDto spaKey = new SpaDataDto();
		spaKey.setSpaGroup(spaGroup);
		spaKey.setSpaName(spaName);

		SpaDataDto spaData = spaMapper.select(spaKey);

	    return spaData;
	}

	/**
	 * 温泉情報の登録
	 *
	 */
	@Transactional(readOnly = false)
	public boolean insertSpaData(SpaDataDto spaData) {

		try {
			spaMapper.insert(spaData);

			return true;
		} catch (Throwable th) {
			return false;
		}
	}

	/**
	 * 温泉情報の削除
	 *
	 */
	@Transactional(readOnly = false)
	public boolean deleteSpaData(SpaDataDto spaData) {

		try {
			spaMapper.delete(spaData);

			return true;
		} catch (Throwable th) {
			return false;
		}
	}

}
