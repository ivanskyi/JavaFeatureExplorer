package common.practice.orm;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class OrmLauncher {

    private static final String JDBC_POSTGRESQL_URL = "jdbc:postgresql://localhost:5432/company";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "admin";

    public static void main(String[] args) {
        try {
            loadAndPrintEmployee();
        } catch (SQLException e) {
            throw new RuntimeException("Unable to load employee entity", e);
        }
    }

    private static void loadAndPrintEmployee() throws SQLException {
        DataSource dataSource = configureDataSource();
        Orm orm = new Orm(dataSource);
        Integer recordId = 1;
        Employee employee = orm.findById(Employee.class, recordId);
        System.out.println(employee);
    }

    private static DataSource configureDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setURL(JDBC_POSTGRESQL_URL);
        dataSource.setUser(DB_USER);
        dataSource.setPassword(DB_PASSWORD);
        return dataSource;
    }
}
