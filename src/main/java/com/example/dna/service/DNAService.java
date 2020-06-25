package com.example.dna.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.dna.entity.DNA;

@Service
public class DNAService {

	public boolean checkMutation(DNA dna) {
		// Convert array to matrix
		String[][] matrix = matrixConverter(dna.getDna());
		
		// Transpose matrix
		String[][] transpose = toHorizontal(matrix);
		
		// Diagonal
		String[][] diagonal = toDiagonal(matrix);
		
		// Diagonal Reverse
		String[][] diagonalReverse = toDiagonalReverse(matrix);
		
		// Check if has duplicate
		return (duplicateChacacters(matrix) || 
				duplicateChacacters(transpose) || 
				duplicateChacacters(diagonal) ||
				duplicateChacacters(diagonalReverse));
	}
	
	public boolean checkMutation(String[][] matrix) {
		
		// Transpose matrix
		String[][] transpose = toHorizontal(matrix);
		
		// Diagonal
		String[][] diagonal = toDiagonal(matrix);
		
		// Diagonal Reverse
		String[][] diagonalReverse = toDiagonalReverse(matrix);
		
		// Check if has duplicate
		return (duplicateChacacters(matrix) || 
				duplicateChacacters(transpose) || 
				duplicateChacacters(diagonal) ||
				duplicateChacacters(diagonalReverse));
	}
	
	private boolean duplicateChacacters(String[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			int count = 0;
			String temp = matrix[i][0];
			for (int j = 0; j < matrix[i].length - 1 ; j++) {
				if (count != 3) {
					if (temp.equals(matrix[i][j + 1])) {
						count = count + 1;
						temp = matrix[i][j + 1];
					}
				} else {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private String[][] toHorizontal(String[][] matrix) {
		
		String[][] transpose = new String[matrix.length][matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++){    
			for (int j = 0; j < matrix[i].length; j++){    
				transpose[i][j]=matrix[j][i];  
			}    
		} 
		
		return transpose;
		
	}
	
	private String[][] toDiagonal(String[][] matrix) {
		
		String[][] diagonal = new String[1][matrix[0].length];
		
		int i = 0;
		
		while (i < matrix.length) {
			diagonal[0][i] = matrix[i][i];
			i++;
		}
		
		return diagonal;
	}
	
	private String[][] toDiagonalReverse(String[][] matrix) {
		
		String[][] diagonal = new String[1][matrix[0].length];
		
		int i = 0;
		int j = matrix.length - 1;
		
		while (i < matrix.length) {
			diagonal[0][i] = matrix[i][j];
			i++;
			j--;
		}
		
		return diagonal;
	}
	
	
	private String[][] matrixConverter(String[] original) {
		String[][] matrix = new String[original.length][6]; 
		
        for (int i = 0; i < original.length; i++) { 
        	// Get the string
            String str = original[i];
            
            //Create array of string
            String[] ch = new String[str.length()];
            
            // Copy character into array
            for (int j = 0; j < str.length(); j++) { 
                ch[j] = Character.toString(str.charAt(j)); 
            }
            
            matrix[i] = ch;
        }
        
        return matrix;
	}
	
	public boolean generateDNA() {
		String[] letters = {"A","T","C","G"};
		String[][] matrix = new String[6][6];
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				Random rand = new Random();
				int randNum = rand.nextInt(3);
				matrix[i][j] = letters[randNum];
			}
		}
		
		return checkMutation(matrix);
		
	}
}
