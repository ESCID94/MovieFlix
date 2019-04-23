package GasAndFood.business.Alimento;

import java.io.IOException;
import java.util.List;

import GasAndFood.integracion.Alimento.DAOAlimento;
import GasAndFood.integracion.Establecimiento.DAOEstablecimiento;
import GasAndFood.integracion.Factorias.FactoriaIntegracion;

public class SAAlimentoImp implements SAAlimento {
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAAlimento#darDeAlta(GandF.MyGF.integracion.TAlimento)
	 */
		@Override
		public int darDeAlta(TAlimento tAlim) throws IOException{
			
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOAlimento daoA = fact.getDAOAlimento();

			TAlimento tAAux = daoA.leerPorNombre(tAlim.getNombre());
			 
			if(tAAux == null){
				tAlim.setActivo(true);
				tAlim.setId(daoA.siguienteIdAux());
				daoA.insertar(tAlim);
				return 0;
			}
			else{
				if(tAAux.getActivo()) return 2;
				else{
					//le pasamos el tipo y el activo.
					daoA.modificar(tAAux.getId(), true, tAlim.getTipo());
					return 1;
				}
			}
			
		}
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAAlimento#actualizarAlimento(java.lang.String, GandF.MyGF.integracion.TipoAlimento, boolean)
	 */
		@Override
		public int actualizarAlimento(String id, TipoAlimento ta, boolean act) throws IOException{
			/**0: no modificado 1: modificado*/
			/**CREAMOS EL DAO*/
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOAlimento daoA = fact.getDAOAlimento();
			DAOEstablecimiento daoE = fact.getDAOEstablecimiento();
			/**BUSCAMOS EN EL ARCHIVO EL NOMBRE Y LA DIRECCION DEL ESTABLECIMIENTO*/
			//TEstablecimiento tEAux = daoe.leer(nombre, dir);
			/**BUSCAMOS EN EL ARCHIVO EL NOMBRE Y LA DIR DEL ESTABLECIMIENTO A MODIFICAR*/
			TAlimento tAaux = daoA.leerPorId(id);
			 /**SI NO EXISTE NO SE MODIFICA O SI EXISTE EL QUE HAY QUE MODIFICAR NO SE MODIFICA*/
			if(tAaux == null){  //si no existe no se modifica
				return 0;
			}
			else{
				/**no modificamos el id del establecimiento*/
				//tE.setId(tEAux.getId());
				if(!act) daoE.borrarRelacionesProducto(id, "alimento");
				return daoA.modificar(id, act, ta); /**modificamos*/
			}
		}
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAAlimento#darDeBaja(java.lang.String)
	 */
		@Override
		public int darDeBaja(String id) throws IOException{
				
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOAlimento daoA = fact.getDAOAlimento();	
			DAOEstablecimiento daoE = fact.getDAOEstablecimiento();
			TAlimento tAaux = daoA.leerPorId(id);
					
				if(null == tAaux){
					return 0;
				}
				else{
					if(tAaux.getActivo()){ 
						daoA.modificar(id, false, tAaux.getTipo());
						daoE.borrarRelacionesProducto(id, "alimento");
						return 1;
						}
					else{
						return 2;
					}
				}
		}
		
		/* (sin Javadoc)
		 * @see GandF.MyGF.business.SAAlimento#leerTodo()
		 */
		@Override
		public List<TAlimento> leerTodo() throws IOException{
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOAlimento daoA = fact.getDAOAlimento();		
			return daoA.readAll();
		}
		
		
		
		/* (sin Javadoc)
		 * @see GandF.MyGF.business.SAAlimento#leerID(GandF.MyGF.integracion.TAlimento)
		 */
		@Override
		public TAlimento leerID(String id) throws IOException{
			
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOAlimento daoA = fact.getDAOAlimento();
			return daoA.leerPorId(id);
			
		}
		/* (sin Javadoc)
		 * @see GandF.MyGF.business.SAAlimento#leerNombre(java.lang.String)
		 */
		@Override
		public TAlimento leerNombre(String nombre) throws IOException{
			
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOAlimento daoA = fact.getDAOAlimento();
			return daoA.leerPorNombre(nombre);
		}
		
		/* (sin Javadoc)
		 * @see GandF.MyGF.business.SAAlimento#leerPorEstablecimiento(java.lang.String)
		 */
		@Override
		public List<TRAlimento> leerPorEstablecimiento(String id) throws IOException{
			
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOAlimento daoA = fact.getDAOAlimento();
			return daoA.leerPorEstablecimiento(id);
		}
}
