/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import views.*;
import models.*;
import controllers.*;
/**
 *
 * @author Octaviano
 */
public class MenuEmpleadoVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModelClientesEmpleados modelClientesEmpleados = new ModelClientesEmpleados();
        ViewClientesEmpleados viewClientesEmpleados = new ViewClientesEmpleados();
        ControllerClientesEmpleados controllerClientesEmpleados = new ControllerClientesEmpleados(modelClientesEmpleados, viewClientesEmpleados);
        
        ModelProductosEmpleados modelProductosEmpleados = new ModelProductosEmpleados();
        ViewProductosEmpleados viewProductosEmpleados = new ViewProductosEmpleados();
        ControllerProductosEmpleados controllerProductosEmpleados = new ControllerProductosEmpleados(modelProductosEmpleados, viewProductosEmpleados);
        
        ModelProveedoresEmpleados modelProveedoresEmpleados = new ModelProveedoresEmpleados();
        ViewProveedoresEmpleados viewProveedoresEmpleados = new ViewProveedoresEmpleados();
        ControllerProveedoresEmpleados controllerProveedoresEmpleados = new ControllerProveedoresEmpleados(modelProveedoresEmpleados, viewProveedoresEmpleados);
        
        ModelSucursalesEmpleados modelSucursalesEmpleados  = new ModelSucursalesEmpleados ();
        ViewSucursalesEmpleados  viewSucursalesEmpleados = new ViewSucursalesEmpleados ();
        ControllerSucursalesEmpleados controllerSucursalesEmpleados  = new ControllerSucursalesEmpleados (modelSucursalesEmpleados , viewSucursalesEmpleados );
        
        modelVENTAS modelVENTAS  = new modelVENTAS ();
        ViewVENTAS  viewVENTAS  = new ViewVENTAS ();
        ControllerVENTAS  controllerVENTAS  = new ControllerVENTAS (modelVENTAS ,viewVENTAS );
        
        Object[] controllers = new Object[6];
        controllers[0] = controllerClientesEmpleados;
        controllers[1] = controllerProductosEmpleados;
        controllers[2] = controllerProveedoresEmpleados;
        controllers[3] = controllerSucursalesEmpleados;
        controllers[4] = controllerVENTAS ;
        
        ModelMenuEmpleadoVentas modelMenuEmpleadoVentas = new ModelMenuEmpleadoVentas ();
        viewMenuEmpleadoVentas viewMenuEmpleadoVentas = new viewMenuEmpleadoVentas();
        ControllerMenuEmpleadoVentas controllerMenuEmpleadoVentas = new  ControllerMenuEmpleadoVentas(modelMenuEmpleadoVentas,viewMenuEmpleadoVentas,controllers);
        
    }
    
}
