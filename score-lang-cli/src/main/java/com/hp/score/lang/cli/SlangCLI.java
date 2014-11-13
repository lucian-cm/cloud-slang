package com.hp.score.lang.cli;

import com.hp.score.lang.compiler.SlangCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Date: 11/7/2014
 *
 * @author lesant
 */

@Component
public class SlangCLI implements CommandMarker{

   @Autowired
   private SlangCompiler compiler;

    private static final String currently = "You are currently running Score version: ";
    private static final String scoreVersion = "0.1.229"; //todo get version

    @CliCommand(value = "slang run", help = "Runs a flow")
    public String run(
            @CliOption(key = "f", mandatory = true, help = "Path to filename. e.g. slang run --f C:\\Slang\\flow.yaml") final String fileName, //flow yaml
            @CliOption(key = "cp", mandatory = false, help = "Classpath") final String classPath, //dependencies
            @CliOption(key = "sp", mandatory = false, help = "System property file location") final String systemProperty,
            @CliOption(key = "D", mandatory = false, help = "inputs in a key=value comma separated list") final Map<String, String> inputs) {

        return null;
    }

    @CliCommand(value = "slang -version", help = "Prints the score version used")
    public String version() {
        return currently + scoreVersion;
    }
    public static String getVersion(){
        return scoreVersion;
    }
}