package com.example.spa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(SpaDataServiceImpl.class);

    @Autowired
    private SpaMapper spaMapper;

    /**
     * 温泉情報の一覧検索
     */
	public List<SpaDataDto> searchByState(String stateCd) {
        logger.info("* search - StateCd: " + stateCd);

		List<SpaDataDto> spaData = spaMapper.searchByState(stateCd);

	    return spaData;
	}

    /**
     * 温泉情報の一覧検索
     */
	public List<SpaDataDto> searchByStateGroup(String stateCd, String spaGroup) {
        logger.info("* search - StateCd: " + stateCd + ", Group: " + spaGroup);

		List<SpaDataDto> spaData = spaMapper.searchByStateGroup(stateCd, spaGroup);

	    return spaData;
	}

	/**
	 * 温泉情報の検索
	 */
	public SpaDataDto selectSpaData(String spaGroup, String spaName) {
        logger.info("* selectSpaData - Group: " + spaGroup + ", Name: " + spaName);

		SpaDataDto spaData = spaMapper.select(spaGroup, spaName);

	    return spaData;
	}

	/**
	 * 温泉情報の確認
	 */
	public boolean isSpaData(String spaGroup, String spaName) {
        logger.info("* isSpaData - Group: " + spaGroup + ", Name: " + spaName);

		SpaDataDto spaKey = new SpaDataDto();
		spaKey.setSpaGroup(spaGroup);
		spaKey.setSpaName(spaName);

		boolean bSpaData;
		if (spaMapper.countByKey(spaGroup, spaName) > 0) {
			bSpaData = true;
		} else {
			bSpaData = false;
		}

	    return bSpaData;
	}

	/**
	 * 温泉情報の登録
	 */
	@Transactional(readOnly = false)
	public boolean insertSpaData(SpaDataDto spaData) {
        logger.info("* insertSpaData - Data: " + spaData.toString() );

		try {
			spaMapper.insert(spaData);

			return true;
		} catch (Throwable th) {
			return false;
		}
	}

	/**
	 * 温泉情報の削除
	 */
	@Transactional(readOnly = false)
	public boolean deleteSpaData(SpaDataDto spaData) {

		try {
			spaMapper.delete(spaData.getSpaGroup(), spaData.getSpaName());

			return true;
		} catch (Throwable th) {
			return false;
		}
	}

}
