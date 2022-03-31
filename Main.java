// File:        Main.java
// Author:      Julie Lobur
// JDK Version: 1.3.1
// Date:        November 7, 2001
// Notice:      This code may be freely used for noncommercial purposes.
// BMM REMOVED : package MarieSimulator;
// BMM, MR     : TOOD: syntax "SKIPCOND 001" should be flagged as error 
// BMM commands for running locally : C:\Program Files\Java\jdk-12.0.2\bin>
//  java -h
//  java -version
//  javac --help
//  javac AssembledCodeLine.java Assembler.java Main.java SymbolEntry.java 
//  jar cvfe MarieAsm.jar Main *.class
//  jar tf MarieAsm.jar
//  java -jar MarieAsm.jar 
class Main 
{
  public static void main(String[] args) 
  {
        String fileName = "Example1.mas";  // not using command line arg yet 
        Assembler   assembler = new Assembler();
        int  irrecoverableError = 0;
  
        if ( fileName == null) 
        {                                   // Make sure we have an
             System.err.println("\nNull input file to assembler.");   // input file specified.
        }
        else
        {
            int i = fileName.lastIndexOf('.');                      // If the user supplied an
            if (i > 0)                                              // extension to the filename,
              fileName = fileName.substring(0, i);                  // ignore it.

            assembler.sourceFileName = fileName;
            assembler.lineNumber = -1;

            irrecoverableError = assembler.performFirstPass();       // Call functional methods.
            if (irrecoverableError == 0)                             // irrecoverableError(s) occur
              irrecoverableError = assembler.performSecondPass();    // as a result of unexpected
            else 
            {                                                   // file IO problems.
              System.err.println("Irrecoverable IO error occurred during first assembly pass.");
            }
            if (irrecoverableError == 0)
              assembler.produceFinalOutput();
            else 
            {
              System.err.println("Irrecoverable IO error occurred during second assembly pass.");
            }
            System.err.println( "assembler.errorCount="+assembler.errorCount);
        } // if ( fileName...
  } // function main()
} // class Main