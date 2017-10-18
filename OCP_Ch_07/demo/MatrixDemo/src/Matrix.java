import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

// 2D matrix
public class Matrix {
  private final List<List<Integer>> matrix;

  private final static int MAX_RANDOM_VALUE = 25;

  private Matrix(List<List<Integer>> matrix) {
    this.matrix = matrix;
  }

  public static Matrix of(List<List<Integer>> matrix) {
    return new Matrix(matrix);
  }

  public static Matrix randomSquareMatrix(int size) {
    return Matrix.randomMatrix(size, size);
  }

  public static Matrix randomMatrix(int yDimension, int xDimension) {
    List<List<Integer>> randomMatrix = new ArrayList<>();
    Random random = new Random();

    IntStream.range(0, yDimension)
    .forEach((y) -> {
      List<Integer> column = new ArrayList<>();

      IntStream.range(0, xDimension)
        .forEach(
          (x) -> {
            column.add(random.nextInt(MAX_RANDOM_VALUE));
        });

      randomMatrix.add(column);
    });

    return Matrix.of(randomMatrix);
  }

  public String getSize() {
    if (this.matrix == null) return "null";

    return matrix.size() + "x" + matrix.get(0).size();
  }

  // TODO: Add Matrix
  public Matrix add(Matrix other) {
    return this;
  }

  // TODO: ConcurrentAddMatrix
  public Matrix addConcurrently(Matrix other) {
    return this;
  }

  @Override
  public String toString() {
    if (this.matrix == null) return "";

    StringBuilder strRepresentation = new StringBuilder();

    matrix.forEach(column -> {
      column.forEach(element -> strRepresentation.append(String.format("%5s", element)));

      strRepresentation.append("\n");
    });

    return strRepresentation.toString();
  }

  private List<Integer> addMatrixColumns(List<Integer> rowA, List<Integer> rowB) {
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

  // TODO: Private compare size
}
