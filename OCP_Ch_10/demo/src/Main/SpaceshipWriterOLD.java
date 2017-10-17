package Main;

import Exceptions.FileExistsException;

import java.io.File;                // NIO
import java.io.FileOutputStream;    // NIO
import java.io.IOException;
import java.io.OutputStream;        // NIO
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SpaceshipWriterOLD {
    public static List<String> writeShipsToFiles(String targetURL, List<SpaceshipDto> spaceships, boolean overwrite) {
        List<String> failedShipNames;

        failedShipNames = spaceships.stream()
                .map(ship -> {
                    try {
                        writeShipToFile(targetURL, ship, overwrite);
                    } catch (IOException | FileExistsException e){
                        return ship.getName() + " " + e.getMessage();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    return null;})
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return failedShipNames;
    }

    public static void writeShipToFile(String targetURL, SpaceshipDto ship, boolean overwrite) throws IOException, FileExistsException {
        String filename = generateShipFilename(ship);
        ensureTargetDirExists(targetURL);

        File shipFile = new File(targetURL + filename);                 // File vs Path

        if (!overwrite & shipFile.exists()) {
            throw new FileExistsException("Cannot overwrite existing file.");
        }

        try (OutputStream out = new FileOutputStream(shipFile)) {               // try with resources
            byte[] shipByteRepresentation = generateShipByteArray(ship);

            out.write(shipByteRepresentation);
        }
    }

    private static void ensureTargetDirExists(String targetURL) throws IOException {
        File directory = new File(targetURL);

        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    private static byte[] generateShipByteArray(SpaceshipDto ship) {
        StringBuilder representation = new StringBuilder();

        representation.append("Ship ID: " + ship.getId());
        representation.append("\nShip Name: " + ship.getName());
        representation.append("\nShip Capacity: " + ship.getCapacity());

        return representation.toString().getBytes();
    }

    private static String generateShipFilename(SpaceshipDto ship) {
        StringBuilder filename = new StringBuilder();
        String fileFriendlyShipName = ship.getName().replace(" ", "");

        filename.append(ship.getId());
        filename.append("-");
        filename.append(fileFriendlyShipName);
        filename.append(".ship");

        return filename.toString();
    }
}
