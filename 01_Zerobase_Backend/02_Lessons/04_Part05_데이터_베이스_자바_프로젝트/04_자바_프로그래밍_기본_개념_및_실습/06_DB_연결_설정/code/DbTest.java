package code;

import java.sql.*;

public class DbTest {
    public void dbSelect() {
        /**
         * 5개
         * 1. ip(domain)
         * 2. port
         * 3. 계정
         * 4. 패스워드
         * 5. 인스턴스
         */
        String url = "jdbc:mariadb://192.168.0.6:3306/testdb1";
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
                    " from member " +
//                    " where member_type = '" + memberTypeValue + "' ";
                    " where member_type = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberTypeValue); // PreparedStatement로 SQL Injection 공격 방어 가능

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String memberType = rs.getString("member_type");
                String userId = rs.getString("user_id");
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
                if (preparedStatement != null && !preparedStatement.isClosed()) { preparedStatement.close(); }
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
    public void dbInsert() {
        /**
         * 5개
         * 1. ip(domain)
         * 2. port
         * 3. 계정
         * 4. 패스워드
         * 5. 인스턴스
         */
        String url = "jdbc:mariadb://192.168.0.6:3306/testdb1";
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
        String userIdValue = "zerobase@naver.com";
        String passwordValue = "3333";
        String nameValue = "제로베이스";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);


//            statement = connection.createStatement();


            String sql = " insert into member (member_type, user_id, password, name) " +
                    " values (?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberTypeValue); // PreparedStatement로 SQL Injection 공격 방어 가능
            preparedStatement.setString(2, userIdValue);
            preparedStatement.setString(3, passwordValue);
            preparedStatement.setString(4, nameValue);


            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println("저장 성공");
            } else {
                System.out.println("저장 실패");
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
                if (preparedStatement != null && !preparedStatement.isClosed()) { preparedStatement.close(); }
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
    public void dbUpdate() {
        /**
         * 5개
         * 1. ip(domain)
         * 2. port
         * 3. 계정
         * 4. 패스워드
         * 5. 인스턴스
         */
        String url = "jdbc:mariadb://192.168.0.6:3306/testdb1";
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
        String userIdValue = "zerobase@naver.com";
        String passwordValue = "9999";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);


//            statement = connection.createStatement();


            String sql = " update member set " +
                    " password = ?" +
                    "where member_type = ? and user_id = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, passwordValue);
            preparedStatement.setString(2, memberTypeValue); // PreparedStatement로 SQL Injection 공격 방어 가능
            preparedStatement.setString(3, userIdValue);



            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
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
                if (preparedStatement != null && !preparedStatement.isClosed()) { preparedStatement.close(); }
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
    public void dbDelete() {
        /**
         * 5개
         * 1. ip(domain)
         * 2. port
         * 3. 계정
         * 4. 패스워드
         * 5. 인스턴스
         */
        String url = "jdbc:mariadb://192.168.0.6:3306/testdb1";
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
        String userIdValue = "zerobase@naver.com";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);


//            statement = connection.createStatement();


            String sql = "delete from member " +
                    "where member_type = ? and user_id = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberTypeValue); // PreparedStatement로 SQL Injection 공격 방어 가능
            preparedStatement.setString(2, userIdValue);



            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
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
                if (preparedStatement != null && !preparedStatement.isClosed()) { preparedStatement.close(); }
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
