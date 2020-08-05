import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int countOfElements = count * count;
        boolean result = true;
        int rightSum = fact(countOfElements);
        int[][] array = new int[countOfElements][countOfElements];
        int[] rightCheck = new int[countOfElements];
        Arrays.fill(rightCheck, 1);
               
        for (int i = 0; i < countOfElements; i++) {
            for (int j = 0; j < countOfElements; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        
        if (count > 1) {
            for (int i = 0; i < countOfElements; i++) {
                int sumLine = 0;
                for (int j = 0; j < countOfElements; j++) {
                    sumLine += array[i][j];
                }
                if (sumLine != rightSum) {
                    result = false;
                    break;
                }
            
                int sumColm = 0;
                for (int j = 0; j < countOfElements; j++) {
                    sumColm += array[j][i];
                }
                if (sumColm != rightSum) {
                    result = false;
                    break;
                }
            }
            for (int i = 0; i < countOfElements; i += count) {
				for (int firstElement = 0; firstElement < countOfElements; firstElement += count) {
                  //int sumSquare = 0;
                  int[] checkArray = new int[countOfElements];
                  for (int x = i; x < i + count; x++) {
                    for (int y = firstElement; y < firstElement + count; y++) {
                        checkArray[array[x][y] - 1]++;  
                    }
                  }
                  //result = rightSum == sumSquare ? true : false;
                  if (!Arrays.equals(rightCheck, checkArray)) {
                      //System.out.print(Arrays.equals(rightCheck, checkArray));
                      result = false;
                      }
                  if (!result) {break;};
                }
                if (!result) {break;};
            }
        } else if (count == 1 && array[0][0] != 1) {
            result = false;
        }
        
        System.out.println(result ? "YES" : "NO");    
    }
    
    public static int fact (int number) {
        if (number == 1) {
            return number;
        } else {
            return number += fact(number - 1);
        }
    }
}