package com.example.spa.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.spa.ExampleBootApplication;
import com.example.spa.entity.SpaDataDto;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ExampleBootApplication.class)
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class SpaDataServiceTest {

    @Autowired
    private SpaDataService spaDataService;

    @Test
    public void test0_Insert() {

	    SpaDataDto spaData = new SpaDataDto();

	    spaData.setSpaGroup("白骨温泉");
	    spaData.setSpaName("泡の湯ホテル");
	    spaData.setStateCd("20");
	    spaData.setHotType("炭酸水素塩泉");
	    spaData.setHotTemp("39");
	    spaData.setSpaAddr(" ... ");
	    spaData.setSpaMemo("てすと");

	    assertTrue(spaDataService.insertSpaData(spaData));
    }

    @Test
    public void test9_Delete() {

	    SpaDataDto spaData = new SpaDataDto();

	    spaData.setSpaGroup("白骨温泉");
	    spaData.setSpaName("泡の湯ホテル");

	    assertTrue(spaDataService.deleteSpaData(spaData));
    }


    @Test
    public void test1_Select() {

		SpaDataDto spaData = spaDataService.selectSpaData("白骨温泉", "泡の湯ホテル");

        assertEquals(spaData.getHotType(), "炭酸水素塩泉");
        assertEquals(spaData.getHotTemp(), "39");
    }

    @Test
    public void test2_Search() {

		List<SpaDataDto> spaData = spaDataService.searchByState("20");

        assertTrue(spaData.size() > 0);
    }

    @Test
    public void test3_Search() {

		List<SpaDataDto> spaData = spaDataService.searchByStateGroup("20", "白骨温泉");

        assertTrue(spaData.size() > 0);
    }

    @Test
    public void test4_IsSpaData() {

		boolean spaData = spaDataService.isSpaData("乳頭温泉", "藤七温泉");

        assertFalse(spaData);
    }

    @Test
    public void test5_IsSpaData() {

		boolean spaData = spaDataService.isSpaData("乳頭温泉", "黒湯温泉");

        assertTrue(spaData);
    }

}
