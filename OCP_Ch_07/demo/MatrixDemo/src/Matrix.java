import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

// 2D matrix
public class Matrix {
  private final List<List<Integer>> matrix;

  private Matrix(List<List<Integer>> matrix) {
    this.matrix = matrix;
  }

  public static Matrix of(List<List<Integer>> matrix) {
    return new Matrix(matrix);
  }

  // TODO: Add Matrix
  public Matrix addMatrix(Matrix other) {
    return this;
  }

  // TODO: ConcurrentAddMatrix
  public Matrix addMatrixConcurrently(Matrix other) {
    return this;
  }

  public static Matrix randomSquareMatrix(int size) {
    return Matrix.randomMatrix(size, size);
  }

  public static Matrix randomMatrix(int xDimension, int yDimension) {
    List<List<Integer>> randomMatrix = new ArrayList<>();
    Random random = new Random();

    IntStream.range(0, xDimension)
      .forEach((x) -> {
        List<Integer> column = new ArrayList<>();

        IntStream.range(0, yDimension)
          .forEach(
            (y) -> {
              column.add(random.nextInt(25));
        });

      randomMatrix.add(column);
    });

    return Matrix.of(randomMatrix);
  }

  @Override
  public String toString() {
    if (this.matrix == null) return "";


    StringBuilder strRepresentation = new StringBuilder();

    matrix.forEach(column -> {
              column.forEach(
                      element -> strRepresentation.append(String.format("%5s", element)));
              strRepresentation.append("\n");
            }
    );

    return strRepresentation.toString();
  }

  // TODO: Private addMatrixColumns
}
