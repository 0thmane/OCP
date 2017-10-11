package Main;

import Exceptions.FileExistsException;

import java.io.*;
import java.nio.file.Path;  // NIO 2
import java.nio.file.Paths; // NIO 2
import java.nio.file.Files; // NIO 2
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SpaceshipWriter {
    public static List<String> writeShipsToFiles(String targetURL, List<SpaceshipDto> spaceships, boolean overwrite) {
        List<String> failedShipNames;

        failedShipNames = spaceships.stream()
                .map(ship -> {
                    try {
                        writeShipToFile(targetURL, ship, overwrite);
                    } catch (IOException | FileExistsException e){
                        return ship.getName();
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
        Path shipPath = Paths.get(targetURL + filename);

        ensureTargetDirExists(targetURL);

        if (!overwrite & Files.exists(shipPath)) {
            throw new FileExistsException("Cannot overwrite existing file.");
        }

        Files.write(shipPath, generateShipByteArray(ship));
    }

    private static void ensureTargetDirExists(String targetURL) throws IOException {
        Path targetPath = Paths.get(targetURL);

        if (!Files.exists(targetPath)) {
            Files.createDirectory(Paths.get("data/"));
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