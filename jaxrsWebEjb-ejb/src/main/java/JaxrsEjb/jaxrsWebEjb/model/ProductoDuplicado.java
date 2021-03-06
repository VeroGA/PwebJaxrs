package JaxrsEjb.jaxrsWebEjb.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "producto_duplicado")
public class ProductoDuplicado implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
	private Long id;

	@NotNull
	@ManyToOne
	private Producto producto;
	
	@NotNull
	private int cantidad;
	
	public ProductoDuplicado() {
		this.producto = null;
		this.cantidad = 0;
	}

	public ProductoDuplicado(JaxrsEjb.jaxrsWebEjb.mybatis.bean.Producto producto, int cantidad, Proveedor proveedor) {
		this.producto = new Producto (producto, proveedor);
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
