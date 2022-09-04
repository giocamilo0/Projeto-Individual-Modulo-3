package crud;
import java.util.Scanner;
import modelo.Logar;
import modelo.LogarDAO;


public class Principal {


		public static void main(String[] args) {
			String senha = "";
			String email = "";
			
			Scanner entrada = new Scanner(System.in);
			
			System.out.println("Informe o seu email:");
			email = entrada.next(); 
			System.out.println("Informe a sua senha:");
			senha = entrada.next();
			
			//Logar usuario1 = new Logar(senha, email);
			//Logar usuario2 = new Logar(senha, email);
			
			Logar validar = new Logar();
			LogarDAO logarDao = new LogarDAO();
			//logarDao.save(usuario1);
			//logarDao.save(usuario2);
			//logarDao.removeById(3);
			//logarDao.removeById(4);
			
			validar = logarDao.validarLogin(senha, email);
			
			boolean validado = false;
			
			if(senha.equals(validar.getSenha()) && email.equals(validar.getEmail())) {
				validado = true;
				System.out.println("Login: " + validado);
			}else {
				validado = false;
				System.out.println("Login: " + validado);
			}
			entrada.close();
			
		}

	}


