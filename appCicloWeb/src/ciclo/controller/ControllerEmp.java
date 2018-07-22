package ciclo.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ciclo.model.manager.ManagerEmp;
import ciclo.view.util.JSFUtil;

@ManagedBean
@SessionScoped
public class ControllerEmp {
	private String idUsuario;
	private String clave;
	@EJB
	private ManagerEmp managerUsuarios;
	public String actionLogin(){
	try {
	boolean respuesta=managerUsuarios.comprobarUsuario(idUsuario, clave);
	JSFUtil.crearMensajeInfo("Login correcto");
	//verificamos si el acceso es con admin:
	if(managerUsuarios.TipoUsuario(idUsuario).equals("ADMINISTRADOR")){
	return "admin/index";
	}
	return "emp/index";
	} catch (Exception e) {
	JSFUtil.crearMensajeError(e.getMessage());
	e.printStackTrace();
	}
	return "";
	}
	public String getIdUsuario() {
	return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
	this.idUsuario = idUsuario;
	}
	public String getClave() {
	return clave;
	}
	public void setClave(String clave) {
	this.clave = clave;
	}
}
