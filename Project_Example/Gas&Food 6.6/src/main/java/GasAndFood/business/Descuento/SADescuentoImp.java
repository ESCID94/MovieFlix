package GasAndFood.business.Descuento;
import java.io.IOException;
import java.util.List;

import GasAndFood.integracion.Descuento.DAODescuento;
import GasAndFood.integracion.Factorias.FactoriaIntegracion;

public class SADescuentoImp implements SADescuento {
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SADescuento#darDeAlta(GandF.MyGF.integracion.TDescuento)
	 */
		@Override
		public int darDeAlta(TDescuento tDesc)  throws IOException {
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance(); // metodo que devuelve la factoria(punto de acceso) para manehar los daos.
			
			DAODescuento daoDes = fact.getDAODescuento();

			TDescuento tDesAux = daoDes.leerPorId(tDesc.getId());
			 
			if(tDesAux == null){
				tDesc.setActivo(true);
				tDesc.setId(daoDes.siguienteIdAux());
				daoDes.insertar(tDesc);
				return 0;
			}
			else{
				if(tDesAux.getActivo()) return 2;
				else{
					//le pasamos el tipo y el activo.
					daoDes.modificar(tDesAux.getId(),true, tDesAux.getTipo());
					return 1;
				}
			}
		}
		
	/* (sin Javadoc)
	 * @see GandF.MyGF.business.SADescuento#darDeBaja(java.lang.String)
	 */
		@Override
		public int darDeBaja(String id) throws IOException{
			TDescuento tDesAux;
					
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAODescuento daodes = fact.getDAODescuento();				
					tDesAux = daodes.leerPorId(id);
					
					if(null == tDesAux){
						return 0;
					}
					else{
						if(tDesAux.getActivo()){ 
							daodes.modificar(id, false, tDesAux.getTipo());
							daodes.borrarRelacionesDescUsu(id);
							return 1;
							}
						else{
							return 2;
						}
					}
		}
		
		/* (sin Javadoc)
		 * @see GandF.MyGF.business.SADescuento#actualizarDescuento(java.lang.String, GandF.MyGF.integracion.TipoDescuento, boolean)
		 */
		@Override
		public int actualizarDescuento(String id, TipoDescuento Des, boolean act ) throws IOException{
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAODescuento daoDesc = fact.getDAODescuento();
			TDescuento tDescAaux = daoDesc.leerPorId(id);
			 /**SI NO EXISTE NO SE MODIFICA O SI EXISTE EL QUE HAY QUE MODIFICAR NO SE MODIFICA*/
			if(tDescAaux == null){  //si no existe no se modifica
				return 0;
			}
			else{
				/**no modificamos el id del Descuento*/
				//tE.setId(tEAux.getId());
				if (!act) {
					daoDesc.borrarRelacionesDescUsu(id);
				}
				return daoDesc.modificar(id, act, Des); /**modificamos*/
			}
		}
		
		/* (sin Javadoc)
		 * @see GandF.MyGF.business.SADescuento#leerTodo()
		 */
		@Override
		public List<TDescuento> leerTodo() throws IOException{
			
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAODescuento daoDesc = fact.getDAODescuento();
			return daoDesc.readAll();
		}
		
		/* (sin Javadoc)
		 * @see GandF.MyGF.business.SADescuento#leerID(GandF.MyGF.integracion.TDescuento)
		 */

		@Override
		public TDescuento leerID(String idDe) throws IOException {
			// TODO Auto-generated method stub
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAODescuento daoDesc = fact.getDAODescuento();
			return daoDesc.leerPorId(idDe);
		}		
}
