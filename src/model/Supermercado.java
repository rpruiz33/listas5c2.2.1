package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	private List<Producto> gondola;
	private List<Carrito> lstCarrito;
	private List<Cliente> lstCliente;
	
	

	public List<Producto> getGondola() {
		return gondola;
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}


	public List<Cliente> getLstCliente() {
		return lstCliente;
	}






	public Supermercado(List<Producto> gondola, List<Carrito> lstCarrito, List<Cliente> lstCliente) {
		super();
		this.gondola = gondola;
		this.lstCarrito = lstCarrito;
		this.lstCliente = lstCliente;
	}



	public boolean agregaarProducto(String producto, float precio) throws Exception {

		int id = 0;
		Producto p = null;
		if (gondola == null) {
			throw new Exception("La góndola no está inicializada");
		}
		for (int i = 0; i < gondola.size(); i++) {
			if (gondola.get(i).getProducto().equals(producto)) {
				throw new Exception("el producto ya existe");
			}

		}
		if (gondola.size() == 0) {
			id = 1;
		} else {
			id = gondola.get(gondola.size() - 1).getIdProducto() + 1;

		}
		p = new Producto(id, producto, precio);
		return gondola.add(p);

	}



	public Producto traerProducto(int idProducto) {
		int cont = 0;
		Producto p = null;
		while (cont < gondola.size() && p == null) {
			if (gondola.get(cont).getIdProducto() == idProducto) {
				p = gondola.get(cont);
			}

			cont++;

		}

		return p;
	}

	public boolean modificarProducto(int idProducto, String producto, double precio) throws Exception {
		Producto p = null;
		boolean flag = false;
		p = traerProducto(idProducto);
		if (p != null) {
			flag = true;
			p.setPrecio((float) precio);
			p.setProducto(producto);
		}
		return flag;
	}

	public boolean eliminarProducto(int idProducto) throws Exception {
		Producto p = null;
		boolean flag = false;

		p = traerProducto(idProducto);
		if (p == null) {
			throw new Exception("el producto ya no existe");
		}
		if (p != null) {
			gondola.remove(p);
			flag = true;

		}

		return flag;

	}
	
	
	public boolean agrgarLstCarrito(Carrito c)throws Exception {
		
		if(lstCarrito==null) {
			throw new Exception("la lista de carrito no est inicializada");
		}
		for(int i=0;i<lstCarrito.size();i++) {
			if(lstCarrito.get(i).getIdCarrito()==c.getIdCarrito()) {
				throw new Exception("el carrito ya existe");
			}
		}
		
		int id=1;
		if(lstCarrito.size()>0) {
				id=lstCarrito.get(lstCarrito.size()-1).getIdCarrito()+1;
		}
		
		return lstCarrito.add(new Carrito(id, LocalDate.now(),LocalTime.now()));
		
	}
	
	public Carrito traerCarrito(int idCarrito)throws Exception {
		int i=0;
		Carrito c=null;
		while(i<lstCarrito.size()&& c!= null ) {
			if(lstCarrito.get(i).getIdCarrito()==idCarrito) {
				c=lstCarrito.get(i);
			}
			i++;
			
			
		}
		if (c==null) {
		throw new Exception("el carrito no existen en la db");
		}
		else {
			return c;
		}
		
	}
	
	public boolean eliminarCarrtto(int idCarrito) throws Exception{
	
	boolean flag=false;
	Carrito c=null;
	c=traerCarrito(idCarrito);
	if(c!=null) {
		  flag=lstCarrito.remove(c);
		}
	return flag;
	
}
	public boolean  modificarCarrito(int idCarrito,LocalDate fecha,LocalTime hora) {
		
		
		
		return ;
		
	}
}

