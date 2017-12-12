package com.mulesoft.about.cli;

import picocli.CommandLine;

import static picocli.CommandLine.*;

@Command(
        name = "Main",
        description = "Demonstrating picocli",
        headerHeading = "Demonstration Usage:%n%n")
public class Main {

    @Option(names = {"-v", "--verbose"}, description = "Verbose output?")
    private boolean verbose;

    @Option(names = {"-f", "--file"}, description = "Path and name of file", required = true)
    private String fileName;

    @Option(names = {"-h", "--help"}, description = "Display help/usage.", help = true)
    boolean help;

    public static void main(String[] arguments) {

        final Main main = CommandLine.populateCommand(new Main(), arguments);

        if (main.help) {
            CommandLine.usage(main, System.out, CommandLine.Help.Ansi.AUTO);
        } else {
            System.out.println("The provided file path and name is " + main.fileName + " and verbosity is set to " + main.verbose);
        }
    }
}
