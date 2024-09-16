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






	public Supermercado() {
		super();
		this.gondola = new ArrayList<>();
		this.lstCarrito = new ArrayList<>();
		this.lstCliente = new ArrayList<>();
	}



	public boolean agregaarProducto(String producto, float precio) throws Exception {

		int id = 0;
		Producto p = null;
		boolean flag=false ;

		for (int i = 0; i < gondola.size(); i++) {
			if (gondola.get(i).getProducto().equals(producto)) {
				throw new Exception("el producto ya existe");
			}
		}
		id = 1;

		if (gondola.size() >1) {
			id = gondola.get(gondola.size() - 1).getIdProducto() + 1;

		}
		p = new Producto(id, producto, precio);
		System.out.println(gondola.add(p));

		flag=true ;


		return flag;

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
		if (p == null) {
			throw new Exception("el producto a modificar ya no existe en la db");
		}
		flag = true;
		p.setPrecio((float) precio);
		p.setProducto(producto);

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

		return lstCarrito.add(new Carrito(id, LocalDate.now(),LocalTime.now(), null));

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

	public boolean eliminarCarritto(int idCarrito) throws Exception{

		boolean flag=false;
		Carrito c=null;
		c=traerCarrito(idCarrito);
		if(c!=null) {
			flag=lstCarrito.remove(c);
		}
		return flag;

	}

	public boolean agregarCliente(Cliente c) {
		int i=0;
		boolean flag =false;
		if (c==null) {
			flag=false;
		}
		while (i<lstCliente.size()&& flag!=true ) {
			if(lstCliente.get(i).equals(c.getIdCliente(), c.getCliente(), c.getDni(),c.getDireccion())){
				flag=true;

			}
			i++;
		}

		if(flag==true) {
			lstCliente.add(c);
			flag=true;
		}

		return flag;
	}

	public Cliente traerCliente(int idCliente )throws Exception {
		Cliente c1=null;
		int i=0;
		boolean flag=false;
		while (i<lstCliente.size() && flag==true ) {
			if(lstCliente.get(i).getIdCliente()==idCliente) {
				c1=lstCliente.get(i);
				flag=true;
			}
			i++;
		}

		if(flag=false) {
			throw new Exception("no existe el cliente");
		}

		return c1;
	}

	public boolean modificarCliente(int idCliente, String Cliente , long dni , String direccion)throws Exception {
		Cliente c=null;
		boolean flag=false;
		c=traerCliente(idCliente);
		if(c==null) {
			throw new Exception("no existe el cliente que quiere modificar en la db");
		}
		flag=true;
		c.setCliente(Cliente);
		c.setDni(dni);
		c.setIdCliente(idCliente);
		c.setDireccion(direccion);
		return flag ; 

	}
	public boolean elliminarCliente(Cliente c) throws Exception {
		boolean flag=false;
		Cliente aux=null;
		aux=traerCliente(c.getIdCliente());
		if(aux==null) {
			throw new Exception("no existe el cliente que quiere meliminar en la db");
		}
		else {
			flag=true;
			lstCliente.remove(aux);
		}
		return flag;
		
		
	}

}


