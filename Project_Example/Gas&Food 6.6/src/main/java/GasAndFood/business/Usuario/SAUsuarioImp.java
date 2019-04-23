package GasAndFood.business.Usuario;

import GasAndFood.business.Descuento.SADescuento;
import GasAndFood.business.Descuento.TDescuento;
import GasAndFood.business.Descuento.TRDescuentoEstablecimiento;
import GasAndFood.business.Establecimiento.SAEstablecimiento;
import GasAndFood.business.Establecimiento.TEstablecimiento;
import GasAndFood.business.Factorias.FactoriaBussines;
import GasAndFood.integracion.Factorias.FactoriaIntegracion;
import GasAndFood.integracion.Usuario.DAOUsuario;

import java.io.IOException;
import java.util.List;


public class SAUsuarioImp implements SAUsuario {

	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAUsuario#darDeAlta(GandF.MyGF.integracion.TUsuario)
	 */
	@Override
	public int darDeAlta (TUsuario tU) throws IOException {
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOUsuario daoe = fact.getDAOUsuario();
		TUsuario tUAux = daoe.leerPorNombre(tU.getNombre());
		if (tUAux == null) {
			tU.setActivo(true);
			tU.setId(daoe.siguienteIdAux());
			daoe.insertar(tU);
			return 0;
		}
		else {
			if (tUAux.getActivo()) return 2;
			else {
				daoe.modificar(tUAux.getId(), tU.getContrasena(), tU.getEmail(), true);
				return 1;
			}
		}
	}

	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAUsuario#actualizarUsuario(java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public int actualizarUsuario (String id,String contrasena,String mail, boolean act) throws IOException {
		/**0: no modificado 1: modificado*/
		/**CREAMOS EL DAO*/
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOUsuario daoe = fact.getDAOUsuario();
		/**BUSCAMOS EN EL ARCHIVO EL NOMBRE Y LA DIR DEL USUARIO A MODIFICAR*/
		TUsuario tUAux = daoe.leerPorId(id);
		if (tUAux == null) return 0;
		else{
			if(!act) daoe.borrarRelaciones(id);
			return daoe.modificar(id, contrasena, mail, act);
		}
	}

	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAUsuario#darDeBaja(java.lang.String)
	 */
	@Override
	public int darDeBaja (String id) throws IOException {
		TUsuario tUAux;
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();

		DAOUsuario daoe = fact.getDAOUsuario();
		tUAux = daoe.leerPorId(id);
		if (null == tUAux) return 0;
		else {
			if (tUAux.getActivo()) {
				daoe.modificar(id, tUAux.getContrasena(), tUAux.getEmail(), false);
				daoe.borrarRelaciones(id);
				return 1;
			}
			else return 2;
		}
	}

	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAUsuario#leerTodo()
	 */
	@Override
	public List<TUsuario> leerTodo () throws IOException {
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOUsuario daoe = fact.getDAOUsuario();
		return daoe.readAll();
	}
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAUsuario#leerID(GandF.MyGF.integracion.TUsuario)
	 */
	@Override
	public TUsuario leerID (String id) throws IOException {
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOUsuario daoe = fact.getDAOUsuario();
		return daoe.leerPorId(id);
	}
	
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAUsuario#leerNombre(java.lang.String)
	 */
	@Override
	public TUsuario leerNombre(String nombre) throws IOException{
		
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOUsuario daoG = fact.getDAOUsuario();
		return daoG.leerPorNombre(nombre);
	}
	
	@Override
	public int añadirRelacion(String id_usuario, String id_descuento, String id_establecimiento)
			throws IOException {
		FactoriaBussines factSA = FactoriaBussines.getInstance();
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		
		
		DAOUsuario daoU = fact.getDAOUsuario();
		SADescuento saD = factSA.getSADescuento();
		SAEstablecimiento saE = factSA.getSAEstablecimiento();
		
		TUsuario tU = daoU.leerPorId(id_usuario);
		TDescuento tD = saD.leerID(id_descuento);
		TEstablecimiento tE = saE.leerID(id_establecimiento);
		
		
		if (tU != null && tE != null && tD != null && tU.getActivo() && tD.getActivo() && tE.getActivo())
			return daoU.añadirRelacion(id_usuario, id_descuento, id_establecimiento);
		return 0;
	}

	@Override
	public int borrarRelaciones(String id_usuario, String id_descuento, String id_establecimiento)
			throws NumberFormatException, IOException {
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOUsuario daoU = fact.getDAOUsuario();
		return daoU.borrarRelaciones(id_usuario, id_descuento, id_establecimiento);
	}

	@Override
	public List<TRDescuentoEstablecimiento> leerPorUsuario(String id_usuario)
			throws IOException {
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOUsuario daoU = fact.getDAOUsuario();
		
		return daoU.leerPorUsuario(id_usuario);
	}

	

}
