package ciclo.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_aquiler database table.
 * 
 */
@Entity
@Table(name="tbl_aquiler")
@NamedQuery(name="TblAquiler.findAll", query="SELECT t FROM TblAquiler t")
public class TblAquiler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idalq;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaalq;

	private BigDecimal valortotal;

	//bi-directional many-to-one association to TblCliente
	@ManyToOne
	@JoinColumn(name="CEDULACLI")
	private TblCliente tblCliente;

	//bi-directional many-to-one association to TblEmpleado
	@ManyToOne
	@JoinColumn(name="CEDULAEMP")
	private TblEmpleado tblEmpleado;

	//bi-directional many-to-one association to TblDetallealquiler
	@OneToMany(mappedBy="tblAquiler")
	private List<TblDetallealquiler> tblDetallealquilers;

	public TblAquiler() {
	}

	public int getIdalq() {
		return this.idalq;
	}

	public void setIdalq(int idalq) {
		this.idalq = idalq;
	}

	public Date getFechaalq() {
		return this.fechaalq;
	}

	public void setFechaalq(Date fechaalq) {
		this.fechaalq = fechaalq;
	}

	public BigDecimal getValortotal() {
		return this.valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public TblCliente getTblCliente() {
		return this.tblCliente;
	}

	public void setTblCliente(TblCliente tblCliente) {
		this.tblCliente = tblCliente;
	}

	public TblEmpleado getTblEmpleado() {
		return this.tblEmpleado;
	}

	public void setTblEmpleado(TblEmpleado tblEmpleado) {
		this.tblEmpleado = tblEmpleado;
	}

	public List<TblDetallealquiler> getTblDetallealquilers() {
		return this.tblDetallealquilers;
	}

	public void setTblDetallealquilers(List<TblDetallealquiler> tblDetallealquilers) {
		this.tblDetallealquilers = tblDetallealquilers;
	}

	public TblDetallealquiler addTblDetallealquiler(TblDetallealquiler tblDetallealquiler) {
		getTblDetallealquilers().add(tblDetallealquiler);
		tblDetallealquiler.setTblAquiler(this);

		return tblDetallealquiler;
	}

	public TblDetallealquiler removeTblDetallealquiler(TblDetallealquiler tblDetallealquiler) {
		getTblDetallealquilers().remove(tblDetallealquiler);
		tblDetallealquiler.setTblAquiler(null);

		return tblDetallealquiler;
	}

}