package org.housered.jstestrunner.output;

import java.io.IOException;
import java.io.OutputStream;

import org.housered.jstestrunner.tests.TestResult;
import org.housered.jstestrunner.tests.TestResult.TestCaseResult;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

public class JUnitTestResultOutputter implements TestResultOutputter
{

    public void writeTestResultToFile(TestResult result, OutputStream outputStream) throws IOException
    {
        Element testSuiteRoot = new Element("testsuite");
        Document testResultDoc = new Document(testSuiteRoot);
        
        testSuiteRoot.setAttribute("name", result.getName());
        testSuiteRoot.setAttribute("tests", String.valueOf(result.getTests()));
        testSuiteRoot.setAttribute("errors", String.valueOf(result.getErrors()));
        testSuiteRoot.setAttribute("failures", String.valueOf(result.getFailures()));
        testSuiteRoot.setAttribute("skip", String.valueOf(result.getSkipped()));
        
        for (TestCaseResult testCaseResult : result.getTestResults()) {
            Element testCase = new Element("testcase");
            testCase.setAttribute("classname", testCaseResult.getTestClass());
            testCase.setAttribute("name", testCaseResult.getTestName());
            testCase.setAttribute("time", String.valueOf(testCaseResult.getTestDurationMillis()));
            // TODO support individual test case results + messages
            testSuiteRoot.addContent(testCase);
        }

        XMLOutputter xmlOutputter = new XMLOutputter();

        xmlOutputter.output(testResultDoc, outputStream);
    }

}