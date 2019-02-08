# Sudoku solver and Tests
This repository is for having a solution to the Sudoku problem. It contains the solution program, testcases and testing script. The solution is
written in Java whereas the testing script is in Python3. This test
script uses a text file as input which contains the test cases, executes
the Java code and runs the byte code. It constructs an input string from
the testcase file and sends it to the byte code as argument. The input testcase
file contains the number of testcases, the size of square matrix for each of
the tests followed by he data for the given Sudoku problem in a matrix. 

## Execution
The Python3 test script is run by the following command:

    $ python3 test_sudoku.py

The above command compiles the Java code, reads input testcase, constructs an
input string and passes it to the byte code as argument. 

## Output
Here is the output of the above command execution:

    $ python3 test_sudoku.py
    Test 1: b' Solution is possible :) 2 1 3 \n1 3 2 \n3 2 1 \n'
    Test 2: b' Solution is possible :) 2 3 1 4 \n1 4 2 3 \n4 1 3 2 \n3 2 4 1 \n'
    Test 3: b' Solution is not possible :( '
    Test 4: b' Solution is not possible :( '
    Test 5: b' Solution is not possible :( '
    Test 6: b' Solution is possible :) 1 2 3 4 5 6 8 7 9 \n4 1 2 6 7 8 5 9 3 \n2 7 4 1 8 5 9 3 6 \n7 4 1 8 9 3 6 5 2 \n3 8 6 9 4 7 2 1 5 \n6 9 7 5 3 4 1 2 8 \n9 6 5 3 1 2 7 8 4 \n5 3 8 7 2 9 4 6 1 \n8 5 9 2 6 1 3 4 7 \n'
    Test 7: b' Solution is possible :) 1 2 \n2 1 \n'

## Further Improvements
Comments/ pull requests are welcome for the following:

    1. Enhancement for the core algorithm.
    2. Suggest more tests.
    3. Enhance the test script itself.
    4. Coding style and any constructive updates.

Thanks for putting in your time to review :)

