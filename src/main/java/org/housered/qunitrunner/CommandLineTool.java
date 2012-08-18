package org.housered.qunitrunner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

@Component
public class CommandLineTool
{

    private JCommander jCommander;

    @Parameter(description = "List of QUnit test files (.js or .html) to run")
    private List<String> tests = new ArrayList<String>();

    @Autowired
    public CommandLineTool(JCommander jCommander)
    {
        this.jCommander = jCommander;
    }

    public void run(String[] args)
    {
        jCommander.parse(args);

        for (String test : tests)
        {
            runTest(test);
        }

        System.out.println("Done");
    }

    private void runTest(String test)
    {
        System.out.println("Test: " + test);
    }

}
