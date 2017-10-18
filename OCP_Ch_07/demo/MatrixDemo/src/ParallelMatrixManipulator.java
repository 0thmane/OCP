import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ParallelMatrixManipulator {

  // Works only for square matrices.
  public List<List<Integer>> addMatrices(List<List<Integer>> matrixA, List<List<Integer>> matrixB) {
    List<List<Integer>> result = new ArrayList<>();

    int matrixSize = matrixA.get(0).size();

    ExecutorService executor = Executors.newFixedThreadPool(3);

    IntStream.range(0, matrixSize)
      .forEach(index -> {
        List<Integer> matrixAColumn = matrixA.get(index);
        List<Integer> matrixBColumn = matrixB.get(index);

        Future<List<Integer>> futureRow = executor.submit(() -> addMatrixColumns(matrixAColumn, matrixBColumn));

        try {
          result.add(futureRow.get());
        } catch (InterruptedException | ExecutionException e) {
          e.printStackTrace();
        }
      });

    executor.shutdown();

    return result;
  }

  public List<Integer> addMatrixColumns(List<Integer> rowA, List<Integer> rowB) {
    List<Integer> resultingRow = new ArrayList<>();

    if (rowA.size() != rowB.size()) {
      throw new RuntimeException("Cannot add rows of different length.");
    }

    for (int index = 0; index < rowA.size(); index++) {
      Integer resultingValue = rowA.get(index) + rowB.get(index);
      resultingRow.add(resultingValue);
    }

    return resultingRow;
  }
}