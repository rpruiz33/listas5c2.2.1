package model;

public class Cliente {
private int idCliente;
private String Cliente;
private long dni;
private String direccion;


public int getIdCliente() {
	return idCliente;
}
public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}
public String getCliente() {
	return Cliente;
}
public void setCliente(String cliente) {
	Cliente = cliente;
}
public long getDni() {
	return dni;
}
public void setDni(long dni) {
	this.dni = dni;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public Cliente(int idCliente, String cliente, long dni, String direccion) {
	super();
	this.idCliente = idCliente;
	Cliente = cliente;
	this.dni = dni;
	this.direccion = direccion;
}




}
