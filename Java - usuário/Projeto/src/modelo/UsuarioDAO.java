package modelo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Usuario usuario) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO usuario(nome,telefone, email,destino,dias,valor,dataCadastro)" + " VALUES(?,?,?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, usuario.getNome());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setInt(2, usuario.getTelefone());
			
			pstm.setString(3, usuario.getEmail());
			
			pstm.setString(4, usuario.getDestino());
			
			pstm.setInt(5, usuario.getDias());
			
			pstm.setFloat(6, usuario.getValor());
			
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setDate(7, new Date(usuario.getDataCadastro().getTime()));

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

	public void removeById(int id) {

		String sql = "DELETE FROM usuario WHERE id = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

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

	public void update(Usuario usuario) {

		String sql = "UPDATE usuario SET nome = ?, telefone = ?, email = ?, destino = ?, dias = ?, valor = ?, dataCadastro = ?" + " WHERE id = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, usuario.getNome());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setInt(2, usuario.getTelefone());
			
			pstm.setString(3, usuario.getEmail());
			
			pstm.setString(4, usuario.getDestino());
			
			pstm.setInt(5, usuario.getDias());
			
			pstm.setFloat(6, usuario.getValor());
			
			
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setDate(7, new Date(usuario.getDataCadastro().getTime()));

			pstm.setInt(8, usuario.getId());

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

	public List<Usuario> getUsuarios() {

		String sql = "SELECT * FROM usuario";

		List<Usuario> usuarios = new ArrayList<Usuario>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Usuario usuario = new Usuario();

				// Recupera o id do banco e atribui ele ao objeto
				usuario.setId(rset.getInt("id"));

				// Recupera o nome do banco e atribui ele ao objeto
				usuario.setNome(rset.getString("nome"));

				// Recupera a idade do banco e atribui ele ao objeto
				usuario.setTelefone(rset.getInt("telefone"));
				
				usuario.setEmail(rset.getString("email"));
				
				usuario.setDestino(rset.getString("destino"));
				
				usuario.setDias(rset.getInt("dias"));
				
				usuario.setValor(rset.getFloat("valor"));

				// Recupera a data do banco e atribui ela ao objeto
				usuario.setDataCadastro(rset.getDate("dataCadastro"));

				// Adiciono o usuario recuperado, a lista de usuarios
				usuarios.add(usuario);
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

		return usuarios;
	}


	public Usuario getUsuarioById(int id) {

		String sql = "SELECT * FROM usuario where id = ?";
		Usuario usuario = new Usuario();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			usuario.setNome(rset.getString("nome"));
			usuario.setTelefone(rset.getInt("telefone"));
			usuario.setEmail(rset.getString("email"));
			usuario.setDestino(rset.getString("destino"));
			usuario.setDias(rset.getInt("dias"));
			usuario.setValor(rset.getFloat("valor"));
			usuario.setDataCadastro(rset.getDate("dataCadastro"));
			

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
		return usuario;
	}
}
