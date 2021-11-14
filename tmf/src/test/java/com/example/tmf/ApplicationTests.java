package com.example.tmf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

import com.testDB.UnitTestCommon;

@SpringBootTest
class ApplicationTests extends UnitTestCommon{

	// 単体テスト用クラスの宣言
	PatchPutMethodController TestClass = new PatchPutMethodController();	

	//@Test
	void T0101_patchPutHandler() throws Exception
	{
		InitTest();
	}

	public int  T0101_patchPutHandlerTestCase(Connection connection, int testCaseNo) throws Exception
	{
        // PreparedStatement preparedStatement = null;

		// String sql = "INSERT INTO products(product_no, name, price)values(1, 'Name', 100) ";
		// preparedStatement = connection.prepareStatement(sql);
		// // SQL文を実行
		// preparedStatement.executeUpdate();

		// if(preparedStatement  != null){
		// 	preparedStatement.close();;
		// }
		return 1;
	}
}
