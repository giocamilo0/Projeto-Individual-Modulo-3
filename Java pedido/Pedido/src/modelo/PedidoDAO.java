package modelo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PedidoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	
	public void save(Pedido pedido) {
		String sql = "INSERT INTO pedido(nome,telefone, email, destino, aerea)" + " VALUES(?,?,?,?,?)";
	

	try {
		// Cria uma conexão com o banco
		conn = Conexao.createConnectionToMySQL();

		// Cria um PreparedStatment, classe usada para executar a query
		pstm = conn.prepareStatement(sql);

		// Adiciona o valor do primeiro parâmetro da sql
		pstm.setString(1, pedido.getNome());
		// Adicionar o valor do segundo parâmetro da sql
		pstm.setInt(2, pedido.getTelefone());
		
		pstm.setString(3, pedido.getEmail());
		
		pstm.setString(4, pedido.getDestino());
		
		pstm.setString(5, pedido.getAerea());
		
		// Adiciona o valor do terceiro parâmetro da sql

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

	String sql = "DELETE FROM pedido WHERE id = ?";

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

public void update(Pedido pedido) {

	String sql = "UPDATE pedido SET nome = ?, telefone = ?, email = ?, destino = ?, aerea = ?" + " WHERE id = ?";

	try {
		// Cria uma conexão com o banco
		conn = Conexao.createConnectionToMySQL();

		// Cria um PreparedStatment, classe usada para executar a query
		pstm = conn.prepareStatement(sql);

		/// Adiciona o valor do primeiro parâmetro da sql
		pstm.setString(1, pedido.getNome());
		// Adicionar o valor do segundo parâmetro da sql
		pstm.setInt(2, pedido.getTelefone());
		
		pstm.setString(3, pedido.getEmail());
		
		pstm.setString(4, pedido.getDestino());
		
		pstm.setString(5, pedido.getAerea());
		
		pstm.setInt(6, pedido.getId());

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

public List<Pedido> getPedidos() {

	String sql = "SELECT * FROM pedido";

	List<Pedido> pedidos = new ArrayList<Pedido>();

	// Classe que vai recuperar os dados do banco de dados
	ResultSet rset = null;

	try {
		conn = Conexao.createConnectionToMySQL();

		pstm = conn.prepareStatement(sql);

		rset = pstm.executeQuery();

		// Enquanto existir dados no banco de dados, faça
		while (rset.next()) {

			Pedido pedido = new Pedido();

			// Recupera o id do banco e atribui ele ao objeto
			pedido.setId(rset.getInt("id"));

			// Recupera o nome do banco e atribui ele ao objeto
			pedido.setNome(rset.getString("nome"));

			// Recupera a idade do banco e atribui ele ao objeto
			pedido.setTelefone(rset.getInt("telefone"));
			
			pedido.setEmail(rset.getString("email"));
			
			pedido.setDestino(rset.getString("destino"));
			
			pedido.setAerea(rset.getString("aerea"));
			
			// Adiciono o usuario recuperado, a lista de usuarios
			pedidos.add(pedido);
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

	return pedidos;
}


public Pedido getPedidoById(int id) {

	String sql = "SELECT * FROM pedido where id = ?";
	Pedido pedido = new Pedido();

	ResultSet rset = null;

	try {
		conn = Conexao.createConnectionToMySQL();
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rset = pstm.executeQuery();

		rset.next();

		pedido.setNome(rset.getString("nome"));
		pedido.setTelefone(rset.getInt("telefone"));
		pedido.setEmail(rset.getString("email"));
		pedido.setDestino(rset.getString("destino"));
		pedido.setAerea(rset.getString("aerea"));


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
	return pedido;
}

}