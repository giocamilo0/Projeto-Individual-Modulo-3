package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LogarDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Logar logar) {

		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados

		String sql = "INSERT INTO logar(senha, email)" + " VALUES(?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, logar.getSenha());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, logar.getEmail());
		
			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public Logar validarLogin(String senha, String email) {

		String sql = "SELECT * FROM logar WHERE senha = ? AND email = ?";
		Logar logar = new Logar();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			//pstm.setInt(1, id);
			pstm.setString(1, senha);
			pstm.setString(2, email);
			rset = pstm.executeQuery();

			while (rset.next()) {
				logar.setSenha(rset.getString("senha"));
				logar.setEmail(rset.getString("email"));
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return logar;
	}
	
	public void removeById(int id) {

		String sql = "DELETE FROM logar WHERE id = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

}
