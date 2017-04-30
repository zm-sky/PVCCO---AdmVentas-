/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios.admVentas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import negocios.admInventario.FacAdmInventario;
import objetosNegocio.Talla;
import objetosNegocio.Usuario;
import objetosNegocio.Venta;
import objetosNegocio.VentaTalla;
import persistencia.Persistencia;
import pvcco.interfaces.IntAdmInventario;
import pvcco.interfaces.IntPersistencia;

/**
 *
 * @author zippy
 */
public class AdmVentas {
    protected AdmVentas(){
        
    }
    
    public void realizarVenta(List<Talla> tallas, List<Integer> cantidades, float totalVenta) {
        try{
            IntPersistencia persistencia = new Persistencia();
            
            Venta venta = new Venta();
            venta.setFecha(Calendar.getInstance().getTime());
            venta.setIdUsuario(persistencia.obten(new Usuario("0")));
            venta.setIdVenta(String.valueOf(persistencia.obtenVentas().size()));
            venta.setPagoLiquidacionApartado(0);
            venta.setPrecioTotal(totalVenta);
            
            persistencia.agregar(venta);
            
            IntAdmInventario inv = new FacAdmInventario();
            
            //Tenemos que dar de baja las tallas que se estan vendiendo en el inventario.
            inv.movimientoEnInventarioPorVenta(tallas, cantidades);
            List<VentaTalla> tallasVendidas = new ArrayList<VentaTalla>();
            
            for(Talla talla : tallas){
                VentaTalla vt = new VentaTalla();
                
                vt.setIdVenta(venta);
                vt.setPrecio(talla.getIdModelo().getPrecio());
                vt.setIdTalla(talla);
                vt.setIdVentaTalla(String.valueOf(persistencia.obtenVentaTallas().size()));
                
                tallasVendidas.add(vt);
                persistencia.agregar(vt);
            }
            
            venta.setVentaTallaList(tallasVendidas);
            persistencia.actualizar(venta);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void agregarVentaPorApartadoLiquidado(List<Talla> tallas, float cantidadPagada) {
        
    }
}
