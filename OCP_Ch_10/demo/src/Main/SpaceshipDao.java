package Main;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class SpaceshipDao {
    // Make sure to use SSL
    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/java?useSSL=true";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    private final static String ALL_FIELDS_QUERY = "SELECT id, name, capacity FROM spaceship;";

    public static List<SpaceshipDto> readAllSpaceships() {
        List<SpaceshipDto> queriedShips = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {

            ResultSet resultSet = statement.executeQuery(ALL_FIELDS_QUERY);

            while (resultSet.next()) {
                SpaceshipDto spaceship = createSpaceship(resultSet);
                queriedShips.add(spaceship);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return queriedShips;
    }

    private static SpaceshipDto createSpaceship(ResultSet resultSet) throws SQLException {
        SpaceshipDto spaceshipDto = new SpaceshipDto();

        spaceshipDto.setId(resultSet.getInt("id"));
        spaceshipDto.setName(resultSet.getString("name"));
        spaceshipDto.setCapacity(resultSet.getInt("capacity"));

        return spaceshipDto;
    }
}
