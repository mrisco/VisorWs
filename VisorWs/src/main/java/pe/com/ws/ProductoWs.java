/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import pe.com.core.dao.ProductoDao;
import pe.com.core.entity.Producto;

/**
 * Servicio Web que expone los métodos para insertar Productos
 * http://localhost:8080/TuBodeguitaWeb/ProductoWs?wsdl
 *
 * @author Henry Joe Wong Urquiza
 * @email hwongu@gmail.com
 */
@WebService(serviceName = "ProductoWs")
public class ProductoWs {

    private final ProductoDao productoDao = new ProductoDao();

    @WebMethod(operationName = "registrarProducto")
    public String registrar(@WebParam(name = "producto") Producto producto) {
        String rpta;
        try {
            productoDao.insertar(producto);
            rpta = "Se guardó de manera correcta el Producto";
        } catch (Exception e) {
            e.printStackTrace();
            rpta = e.getMessage();
        }
        return rpta;
    }

    @WebMethod(operationName = "actualizarProducto")
    public String actualizar(@WebParam(name = "producto") Producto producto) {
        String rpta;
        try {
            productoDao.actualizar(producto);
            rpta = "Se actualizó de manera correcta el Producto";
        } catch (Exception e) {
            e.printStackTrace();
            rpta = e.getMessage();
        }
        return rpta;
    }

    @WebMethod(operationName = "eliminarProducto")
    public String eliminar(@WebParam(name = "producto") Producto producto) {
        String rpta;
        try {
            productoDao.eliminar(producto);
            rpta = "Se eliminó de manera correcta el Producto";
        } catch (Exception e) {
            e.printStackTrace();
            rpta = e.getMessage();
        }
        return rpta;
    }

    @WebMethod(operationName = "listarProductos")
    public List<Producto> listar(@WebParam(name = "filtro") String filtro) {
        List<Producto> productos = null;
        try {
            productos = productoDao.listar(filtro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productos;
    }

    @WebMethod(operationName = "listarProductosTodos")
    public List<Producto> listarTodas() {
        List<Producto> productos = null;
        try {
            productos = productoDao.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productos;
    }

}
