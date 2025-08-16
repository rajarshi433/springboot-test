package com.jtrac.constants;

public final class QueryConstants {
    public static final String GET_ALL_USERS = "SELECT * FROM t_user";
    public static final String CREATE_USER = "INSERT INTO t_user (emp_id, first_name, last_name, password, role_name)" +
            "VALUES (:empId, :firstName, :lastName, :password, :role)";
    public static final String GET_ROLE_BY_ROLE_NAME = "SELECT * FROM t_role WHERE role_name = :roleName";
    public static final String CREATE_PDN = "INSERT INTO t_pdn (components, created_at,\n" +
            "                deployment_status, description, developer,\n" +
            "                git, last_updated, logged_by, module,\n" +
            "                pdn_number, problem_id, problem_source, product,\n" +
            "                review_status, reviewer_name,\n" +
            "                reviewer_id, sent_back, sub_module, user_id)" +
            "VALUES (:components, :createdAt,\n" +
            "                :deploymentStatus, :description, :developer,\n" +
            "                :git, :lastUpdated, :loggedBy, :module,\n" +
            "                :pdnNumber, :problemId, :problemSource, :product,\n" +
            "                :reviewStatus, :reviewerName,\n" +
            "                :reviewerId, :sentBack, :subModule, :userId)";
}
