package Laboratorul8;
import java.sql.*;

public class Database {

    private static Database dbInstance;
    private static Connection con;


    private Database() {
    }

    public static Database getInstance() { //nu lasa utilizatorul sa aiba 2 conexiuni la acc baza de date
        if (dbInstance == null) {
            dbInstance = new Database();
        }
        return dbInstance;
    }

    public Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");//incarca driverul pt oracle
                String host = "jdbc:oracle:thin:@localhost:1521:xe";
                String username = "STUDENT";
                String password = "STUDENT";
                con = DriverManager.getConnection(host, username, password);//creez conexiunea
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return con;//returnez conexiunea
    }

    public static Connection endConnection(){
        if(con != null)
            try{
                con.close();//daca nu e nula inchide conexiunea
            } catch (SQLException ex) {ex.printStackTrace();}
        return con;
    }
}