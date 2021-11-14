package com.example.tmf;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

//=========================================================
// Database Model クラス
// 利用可能なデータ型
// Integer
// Long
// Double
// Float
// String
// Date         import java.sql.Date;       が必要
// Timestamp    import java.sql.Timestamp;  が必要
//=========================================================
@Getter
@Setter
public class FetchData{
	public Integer product_no;
	public String name;
	public Integer price;
	public Timestamp createdate;
}

