package model;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	private List<Producto> gondola;

	public List<Producto> getGondola() {
		return gondola;
	}

	public void setGondola(List<Producto> gondola) {
		this.gondola = gondola;
	}

	public Supermercado() {
		super();
		gondola = new ArrayList<Producto>();
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

	@Override
	public String toString() {
		return "Supermercado [gondola=" + gondola + ", getGondola()=" + getGondola() + ", getClass()=" + getClass()
		+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
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
}
