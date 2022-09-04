package crud;
import java.util.Scanner;
import modelo.Pedido;
import modelo.PedidoDAO;
public class Principal {

	public static void main(String[] args) {
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = new Pedido();
		
		Scanner entrada = new Scanner(System.in);
		
		String nome = "";
		String email = "";
		String destino = "";
		String aerea = "";
		int telefone;
		int opcao = 0;
		int codigo = 0;
		

		do {

			System.out.println("******** Pacotes de Viagens ********");
			System.out.println("1 - Cadastrar dados do pedido");
			System.out.println("2 - Excluir dados de compra");
			System.out.println("3 - Atualizar dados de compra");
			System.out.println("4 - Mostrar dados");
			System.out.println("5 - Localizar por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();
			
			switch (opcao) {
			case 1: {
				System.out.println("Informe o nome completo: ");
				nome = entrada.next();
				pedido.setNome(nome);

				System.out.println("Informe o seu telefone: ");
				telefone = entrada.nextInt();
				pedido.setTelefone(telefone);
				
				System.out.println("Informe o seu e-mail: ");
				email = entrada.next();
				pedido.setEmail(email);
				
				System.out.println("Informe o destino escolhido: ");
				destino = entrada.next();
				pedido.setDestino(destino);
				
				System.out.println("Informe a companhia aérea escolhida: ");
				aerea = entrada.next();
				pedido.setAerea(aerea);
				
				pedidoDAO.save(pedido);
				System.out.println("Dados salvos com sucesso! ");
				break;
			}
			case 2: {
				System.out.println("Informe o codigo do produto para excluir: ");
				try {
					codigo = entrada.nextInt();
					
					pedidoDAO.removeById(codigo);
					
					
				} catch (Exception e) {
					// e.getMessage();
					 
					System.out.println("Não há nenhum item para excluir");
				}

				break;
			}
			case 3: {

				System.out.println("Informe o código do pedido para atualizar:");
				codigo = entrada.nextInt();
				
				System.out.println("Informe o nome completo: ");
				nome = entrada.next();
				pedido.setNome(nome);

				System.out.println("Informe um novo destino: ");
				destino = entrada.next();
				pedido.setDestino(destino);

				System.out.println("Informe novamente o telefone: ");
				telefone = entrada.nextInt();
				pedido.setTelefone(telefone);
				
				System.out.println("Informe novamente o e-mail: ");
				email = entrada.next();
				pedido.setEmail(email);
				
				System.out.println("Informe uma nova companhia aérea: ");
				aerea = entrada.next();
				pedido.setAerea(aerea);
				
				System.out.println("Alterações salvas com sucesso! ");
				
				

				pedido.setId(codigo);

				pedidoDAO.update(pedido);
				
			}
			case 4: {
				for (Pedido c : pedidoDAO.getPedidos()) {
					
					System.out.println("INFORMAÇÕES DO CARRINHO:");
					System.out.println("NOME: " + c.getNome());
					System.out.println("TELEFONE: " + c.getTelefone());
					System.out.println("E-MAIL: " + c.getEmail());
					System.out.println("DESTINO: " + c.getDestino());
					System.out.println("COMPANHIA AÉREA: " + c.getAerea());

					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Informe o ID para buscar: ");
				int id = entrada.nextInt();
				
				Pedido c = new Pedido();

				c = pedidoDAO.getPedidoById(id);

				System.out.println("NOME: " + c.getNome());
				System.out.println("TELEFONE: " + c.getTelefone());
				System.out.println("E-MAIL: " + c.getEmail());
				System.out.println("DESTINO: " + c.getDestino());
				System.out.println("COMPANHIA AÉREA: " + c.getAerea());

				System.out.println("----------------------------------- ");
			}
			break;
			
			case 6: {
				System.out.println(" === Obrigada! === ");
				break;
			}
			default:
				System.out.println("Opção invalida");

			}
			;
		} while (opcao != 6);

		entrada.close();
	}
}
	
