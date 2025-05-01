/*Check the working of the following code and give comments with respect to use of “outer” :

outer:
for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 10; j++) {
        if (j == 1)
            break outer; // Break out of the outer loop entirely when j equals 1
        System.out.println("value of j = " + j);
    }
} // end of outer loop

Working of the Code

    Label outer:
    The label outer: is used to identify the outer loop. This allows the break statement to exit not just the inner loop, but also the outer loop entirely.

    Inner Loop (for j) Execution
        When j == 0, the System.out.println() statement executes, printing value of j = 0.
        When j == 1, the if (j == 1) condition evaluates to true. The break outer; statement is executed.

    Effect of break outer;
        The break statement terminates the execution of the labeled outer loop (outer:), skipping all subsequent iterations of both i and j loops.
        This means the program exits the entire outer loop as soon as j == 1 in the first iteration of the i loop.

    Output
    Only one line will be printed:
        value of j = 0

 */