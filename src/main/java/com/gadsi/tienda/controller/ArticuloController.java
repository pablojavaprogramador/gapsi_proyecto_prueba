package com.gadsi.tienda.controller;

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
    String agregarArticulo(@RequestBody Articulo articulo){
    	Articulo salvarArticulo = articuloService.save(articulo);
        return "SUCCESS";
    }

    @RequestMapping(value = "/articulo", method = RequestMethod.PUT)
    Articulo actualizarArticulo(@RequestBody Articulo articulo){
    	Articulo actualizarArticulo = articuloService.save(articulo);
        return actualizarArticulo;
    }

    @RequestMapping(value = "/articulo", method = RequestMethod.DELETE)
    Map<String, String> eliminarArticulo(@RequestParam Integer id){
        Map<String, String> status = new HashMap<>();
        Optional<Articulo> articulo = articuloService.findById(id);
        if(articulo.isPresent()) {
        	articuloService.delete(articulo.get());
            status.put("Estatus", "Se elimino el articulo correctamente");
        }
        else {
            status.put("Estatus", "El Articulo no se ha encontrado");
        }
        return status;
    }


    @RequestMapping(value = "/articulos", method = RequestMethod.GET)
    List<Articulo>consultaArticulos(){
        return articuloService.findAll();
    }

    @RequestMapping(value = "/articulos", method = RequestMethod.POST)
    String agregarArticulos(@RequestBody List<Articulo> listaArticulos){
    	articuloService.saveAll(listaArticulos);
        return "SUCCESS";
    }

    @RequestMapping(value = "/articulos", method = RequestMethod.DELETE)
    String eliminarAllArticulos(){
    	articuloService.deleteAll();
        return "SUCCESS";
    }
}
