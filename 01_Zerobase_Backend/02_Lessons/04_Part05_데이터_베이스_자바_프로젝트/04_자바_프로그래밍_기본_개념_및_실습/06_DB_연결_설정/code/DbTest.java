package code;

import java.sql.*;

public class DbTest {
    public static void main(String[] args) {
        /**
         * 5개
         * 1. ip(domain)
         * 2. port
         * 3. 계정
         * 4. 패스워드
         * 5. 인스턴스
         */
        String url = "jdbc:mariadb://IP_ADDR:IP_PORT/INSTANCE";
        String dbUserId = "testuser1";
        String dbPassword = "testuser1";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제(close)

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

//        CallableStatement callableStatement = null;
//        Statement statement = null; (파라미터 이슈가 발생하므로 PreparedStatement 사용)
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet rs = null;

        // email 대신 kakao, facebook 등 유동적으로 값을 사용하고 싶을 때, 변수 사용
        // (다만, 외부에서 injection 가능하므로, 실무에서는 암호화 필요)
        String memberTypeValue = "email";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);


//            statement = connection.createStatement();


            String sql = " select member_type, user_id, password, name " +
                    " from_member " +
//                    " where member_type = '" + memberTypeValue + "' ";
                    " where member_type = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberTypeValue); // PreparedStatement로 SQL Injection 공격 방어 가능

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String memberType = rs.getString("member_type");
                String userId = rs.getString(" user_id");
                String password = rs.getString("password");
                String name = rs.getString("name");

                System.out.println(memberType + ", " + userId + ", " + password + ", " + name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null && !rs.isClosed()) { rs.close(); }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if (statement != null && !statement.isClosed()) { statement.close(); }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if (connection != null && !connection.isClosed()) { connection.close(); }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
