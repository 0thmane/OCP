package Main;

import java.io.IOException;
import java.util.List;

public class Main {

    private final static String TARGET_PATH_URL = "data/";

    private static void runDemo() {
        List<SpaceshipDto> spaceships = SpaceshipDao.readAllSpaceships();
        List<String> failedToWriteShips = SpaceshipWriter.writeShipsToFiles(TARGET_PATH_URL, spaceships, false);

        failedToWriteShips.stream()
                .forEach(shipName -> System.out.println("Failed to write ship: " + shipName));
    }

    public static void main(String[] args) throws IOException {
        runDemo();
    }
}
