import java.util.*;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class ParallelMatrixManipulator {
    private ParallelMatrixManipulator() {}

    public static List<List<Integer>> addMatrices(List<List<Integer>> matrixA, List<List<Integer>> matrixB) {
        List<List<Integer>> result = new ArrayList<>();

        int matrixWidth = matrixA.size();
        int matrixHeight = matrixA.get(0).size();

        

        // --------------------------------------------------------------------------------------------------------------------------------
        // Attempt 4
        /*
        IntStream.range(0, matrixHeight)
            // .parallel()
            .forEach(columnIndex -> {
                List<Integer> resultingRow = new ArrayList<>();

                IntStream.range(0, matrixWidth)
                    .forEach(rowIndex -> {
                        Integer newElement = new Integer(matrixA.get(columnIndex).get(rowIndex) + matrixB.get(columnIndex).get(rowIndex));

                        resultingRow.add(newElement);
                    });

                result.add(resultingRow);
            });

        return result;
        */
    }
}
