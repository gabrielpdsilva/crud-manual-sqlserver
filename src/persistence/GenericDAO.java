package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO implements IGenericDAO {

	private Connection c;

	@Override
	public Connection getConnection() {
		try {
			Connection c = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=loja;user=sa;password=123456");
			System.out.println("Conexao estabelecida.");
			return c;
		} catch (SQLException e) {
			System.out.println("Falha na conexão.");
			throw new RuntimeException(e);
		}
	}
}
