package config;

import java.util.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;

import controller.CargoController;
import controller.ChoferController;
import controller.EmpleadoController;
import controller.TarifarioController;
import controller.VehiculoController;

@ApplicationPath("rest")
public class MiAplicacion extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(CargoController.class);
		classes.add(ChoferController.class);
		classes.add(EmpleadoController.class);
		classes.add(VehiculoController.class);
		classes.add(TarifarioController.class);
		return classes;
	}


}
