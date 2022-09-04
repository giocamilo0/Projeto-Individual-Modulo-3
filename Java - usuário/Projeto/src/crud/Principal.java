package crud;
import java.util.Date;
import java.util.Scanner;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class Principal {

	public static void main(String[] args) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();

		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		String nome = "";
		int telefone = 0;
		String email = "";
		int codigo = 0;
		String destino ="";
		float valor=0;
		int dias=0;
		
		

		do {

			System.out.println("******** Cadastro de Usuário ********");
			System.out.println("1 - Cadastro de usuário - Pedido");
			System.out.println("2 - Excluir usuário");
			System.out.println("3 - Atualizar usuário");
			System.out.println("4 - Mostrar usuários");
			System.out.println("5 - Localizar por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {
				System.out.println("Informe o nome do cliente: ");
				nome = entrada.next();
				usuario.setNome(nome);

				System.out.println("Informe o telefone do cliente: ");
				telefone = entrada.nextInt();
				usuario.setTelefone(telefone);
				
				System.out.println("Informe o e-mail do cliente: ");
				email = entrada.next();
				usuario.setEmail(email);

				System.out.println("Informe o destino do cliente: ");
				destino = entrada.next();
				usuario.setDestino(destino);
				
				System.out.println("Informe a quantidade de dias: ");
				dias = entrada.nextInt();
				usuario.setDias(dias);
				
				System.out.println("Informe valor da passagem do cliente: ");
				valor = entrada.nextFloat();
				usuario.setValor(valor);
				
				usuario.setDataCadastro(new Date());

				usuarioDAO.save(usuario);
				System.out.println("Compra cadastrada! ");
				break;
			}
			case 2: {
				System.out.println("Informe o codigo do contato para excluir: ");
				try {
					codigo = entrada.nextInt();
					
					usuarioDAO.removeById(codigo);
					
				} catch (Exception e) {
					// e.getMessage();
					 
					System.out.println("Não há nenhum cliente para excluir");
				}

				break;
			}
			case 3: {

				System.out.println("Informe o código do cliente para atualizar: ");
				codigo = entrada.nextInt();

				System.out.println("Informe o nome correto do cliente: ");
				nome = entrada.next();
				usuario.setNome(nome);

				System.out.println("Informe um novo telefone: ");
				telefone = entrada.nextInt();
				usuario.setTelefone(telefone);
				
				System.out.println("Informe um novo e-mail: ");
				email = entrada.next();
				usuario.setEmail(email);
				
				System.out.println("Informe um novo destino: ");
				destino = entrada.next();
				usuario.setDestino(destino);
				
				System.out.println("Informe a quantidade de dias: ");
				dias = entrada.nextInt();
				usuario.setDias(dias);
				
				System.out.println("Informe o novo valor: ");
				valor = entrada.nextFloat();
				usuario.setValor(valor);
				
				System.out.println("Alterações salvas com sucesso! ");
				
				usuario.setDataCadastro(new Date());

				usuario.setId(codigo);

				usuarioDAO.update(usuario);
				
			}
			case 4: {
				for (Usuario c : usuarioDAO.getUsuarios()) {

					System.out.println("NOME: " + c.getNome());
					System.out.println("TELEFONE: " + c.getTelefone());
					System.out.println("E-MAIL: " + c.getEmail());
					System.out.println("DESTINO: " + c.getDestino());
					System.out.println("QTD DE DIAS: " + c.getDias());
					System.out.println("VALOR: " + c.getValor());
					System.out.println("DATA DE CADASTRO: " + c.getDataCadastro());

					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Informe o ID para buscar: ");
				int id = entrada.nextInt();
				
				Usuario c = new Usuario();

				c = usuarioDAO.getUsuarioById(id);

				System.out.println("NOME: " + c.getNome());
				System.out.println("TELEFONE: " + c.getTelefone());
				System.out.println("E-MAIL: " + c.getEmail());
				System.out.println("DESTINO: " + c.getDestino());
				System.out.println("QTD DE DIAS: " + c.getDias());
				System.out.println("VALOR: " + c.getValor());
				System.out.println("DATA DE CADASTRO: " + c.getDataCadastro());

				System.out.println("----------------------------------- ");
			}
				break;

			case 6: {
				System.out.println(" === Fim === ");
				break;
			}
			default:
				System.out.println("Opcao invalida: ");

			}
			;

		} while (opcao != 6);

		entrada.close();

	
	
}
}

	
	
	

