package com.ust.AppiumTesting.dataProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.ust.AppiumTesting.utils.AndroidActions;

public class DataProviders {
	
	@DataProvider(name="Digits")
	public Object[] getData() throws IOException {
		List<HashMap<String,String>> list  = AndroidActions.getJsonData(System.getProperty("user.dir")+"\\Testdata\\Data.json");
		return list.toArray();
	}

}
