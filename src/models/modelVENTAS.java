/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import conectar_tablas.Database; //llamamos la conexion a la BD para almacen
import static conectar_tablas.Database.getConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Octaviano
 */
public class modelVENTAS {
    //************************* Variables necesarias para compras *****************************
    
    public String RFC_empleado;
    public String nombre_empleado;// solo se obtendra este dato, no se almacenara
    public String apellido_pat_empleado;// solo se obtendra este dato, no se almacenara
    public String apellido_mat_empleado;// solo se obtendra este dato, no se almacenara
    public int num_sucursal; //solo se obtendra este dato, no se almacenara. 
    public String RFC_cliente;
    public String nombre_cliente;
    public String apell_pat_cliente; // solo se obtendra este dato, no se almacenara
    public String apell_mat_cliente; // solo se obtendra este dato, no se almacenara
    public int puntos_acumulados;
    public float subtotal;
    public float iva;
    public float importe;
    
    public int numero_venta;
    public String codigo_producto;
    public String codigo_producto_Promo;
    public String codigo_producto_Promo2;
    public String nombre_producto;// solo se obtendra este dato, no se almacenara
    public String tipo_producto;// solo se obtendra este dato, no se almacenara
    public String marca_producto;// solo se obtendra este dato, no se almacenara
    public String Status_producto;
    public String Status_vista;
    public int cantidad_venta = 1; //se incia la venta en uno
    public float precio_venta;
    public float precio_venta_promo;
    public Date fecha_final;
    public float total_por_producto=0.0f;
    
    public ArrayList producto; // la variable almacenara una lista para llenar comboBox
    public ArrayList numero_empleado; // la variable almacenara una lista para llenar comboBox
    public ArrayList numero_sucursal; // la variable almacenara una lista para llenar comboBox
    public ArrayList numero_cliente; // la variable almacenara una lista para llenar comboBox
    public ArrayList descuento_combo; // la variable almacenara una lista para llenar comboBox
    
    public int codigo_descuento;
    public int puntos_requeridos;
    public int cantidad_puntos;
    public int porcentaje;
    public float descuento;
    public float descuento_prod;
    
    public float efectivo;
    public String forma_pago;
    public float cambio;
    
    public int puntos_ganados;
    
    public String activo;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
    
    public String getRFC_empleado() {
        return RFC_empleado;
    }

    public void setRFC_empleado(String RFC_empleado) {
        this.RFC_empleado = RFC_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_pat_empleado() {
        return apellido_pat_empleado;
    }

    public void setApellido_pat_empleado(String apellido_pat_empleado) {
        this.apellido_pat_empleado = apellido_pat_empleado;
    }

    public String getApellido_mat_empleado() {
        return apellido_mat_empleado;
    }

    public void setApellido_mat_empleado(String apellido_mat_empleado) {
        this.apellido_mat_empleado = apellido_mat_empleado;
    }

    public int getNum_sucursal() {
        return num_sucursal;
    }

    public void setNum_sucursal(int num_sucursal) {
        this.num_sucursal = num_sucursal;
    }

    public String getRFC_cliente() {
        return RFC_cliente;
    }

    public void setRFC_cliente(String RFC_cliente) {
        this.RFC_cliente = RFC_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApell_pat_cliente() {
        return apell_pat_cliente;
    }

    public void setApell_pat_cliente(String apell_pat_cliente) {
        this.apell_pat_cliente = apell_pat_cliente;
    }

    public String getApell_mat_cliente() {
        return apell_mat_cliente;
    }

    public void setApell_mat_cliente(String apell_mat_cliente) {
        this.apell_mat_cliente = apell_mat_cliente;
    }

    public int getPuntos_acumulados() {
        return puntos_acumulados;
    }

    public void setPuntos_acumulados(int puntos_acumulados) {
        this.puntos_acumulados = puntos_acumulados;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public int getNumero_venta() {
        return numero_venta;
    }

    public void setNumero_venta(int numero_venta) {
        this.numero_venta = numero_venta;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getCodigo_producto_Promo() {
        return codigo_producto_Promo;
    }

    public void setCodigo_producto_Promo(String codigo_producto_Promo) {
        this.codigo_producto_Promo = codigo_producto_Promo;
    }

    public String getCodigo_producto_Promo2() {
        return codigo_producto_Promo2;
    }

    public void setCodigo_producto_Promo2(String codigo_producto_Promo2) {
        this.codigo_producto_Promo2 = codigo_producto_Promo2;
    }
   
    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getMarca_producto() {
        return marca_producto;
    }

    public void setMarca_producto(String marca_producto) {
        this.marca_producto = marca_producto;
    }

    public String getStatus_producto() {
        return Status_producto;
    }

    public void setStatus_producto(String Status_producto) {
        this.Status_producto = Status_producto;
    }

    public String getStatus_vista() {
        return Status_vista;
    }

    public void setStatus_vista(String Status_vista) {
        this.Status_vista = Status_vista;
    }

    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public float getPrecio_venta_promo() {
        return precio_venta_promo;
    }

    public void setPrecio_venta_promo(float precio_venta_promo) {
        this.precio_venta_promo = precio_venta_promo;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }
    
    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public float getTotal_por_producto() {
        return total_por_producto;
    }

    public void setTotal_por_producto(float total_por_producto) {
        this.total_por_producto = total_por_producto;
    }

    public int getCodigo_descuento() {
        return codigo_descuento;
    }

    public void setCodigo_descuento(int codigo_descuento) {
        this.codigo_descuento = codigo_descuento;
    }

    public int getPuntos_requeridos() {
        return puntos_requeridos;
    }

    public void setPuntos_requeridos(int puntos_requeridos) {
        this.puntos_requeridos = puntos_requeridos;
    }

    public int getCantidad_puntos() {
        return cantidad_puntos;
    }

    public void setCantidad_puntos(int cantidad_puntos) {
        this.cantidad_puntos = cantidad_puntos;
    }

    
    
    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public float getDescuento() {
        return descuento;
    }

    public float getDescuento_prod() {
        return descuento_prod;
    }

    public void setDescuento_prod(float descuento_prod) {
        this.descuento_prod = descuento_prod;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(float efectivo) {
        this.efectivo = efectivo;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public float getCambio() {
        return cambio;
    }

    public void setCambio(float cambio) {
        this.cambio = cambio;
    }

    public int getPuntos_ganados() {
        return puntos_ganados;
    }

    public void setPuntos_ganados(int puntos_ganados) {
        this.puntos_ganados = puntos_ganados;
    }

    public ArrayList getProducto() {
        return producto;
    }

    public void setProducto(ArrayList producto) {
        this.producto = producto;
    }

    public ArrayList getNumero_empleado() {
        return numero_empleado;
    }

    public void setNumero_empleado(ArrayList numero_empleado) {
        this.numero_empleado = numero_empleado;
    }

    public ArrayList getNumero_sucursal() {
        return numero_sucursal;
    }

    public void setNumero_sucursal(ArrayList numero_sucursal) {
        this.numero_sucursal = numero_sucursal;
    }

    public ArrayList getNumero_cliente() {
        return numero_cliente;
    }

    public void setNumero_cliente(ArrayList numero_cliente) {
        this.numero_cliente = numero_cliente;
    }

    public ArrayList getDescuento_combo() {
        return descuento_combo;
    }

    public void setDescuento_combo(ArrayList descuento_combo) {
        this.descuento_combo = descuento_combo;
    }
    
    
    //**************Variables para conexion 
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    PreparedStatement ps;
    
    public DefaultTableModel model_ventas = new DefaultTableModel();
    public int rec;//Variable que tomara el valor seleccionado en la tabla 

    public DefaultTableModel getModel_ventas() {
        return model_ventas;
    }

    public void setModel_ventas(DefaultTableModel model_ventas) {
        this.model_ventas = model_ventas;
    }

    public int getRec() {
        return rec;
    }

    public void setRec(int rec) {
        this.rec = rec;
    }
    
    //**********************ACTUALIZANDO STOCK*****************************
   public int stock_productos;
   public int stock_productos_sucursales;
   public int existencias_sucursal;
   public int existencia_general;

    public int getStock_productos() {
        return stock_productos;
    }

    public void setStock_productos(int stock_productos) {
        this.stock_productos = stock_productos;
    }

    public int getStock_productos_sucursales() {
        return stock_productos_sucursales;
    }

    public void setStock_productos_sucursales(int stock_productos_sucursales) {
        this.stock_productos_sucursales = stock_productos_sucursales;
    }

    public int getExistencias_sucursal() {
        return existencias_sucursal;
    }

    public void setExistencias_sucursal(int existencias_sucursal) {
        this.existencias_sucursal = existencias_sucursal;
    }

    public int getExistencia_general() {
        return existencia_general;
    }

    public void setExistencia_general(int existencia_general) {
        this.existencia_general = existencia_general;
    }

    
    /**
     * Conexion a la Base de datos
     */  
    public void Conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/stockcia", "root", "");
            st = conexion.createStatement(); 

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
    /***
     * el metodo que llenara los comboBox con los registros necesarios de la base de datos
     */
    public void llenarCombo(){
        //llenar comboBox de RFC empleados 
      ArrayList rfc = new ArrayList();
      try{
          rs = st.executeQuery("SELECT * FROM empleados_ventas;");
      }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"error1 al llenar comboBox"+e);
      }
      try{
          while(rs.next()){
              String empl=rs.getString("RFC_empl_vent");
              rfc.add(empl);//agregar los datos a la lista        
          }this.setNumero_empleado(rfc);// almacena la lista con los numeros de proveedores obetenidos de la BD      
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,"error3 al llenar comboBox"+e);
      }
      ArrayList num_suc = new ArrayList(); // lista para sucursales
      //llenar comboBox de Sucursales
      try{
          
          rs = st.executeQuery("SELECT * FROM sucursal;");
      }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"error1 al llenar comboBox"+e);
      }
      try{
          while(rs.next()){
              String sucursal=rs.getString("no_sucursal");
              num_suc.add(sucursal);//agregar los datos a la lista        
          }this.setNumero_sucursal(num_suc);// almacena la lista con los numeros de proveedores obetenidos de la BD      
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,"error2 al llenar comboBox"+e);
      }
      //llenar comboBox de codigo de productos
      ArrayList codigo = new ArrayList();
      try{
          rs = st.executeQuery("SELECT * FROM productos;");
      }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"error4 al llenar comboBox"+e);
      }
      try{
          while(rs.next()){
              String prod=rs.getString("codigo_producto");
              codigo.add(prod);//agregar los datos a la lista        
          }this.setProducto(codigo);// almacena la lista con los numeros de proveedores obetenidos de la BD      
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,"error5 al llenar comboBox"+e);
      }
      //llenar comboBox de RFC del cliente
      ArrayList cliente = new ArrayList();
      try{
          rs = st.executeQuery("SELECT * FROM clientes;");
      }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"error4 al llenar comboBox"+e);
      }
      try{
          while(rs.next()){
              String client=rs.getString("RFC_cliente");
              cliente.add(client);//agregar los datos a la lista        
          }this.setNumero_cliente(cliente);// almacena la lista con los numeros de proveedores obetenidos de la BD      
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,"error5 al llenar comboBox"+e);
      }
      //llenar comboBox de Descuentos
      ArrayList descuentos = new ArrayList();
      try{
          rs = st.executeQuery("SELECT * FROM descuentos;");
      }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"error4 al llenar comboBox"+e);
      }
      try{
          while(rs.next()){
              String desc=rs.getString("codigo_descuento");
              descuentos.add(desc);//agregar los datos a la lista        
          }this.setDescuento_combo(descuentos);// almacena la lista con los numeros de proveedores obetenidos de la BD      
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,"error5 al llenar comboBox"+e);
      }
    }
    /**
     * llenado de los TextFields con los datos que le correspondan 
     * segun sea seleccionado en el comboBox
     */
    public void llenarTextFieldsEmpleados(){
        try{
            RFC_empleado=this.getRFC_empleado();
            rs = st.executeQuery("SELECT * FROM empleados_ventas WHERE RFC_empl_vent='" +RFC_empleado+ "';");//consulta a empleaddos ventas
                rs.next();
                nombre_empleado = rs.getString("nombre_empl_vent");
                apellido_pat_empleado = rs.getString("ap_pat_vent");
                apellido_mat_empleado = rs.getString("ap_mat_vent");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error7 al llenarTextFields"+e);
        }   
    }
    public void llenarTextFieldsClientes(){
        try{
            RFC_cliente=this.getRFC_cliente();
            rs = st.executeQuery("SELECT * FROM clientes WHERE RFC_cliente='" +RFC_cliente+ "';");//consulta a clientes
            rs.next();
            nombre_cliente = rs.getString("nombre_client");
            apell_pat_cliente= rs.getString("ap_pat_client");
            apell_mat_cliente = rs.getString("ap_mat_client");
            puntos_acumulados=rs.getInt("puntos");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error8 al llenarTextFields"+e);
        }
    }
    public void llenarTextFieldsDescuentos(){
        try{
        codigo_descuento = this.getCodigo_descuento();
        rs = st.executeQuery("SELECT * FROM descuentos WHERE codigo_descuento='" +codigo_descuento+ "';");//consulta a descuentos
        rs.next();
        porcentaje = rs.getInt("porcentaje");
        cantidad_puntos = rs.getInt("cantidad_puntos");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error9 al llenarTextFields"+e);
        }
     }
    /**
     * El metodo  pasara a las variables correspondintes los datos de los productos
     * pasara los datos de los productos que esten el promocion
     * para poder ser utlizado en el controlador de ventas 
     * verificara si la Promocion esta Vigente 
     * verificara si el producto esta o no a la venta 
     */
    public void llenarTextFieldsProductos(){
       try{//tabla de productos 
           codigo_producto = this.getCodigo_producto();
           rs = st.executeQuery("SELECT * FROM productos WHERE codigo_producto='"+codigo_producto+"';");//consulta a productos
           rs.next();
           nombre_producto = rs.getString("nom_producto");// solo se obtendra este dato, no se almacenara
           tipo_producto = rs.getString("tipo_producto");// solo se obtendra este dato, no se almacenara
           marca_producto = rs.getString("marca");  
           precio_venta = rs.getFloat("precio_unitario_venta");
           Status_producto=rs.getString("status_prod");
           switch (Status_producto) {
            case "en venta":
               Status_vista = "Venta Normal";
                break;
            case "ya no se maneja":
                Status_vista = "El producto ya no se maneja";
                precio_venta=0.0f;
                break;
        }
        codigo_producto_Promo = this.getCodigo_producto();
        rs = st.executeQuery("SELECT * FROM promociones inner join promocion_prod on promociones.id_promociones = promocion_prod.id_promociones WHERE promocion_prod.codigo_producto='"+codigo_producto_Promo+"';");//consulta a productos
        rs.next();
        codigo_producto_Promo2 = rs.getString("codigo_producto");
        if (codigo_producto.equals(codigo_producto_Promo2)){
            
            fecha_final = rs.getDate("fecha_final");// solo se obtendra este dato, no se almacenara
            System.out.println("La fecha:"+fecha_final);
            
         }
        //Conocer si la promocion a un se aplica segun la fecha de vencimiento
        Date date = new Date(); //Obtenemos la fecha del sistema (Actual)
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//dando formato a la fecha
        System.out.println("Fecha Controlador: "+dateFormat.format(date)); //agregamos el formato a la fecha
        //Hacer la comparacion para saber si la promocion aun se aplica 
        if(date.before(fecha_final)){
            precio_venta =rs.getFloat("precio_descuento");// solo se obtendra este dato, no se almacenara
            Status_vista = "Producto en **Promocion**";
            System.out.println("se aplica la promocion");
        }else{
            Status_vista = "Venta Normal";
        }  
       }catch(Exception e){
            System.out.println("El producto no esta en promocion, o se vencio su promocion");
       }
    }
    //******************** METODOS PARA REALIZAR LA VENTA ***************************
    /**
     * metodo para conocer que numero de Venta es el que sigue
     */
    public void numeroVentas(){
        try{ //obtener el nuemero de registros dentro de la base de datos
            rs=st.executeQuery("SELECT * from ventas;");
            rs.last();
            numero_venta=rs.getInt("id_ventas");//obetner el numero de compra a realizar
            numero_venta=numero_venta+1;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error10 AgregarDatosCompras "+ e);
      }
    }
    
    // Calculando el total por producto vendido 
    public void TotalProductoVendido(){
        cantidad_venta = this.getCantidad_venta();
        precio_venta = this.getPrecio_venta();
        //Realizando la operacion para obtener el total por producto
        total_por_producto=cantidad_venta*precio_venta;
    }
    //LLenando la tabla con el producto que se va a comprar 
     /**
     * los siguientes metodos realizaran los siguientes procesos
     * 1. pasaran cada dato ingresado para la compra en la tabla, llenado una lista de los productos comprados
     * 2. calcularan el importe, iva y subtotal de toda la compra en genera
     * 3. este metodo solo servira para dar vista de como se ve cada producto 
     *    con su respectivo precio y cantidad manejando tambien el Total final (SIN GUARDAR EN LA BASE DE DATOS)
     */
    public void AgregarDatosVenta(){
        model_ventas.setColumnIdentifiers(new Object[]{"Numero de Venta", "Codigo Producto", "Nombre Producto", "Marca","Precio", "Cantidad", "Total"}); 
        String datos[] = new String[8];
        datos[0] = Integer.toString(this.getNumero_venta());
        datos[1] = this.getCodigo_producto();
        datos[2] = this.getNombre_producto();
        datos[3] = this.getMarca_producto();
        datos[4] = Float.toString(this.getPrecio_venta());
        datos[5] = Integer.toString(this.getCantidad_venta());
        datos[6] = Float.toString(this.getTotal_por_producto());
        model_ventas.addRow(datos);
    }
    /**
     * Calculando el importe de la Venta
     */
    public void importe(){
      //*********************calculando el importe, iva y subtotal de la compra***************
      importe=this.getImporte();
      iva= importe*16/100;//calculando el iva
      subtotal = importe - iva; //calculando el subtotal
      /**
       * Generar Puntos de acuerdo al importe generado y los puntos se generan para todos 
       * los clientes, siempre y cuando no sea el cliente general 
      */
      RFC_cliente=this.getRFC_cliente();
      if ("CLIENTEGENERA".equals(RFC_cliente)){
          System.out.println("el cliente general no genera puntos");
      }else{
          puntos_ganados =(int)importe*3/100; //calcular los puntos ganados
      }
    }
    /**
     * Aplicando el descuento segun los puntos que el cliente tenga
     * el descuento se aplica en el importe final 
     */
    public void DescuentoImporte(){
        llenarTextFieldsClientes();
        llenarTextFieldsDescuentos();
        if (puntos_acumulados >= cantidad_puntos){ // si los puntos del cliente son menores o iguales a los requeridos
            int confirmar = JOptionPane.showConfirmDialog(null, "¿esta seguro de realizar el descuento?");    
            if(JOptionPane.OK_OPTION==confirmar){
                porcentaje = this.getPorcentaje();
                importe = this.getImporte();
                descuento = (porcentaje * importe)/100;
                descuento_prod = importe - descuento; //se aplica el descuento al importe final
                //volviando a calcular el iva y el subtotal
                iva= descuento_prod*16/100;//calculando el iva
                subtotal = descuento_prod - iva; //calculando el subtotal
                activo = "deshabilitado";
            }
          
        }else {
            descuento_prod = importe;
            activo = "habilitado";
            JOptionPane.showMessageDialog(null,"no se puede aplicar el descuento");
        }
    }
    /***
     * metodo que recibira el efectivo que da el cliente y de acuerdo al cliente 
     * calculara cuanto debe de recibir de cambio
     * si el efectivo es menor al importe, no se puede realizar la operacion
     * de lo contrario la operacion se realizara con exito
     */
    public void Cambio(){
        try{
            efectivo = this.getEfectivo();
            if (efectivo > importe){
                cambio = efectivo - importe; //se hace el calculo del cambio 
            }
       }catch(Exception e){
            System.out.println("error MODELO: ignorado, Cambio");
        } 
    }
    //************************* GUARDAR LA VENTA REALIZADA EN LA BASE DE DATOS **************************
    /**
     * finalizar Venta
     * se hara la consulta a la base de datos, con las tablas de venta y detalle_venta
     * guardara en la tablas los datos que le corresponden a cada una
     * para realizar la venta y finalizarla 
    */  
   
    /***
     * Metodo que guradara en la tabla de ventas 
     */  
    public void finalizarCompratablaVenta(){
        int confirmar = JOptionPane.showConfirmDialog(null, "¿esta seguro de realizar la compra?");    
        if(JOptionPane.OK_OPTION==confirmar) {
            try{// se guarda en la tabla de compra   
                Connection cn = getConexion();
                RFC_cliente = this.getRFC_cliente();
                subtotal = this.getSubtotal();
                iva = this.getIva();
                importe = this.getImporte();
                numero_venta = this.getNumero_venta();
                RFC_empleado = this.getRFC_empleado();
                forma_pago= "Efectivo";
                num_sucursal = this.getNum_sucursal();
                codigo_descuento = this.getCodigo_descuento();
                puntos_ganados = this.getPuntos_ganados();
                ps = cn.prepareStatement("insert into ventas (RFC_cliente,subtotal_venta,iva,importe_vent,num_factura,RFC_empleado,forma_pago,no_sucursal,codigo_descuento,puntos_ganados)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
                ps.setString(1,RFC_cliente);
                ps.setFloat(2,subtotal);
                ps.setFloat(3,iva);
                ps.setFloat(4,importe);
                ps.setInt(5,numero_venta);
                ps.setString(6,RFC_empleado);
                ps.setString(7,forma_pago);
                ps.setInt(8,num_sucursal);
                ps.setInt(9,codigo_descuento);
                ps.setInt(10,puntos_ganados);
                ps.executeUpdate();//realizndo la accion de guardar
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"error12 FinalizarCompras "+ e);
          }
      }
    }
    /**
     * este metodo guardara en la base de datos los datos correspondientes en detalle compra
     * 1. se le agrega a cada variable el valor correspondiente para despues agregarlo a la base de datos
     * 2. se hace la consulta para insertar datos
     */
     public void finalizarCompratablaDetalleVenta(){
        try{//se guardara en la tabla detalle_compra
            Connection cn = getConexion();
            num_sucursal = this.getNum_sucursal();
            numero_venta = this.getNumero_venta();
            codigo_producto = this.getCodigo_producto();
            cantidad_venta = this.getCantidad_venta();
            precio_venta = this.getPrecio_venta();
            total_por_producto = this.getTotal_por_producto();
            ps = cn.prepareStatement("insert into detalle_ventas (id_ventas,codigo_producto,cantidad,precio_venta,total_producto)"
                + " values(?, ?, ?, ?, ?);");
            ps.setInt(1,numero_venta);
            ps.setString(2,codigo_producto);
            ps.setFloat(3,cantidad_venta);
            ps.setFloat(4,precio_venta);
            ps.setFloat(5,total_por_producto);
            ps.executeUpdate();//realizndo la accion de guardar    
      }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error13 FinalizarCompras "+ e);
      }    
    }
}
