package ciclo.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_coches database table.
 * 
 */
@Entity
@Table(name="tbl_coches")
@NamedQuery(name="TblCoch.findAll", query="SELECT t FROM TblCoch t")
public class TblCoch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idco;

	@Lob
	private String descripcionco;

	private String estadoco;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaadquisicionco;

	private String tipoco;

	//bi-directional many-to-one association to TblDetallealquiler
	@OneToMany(mappedBy="tblCoch")
	private List<TblDetallealquiler> tblDetallealquilers;

	//bi-directional many-to-one association to TblMantenimiento
	@OneToMany(mappedBy="tblCoch")
	private List<TblMantenimiento> tblMantenimientos;

	public TblCoch() {
	}

	public String getIdco() {
		return this.idco;
	}

	public void setIdco(String idco) {
		this.idco = idco;
	}

	public String getDescripcionco() {
		return this.descripcionco;
	}

	public void setDescripcionco(String descripcionco) {
		this.descripcionco = descripcionco;
	}

	public String getEstadoco() {
		return this.estadoco;
	}

	public void setEstadoco(String estadoco) {
		this.estadoco = estadoco;
	}

	public Date getFechaadquisicionco() {
		return this.fechaadquisicionco;
	}

	public void setFechaadquisicionco(Date fechaadquisicionco) {
		this.fechaadquisicionco = fechaadquisicionco;
	}

	public String getTipoco() {
		return this.tipoco;
	}

	public void setTipoco(String tipoco) {
		this.tipoco = tipoco;
	}

	public List<TblDetallealquiler> getTblDetallealquilers() {
		return this.tblDetallealquilers;
	}

	public void setTblDetallealquilers(List<TblDetallealquiler> tblDetallealquilers) {
		this.tblDetallealquilers = tblDetallealquilers;
	}

	public TblDetallealquiler addTblDetallealquiler(TblDetallealquiler tblDetallealquiler) {
		getTblDetallealquilers().add(tblDetallealquiler);
		tblDetallealquiler.setTblCoch(this);

		return tblDetallealquiler;
	}

	public TblDetallealquiler removeTblDetallealquiler(TblDetallealquiler tblDetallealquiler) {
		getTblDetallealquilers().remove(tblDetallealquiler);
		tblDetallealquiler.setTblCoch(null);

		return tblDetallealquiler;
	}

	public List<TblMantenimiento> getTblMantenimientos() {
		return this.tblMantenimientos;
	}

	public void setTblMantenimientos(List<TblMantenimiento> tblMantenimientos) {
		this.tblMantenimientos = tblMantenimientos;
	}

	public TblMantenimiento addTblMantenimiento(TblMantenimiento tblMantenimiento) {
		getTblMantenimientos().add(tblMantenimiento);
		tblMantenimiento.setTblCoch(this);

		return tblMantenimiento;
	}

	public TblMantenimiento removeTblMantenimiento(TblMantenimiento tblMantenimiento) {
		getTblMantenimientos().remove(tblMantenimiento);
		tblMantenimiento.setTblCoch(null);

		return tblMantenimiento;
	}

}