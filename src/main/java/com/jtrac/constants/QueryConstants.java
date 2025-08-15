package com.jtrac.constants;

public final class QueryConstants {
    public static final String GET_ALL_USERS = "SELECT * FROM users";
    public static final String INSERT_USER = "INSERT INTO users (emp_id, first_name, last_name, password, role_name)" +
            "VALUES (:empId, :firstName, :lastName, :password, :role)";
    public static final String GET_ROLE_BY_ROLE_NAME = "SELECT * FROM roles WHERE role_name = :roleName";
}
