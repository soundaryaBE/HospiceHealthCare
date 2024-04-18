package com.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Date;

public class JavaUtility {
public int getRandomNo()
{
	Random ran=new Random();
	int random=ran.nextInt(500);
	return random;
}
public String getUniqueEmail(String mail)
{
	Random ran=new Random();
	int random=ran.nextInt(500);
	String[] x = mail.split("@");
	String uniqueMail = x[0]+random+"@"+x[1];
	return uniqueMail;
}

public String getSystemDate()
{
	Date dt=new Date();
	String date=dt.toString();
	return date;
	
}
public String getSystemDateInformat()
{
	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	Date dt = new Date();
	String sysDatewInFormat = dateFormat.format(dt);
	return sysDatewInFormat;
}
}
