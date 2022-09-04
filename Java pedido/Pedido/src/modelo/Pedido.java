package modelo;

public class Pedido {
	
private String nome;
private int telefone;
String email = "";
String destino = "";
private int id;
private String aerea;


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
public String getDestino() {
	return destino;
}
public void setDestino(String destino) {
	this.destino = destino;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getAerea() {
	return aerea;
}
public void setAerea(String aerea) {
	this.aerea = aerea;
	
}


}
