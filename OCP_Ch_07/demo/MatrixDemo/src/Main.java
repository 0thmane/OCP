import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Matrix-adding algorithm implemented in parallel and sequential fashion.
 * <p>
 * Comparing performance.
 **/
public class Main {

  private static final int ITERATION_LIMIT = 1;
  private static final int SQUARE_MATRIX_SIZE = 1;

  private ExecutorService executor = Executors.newFixedThreadPool(4);

  private void printTimeTaken(long startTime, long endTime) {
    long timeTaken = endTime - startTime;

    System.out.println("The calculation took " + timeTaken + "ms.");
  }

  private void timeAddition(String methodology, Matrix matrixA, Matrix matrixB) {
    Matrix result = null;

    long startTime = System.currentTimeMillis();

    for (int iteration = 0; iteration < ITERATION_LIMIT; iteration++) {
      switch (methodology) {
        case "Sequentially":
          result = matrixA.add(matrixB);
          break;
        case "Concurrently":
          result = matrixA.addConcurrently(matrixB, executor);
          break;
      }
    }

    long endTime = System.currentTimeMillis();

    System.out.print(methodology + " " + ITERATION_LIMIT + " times: ");
    printTimeTaken(startTime, endTime);
    System.out.println(result);
  }

  public void runDemo() {
    Matrix matrixA = Matrix.randomSquareMatrix(SQUARE_MATRIX_SIZE);
    Matrix matrixB = Matrix.randomSquareMatrix(SQUARE_MATRIX_SIZE);

    printMatrixOperation(matrixA, matrixB);

    this.timeAddition("Sequentially", matrixA, matrixB);
    this.timeAddition("Concurrently", matrixA, matrixB);
  }

  private void printMatrixOperation(Matrix matrixA, Matrix matrixB) {
    System.out.println(matrixA);
    System.out.println("+");
    System.out.println(matrixB);
    System.out.println("=");
  }

  public static void main(String[] args) {
    new Main().runDemo();
  }
}
