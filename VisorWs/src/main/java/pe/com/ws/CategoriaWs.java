/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ws;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.com.core.dao.CategoriaDao;
import pe.com.core.entity.Categoria;

/**
 * Servicio Web que expone los métodos para insertar Categorías
 * http://localhost:8080/TuBodeguitaWeb/CategoriaWs?wsdl
 *
 * @author Henry Joe Wong Urquiza
 * @email hwongu@gmail.com
 */
@WebService(serviceName = "CategoriaWs")
public class CategoriaWs {

    private final CategoriaDao categoriaDao = new CategoriaDao()

    @WebMethod(operationName = "registrarCategoria")
    public String registrar(@WebParam(name = "nombre") String nombre) {
        String rpta = "";
        try {
            Categoria categoria = new Categoria();
            categoria.setNombre(nombre.trim().toUpperCase());
            categoriaDao.insertar(categoria);
            rpta = "Se guardó de manera correcta la Categoría";
        } catch (Exception e) {
            e.printStackTrace();
            rpta = e.getMessage();
        }
        return rpta;
    }

    @WebMethod(operationName = "actualizarCategoria")
    public String actualizar(@WebParam(name = "codigoCategoria") int idCategoria, @WebParam(name = "nombre") String nombre) {
        String rpta = "";
        try {
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(idCategoria);
            categoria.setNombre(nombre.trim().toUpperCase());
            categoriaDao.actualizar(categoria);
            rpta = "Se actualizó de manera correcta la Categoría";
        } catch (Exception e) {
            e.printStackTrace();
            rpta = e.getMessage();
        }
        return rpta;
    }

    @WebMethod(operationName = "eliminarCategoria")
    public String eliminar(@WebParam(name = "codigoCategoria") int idCategoria) {
        String rpta = "";
        try {
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(idCategoria);
            categoriaDao.eliminar(categoria);
            rpta = "Se eliminó de manera correcta la Categoría";
        } catch (Exception e) {
            e.printStackTrace();
            rpta = e.getMessage();
        }
        return rpta;
    }

    @WebMethod(operationName = "listarCategorias")
    public List<Categoria> listar(@WebParam(name = "filtro") String filtro) {
        List<Categoria> categorias = null;
        try {
            categorias = categoriaDao.listar(filtro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categorias;
    }

    @WebMethod(operationName = "listarCategoriasTodas")
    public List<Categoria> listarTodas() {
        List<Categoria> categorias = null;
        try {
            categorias = categoriaDao.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categorias;
    }

}
