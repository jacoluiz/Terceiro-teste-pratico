package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USERNAME = "automacao";
	private static final String PASSWORD = "Senha@123";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/banco_teste_automacao";

	public static Connection criarConeccaoComMySQL() throws Exception {

		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}

	public static void main(String[] args) throws Exception {
		Connection con = criarConeccaoComMySQL();
		if (con != null) {
			con.close();
		}
	}
}