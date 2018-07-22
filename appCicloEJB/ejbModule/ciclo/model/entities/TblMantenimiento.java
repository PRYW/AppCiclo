package ciclo.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_mantenimiento database table.
 * 
 */
@Entity
@Table(name="tbl_mantenimiento")
@NamedQuery(name="TblMantenimiento.findAll", query="SELECT t FROM TblMantenimiento t")
public class TblMantenimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idman;

	@Lob
	private String descripcionman;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaingresoman;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechasalidaman;

	//bi-directional many-to-one association to TblCoch
	@ManyToOne
	@JoinColumn(name="IDCO")
	private TblCoch tblCoch;

	public TblMantenimiento() {
	}

	public int getIdman() {
		return this.idman;
	}

	public void setIdman(int idman) {
		this.idman = idman;
	}

	public String getDescripcionman() {
		return this.descripcionman;
	}

	public void setDescripcionman(String descripcionman) {
		this.descripcionman = descripcionman;
	}

	public Date getFechaingresoman() {
		return this.fechaingresoman;
	}

	public void setFechaingresoman(Date fechaingresoman) {
		this.fechaingresoman = fechaingresoman;
	}

	public Date getFechasalidaman() {
		return this.fechasalidaman;
	}

	public void setFechasalidaman(Date fechasalidaman) {
		this.fechasalidaman = fechasalidaman;
	}

	public TblCoch getTblCoch() {
		return this.tblCoch;
	}

	public void setTblCoch(TblCoch tblCoch) {
		this.tblCoch = tblCoch;
	}

}