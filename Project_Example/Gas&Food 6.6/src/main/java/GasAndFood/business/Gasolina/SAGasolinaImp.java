package GasAndFood.business.Gasolina;

import java.io.IOException;
import java.util.List;

import GasAndFood.integracion.Establecimiento.DAOEstablecimiento;
import GasAndFood.integracion.Factorias.FactoriaIntegracion;
import GasAndFood.integracion.Gasolina.DAOGasolina;

public class SAGasolinaImp implements SAGasolina {
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAGasolina#darDeAlta(GandF.MyGF.integracion.TGasolina)
	 */
		@Override
		public int darDeAlta(TGasolina tGas) throws IOException{
			
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOGasolina daoG = fact.getDAOGasolina();

			TGasolina tGAux = daoG.leerPorNombre(tGas.getNombre());
			 
			if(tGAux == null){
				tGas.setActivo(true);
				tGas.setId(daoG.siguienteIdAux());
				daoG.insertar(tGas);
				return 0;
			}
			else{
				if(tGAux.getActivo()) return 2;
				else{
					//le pasamos el tipo y el activo.
					daoG.modificar(tGAux.getId(), true,tGas.getId() ,tGas.getTipo());
					return 1;
				}
			}
			
		}
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAGasolina#actualizarGasolina(java.lang.String, GandF.MyGF.integracion.TipoGasolina, boolean)
	 */
		@Override
		public int actualizarGasolina(String id, TipoGasolina ga, String gasolinaEst, boolean act) throws IOException{
			/**0: no modificado 1: modificado*/
			/**CREAMOS EL DAO*/
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOGasolina daoG = fact.getDAOGasolina();
			DAOEstablecimiento daoE = fact.getDAOEstablecimiento();
			/**BUSCAMOS EN EL ARCHIVO EL NOMBRE Y LA DIRECCION DEL ESTABLECIMIENTO*/
			//TEstablecimiento tEAux = daoe.leer(nombre, dir);
			/**BUSCAMOS EN EL ARCHIVO EL NOMBRE Y LA DIR DEL ESTABLECIMIENTO A MODIFICAR*/
			TGasolina tGaux = daoG.leerPorId(id);
			 /**SI NO EXISTE NO SE MODIFICA O SI EXISTE EL QUE HAY QUE MODIFICAR NO SE MODIFICA*/
			if(tGaux == null){  //si no existe no se modifica
				return 0;
			}
			else{
				/**no modificamos el id del establecimiento*/
				//tE.setId(tEAux.getId());
				if(!act) daoE.borrarRelacionesProducto(id,  "gasolina");
				return daoG.modificar(id,act,gasolinaEst,ga); /**modificamos*/
				}
			}
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SAGasolina#darDeBaja(java.lang.String)
	 */
		@Override
		public int darDeBaja(String id) throws IOException{
			
					
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOGasolina daoG = fact.getDAOGasolina();	
			DAOEstablecimiento daoE = fact.getDAOEstablecimiento();		
			TGasolina tGaux = daoG.leerPorId(id);
					
				if(null == tGaux){
					return 0;
				}
				else{
					if(tGaux.getActivo()){ 
						daoG.modificar(id, false, tGaux.getNombre(), tGaux.getTipo());
						daoE.borrarRelacionesProducto(id, "gasolina");
						return 1;
						}
					else{
						return 2;
					}
				}
		}
		
		/* (sin Javadoc)
		 * @see GandF.MyGF.business.SAGasolina#leerTodo()
		 */
		@Override
		public List<TGasolina> leerTodo() throws IOException{
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOGasolina daoG = fact.getDAOGasolina();		
			return daoG.readAll();
		}
		
		
		
		/* (sin Javadoc)
		 * @see GandF.MyGF.business.SAGasolina#leerID(GandF.MyGF.integracion.TGasolina)
		 */
		@Override
		public TGasolina leerID(String id) throws IOException{
			
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOGasolina daoG = fact.getDAOGasolina();
			TGasolina tGaux  = daoG.leerPorId(id);
			if (tGaux == null) return null;
			else return tGaux;
		}
		
		/* (sin Javadoc)
		 * @see GandF.MyGF.business.SAGasolina#leerNombre(java.lang.String)
		 */
		@Override
		public TGasolina leerNombre(String nombre) throws IOException{
			
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOGasolina daoG = fact.getDAOGasolina();
			return daoG.leerPorNombre(nombre);
		}
		
		/* (sin Javadoc)
		 * @see GandF.MyGF.business.SAGasolina#leerPorEstablecimiento(java.lang.String)
		 */
		@Override
		public List<TRGasolina> leerPorEstablecimiento(String id) throws IOException{
			
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOGasolina daoG = fact.getDAOGasolina();
			return daoG.leerPorEstablecimiento(id);
		}
}
