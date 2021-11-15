package com.example.tmf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

import com.unitTest.UnitTestCommon;

@SpringBootTest
class DatabaseTest extends UnitTestCommon
{
	// 単体テスト用クラスの宣言
	Database TestClass = new Database();	

	@Test
	void setWherePk() throws Exception
	{
		InitTest(true);
	}

	public int setWherePkTestCase(Connection connection, int testCaseNo) throws Exception
	{
		int ret = 0;

		String[] ids = null;
		
		switch(testCaseNo){

			case 1:
				ids = null;
				TestClass.setWherePk(ids);
				break;

			default:
				ret = 1;

		}

		return ret;
	}
}
