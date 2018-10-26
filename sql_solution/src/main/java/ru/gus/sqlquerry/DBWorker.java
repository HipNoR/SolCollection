package ru.gus.sqlquerry;

import java.sql.*;

/**
 * Example of worker with db.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 26.10.2018
 */
public class DBWorker implements AutoCloseable {

    private Connection connect;

    public DBWorker() {
        try {
            setConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Simple protected from sql injection query.
     * @param id for example.
     */
    public void simpleQuerry(int id) {
        try (final PreparedStatement st = this.connect.prepareStatement("SELECT * FROM table WHERE id=(?)")) {
            st.setInt(1, id);
            try (final ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    String sample = rs.getString("");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setConnection() throws SQLException {
        String url = "url to DB";
        String username = "username";
        String password = "password";
        connect = DriverManager.getConnection(url, username, password);
    }


    @Override
    public void close() throws Exception {
        connect.close();
    }
}
