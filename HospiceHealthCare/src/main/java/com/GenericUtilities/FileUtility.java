package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
public String readDataFromPropertyFile(String key) throws IOException
{
	FileInputStream fis=new FileInputStream(IpathConstant.FilePath);
    Properties pobj = new Properties();
    pobj.load(fis);
    String value = pobj.getProperty(key);
    return value;
 
}
}
