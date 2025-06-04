package common.practice.orm;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.Arrays;

public class Orm {

    private final DataSource dataSource;

    public Orm(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public <T> T findById(Class<T> entityClass, Object id) {
        try {
            return executeFindByIdQuery(entityClass, id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load entity: " + entityClass.getSimpleName(), e);
        }
    }

    private <T> T executeFindByIdQuery(Class<T> entityClass, Object id) throws Exception {
        try (var connection = dataSource.getConnection()) {
            String tableName = entityClass.getAnnotation(Table.class).name();
            String idColumn = Arrays.stream(entityClass.getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(Id.class))
                    .findFirst()
                    .map(this::resolveColumnName)
                    .orElseThrow();

            String sql = "SELECT * FROM %s WHERE %s = ?".formatted(tableName, idColumn);
            try (var statement = connection.prepareStatement(sql)) {
                statement.setObject(1, id);
                try (var resultSet = statement.executeQuery()) {
                    if (!resultSet.next()) return null;
                    return mapResultSetToEntity(entityClass, resultSet);
                }
            }
        }
    }

    private <T> T mapResultSetToEntity(Class<T> entityClass, ResultSet resultSet) throws Exception {
        T entity = entityClass.getConstructor().newInstance();
        for (Field field : entityClass.getDeclaredFields()) {
            field.setAccessible(true);
            String columnName = resolveColumnName(field);
            Object columnValue = resultSet.getObject(columnName);
            field.set(entity, columnValue);
        }
        return entity;
    }

    private String resolveColumnName(Field field) {
        if (field.isAnnotationPresent(Column.class)) {
            return field.getAnnotation(Column.class).name();
        }
        return toSnakeCase(field.getName());
    }

    public static String toSnakeCase(String input) {
        return input.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
    }
}
