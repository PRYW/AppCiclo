package ciclo.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_cliente database table.
 * 
 */
@Entity
@Table(name="tbl_cliente")
@NamedQuery(name="TblCliente.findAll", query="SELECT t FROM TblCliente t")
public class TblCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cedulacli;

	private String direccioncli;

	private String emailcli;

	private String nombrecli;

	private String telefonocli;

	//bi-directional many-to-one association to TblAquiler
	@OneToMany(mappedBy="tblCliente")
	private List<TblAquiler> tblAquilers;

	public TblCliente() {
	}

	public String getCedulacli() {
		return this.cedulacli;
	}

	public void setCedulacli(String cedulacli) {
		this.cedulacli = cedulacli;
	}

	public String getDireccioncli() {
		return this.direccioncli;
	}

	public void setDireccioncli(String direccioncli) {
		this.direccioncli = direccioncli;
	}

	public String getEmailcli() {
		return this.emailcli;
	}

	public void setEmailcli(String emailcli) {
		this.emailcli = emailcli;
	}

	public String getNombrecli() {
		return this.nombrecli;
	}

	public void setNombrecli(String nombrecli) {
		this.nombrecli = nombrecli;
	}

	public String getTelefonocli() {
		return this.telefonocli;
	}

	public void setTelefonocli(String telefonocli) {
		this.telefonocli = telefonocli;
	}

	public List<TblAquiler> getTblAquilers() {
		return this.tblAquilers;
	}

	public void setTblAquilers(List<TblAquiler> tblAquilers) {
		this.tblAquilers = tblAquilers;
	}

	public TblAquiler addTblAquiler(TblAquiler tblAquiler) {
		getTblAquilers().add(tblAquiler);
		tblAquiler.setTblCliente(this);

		return tblAquiler;
	}

	public TblAquiler removeTblAquiler(TblAquiler tblAquiler) {
		getTblAquilers().remove(tblAquiler);
		tblAquiler.setTblCliente(null);

		return tblAquiler;
	}

}