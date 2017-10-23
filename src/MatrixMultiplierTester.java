/** “MatrixMultiplierTester."
 *
 *  Created: 10/5/17
 *  Last updated: 10/6/17
 *
 *  Project 8; CSC201-004N
 *  Assignment 8.6
 *
 *  @author Emma Slayton
 *
 *
 */

import java.util.Scanner;

public class MatrixMultiplierTester {
    public static void main(String[] args) {

        /* Create a set of empty 3x3 array of 10 numbers  */
        double[][] A = {
                {0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0}};

        double[][] B = {
                {0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0}};

        double[][] C = {   {0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0}   };
               
  
        /* Initialize to test values for testing         
           double[][] A = {   {1.0, 2.0, 3.0},
                              {4.0, 5.0, 6.0},
                              {7.0, 8.0, 9.0}   };

           double[][] B = {   {0.0, 2.0, 4.0},
                              {1.0, 4.5, 2.2},
                              {1.1, 4.3, 5.2}   };   
        
       */

        /* repeat process until input is valid. */
        boolean input_A_Done = false;
        boolean input_B_Done = false;

        System.out.println("This test program multiplies two 3x3 matrices together and displays the resulting");
        System.out.println("3x3 matrix.  The 9 inputs for Matrix 1 must be successfully input before those ");
        System.out.println("for Matrix 2.  Erroneous input will necessitate re-entering data for that matrix.");
        System.out.println("Only the first 9 numbers entered for each matrix will be processed.");
        System.out.println("Input beyond the first 9 numbers will be ignored.");
        System.out.println("\n");
              
                
        /* Get the User Input for the first 3x3 matrix */
        while (input_A_Done == false) {
                    
                    /*Prompt User to enter ten Numbers  */
            System.out.print("\nEnter Matrix1: ");
            input_A_Done = getInput(A);
        }
        
        /* Get the User Input for the first 3x3 matrix */
        while (input_B_Done == false) {
                    
                    /*Prompt User to enter ten Numbers  */
            System.out.print("\nEnter Matrix2: ");
            input_B_Done = getInput(B);
        }
            
        /* Multiply the Matrices and return the result as a Matix */
        C = multiplyMatrix(A,B);
        
        /* Make the output look as requested by the problem, not vertically as I would do it */
        outputResults(A,B,C);


    }

    /* multplyMatrix multiplies two 3x3 Matrices together and returns a 3x3 Matrix as a result */
   /* The assumption is made that the incoming Matrices have valid values in them and are of the correct sizes */
    public static double[][] multiplyMatrix(double[][]a, double[][]b) {
        double[][] r = {
                {0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0}
        };

        int r_row = 0;
        int r_col = 0;
        int a_row = 0;
        int a_col = 0;
        int b_row = 0;
        int b_col = 0;

        int r_a_row = 0;        /* r_row and a_row are always the same */
        int r_b_col = 0;        /* r_col and b_col are always the same */
        int a_col_b_row = 0;    /* a_col and b_row are always the same */
         
         
         /* Math:
            for a 3x3 matrix the following is the formula for determing the multiplication result where result = a * b
            Result[0][0] = a[row][col++] * b[row++][col] + */
         
         /* r00, r01, r02 */    /* a00, a01, a02 */    /* b00, b01, b02 */
         /* r10, r11, r12 */    /* a10, a11, a12 */    /* b10, b11, b12 */
         /* r20, r21, r22 */    /* a20, a21, a22 */    /* b20, b21, b22 */
      
         /* Top Row of Result Matrix
         r[0][0] = a[0][0]*b[0][0] + a[0][1]*b[1][0] + a[0][2]*b[2][0];
         r[0][1] = a[0][0]*b[0][1] + a[0][1]*b[1][1] + a[0][2]*b[2][1];
         r[0][2] = a[0][0]*b[0][2] + a[0][1]*b[1][2] + a[0][2]*b[2][2];
         
         Middle Row of Result Matrix
         r[1][0] = a[1][0]*b[0][0] + a[1][1]*b[1][0] + a[1][2]*b[2][0];
         r[1][1] = a[1][0]*b[0][1] + a[1][1]*b[1][1] + a[1][2]*b[2][1];
         r[1][2] = a[1][0]*b[0][2] + a[1][1]*b[1][2] + a[1][2]*b[2][2];
         
         Bottom Row of Result Matrix
         r[2][0] = a[2][0]*b[0][0] + a[2][1]*b[1][0] + a[2][2]*b[2][0];
         r[2][1] = a[2][0]*b[0][1] + a[2][1]*b[1][1] + a[2][2]*b[2][1];
         r[2][2] = a[2][0]*b[0][2] + a[2][1]*b[1][2] + a[2][2]*b[2][2];   */
         
           
         /* Notes: r_row and a_row are always the same and increment from 0 to 2   
                   r_col always progresses from 0 to 2 before r_row is incremented 
                   r_col and b_col are always the same value                       
                   a_col and b_row are always the same value cycling from 0 to 2   
                        after a_col and b_row process at 2 they reset to 0 and     
                        r_col / b_col are incremented by 1                         
        
        
                   lets call r_row/a_row r_a_row to avoid confusion                
                        for (r_row = 0, r_row < 2, r_row++)  outer loop            
                   lets call r_col/b_col r_b_col to avoid confusion                
                           for(r_col = 0, r_col < 2, r_col++) nested loop          
                   lets call a_col/b_row a_col_b_row                               */

        for (r_a_row = 0; r_a_row < 3; r_a_row++) {
            for(r_b_col = 0; r_b_col < 3; r_b_col++) {
                for(a_col_b_row = 0; a_col_b_row < 3; a_col_b_row++ ) {
                  /* incrementally add the result of each product together to produce the result cell answer */
                    r[r_a_row][r_b_col] +=  a[r_a_row][a_col_b_row]* b[a_col_b_row][r_b_col];
                }
            }
        }


        return r;
    }

    /* This method outputs the input matrices and the result in format similar to pg 307 of our textbook */
    public static void outputResults(double[][]a,double[][]b, double[][]c) {
        System.out.println(" ");
        System.out.println("The multiplication of the matrices is:\n\n");
        System.out.println("       Matrix  A                  Matrix  B                    Result\n");
        for ( int i = 0; i< 3; i++ ) {

            for ( int j = 0; j <3; j++ ) {
                 /*output the values in a row of a[][]*/
                System.out.printf("%6.2f ", a[i][j]);
            }
           
             /* Mark the * between the Matrices if middle row */
            if (i == 1) {
                System.out.print("   *   ");
            } else {  /* just put space in between don't put a "*" */
                System.out.print("       ");
            }


            for ( int j = 0; j <3; j++ ) {
                 /*output the values in a row of b[][]*/
                System.out.printf("%6.2f ", b[i][j]);
            }
           
             /* Mark the = between the Matrices if middle row */
            if (i == 1) {
                System.out.print("   =   ");
            } else {    /* just put space in between don't put a "*" */
                System.out.print("       ");
            }

            for ( int j = 0; j <3; j++ ) {
                 /*output the values in a row of c[][]*/
                System.out.printf("%6.2f ", c[i][j]);
            }

            System.out.print("\n");


        }
    }

    /* get the input from the user and populate the Matrix */
    public static boolean getInput( double[][]nums) {
        /* Create a Scanner */
        Scanner input = new Scanner(System.in);
        
       
        /* assume pristine input for now */
        /* read the input */
        for (int i = 0; i < 3; i++)  {
            for (int j = 0; j < 3; j++) {
                if (input.hasNextDouble()) {
                    nums[i][j] = input.nextDouble();
                } else {
                    System.out.println("ERROR: invalid input detected.");
                    System.out.println("Please enter only the number itself, no commas, letter, special characters, etc.");
                    System.out.println("(Ex: 28 = '28')");
                    System.out.println("  ");
                    System.out.println("Any previous values given for this matrix have been erased.");
                    System.out.println("Please input all valid values for this matrix.\n\n\n");
                    return false;
                }
            }
        }
        
        /* show the user what they entered
           System.out.print("You entered: ");     
           printArray (nums);              
         */

        return true;
    }
}