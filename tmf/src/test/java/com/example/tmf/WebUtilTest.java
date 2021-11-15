package com.example.tmf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

import com.unitTest.UnitTestCommon;

@SpringBootTest
class WebUtilTest extends UnitTestCommon
{
	// 単体テスト用クラスの宣言
	WebUtil TestClass = new WebUtil();	

	@Test
	void splitId() throws Exception
	{
		InitTest(true);
	}

	public int  splitIdTestCase(Connection connection, int testCaseNo) throws Exception
	{
		int ret = 0;

		String pathIds = "";
		String[] ids = null;
		
		switch(testCaseNo){

			case 1:
				pathIds = "";
				ids = WebUtil.splitId(pathIds);
				if(ids != null){
					AssertFail();
				}
				break;

			case 2:
				pathIds = "aaa";
				ids = WebUtil.splitId(pathIds);
				if(ids.length != 1){
					AssertFail();
				}
				if(!ids[0].equals(pathIds)){
					AssertFail();
				}
				break;

			case 3:
				pathIds = "aaa-bbb";
				try{
					ids = WebUtil.splitId(pathIds);
				}catch(Exception ex){
					exceptionFlg = true;
				}
				if(!exceptionFlg){
					AssertFail();
				}
				break;

			default:
				ret = 1;

		}

		return ret;
	}
}
