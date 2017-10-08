package 백준.미해결;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;


public class 장남감{
    public static void main(String[] args) throws Exception {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt(); 
		ArrayList<Integer> weight = new ArrayList<Integer>();
		for(int i = 0; i < n; i ++)
			weight.add(sc.nextInt());
		weight.add(Integer.MAX_VALUE);
		Collections.sort(weight);
		
		int result = 0;
		int min =  weight.get(0); 
		int max = 0;
		for (int i = 0; i < weight.size(); i++) {
			int value = weight.get(i);
			if (max + 4 < value) {
				result += (max - min + 1) / 5 + 1;
				min = value;
			}
			max = value;
		}
		System.out.println(result);
		
    }
}

