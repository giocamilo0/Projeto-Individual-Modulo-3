package modelo;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final String USERNAME = "root";

	private static final String PASSWORD = "batatafrita@123";

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/login";

//   * Cria uma conexão com o banco de dados MySQL utilizando o nome de usuário e senha fornecidos
//   * @param username
//   * @param senha
//   * @return uma conexão com o banco de dados
//   * @throws Exception

	public static Connection createConnectionToMySQL() throws Exception {

		// Cria a conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}

}
