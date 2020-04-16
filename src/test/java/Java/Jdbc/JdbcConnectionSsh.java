package Java.Jdbc;

/**
 * https://stackoverflow.com/questions/1968293/connect-to-remote-mysql-database-through-ssh-using-java
 */

import java.sql.*;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class JdbcConnectionSsh {
    static int localPort;
    static String remoteHost;
    static int remotePort;


    public static void go() {
        String user = "ripon";
        String password = "wasim";
        String host = "myhost.ripon.wasim";
        int port = 22;
        try {
JSch jsch = new JSch();
Session session = jsch.getSession(user, host, port);
localPort = 4321;
remoteHost = "localhost";
remotePort = 3306;
session.setPassword(password);
session.setConfig("StrictHostKeyChecking", "no");
System.out.println("Establishing Connection...");
session.connect();
int assigned_port = session.setPortForwardingL(localPort, remoteHost, remotePort);
            System.out.println("localhost:" + assigned_port + " -> " + remoteHost + ":" + remotePort);
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    public static void goR() {
        String user = "ripon";
        String password = "wasim";
        String host = "myhost.ripon.wasim";

        try {
JSch jsch = new JSch();
Session session = jsch.getSession(user, host, 22);
int localPort = 8888;
String localHost = "localhost";
int remotePort = 8881;
session.setPassword(password);
session.setConfig("StrictHostKeyChecking", "no");
System.out.println("Establishing Connection...");
session.connect();
session.setPortForwardingR(localPort, localHost, remotePort);
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    public static void main(String[] args) {
        try {
            go();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("An example for updating a Row from Mysql Database!");
        Connection con = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://" + remoteHost + ":" + localPort + "/";
        String db = "testDB";
        String dbUser = "wasim";
        String dbPasswd = "riponalwasim123";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + db, dbUser, dbPasswd);
            try {
                Statement st = con.createStatement();
                String sql = "UPDATE MyTableName " +
                        "SET email = 'ripon.wasim@smile.com' WHERE email='peace@happy.com'";

                int update = st.executeUpdate(sql);
                if (update >= 1) {
                    System.out.println("Row is updated.");
                } else {
                    System.out.println("Row is not updated.");
                }
            } catch (SQLException s) {
                System.out.println("SQL statement is not executed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


