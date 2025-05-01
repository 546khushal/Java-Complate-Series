/*
1. Understanding Java Development Kit (JDK) and Environment Variables

    ->Java Development Kit (JDK):
    JDK is a software development kit used to develop Java applications. It includes:
        > Java Runtime Environment (JRE)
        > Java Compiler (javac)
        > Java Debugger
        > Java libraries

    ->Environment Variables Setting:
    To set up JDK on your system:
        1. Download and install the JDK from Oracle's official site.
        2. Set the JAVA_HOME environment variable:
              -> Windows:
                 Go to System Properties > Environment Variables. Add JAVA_HOME and set its path to the JDK installation folder (e.g., C:\Program Files\Java\jdk-XX).
              -> Add the bin folder of the JDK to the Path variable (e.g., C:\Program Files\Java\jdk-XX\bin).
        3.Verify the installation:
        Open a terminal and type:
            java -version
            javac -version
*/