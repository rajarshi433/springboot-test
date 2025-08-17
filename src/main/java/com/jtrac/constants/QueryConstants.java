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
            "                reviewer_id, delivered, sent_back, sub_module, user_id)" +
            "VALUES (:components, :createdAt,\n" +
            "                :deploymentStatus, :description, :developer,\n" +
            "                :git, :lastUpdated, :loggedBy, :module,\n" +
            "                :pdnNumber, :problemId, :problemSource, :product,\n" +
            "                :reviewStatus, :reviewerName,\n" +
            "                :reviewerId, :delivered, :sentBack, :subModule, :userId)";
    public static final String GET_ALL_PDNS = "SELECT * FROM t_pdn t ORDER BY t.created_at DESC";
    public static final String GET_PDNS_BY_GIT = "SELECT * FROM t_pdn t WHERE t.git = :git ORDER BY t.created_at DESC";

    //For Developer
    public static final String GET_PDNS_BY_DEVELOPER = "SELECT * FROM t_pdn t WHERE t.user_id = :userId ORDER BY " +
            "t.created_at DESC";

    //For Reviewer
    public static final String GET_PDNS_BY_REVIEWER = "SELECT * FROM t_pdn t WHERE t.reviewer_id = :reviewerId " +
            "AND t.review_status = 'PENDING' ORDER BY t.created_at DESC";

    //For Developer
    public static final String GET_PDNS_NOT_REVIEWED = "SELECT * FROM t_pdn t WHERE t.review_status = 'PENDING' " +
            "AND t.user_id = :userId " +
            "ORDER BY t.created_at DESC";

    public static final String GET_PDNS_NOT_DEPLOYED = "SELECT * FROM t_pdn t WHERE t.deployment_status = " +
            ":deploymentStatus AND t.review_status = 'SUCCESS' ORDER BY t.created_at DESC";

    // Also get pdn not delivered

    public static final String GET_PDNS_BY_FILTER_OBJ = "SELECT * FROM t_pdn t WHERE " +
            "(:pdnNumber IS NULL OR t.pdn_number = :pdnNumber) " +
            "AND (:fromDate IS NULL OR t.created_at >= :fromDate) " +
            "AND (:toDate IS NULL OR t.created_at < :toDate) " +
            "AND (:developer IS NULL OR t.developer = :developer) " +
            "AND (:git IS NULL OR t.git = :git)" +
            "ORDER BY t.created_at DESC";
}
