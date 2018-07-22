package ciclo.model.manager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ciclo.model.entities.TblEmpleado;

/**
* Session Bean implementation class ManagerUsuarios
*/
@Stateless
@LocalBean
public class ManagerEmp {
@PersistenceContext(unitName = "cicloDS")
private EntityManager em;
 public ManagerEmp() {

 }

 public boolean comprobarUsuario(String idUsuario,String clave) throws Exception{
 TblEmpleado u=em.find(TblEmpleado.class, idUsuario);
 if(u==null)
 throw new Exception("No existe el usuario "+idUsuario);
 if(u.getPasswordemp().equals(clave))
 return true;
 throw new Exception("Contraseña no válida.");
 }
 
 public String TipoUsuario(String idUsuario) throws Exception{
	 TblEmpleado u=em.find(TblEmpleado.class, idUsuario);
	 if(u==null)
	 throw new Exception("No existe el usuario "+idUsuario);
	 return u.getTipoemp();
	 }
}
