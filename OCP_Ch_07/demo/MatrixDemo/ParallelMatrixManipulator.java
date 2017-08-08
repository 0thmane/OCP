import java.util.*;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class ParallelMatrixManipulator {
    private ParallelMatrixManipulator() {}

    public static List<List<Integer>> addMatrices(List<List<Integer>> matrixA, List<List<Integer>> matrixB) {
        List<List<Integer>> result = new ArrayList<>();
        int rowSize = matrixA.get(0).size();
        int columnSize = matrixA.size();

        IntStream.range(0, columnSize)
            .parallel()
            .forEach(columnIndex -> {
                List<Integer> resultingRow = new ArrayList<>();

                IntStream.range(0, rowSize)
                    .forEach(rowIndex -> {
                        Integer newElement = new Integer(matrixA.get(columnIndex).get(rowIndex) + matrixB.get(columnIndex).get(rowIndex));

                        resultingRow.add(newElement);
                    });

                result.add(resultingRow);
            });

        // -------------------------------------------------------------------------------------------------------------------------------
        // Attempt 2
        /*
        Stream.generate(() -> new ArrayList<Integer>())
            .limit(matrixA.size())
            .parallel()
            .forEach(resultingRow -> {
                IntStream.range(0, rowSize)
                    .forEach(index -> {
                        Integer newElement = new Integer(index);
                        resultingRow.add(newElement);
                    });

                System.out.println(resultingRow);
            });
        */


        // -------------------------------------------------------------------------------------------------------------------------------
        // Attempt 1
        /*
        Stream.generate(() -> new ArrayList<Integer>())
            .limit(matrixA.size())
            .forEach(resultingRow -> {
                Stream.generate(() -> new Integer(5))
                    .limit(matrixA.get(0).size())
                    .forEach(resultingElement -> System.out.println(resultingElement));
            });
        */
        return result;
    }
}
