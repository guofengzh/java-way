package mybatis.getstarted.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by guofeng on 2016/6/8.
 */
public class DbSetup {
    public static void runScript(SqlSession sqlSession, String resource) throws IOException, SQLException {
        Connection connection = null ;
        try {
            connection = sqlSession.getConnection();
            runScript(connection, resource);
        } finally {
            connection.close();
        }
    }

    public static void runScript(Connection connection, String resource) throws IOException, SQLException {
            ScriptRunner runner = new ScriptRunner(connection);
            runner.setAutoCommit(true);
            runner.setStopOnError(false);
            runner.setLogWriter(null);
            runner.setErrorLogWriter(null);
            runScript(runner, resource);
    }
    public static void runScript(ScriptRunner runner, String resource) throws IOException, SQLException {
        Reader reader = Resources.getResourceAsReader(resource);
        try {
            runner.runScript(reader);
        } finally {
            reader.close();
        }
    }}
