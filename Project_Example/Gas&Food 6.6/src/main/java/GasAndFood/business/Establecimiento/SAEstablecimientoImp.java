package GasAndFood.business.Establecimiento;

import java.io.IOException;
import java.util.List;

import GasAndFood.business.Alimento.SAAlimento;
import GasAndFood.business.Alimento.TAlimento;
import GasAndFood.business.Factorias.FactoriaBussines;
import GasAndFood.business.Gasolina.SAGasolina;
import GasAndFood.business.Gasolina.TGasolina;
import GasAndFood.integracion.Establecimiento.DAOEstablecimiento;
import GasAndFood.integracion.Factorias.FactoriaIntegracion;

public class SAEstablecimientoImp implements SAEstablecimiento {
	
/* (sin Javadoc)
 * @see GandF.MyGF.business.SAEstablecimiento#darDeAlta(GandF.MyGF.integracion.TEstablecimiento)
 */
	@Override
	public int darDeAlta(TEstablecimiento tE) throws IOException{
		
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoe = fact.getDAOEstablecimiento();

		TEstablecimiento tEAux = daoe.leerPorNombre(tE.getNombre(), tE.getDireccion());
		 
		if(tEAux == null){
			tE.setActivo(true);
			tE.setId(daoe.siguienteIdAux());

			daoe.insertar(tE);
			return 0;
		}
		else{
			if(tEAux.getActivo()) return 2;
			else{
				//le pasamos el tipo y el activo.
				daoe.modificar(tEAux.getId(), true, tE.getTipo());
				return 1;
			}
		}
		
	}
/* (sin Javadoc)
 * @see GandF.MyGF.business.SAEstablecimiento#actualizarEstablecimiento(java.lang.String, GandF.MyGF.integracion.TipoEstablecimiento, boolean)
 */
	@Override
	public int actualizarEstablecimiento(String id, TipoEstablecimiento te, boolean act) throws IOException{
		/**0: no modificado 1: modificado*/
		/**CREAMOS EL DAO*/
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoe = fact.getDAOEstablecimiento();
		/**BUSCAMOS EN EL ARCHIVO EL NOMBRE Y LA DIRECCION DEL ESTABLECIMIENTO*/
		//TEstablecimiento tEAux = daoe.leer(nombre, dir);
		/**BUSCAMOS EN EL ARCHIVO EL NOMBRE Y LA DIR DEL ESTABLECIMIENTO A MODIFICAR*/
		TEstablecimiento tEAux = daoe.leerPorId(id);
		 /**SI NO EXISTE NO SE MODIFICA O SI EXISTE EL QUE HAY QUE MODIFICAR NO SE MODIFICA*/
		if(tEAux == null){  //si no existe no se modifica
			return 0;
		}
		else{
			/**no modificamos el id del establecimiento*/
			//tE.setId(tEAux.getId());

			if (!act){ 
				daoe.borrarRelacionesEstablecimientos(id);
				daoe.borrarRelacionesDescUsu(id);
			}
			return daoe.modificar(id, act, te); /**modificamos*/
			}
		}
/* (sin Javadoc)
 * @see GandF.MyGF.business.SAEstablecimiento#darDeBaja(java.lang.String)
 */
	@Override
	public int darDeBaja(String id) throws IOException{
		TEstablecimiento tEAux;
				
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoe = fact.getDAOEstablecimiento();				
				tEAux = daoe.leerPorId(id);
				
				if(null == tEAux){
					return 0;
				}
				else{
					if(tEAux.getActivo()){ 
						daoe.modificar(id, false, tEAux.getTipo());
						daoe.borrarRelacionesEstablecimientos(id);
						daoe.borrarRelacionesDescUsu(id);
						return 1;
						}
					else{
						return 2;
					}
				}
			}
	
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAEstablecimiento#leerTodo()
	 */
	@Override
	public List<TEstablecimiento> leerTodo() throws IOException{
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoe = fact.getDAOEstablecimiento();		
		return daoe.readAll();
	}
	
	
	
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAEstablecimiento#leerID(GandF.MyGF.integracion.TEstablecimiento)
	 */
	@Override
	public TEstablecimiento leerID(String id) throws IOException{
		TEstablecimiento tEAux;
		
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoe = fact.getDAOEstablecimiento();
		tEAux = daoe.leerPorId(id);
		if (tEAux == null) return null;
		else return tEAux;
	}
	
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAEstablecimiento#leerNombre(java.lang.String, java.lang.String)
	 */
	@Override
	public TEstablecimiento leerNombre(String nombre, String direccion) throws IOException{
		
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoA = fact.getDAOEstablecimiento();
		return daoA.leerPorNombre(nombre, direccion);
	}
	
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAEstablecimiento#leerPorProducto(java.lang.String)
	 */
	@Override
	public List<TREstablecimiento> leerPorAlimento(String id) throws IOException{
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoA = fact.getDAOEstablecimiento();
		return daoA.leerPorProducto(id, "alimento");
	}
	
	@Override
	public List<TREstablecimiento> leerPorGasolina(String id) throws IOException{
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoA = fact.getDAOEstablecimiento();
		return daoA.leerPorProducto(id, "gasolina");
	}
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAEstablecimiento#borrarRelaciones(java.lang.String, java.lang.String)
	 */
	@Override
	public int borrarRelacionesAlimentos(String id1, String id2) throws NumberFormatException, IOException{
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoA = fact.getDAOEstablecimiento();
		return daoA.borrarRelacionesProducto(id1, id2, "alimento");
	}
	
	public int borrarRelacionesGasolinas(String id1, String id2) throws NumberFormatException, IOException{
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoA = fact.getDAOEstablecimiento();
		return daoA.borrarRelacionesProducto(id1, id2, "gasolina");
	}
	
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAEstablecimiento#añadirRelacion(java.lang.String, java.lang.String, float, int)
	 */
	@Override
	public int añadirRelacionAlimento(String id1, String id2, float precio, int descuento) throws IOException{
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoA = fact.getDAOEstablecimiento();
		
		FactoriaBussines factSA = FactoriaBussines.getInstance();
		SAAlimento SAA = factSA.getSAAlimento();
		TAlimento ali = SAA.leerID(id2);
		TEstablecimiento est = daoA.leerPorId(id1);
		
		if(ali != null && est != null && ali.getActivo() && est.getActivo()) return daoA.añadirRelacion(id1, id2, precio, descuento, "alimento");
		else return 0;
	}
	
	@Override
	public int añadirRelacionGasolina(String id1, String id2, float precio, int descuento) throws IOException{
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoA = fact.getDAOEstablecimiento();
		
		FactoriaBussines factSA = FactoriaBussines.getInstance();
		SAGasolina SAG = factSA.getSAGasolina();
		TGasolina gas = SAG.leerID(id2);
		TEstablecimiento est = daoA.leerPorId(id1);
		
		if(gas != null && est != null && gas.getActivo() && est.getActivo()) return daoA.añadirRelacion(id1, id2, precio, descuento, "gasolina");
		else return 0;
	}
}
