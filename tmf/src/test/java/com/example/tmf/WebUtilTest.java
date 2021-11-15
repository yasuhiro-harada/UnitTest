package com.example.tmf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

import com.unitTest.UnitTestCommon;

@SpringBootTest
class WebUtilTests extends UnitTestCommon{

	// 単体テスト用クラスの宣言
	WebUtil TestClass = new WebUtil();	

	@Test
	void splitId() throws Exception
	{
		InitTest();
	}

	public int  splitIdTestCase(Connection connection, int testCaseNo) throws Exception
	{
		int ret = 0;

		try{
			switch(testCaseNo){

				case 1:
					String pathIds = "";
					String[] ids = WebUtil.splitId(pathIds);
					if(ids != null){
						AssertFail();
					}

				default:
					ret = 1;

			}
		}catch(TmfException ex){
			AssertFail(ex.getMessage());
		}
		return ret;
	}
}
