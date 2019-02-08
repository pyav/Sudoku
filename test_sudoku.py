#!/usr/bin/env python3

'''
This program file reads an input testcase file and constructs an input string
which it then sends to the Sudoku solver program. It then gets the return value
which tells whether a solution is possible for the Sudoku problem given in the
input file having testcases.

__author__ = pyav

'''

import os
import sys
import time
import subprocess
from subprocess import PIPE, STDOUT, Popen

def is_solution_possible(byte_code_name, final_input_val):
    '''
    Run the Java program which solves the given Sudoku problem and send the
    input string having the values in the matrix. The first value contains the
    size of the square 2D matrix.
    '''
    cmd_run = ['java', byte_code_name, final_input_val]
    p = Popen(cmd_run, stdout=PIPE, stdin=PIPE, stderr=STDOUT)
    stdout, stderr = p.communicate(final_input_val.encode())
    return stdout
    

def run_code(byte_code_name, testcase_file):
    count_test = 1
    f = open(testcase_file, "r")
    # Get the number of testcases
    num_tests = int(f.readline())
    # Iterate for all the testcases
    for i in range(0, num_tests):
        f.readline()
        size = int(f.readline())
        final_input_val = str()
        for i in range(0, size):
            final_input_val += f.readline().rstrip('\n') + " "
        final_input_val = str(size) + " " + final_input_val[:-1]
        # Send final_input_val to the java program and get the result.
        ret = is_solution_possible(byte_code_name, final_input_val)
        print("Test " + str(count_test) + ": " + str(ret))
        count_test += 1
    f.close()

def compile_code(code_file):
    cmd_compile = ['javac', code_file]
    subprocess.check_call(cmd_compile)
    byte_code_name = os.path.splitext(code_file)[0]
    count = 0
    if os.path.exists(byte_code_name + '.class'):
        return byte_code_name
    print('Not found ' + byte_code_name + '.class')
    return None

def main():
    code_file = 'SudokuSolver.java'
    byte_code_name = compile_code(code_file)
    if byte_code_name == None:
        sys.exit(1)
    testcase_file = './testcases_sudoku.txt'
    run_code(byte_code_name, testcase_file)

main()

# __eof__
