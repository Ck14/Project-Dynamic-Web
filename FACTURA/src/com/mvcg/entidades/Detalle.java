package com.mvcg.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DETALLE database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Detalle.findAll", query="SELECT d FROM Detalle d"),
	@NamedQuery(name="Detalle.findByFacturaId", query="SELECT d FROM Detalle d WHERE d.factura.idFactura = :idFactura"),
	@NamedQuery(name="Detalle.total", query="SELECT SUM(d.subtotal) FROM Detalle d WHERE d.factura.idFactura = :idFactura")
})
public class Detalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DETALLE_IDDETALLE_GENERATOR", sequenceName="SEQ_DETALLE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DETALLE_IDDETALLE_GENERATOR")
	@Column(name="ID_DETALLE")
	private long idDetalle;

	private BigDecimal cantidad;

	private BigDecimal precio;

	private BigDecimal subtotal;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="ID_FACTURA")
	private Factura factura;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
	private Producto producto;

	public Detalle() {
	}

	public long getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(long idDetalle) {
		this.idDetalle = idDetalle;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}