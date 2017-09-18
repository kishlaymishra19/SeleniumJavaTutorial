package com.democart.Commonlib;

public class ConstantClass{
	static ExcelUtils data=new ExcelUtils();
	public static int n=1;
	public static final String demoCartURL="https://demostore.x-cart.com/";
	public static final String demoStroreTitle="X-Cart Demo store company > Catalog";
	public static final String chromePath="drivers//chromedriver.exe";
	public static final String firefoxPath="drivers//geckodriver.exe";
	public static final String iePath="drivers//IEDriverServer.exe";
	public static final String loginUserName =data.getData(n, "UserName");
	public static final String loginPassword =data.getData(n, "Password");

	public static final String orderConfirmationMsg="Thank you for your order";
	
	public static final String usrEmail =data.getData(n, "Emailid");
	public static final String usrFName =data.getData(n, "FirstName");
	public static final String usrLName =data.getData(n, "LastName");
	public static final String usrAddr =data.getData(n, "Address");
	public static final String usrCity =data.getData(n, "City");
	public static final String usrCountry =data.getData(n, "Country");
	public static final String usrState =data.getData(n, "State");
	public static final String usrPinCode =data.getData(n, "Pincode");
	public static final String usrPhoneNumber =data.getData(n, "PhoneNumber");

}
