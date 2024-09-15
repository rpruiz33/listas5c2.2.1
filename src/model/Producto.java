package model;

import java.util.Objects;

public class Producto {
private int idProducto;
private String producto;
private float precio;


public int getIdProducto() {
	return idProducto;
}
public void setIdProducto(int idProducto) {
	this.idProducto = idProducto;
}
public String getProducto() {
	return producto;
}
public void setProducto(String producto) {
	this.producto = producto;
}
public float getPrecio() {
	return precio;
}
public void setPrecio(float precio) {
	this.precio = precio;
}

public Producto( int id ,String producto, float precio) {
	super();
	this.idProducto = id;
	this.producto = producto;
	this.precio = precio;
}

public boolean equals(Producto p) {

	return this.producto.equals(p.getProducto())&& this.idProducto== p.getIdProducto();
}
@Override
public String toString() {
	return "Producto [idProducto=" + idProducto + ", producto=" + producto + ", precio=" + precio + "]";
}







}
