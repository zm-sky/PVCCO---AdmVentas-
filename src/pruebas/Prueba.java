/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.ArrayList;
import java.util.List;
import negocios.admVentas.FacAdmVentas;
import objetosNegocio.Modelo;
import objetosNegocio.Talla;
import objetosNegocio.Usuario;
import persistencia.Persistencia;
import pvcco.interfaces.IntAdmVentas;

/**
 *
 * @author zippy
 */
public class Prueba {
    public static void main(String[] args) throws Exception{
        Modelo m = new Persistencia().obten(new Modelo("0"));
        
        List<Talla> tallas = m.getTallaList();
        tallas.remove(0);
        
        List<Integer> cantidades = new ArrayList();
        cantidades.add(1);
        cantidades.add(1);
        
        IntAdmVentas adm = new FacAdmVentas();
        adm.realizarVenta(tallas, cantidades,1000);
    }
}
