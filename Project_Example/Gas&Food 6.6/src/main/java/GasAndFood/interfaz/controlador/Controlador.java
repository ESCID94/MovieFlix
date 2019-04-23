package GasAndFood.interfaz.controlador;

import GasAndFood.business.Alimento.SAAlimento;
import GasAndFood.business.Alimento.TAlimento;
import GasAndFood.business.Alimento.TRAlimento;
import GasAndFood.business.Alimento.TipoAlimento;
import GasAndFood.business.Descuento.SADescuento;
import GasAndFood.business.Descuento.TDescuento;
import GasAndFood.business.Descuento.TRDescuentoEstablecimiento;
import GasAndFood.business.Descuento.TipoDescuento;
import GasAndFood.business.Establecimiento.SAEstablecimiento;
import GasAndFood.business.Establecimiento.TEstablecimiento;
import GasAndFood.business.Establecimiento.TREstablecimiento;
import GasAndFood.business.Establecimiento.TipoEstablecimiento;
import GasAndFood.business.Factorias.FactoriaBussines;
import GasAndFood.business.Gasolina.SAGasolina;
import GasAndFood.business.Gasolina.TGasolina;
import GasAndFood.business.Gasolina.TRGasolina;
import GasAndFood.business.Gasolina.TipoGasolina;
import GasAndFood.business.Usuario.SAUsuario;
import GasAndFood.business.Usuario.TUsuario;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controlador {

	private FactoriaBussines fact;
	private SAUsuario saUsuario;
	private SAAlimento saAlimento;
	private SADescuento saDescuento;
	private SAEstablecimiento saEstablecimiento;
	private SAGasolina saGasolina;
	private DefaultTableModel model;
	private JTable tabla;
	private String resultado = "";

	public Controlador(FactoriaBussines modelo) {
		// TODO Apï¿½ndice de constructor generado automï¿½ticamente
		fact = modelo;

	}

	public void accion(int evento, Object datos) throws IOException {
		model = new DefaultTableModel();
		tabla = null;
		switch (evento) {

		// USUARIOS
		case Evento.ALTA_USUARIO:
			saUsuario = fact.getSAUsuario();
			TUsuario tUA = (TUsuario) datos;
			switch (saUsuario.darDeAlta(tUA)) {
			case 0:
				resultado = "Alta usuario correcto";
				break;
			case 1:
				resultado = "El usuario se ha encontrado y dado de alta";
				break;
			case 2:
				resultado = "El usuario ya estaba dado de alta";
				break;
			default:
				resultado = "Resultado inesperado en Alta usuario";
				break;
			}
			break;

		case Evento.ACTUALIZAR_USUARIO:
			saUsuario = fact.getSAUsuario();
			TUsuario tUM = (TUsuario) datos;
			String id = tUM.getId();
			String contrasena = tUM.getContrasena();
			String mail = tUM.getEmail();
			boolean act = tUM.getActivo();
			switch (saUsuario.actualizarUsuario(id, contrasena, mail, act)) {
			case 0:
				resultado = "No se ha encontrado el usuario a modificar";
				break;
			case 1:
				resultado = "Se ha modificado el usuario correctamente";
				break;
			default:
				resultado = "Resultado inesperado en Actualizar usuario";
				break;
			}
			break;

		case Evento.BAJA_USUARIO:
			saUsuario = fact.getSAUsuario();
			String idU = (String) datos;
			switch (saUsuario.darDeBaja(idU)) {
			case 0:
				resultado = "No se ha encontrado el usuario a borrar";
				break;
			case 1:
				resultado = "El usuario se ha dado de baja correctamente";
				break;
			case 2:
				resultado = "El usuario ya estaba dado de baja";
				break;
			default:
				resultado = "Resultado inesperado en Baja usuario";
				break;
			}
			break;

		case Evento.LEER_USUARIO:
			saUsuario = fact.getSAUsuario();
			String idUs = (String) datos;
			TUsuario tUL = saUsuario.leerID(idUs);
			if (tUL != null) {
				setTable(Evento.LEER_USUARIO);
				toTable(evento, tUL);
				tabla = new JTable(model);
			} else
				resultado = "No encontrado";
			break;

		case Evento.LEER_TODO_USUARIO:
			saUsuario = fact.getSAUsuario();
			List<TUsuario> listaU = saUsuario.leerTodo();
			setTable(Evento.LEER_TODO_USUARIO);
			toTable(evento, listaU);
			tabla = new JTable(model);
			break;

		// ESTABLECIMIENTO
		case Evento.ALTA_ESTABLECIMIENTO:
			saEstablecimiento = fact.getSAEstablecimiento();
			TEstablecimiento tEA = (TEstablecimiento) datos;

			switch (saEstablecimiento.darDeAlta(tEA)) {
			case 0:
				resultado = "Alta Establecimiento correcto";
				break;
			case 1:
				resultado = "El Establecimiento se ha encontrado y dado de alta";
				break;
			case 2:
				resultado = "El Establecimiento ya estaba dado de alta";
				break;
			default:
				resultado = "Resultado inesperado en Alta Establecimiento";
				break;
			}
			break;

		case Evento.ACTUALIZAR_ESTABLECIMIENTO:
			saEstablecimiento = fact.getSAEstablecimiento();
			TEstablecimiento tEM = (TEstablecimiento) datos;
			String idEa = tEM.getId();
			TipoEstablecimiento tipo = tEM.getTipo();
			boolean actE = tEM.getActivo();
			switch (saEstablecimiento.actualizarEstablecimiento(idEa, tipo,
					actE)) {
			case 0:
				resultado = "No se ha encontrado el ESTABLECIMIENTO a modificar";
				break;
			case 1:
				resultado = "Se ha modificado el ESTABLECIMIENTO correctamente";
				break;
			default:
				resultado = "Resultado inesperado en Actualizar ESTABLECIMIENTO";
				break;
			}
			break;

		case Evento.BAJA_ESTABLECIMIENTO:
			saEstablecimiento = fact.getSAEstablecimiento();
			String idE = (String) datos;
			switch (saEstablecimiento.darDeBaja(idE)) {
			case 0:
				resultado = "No se ha encontrado el estableciminento a borrar";
				break;
			case 1:
				resultado = "El establecimiento se ha dado de baja correctamente";
				break;
			case 2:
				resultado = "El establecimiento ya estaba dado de baja";
				break;
			default:
				resultado = "Resultado inesperado en Baja establecimiento";
				break;
			}
			break;

		case Evento.LEER_ESTABLECIMIENTO:
			saEstablecimiento = fact.getSAEstablecimiento();
			String IdEL = (String) datos;
			TEstablecimiento tEL = saEstablecimiento.leerID(IdEL);
			if (tEL != null) {
				setTable(Evento.LEER_ESTABLECIMIENTO);
				toTable(evento, tEL);
				tabla = new JTable(model);
			} else
				resultado = "No encontrado";
			break;

		case Evento.LEER_TODO_ESTABLECIMIENTO:
			saEstablecimiento = fact.getSAEstablecimiento();
			List<TEstablecimiento> listaE = saEstablecimiento.leerTodo();
			setTable(Evento.LEER_TODO_ESTABLECIMIENTO);
			toTable(evento, listaE);
			tabla = new JTable(model);
			break;

		// ALIMENTO
		case Evento.ALTA_ALIMENTO:
			saAlimento = fact.getSAAlimento();
			TAlimento tAA = (TAlimento) datos;
			switch (saAlimento.darDeAlta(tAA)) {
			case 0:
				resultado = "Alta Alimento correcto";
				break;
			case 1:
				resultado = "El Alimento se ha encontrado y dado de alta";
				break;
			case 2:
				resultado = "El Alimento ya estaba dado de alta";
				break;
			default:
				resultado = "Resultado inesperado en Alta Alimento";
				break;
			}
			break;

		case Evento.ACTUALIZAR_ALIMENTO:
			saAlimento = fact.getSAAlimento();
			TAlimento tA = (TAlimento) datos;
			String idA = tA.getId();
			TipoAlimento tipoA = tA.getTipo();
			boolean actA = tA.getActivo();
			switch (saAlimento.actualizarAlimento(idA, tipoA, actA)) {
			case 0:
				resultado = "No se ha encontrado el Alimento a modificar";
				break;
			case 1:
				resultado = "Se ha modificado el Alimento correctamente";
				break;
			default:
				resultado = "Resultado inesperado en Actualizar Alimento";
				break;
			}
			break;

		case Evento.BAJA_ALIMENTO:
			saAlimento = fact.getSAAlimento();
			String idAb = (String) datos;
			switch (saAlimento.darDeBaja(idAb)) {
			case 0:
				resultado = "No se ha encontrado el alimento a borrar";
				break;
			case 1:
				resultado = "El alimento se ha dado de baja correctamente";
				break;
			case 2:
				resultado = "El alimento ya estaba dado de baja";
				break;
			default:
				resultado = "Resultado inesperado en Baja alimento";
				break;
			}
			break;

		case Evento.LEER_ALIMENTO_ID:
			saAlimento = fact.getSAAlimento();
			String idAl = (String) datos;
			TAlimento tALid = saAlimento.leerID(idAl);
			if (tALid != null) {
				setTable(Evento.LEER_ALIMENTO_ID);
				toTable(evento, tALid);
				tabla = new JTable(model);
			} else
				resultado = "No encontrado";
			break;

		case Evento.LEER_ALIMENTO_NOMBRE:
			saAlimento = fact.getSAAlimento();
			TAlimento tALnombre = (TAlimento) datos;
			tALnombre = saAlimento.leerNombre(tALnombre.getNombre());
			if (tALnombre != null) {
				setTable(Evento.LEER_ALIMENTO_NOMBRE);
				toTable(evento, tALnombre);
				tabla = new JTable(model);
			} else
				resultado = "No encontrado";
			break;

		case Evento.LEER_TODO_ALIMENTO:
			saAlimento = fact.getSAAlimento();
			List<TAlimento> listaA = saAlimento.leerTodo();
			setTable(Evento.LEER_TODO_ALIMENTO);
			toTable(evento, listaA);
			tabla = new JTable(model);
			break;

		// DESCUENTO
		case Evento.ALTA_DESCUENTO:
			saDescuento = fact.getSADescuento();
			TDescuento tDA = (TDescuento) datos;
			switch (saDescuento.darDeAlta(tDA)) {
			case 0:
				resultado = "Se ha creado y activado correctamente.";
				break;
			case 1:
				resultado = "Ya existia el descuesto, lo hemos activado.";
				break;
			case 2:
				resultado = "Ya existia y ya estaba activado.";
				break;
			}
			break;

		case Evento.ACTUALIZAR_DESCUENTO:
			saDescuento = fact.getSADescuento();
			TDescuento tDAc = (TDescuento) datos;
			String idDAc = tDAc.getId();
			TipoDescuento tipoDAc = tDAc.getTipo();
			boolean actDAc = tDAc.getActivo();
			switch (saDescuento.actualizarDescuento(idDAc, tipoDAc, actDAc)) {
			case 0:
				resultado = "No se ha encontrado el DESCUENTO a modificar";
				break;
			case 1:
				resultado = "Se ha modificado el DESCUENTO correctamente";
				break;
			}
			break;

		case Evento.BAJA_DESCUENTO:
			saDescuento = fact.getSADescuento();
			String idD = (String) datos;
			switch (saDescuento.darDeBaja(idD)) {
			case 0:
				resultado = "No existe el descuento.";
				break;
			case 1:
				resultado = "El descuento se ha dado de baja correctamente.";
				break;
			case 2:
				resultado = "El descuento ya estaba dado de baja.";
				break;
			}
			break;

		case Evento.LEER_DESCUENTO:
			saDescuento = fact.getSADescuento();
			String idDe = (String) datos;
			TDescuento tDL = saDescuento.leerID(idDe);
			if (tDL != null) {
				setTable(Evento.LEER_DESCUENTO);
				toTable(evento, tDL);
				tabla = new JTable(model);
			} else
				resultado = "No encontrado";
			break;

		case Evento.LEER_TODO_DESCUENTO:
			saDescuento = fact.getSADescuento();
			List<TDescuento> listaD = saDescuento.leerTodo();
			setTable(Evento.LEER_TODO_DESCUENTO);
			toTable(evento, listaD);
			tabla = new JTable(model);
			break;

		// GASOLINA
		case Evento.ALTA_GASOLINA:
			saGasolina = fact.getSAGasolina();
			TGasolina tGA = (TGasolina) datos;
			switch (saGasolina.darDeAlta(tGA)) {
			case 0:
				resultado = "Se ha creado y activado correctamente.";
				break;
			case 1:
				resultado = "Ya existia el descuesto, lo hemos activado.";
				break;
			case 2:
				resultado = "Ya existia y ya estaba activado.";
				break;
			}
			break;

		case Evento.ACTUALIZAR_GASOLINA:
            saGasolina = fact.getSAGasolina();
            TGasolina tGAc = (TGasolina) datos;
            String idGAc = tGAc.getId();
            TipoGasolina tipoGAc = tGAc.getTipo();
            String nombreGAc = tGAc.getNombre();
            boolean actGAc = tGAc.getActivo();
            switch (saGasolina.actualizarGasolina(idGAc, tipoGAc,nombreGAc,actGAc)) {

			case 0:
				resultado = "No se ha encontrado el GASOLINA a modificar";
				break;
			case 1:
				resultado = "Se ha modificado el GASOLINA correctamente";
				break;
			}
			break;

		case Evento.BAJA_GASOLINA:
			saGasolina = fact.getSAGasolina();
			String idG = (String) datos;
			switch (saGasolina.darDeBaja(idG)) {
			case 0:
				resultado = "No existe la gasolina.";
				break;
			case 1:
				resultado = "La gasolina se ha dado de baja correctamente.";
				break;
			case 2:
				resultado = "La gasolina ya estaba dada de baja.";
				break;
			}
			break;

		case Evento.LEER_GASOLINA:
			saGasolina = fact.getSAGasolina();
			String idGa = (String) datos;
			TGasolina tGL = saGasolina.leerID(idGa);
			if (tGL != null) {
				setTable(Evento.LEER_GASOLINA);
				toTable(evento, tGL);
				tabla = new JTable(model);
			} else
				resultado = "No encontrado";
			break;

		case Evento.LEER_TODO_GASOLINA:
			saGasolina = fact.getSAGasolina();
			List<TGasolina> listaG = saGasolina.leerTodo();
			setTable(Evento.LEER_TODO_GASOLINA);
			toTable(evento, listaG);
			tabla = new JTable(model);
			break;

        case Evento.VER_RELACION_A:
        	saEstablecimiento = fact.getSAEstablecimiento();
        	String idRA = (String) datos;
            List <TREstablecimiento> listaRA = saEstablecimiento.leerPorAlimento(idRA);
            setTable(Evento.VER_RELACION_A);
            toTable(evento, listaRA);
            tabla = new JTable(model);
            break;

        case Evento.VER_RELACION_G:
        	saEstablecimiento = fact.getSAEstablecimiento();
        	String idRG = (String) datos;
            List < TREstablecimiento > listaRG = saEstablecimiento.leerPorGasolina(idRG);
            setTable(Evento.VER_RELACION_G);
            toTable(evento, listaRG);
            tabla = new JTable(model);
            break;

        case Evento.VER_RELACION_U:
        	saUsuario = fact.getSAUsuario();
        	String idRU = (String) datos;
			List<TRDescuentoEstablecimiento> listaR = saUsuario.leerPorUsuario(idRU);
			setTable(Evento.VER_RELACION_U);
			toTable(evento, listaR);
			tabla = new JTable(model);
			break;
			
        case Evento.VER_RELACION_A_E:
        	saAlimento = fact.getSAAlimento();
        	String idAE = (String) datos;
			List<TRAlimento> listaAE = saAlimento.leerPorEstablecimiento(idAE);
			setTable(Evento.VER_RELACION_A_E);
			toTable(evento, listaAE);
			tabla = new JTable(model);
			break;
			
        case Evento.VER_RELACION_G_E:
        	saGasolina = fact.getSAGasolina();
        	String idGE = (String) datos;
			List<TRGasolina> listaGE = saGasolina.leerPorEstablecimiento(idGE);
			setTable(Evento.VER_RELACION_A_E);
			toTable(evento, listaGE);
			tabla = new JTable(model);
			break;

		default:
			Thread.dumpStack();
			break;
		}

		if (tabla == null)
			JOptionPane.showMessageDialog(null, resultado);
		else {
			JFrame frame = new JFrame(resultado);

			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());

			JScrollPane tableContainer = new JScrollPane(tabla);

			panel.add(tableContainer, BorderLayout.CENTER);
			frame.getContentPane().add(panel);

			frame.pack();
			frame.setVisible(true);
		}
	}

	//Esta función debería realizarse por accion() pero no lo hace porque no existe un objeto 'relacion'
	public void relacionE(int evento, String id, String id2, float prec, int desc) throws IOException {
	    model = new DefaultTableModel();
		tabla = null;
	    saEstablecimiento = fact.getSAEstablecimiento();
	    switch (evento) {
	        case Evento.ADD_RELACION_A:
	            switch (saEstablecimiento.añadirRelacionAlimento(id, id2, prec, desc)) {
	                case 0:
	                    resultado = "Uno de los dos ID's no está activo." +
	                        System.lineSeparator() + "Relación no añadida";
	                    break;
	                case 1:
	                    resultado = "Relación añadida";
	                    break;
	                case 2:
	                    resultado = "La relación ya existe.";
	                    break;
	            }
	            break;

	        case Evento.ADD_RELACION_G:
	            switch (saEstablecimiento.añadirRelacionGasolina(id, id2, prec, desc)) {
	                case 0:
	                    resultado = "Uno de los dos ID's no se ha encontrado." +
	                        System.lineSeparator() + "Relación no añadida";
	                    break;
	                case 1:
	                    resultado = "Relación añadida";
	                    break;
	                case 2:
	                    resultado = "La relación ya existe.";
	                    break;
	            }
	            break;

	        case Evento.DELETE_RELACION_A:
	            switch (saEstablecimiento.borrarRelacionesAlimentos(id, id2)) {
	                case 0:
	                    resultado = "Uno de los dos ID's no se ha encontrado." +
	                        System.lineSeparator() + "Relación no borrada";
	                    break;
	                case 1:
	                    resultado = "Relación borrada";
	                    break;
	            }
	            break;

	        case Evento.DELETE_RELACION_G:
	            switch (saEstablecimiento.borrarRelacionesGasolinas(id, id2)) {
	                case 0:
	                    resultado = "Uno de los dos ID's no se ha encontrado." +
	                        System.lineSeparator() + "Relación no borrada";
	                    break;
	                case 1:
	                    resultado = "Relación borrada";
	                    break;
	            }
	            break;
	    }
	    show();
	}
	
	//Esta función debería realizarse por accion() pero no lo hace porque no existe un objeto 'relacion'
	public void relacionU(int evento, String id, String id2, String id3) throws IOException {
		model = new DefaultTableModel();
		tabla = null;
		saUsuario = fact.getSAUsuario();
		switch (evento) {
		case Evento.ADD_RELACION_U:
			switch (saUsuario.añadirRelacion(id, id2, id3)) {
            case 0:
                resultado = "Uno de los dos ID's no se ha encontrado." +
                    System.lineSeparator() + "Relación no añadida";
                break;
            case 1:
                resultado = "Relación añadida";
                break;
            case 2:
                resultado = "La relación ya existe.";
                break;
        }
			break;
			
		case Evento.DELETE_RELACION_U:
			switch (saUsuario.borrarRelaciones(id, id2, id3)) {
            case 0:
                resultado = "Uno de los dos ID's no se ha encontrado." +
                    System.lineSeparator() + "Relación no borrada";
                break;
            case 1:
                resultado = "Relación borrada";
                break;
			}
			break;
		}
		
		show();
	}
	
	private void show(){
		if (tabla == null)
			JOptionPane.showMessageDialog(null, resultado);
		else {
			JFrame frame = new JFrame(resultado);

			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());

			
			JScrollPane tableContainer = new JScrollPane(tabla);

			panel.add(tableContainer, BorderLayout.CENTER);
			frame.getContentPane().add(panel);

			frame.pack();
			frame.setVisible(true);
		}
	}

	private void setTable(int evento) {
		switch (evento) {
		// USUARIO
		case Evento.LEER_USUARIO:
			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Contraseña");
			model.addColumn("Usuario");
			model.addColumn("E-Mail");
			model.addColumn("Activo");
			resultado = "Usuario";
			break;
		case Evento.LEER_TODO_USUARIO:
			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Contraseña");
			model.addColumn("Usuario");
			model.addColumn("E-Mail");
			model.addColumn("Activo");
			resultado = "Todos los usuarios";
			break;

		// ESTABLECIMIENTO
		case Evento.LEER_ESTABLECIMIENTO:
			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Direccion");
			model.addColumn("CP");
			model.addColumn("Tipo");
			model.addColumn("Activo");
			resultado = "Establecimiento";
			break;

		case Evento.LEER_TODO_ESTABLECIMIENTO:
			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Direccion");
			model.addColumn("CP");
			model.addColumn("Tipo");
			model.addColumn("Activo");
			resultado = "Todos los establecimientos";
			break;

		// ALIMENTO
		case Evento.LEER_ALIMENTO_ID:
			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Tipo");
			model.addColumn("Activo");
			resultado = "Alimento";
			break;

		case Evento.LEER_ALIMENTO_NOMBRE:
			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Tipo");
			model.addColumn("Activo");
			resultado = "Alimento";
			break;

		case Evento.LEER_TODO_ALIMENTO:
			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Tipo");
			model.addColumn("Activo");
			resultado = "Todos los Alimentos";
			break;

		// DESCUENTO
		case Evento.LEER_DESCUENTO:

			model.addColumn("ID");
			model.addColumn("Tipo");
			model.addColumn("Activo");
			resultado = "Descuento";
			break;

		case Evento.LEER_TODO_DESCUENTO:

			model.addColumn("ID");
			model.addColumn("Tipo");
			model.addColumn("Activo");
			resultado = "Todos los descuentos";
			break;

		// GASOLINA
		case Evento.LEER_GASOLINA:

			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Tipo");
			model.addColumn("Activo");
			resultado = "Gasolina";
			break;

		case Evento.LEER_TODO_GASOLINA:

			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Tipo");
			model.addColumn("Activo");
			resultado = "Todos las gasolinas";
			break;

		// RELACIONES
		case Evento.VER_RELACION_A:
			model.addColumn("Establecimiento");
			model.addColumn("Precio");
			model.addColumn("Descuento");
			resultado = "Relaciones";
			break;
			
		case Evento.VER_RELACION_G:
			model.addColumn("Establecimiento");
			model.addColumn("Precio");
			model.addColumn("Descuento");
			resultado = "Relaciones";
			break;
			
		case Evento.VER_RELACION_U:
			model.addColumn("Establecimiento");
			model.addColumn("Descuento");
			resultado = "Relaciones";
			break;
			
		case Evento.VER_RELACION_A_E:
			model.addColumn("Alimento");
			model.addColumn("Precio");
			model.addColumn("Descuento");
			resultado = "Relaciones";
			break;
			
		case Evento.VER_RELACION_G_E:
			model.addColumn("Gasolina");
			model.addColumn("Precio");
			model.addColumn("Descuento");
			resultado = "Relaciones";
			break;


		}
	}

	private void toTable(int evento, Object o) {
		String act;
		switch (evento) {
		case Evento.LEER_USUARIO:
			TUsuario TU = (TUsuario) o;
			if (TU.getActivo()) act = "Sí";
			else act = "No";
			String[] usuario = { TU.getId(), TU.getNombre(),
					TU.getContrasena(), TU.getUsuario(), TU.getEmail(), act };
			model.addRow(usuario);
			break;
		case Evento.LEER_ESTABLECIMIENTO:
			TEstablecimiento TE = (TEstablecimiento) o;
			if (TE.getActivo()) act = "Sí";
			else act = "No";
			String[] establecimiento = { TE.getId(), TE.getNombre(),
					TE.getDireccion(), TE.getCP(), TE.getTipo().toString(), act };
			model.addRow(establecimiento);
			break;
		case Evento.LEER_ALIMENTO_ID:
			TAlimento TAI = (TAlimento) o;
			if (TAI.getActivo()) act = "Sí";
			else act = "No";
			String[] alimentoI = { TAI.getId(), TAI.getNombre(),
					TAI.getTipo().toString(), act };
			model.addRow(alimentoI);
			break;
		case Evento.LEER_ALIMENTO_NOMBRE:
			TAlimento TA = (TAlimento) o;
			if (TA.getActivo()) act = "Sí";
			else act = "No";
			String[] alimento = { TA.getId(), TA.getNombre(),
					TA.getTipo().toString(), act };
			model.addRow(alimento);
			break;
		case Evento.LEER_DESCUENTO:
			TDescuento TD = (TDescuento) o;
			if (TD.getActivo()) act = "Sí";
			else act = "No";
			String[] descuento = { TD.getId(), TD.getTipo().toString(), act };
			model.addRow(descuento);
			break;
		case Evento.LEER_GASOLINA:
			TGasolina TG = (TGasolina) o;
			if (TG.getActivo()) act = "Sí";
			else act = "No";
			String[] gasolina = { TG.getId(), TG.getNombre(),
					TG.getTipo().toString(), act };
			model.addRow(gasolina);
			break;
		case Evento.LEER_TODO_USUARIO:
			List<?> listaU = (List<?>) o;
			for (Iterator<?> i = listaU.iterator(); i.hasNext();)
				toTable(Evento.LEER_USUARIO, i.next());
			break;
		case Evento.LEER_TODO_DESCUENTO:
			List<?> listaD = (List<?>) o;
			for (Iterator<?> i = listaD.iterator(); i.hasNext();)
				toTable(Evento.LEER_DESCUENTO, i.next());
			break;
		case Evento.LEER_TODO_ESTABLECIMIENTO:
			List<?> listaE = (List<?>) o;
			for (Iterator<?> i = listaE.iterator(); i.hasNext();)
				toTable(Evento.LEER_ESTABLECIMIENTO, i.next());
			break;
		case Evento.LEER_TODO_ALIMENTO:
			List<?> listaA = (List<?>) o;
			for (Iterator<?> i = listaA.iterator(); i.hasNext();)
				toTable(Evento.LEER_ALIMENTO_ID, i.next());
			break;
		case Evento.LEER_TODO_GASOLINA:
			List<?> listaG = (List<?>) o;
			for (Iterator<?> i = listaG.iterator(); i.hasNext();)
				toTable(Evento.LEER_GASOLINA, i.next());
			break;
		case Evento.VER_RELACION_U:
			List<?> listaRU=(List<?>) o;
			for (Iterator<?> i = listaRU.iterator(); i.hasNext();){
				TRDescuentoEstablecimiento TRDE=(TRDescuentoEstablecimiento) i.next();
				String[]TRDES={TRDE.getEstablecimiento().getNombre(), TRDE.getDescuento().getTipo().toString()};
				model.addRow(TRDES);
			}
			break;
		case Evento.VER_RELACION_A:
			List<?> listaRA=(List<?>) o;
			for (Iterator<?> i = listaRA.iterator(); i.hasNext();){
				TREstablecimiento TRA=(TREstablecimiento) i.next();
				String[]TRDES={TRA.getEstablecimiento().getNombre(), Float.toString(TRA.getPrecio()), Integer.toString(TRA.getDescuento())+"%"};
				model.addRow(TRDES);
			}
			break;
		case Evento.VER_RELACION_G:
			List<?> listaRG=(List<?>) o;
			for (Iterator<?> i = listaRG.iterator(); i.hasNext();){
				TREstablecimiento TRG=(TREstablecimiento) i.next();
				String[]TRDES={TRG.getEstablecimiento().getNombre(), Float.toString(TRG.getPrecio()), Integer.toString(TRG.getDescuento())+"%"};
				model.addRow(TRDES);
			}
			break;
		case Evento.VER_RELACION_A_E:
			List<?> listaAE=(List<?>) o;
			for (Iterator<?> i = listaAE.iterator(); i.hasNext();){
				TRAlimento TRAE=(TRAlimento) i.next();
				String[]TRDES={TRAE.getAlimento().getNombre(), Float.toString(TRAE.getPrecio()), Integer.toString(TRAE.getDescuento())+"%"};
				model.addRow(TRDES);
			}
			break;
		case Evento.VER_RELACION_G_E:
			List<?> listaGE=(List<?>) o;
			for (Iterator<?> i = listaGE.iterator(); i.hasNext();){
				TRGasolina TRGE=(TRGasolina) i.next();
				String[]TRDES={TRGE.getGasolina().getNombre(), Float.toString(TRGE.getPrecio()), Integer.toString(TRGE.getDescuento())+"%"};
				model.addRow(TRDES);
			}
			break;
		}

	}
}