package com.example.tmf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.unitTest.UnitTestCommon;

@SpringBootTest
class StubTest extends UnitTestCommon
{
	// 単体テスト用クラスの宣言
	ReqData TestClass = new ReqData();	

	@Test
	void MessageCrud() throws Exception
	{
		InitTest(true);
	}

	public int MessageCrudTestCase(Connection connection, int testCaseNo) throws Exception
	{
		int ret = 0;

		StubMessageConsumer stubMessageConsumer = new StubMessageConsumer();
		StubMessageProducer stubMessageProducer = new StubMessageProducer();
		List<MessageKey> messageKeys = new ArrayList<MessageKey>();
		List<ResData> resDatas = new ArrayList<ResData>();
		MessageKey messageKey = new MessageKey();
		ReqData reqData = new ReqData();
		messageKey.setMessageId("ABCDE");
		
		//*********************************
		// Test Case
		//*********************************
		switch(testCaseNo){

			// GET Test
			case 1:
				
				break;

			default:
				ret = 1;

		}

		return ret;
	}
}
