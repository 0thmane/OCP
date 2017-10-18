package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private final static String TARGET_PATH_URL = "data/";


    private static void runDemo(String implementationType) {
        List<SpaceshipDto> spaceships = SpaceshipDao.readAllSpaceships();
        List<String> failedToWriteShips = new ArrayList<>();

        switch (implementationType) {
            case "new" :
                failedToWriteShips = new SpaceshipWriter().writeShipsToFiles(TARGET_PATH_URL, spaceships, false);
                break;
            case "old" :
                failedToWriteShips = new SpaceshipWriterOLD().writeShipsToFiles(TARGET_PATH_URL, spaceships, false);
                break;
            default :
                System.out.println("Unrecognized implementation type.");
        }

        failedToWriteShips.forEach(shipName -> System.out.println("Failed to write ship: " + shipName));
    }

    public static void main(String[] args) throws IOException {
        runDemo("old");
    }
}
