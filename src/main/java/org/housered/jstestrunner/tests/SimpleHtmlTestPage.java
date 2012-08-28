package org.housered.jstestrunner.tests;

public class SimpleHtmlTestPage implements TestPage
{

    private String htmlFilePath;

    public SimpleHtmlTestPage(String htmlFilePath)
    {
        this.htmlFilePath = htmlFilePath;
    }

    public String getFilePath()
    {
        return "file:///" + this.htmlFilePath;
    }

}
