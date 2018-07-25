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
		System.out.println("Entramos del metodo comprobar");
	boolean respuesta=managerUsuarios.comprobarUsuario(idUsuario, clave);
	System.out.println("salimos del metodo comprobar");
	JSFUtil.crearMensajeInfo("Login correcto");
	System.out.println("entramos a tipo");
	String TipoUser=managerUsuarios.TipoUsuario(idUsuario);
	System.out.println("Tipo es "+TipoUser);
	if(TipoUser.equals("ADMINISTRADOR")){
	return "admin/index";
	}else {
		if(TipoUser.equals("EMPLEADO")){
			return "emp/index";
			}else {
				return "";
			}	
	}
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
