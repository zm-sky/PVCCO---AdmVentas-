/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios.admVentas;

import java.util.List;
import objetosNegocio.Talla;
import objetosNegocio.Usuario;
import pvcco.interfaces.IntAdmVentas;

/**
 *
 * @author zippy
 */
public class FacAdmVentas implements IntAdmVentas{

    private AdmVentas admVentas;
    
    public FacAdmVentas(){
        admVentas = new AdmVentas();
    }
    
    @Override
    public void realizarVenta(List<Talla> tallas, List<Integer> cantidades,  float totalVenta) {
        admVentas.realizarVenta(tallas, cantidades, totalVenta);
    }

    @Override
    public void agregarVentaPorApartadoLiquidado(List<Talla> tallas, List<Integer> cantidades, float cantidadPagada) {
        admVentas.agregarVentaPorApartadoLiquidado(tallas, cantidadPagada);
    }
    
}
