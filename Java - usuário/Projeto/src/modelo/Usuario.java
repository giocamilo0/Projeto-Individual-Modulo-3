package modelo;
import java.util.Date;

public class Usuario {

	private int id;
	private String nome;
	private int telefone;
	String email = "";
	String destino="";
	int dias=0;
	float valor=0;
	private Date dataCadastro;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
		
	}
	
	
	public void setDias(int dias) {
		this.dias = dias;
		
	}

	public int getDias() {

		return dias;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public float getValor() {
		return valor;
	}



	
}
