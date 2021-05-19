package com.gadsi.tienda;

import com.gadsi.tienda.model.Articulo;
import com.gadsi.tienda.service.ArticuloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @RequestMapping(value = "/articulo/{id}", method = RequestMethod.GET)
    Articulo consultaArticulo(@PathVariable Integer id){
        return  articuloService.findById(id).get();
    }

    @RequestMapping(value = "/articulo", method = RequestMethod.POST)
    String agregarArticulo(@RequestBody Articulo employee){
    	Articulo savedEmployee = articuloService.save(employee);
        return "SUCCESS";
    }

    @RequestMapping(value = "/articulo", method = RequestMethod.PUT)
    Articulo actualizarArticulo(@RequestBody Articulo employee){
    	Articulo updatedEmployee = articuloService.save(employee);
        return updatedEmployee;
    }

    @RequestMapping(value = "/articulo", method = RequestMethod.DELETE)
    Map<String, String> eliminarArticulo(@RequestParam Integer id){
        Map<String, String> status = new HashMap<>();
        Optional<Articulo> employee = articuloService.findById(id);
        if(employee.isPresent()) {
        	articuloService.delete(employee.get());
            status.put("Status", "Employee deleted successfully");
        }
        else {
            status.put("Status", "Employee not exist");
        }
        return status;
    }


    @RequestMapping(value = "/articulos", method = RequestMethod.GET)
    List<Articulo>consultaArticulos(){
        return articuloService.findAll();
    }

    @RequestMapping(value = "/articulos", method = RequestMethod.POST)
    String agregarArticulos(@RequestBody List<Articulo> employeeList){
    	articuloService.saveAll(employeeList);
        return "SUCCESS";
    }

    @RequestMapping(value = "/articulos", method = RequestMethod.DELETE)
    String eliminarAllArticulos(){
    	articuloService.deleteAll();
        return "SUCCESS";
    }
}
