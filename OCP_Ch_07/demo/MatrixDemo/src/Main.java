import java.util.*;

/**
 * Matrix-adding algorithm implemented in parallel and sequential fashion.
 * <p>
 * Comparing performance.
 **/
public class Main {

  private static List<List<Integer>> matrixA = generateMatrixOne();
  private static List<List<Integer>> matrixB = generateMatrixTwo();
  private static List<List<Integer>> result = new ArrayList<>();

  private static void printMatrix(List<List<Integer>> matrix) {
    StringBuilder strRepresentation = new StringBuilder();

    matrix.forEach(column -> {
              column.forEach(
                      element -> strRepresentation.append(String.format("%5s", element)));
              strRepresentation.append("\n");
            }
    );

    System.out.println(strRepresentation);
  }

  private static void printTimeTaken(long startTime, long endTime) {
    long timeTaken = endTime - startTime;

    System.out.println("The calculation took " + timeTaken + "ms.");
  }

  private static List<List<Integer>> generateMatrixOne() {
    List<List<Integer>> matrix = new ArrayList<>();
    List<Integer> row1 = Arrays.asList(1, 2, 3);
    List<Integer> row2 = Arrays.asList(4, 5, 6);
    List<Integer> row3 = Arrays.asList(7, 8, 9);

    matrix.add(row1);
    matrix.add(row2);
    matrix.add(row3);

    return matrix;
  }

  private static List<List<Integer>> generateMatrixTwo() {
    List<List<Integer>> matrix = new ArrayList<>();
    List<Integer> row1 = Arrays.asList(9, 8, 7);
    List<Integer> row2 = Arrays.asList(6, 15, 4);
    List<Integer> row3 = Arrays.asList(3, 2, 1);

    matrix.add(row1);
    matrix.add(row2);
    matrix.add(row3);

    return matrix;
  }

  private static void timeAddition(int iterationLimit, String methodology) {
    long startTime = System.currentTimeMillis();

    for (int iteration = 0; iteration < iterationLimit; iteration++) {
      switch (methodology) {
        case "Sequentially":
          result = new MatrixManipulator().addMatrices(matrixA, matrixB);
          break;
        case "Concurrently":
          result = new ParallelMatrixManipulator().addMatrices(matrixA, matrixB);
          break;
      }
    }

    long endTime = System.currentTimeMillis();

    System.out.print(methodology + " " + iterationLimit + " times: ");
    printTimeTaken(startTime, endTime);
    printMatrix(result);
  }

  public static void main(String[] args) {
//        int iterationLimit = 1_000;
//
//        // ---- Printing the Matrices
//        printMatrix(matrixA);
//        System.out.println("+");
//        printMatrix(matrixB);
//        System.out.println("=");
//
//        // ---- Sequentially adding the Matrices
//        timeAddition(iterationLimit, "Sequentially");
//
//        // ---- Parallel adding of the Matrices
//        timeAddition(iterationLimit, "Concurrently");

    // --------------------------------------------------------------------------------------------------------
    int iterationLimit = 1_000;
    int matrixSize = 4;

    Matrix matrixA = Matrix.randomMatrix(matrixSize, 2);
    Matrix matrixB = Matrix.randomSquareMatrix(matrixSize);

    System.out.println(matrixA);
//    System.out.println(matrixB);
    System.out.println(matrixA.getSize());
  }
}
