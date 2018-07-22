package ciclo.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_empleado database table.
 * 
 */
@Entity
@Table(name="tbl_empleado")
@NamedQuery(name="TblEmpleado.findAll", query="SELECT t FROM TblEmpleado t")
public class TblEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cedulaemp;

	private int emailemp;

	private String nombreemp;

	private String passwordemp;

	private String telefonoemp;

	private String tipoemp;

	//bi-directional many-to-one association to TblAquiler
	@OneToMany(mappedBy="tblEmpleado")
	private List<TblAquiler> tblAquilers;

	public TblEmpleado() {
	}

	public String getCedulaemp() {
		return this.cedulaemp;
	}

	public void setCedulaemp(String cedulaemp) {
		this.cedulaemp = cedulaemp;
	}

	public int getEmailemp() {
		return this.emailemp;
	}

	public void setEmailemp(int emailemp) {
		this.emailemp = emailemp;
	}

	public String getNombreemp() {
		return this.nombreemp;
	}

	public void setNombreemp(String nombreemp) {
		this.nombreemp = nombreemp;
	}

	public String getPasswordemp() {
		return this.passwordemp;
	}

	public void setPasswordemp(String passwordemp) {
		this.passwordemp = passwordemp;
	}

	public String getTelefonoemp() {
		return this.telefonoemp;
	}

	public void setTelefonoemp(String telefonoemp) {
		this.telefonoemp = telefonoemp;
	}

	public String getTipoemp() {
		return this.tipoemp;
	}

	public void setTipoemp(String tipoemp) {
		this.tipoemp = tipoemp;
	}

	public List<TblAquiler> getTblAquilers() {
		return this.tblAquilers;
	}

	public void setTblAquilers(List<TblAquiler> tblAquilers) {
		this.tblAquilers = tblAquilers;
	}

	public TblAquiler addTblAquiler(TblAquiler tblAquiler) {
		getTblAquilers().add(tblAquiler);
		tblAquiler.setTblEmpleado(this);

		return tblAquiler;
	}

	public TblAquiler removeTblAquiler(TblAquiler tblAquiler) {
		getTblAquilers().remove(tblAquiler);
		tblAquiler.setTblEmpleado(null);

		return tblAquiler;
	}

}