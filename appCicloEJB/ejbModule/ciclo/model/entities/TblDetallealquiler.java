package ciclo.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the tbl_detallealquiler database table.
 * 
 */
@Entity
@Table(name="tbl_detallealquiler")
@NamedQuery(name="TblDetallealquiler.findAll", query="SELECT t FROM TblDetallealquiler t")
public class TblDetallealquiler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddeta;

	private int catidadpersdeta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date horaregresodeta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date horasalidadeta;

	private BigDecimal subtotaldeta;

	//bi-directional many-to-one association to TblAquiler
	@ManyToOne
	@JoinColumn(name="IDALQ")
	private TblAquiler tblAquiler;

	//bi-directional many-to-one association to TblCoch
	@ManyToOne
	@JoinColumn(name="IDCO")
	private TblCoch tblCoch;

	public TblDetallealquiler() {
	}

	public int getIddeta() {
		return this.iddeta;
	}

	public void setIddeta(int iddeta) {
		this.iddeta = iddeta;
	}

	public int getCatidadpersdeta() {
		return this.catidadpersdeta;
	}

	public void setCatidadpersdeta(int catidadpersdeta) {
		this.catidadpersdeta = catidadpersdeta;
	}

	public Date getHoraregresodeta() {
		return this.horaregresodeta;
	}

	public void setHoraregresodeta(Date horaregresodeta) {
		this.horaregresodeta = horaregresodeta;
	}

	public Date getHorasalidadeta() {
		return this.horasalidadeta;
	}

	public void setHorasalidadeta(Date horasalidadeta) {
		this.horasalidadeta = horasalidadeta;
	}

	public BigDecimal getSubtotaldeta() {
		return this.subtotaldeta;
	}

	public void setSubtotaldeta(BigDecimal subtotaldeta) {
		this.subtotaldeta = subtotaldeta;
	}

	public TblAquiler getTblAquiler() {
		return this.tblAquiler;
	}

	public void setTblAquiler(TblAquiler tblAquiler) {
		this.tblAquiler = tblAquiler;
	}

	public TblCoch getTblCoch() {
		return this.tblCoch;
	}

	public void setTblCoch(TblCoch tblCoch) {
		this.tblCoch = tblCoch;
	}

}