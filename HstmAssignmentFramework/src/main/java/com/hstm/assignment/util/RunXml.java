package com.hstm.assignment.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.TestNG;

import com.hstm.assignment.base.TestBase;

public class RunXml {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*TestNG runner =  new TestNG(); ;
		List<String> tempSuite = new ArrayList<String>();
		String path = TestBase.currentDir + "//src//main//resources//TestNGAssignmentTest.xml";
		tempSuite.add(path);
		runner.addListener(listener);
		runner.addListener(new ExecutionListner());
		runner .run();*/
		
		for(int i=0;i<3;i++)
        {
            List<String> suites = new ArrayList<String>();
            /*String fpath = "D:/javaworkspace/HstmAssignmentFramework/src/main/resources/TestNGAssignmentTest.xml";
            
            Properties p = new Properties();
            InputStream inp= new FileInputStream(fpath);
            p.load(inp);*/
            suites.add("C:/Users/M1032759/git/ProjectPOM1/HstmAssignmentFramework/TestNGAssignmentTest.xml"); //path of .xml file to be run-provide complete path

            TestNG tng = new TestNG();
            tng.setTestSuites(suites);

            tng.run(); //run test suite
        }
	}

}
