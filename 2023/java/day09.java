import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class day09
{
	public static void main(String[] args) throws FileNotFoundException
	{
		final Scanner input = new Scanner(new File("2023/input/09.txt"));

		final double start = System.nanoTime();
		
		int partOne = 0;
		int partTwo = 0;
		
		while(input.hasNextLine())
		{
			String currentLine = input.nextLine();
			int[] currentLineValues = Arrays.stream(currentLine.split(" ")).mapToInt(Integer::parseInt).toArray();
			
			partOne += findPattern(currentLineValues, false);
			partTwo += findPattern(currentLineValues, true);
		}
		
		System.out.println("Part One: " + partOne);
		System.out.println("Part Two: " + partTwo);
		
		final double runtime = (System.nanoTime() - start) / 1000000;
		System.out.println("Runtime: " + runtime + "ms");
	}
	
	static int findPattern(int[] a, boolean isPartTwo)
	{		
		int[] b = new int[a.length-1];
				
		for(int i = 0; i < b.length; i++)
			b[i] = a[i+1] - a[i];
		
		return Arrays.stream(a).allMatch(n -> n == 0) ? 0: isPartTwo ? a[0] - findPattern(b, true) : a[a.length-1] + findPattern(b, false);
	}
}