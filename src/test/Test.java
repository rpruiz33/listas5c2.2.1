package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import model.Carrito;
import model.Cliente;
import model.ItemCarrito;
import model.Producto;
import model.Supermercado;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		Supermercado s = new Supermercado();
		Cliente c1= new Cliente(1, "rober", 12121212, "calle unla");
		Producto p = new Producto(1, "cafe", 23.2f);
		ItemCarrito i = new ItemCarrito(1, p, 22);
		Carrito c = new Carrito(1, LocalDate.of(2222, 02, 02), LocalTime.of(12, 12),c1);
		System.out.println(c.agregarItem(p, 1));
		System.out.println(c.agregarItem(p, 1));
		System.out.println("\ntamanio de gondola"+s.getGondola());
		try {
			System.out.println(s.agregaarProducto("yerba", 3));
			System.out.println(s.agregaarProducto("fideos", 3));

		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		System.out.println(s.traerProducto(0));

		try {
			System.out.println((2));
			System.out.println(s.eliminarProducto(2));
			System.out.println(s.eliminarProducto(2));
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		System.out.println(s.traerProducto(66));
		try {
			System.out.println(s.eliminarProducto(1));
			System.out.println(s.eliminarProducto(2));
		}
		catch (Exception e) {
				System.out.println("Excepcion: " + e.getMessage());
		}
		try {
		System.out.println(c.agregarItem(p,21));
		}
		catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		System.out.println("----------------\n");
		try {
			System.out.println(c.eliminarItem(p, 1));
		}catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

	
}
}