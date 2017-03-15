package SOLUCAO;

/**
 * Store the representation of a solution
 * @author cesar
 */

public class Solution {

	private int[][] x;
	private int[] s;
	private double of = 0;
	
	public Solution(int[][] x){
		this.x = x;
		this.s = buildRepresentation();
		calculateFo();
	}
	
	public Solution(int[][] x, int of){
		this.x = x;
		this.s = buildRepresentation();
		this.of = of;
	}
	
	public int[][] getX(){
		return x;
	}
	
	public void setX(int[][] x){
		this.x = x;
	}
	
	public int[] getS(){
		return s;
	}
	
	public void setS(int[] s){
		this.s = s;
	}
	
	public double calculateFo(){
		
		return of;
	}
	
	public int[] buildRepresentation(){
		return s;
	}
	
	public void printSolution(){
		System.out.println("solução");
	}
}
