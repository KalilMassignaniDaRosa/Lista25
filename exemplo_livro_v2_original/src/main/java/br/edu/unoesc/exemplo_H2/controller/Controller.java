package br.edu.unoesc.exemplo_H2.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import util.Calculadora;
import util.ConversorNumerico;
import util.OperacaoException;

@RestController
@RequestMapping("/api/calculadora")
public class Controller {
	private Logger logger = Logger.getLogger(Controller.class.getName()); 
    
    @GetMapping("/somar-query")
    public Double somarQuery(@RequestParam(value = "numero1", defaultValue = "1") String numero1,
    						 @RequestParam(value = "numero2", defaultValue = "1") String numero2) {
    	return Calculadora.somar(numero1, numero2);
    }
    
    @RequestMapping(value = "/somar-path/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double somarPath(@PathVariable("numero1") String numero1,
    					    @PathVariable(value = "numero2") String numero2) {
    	return Calculadora.somar(numero1, numero2);
    }
    
    @GetMapping("/subtrair-query")
    public Double subtrairQuery(@RequestParam(value = "numero1", defaultValue = "1") String numero1,
    						 @RequestParam(value = "numero2", defaultValue = "1") String numero2) {	
    	return Calculadora.subtrair(numero1, numero2);
    }
    
    @RequestMapping(value = "/subtrair-path/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double subtrairPath(@PathVariable("numero1") String numero1,
    					    @PathVariable(value = "numero2") String numero2) {
    	
    	return Calculadora.subtrair(numero1, numero2);
    }
    
    
    @GetMapping("/multiplicar-query")
    public Double multiplicarQuery(@RequestParam(value = "numero1", defaultValue = "1") String numero1,
    						 @RequestParam(value = "numero2", defaultValue = "1") String numero2) {
    	return Calculadora.multiplicar(numero1, numero2);
    }
    
    @RequestMapping(value = "/multiplicar-path/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double multiplicarPath(@PathVariable("numero1") String numero1,
    					    @PathVariable(value = "numero2") String numero2) {
    	return Calculadora.multiplicar(numero1, numero2);
    }
    
    @GetMapping("/dividir-query")
    public String dividirQuery(@RequestParam(value = "numero1", defaultValue = "1") String numero1,
    						 @RequestParam(value = "numero2", defaultValue = "1") String numero2) {
    	try {
    		return Calculadora.dividir(numero1, numero2).toString();
    	}catch (OperacaoException e) {
			return e.getMessage();
		}
    }
    
    @RequestMapping(value = "/dividir-path/{numero1}/{numero2}", method = RequestMethod.GET)
    public String dividirPath(@PathVariable("numero1") String numero1,
    					    @PathVariable(value = "numero2") String numero2) {
    	try {
    		return Calculadora.dividir(numero1, numero2).toString();
    	}catch (OperacaoException e) {
			return e.getMessage();
		}
    	
    }
    
    @GetMapping("/media-query")
    public Double mediaQuery(@RequestParam(value = "numero1", defaultValue = "1") String numero1,
    						 @RequestParam(value = "numero2", defaultValue = "1") String numero2) {
    	return Calculadora.media(numero1, numero2);
    }
    
    @RequestMapping(value = "/media-path/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double mediaPath(@PathVariable("numero1") String numero1,
    					    @PathVariable(value = "numero2") String numero2) {
    	return Calculadora.media(numero1, numero2);
    }
    
    @GetMapping("/potencia-query")
    public Double potenciaQuery(@RequestParam(value = "numero1", defaultValue = "1") String numero1,
    						 @RequestParam(value = "numero2", defaultValue = "1") String numero2) {
    	return Calculadora.potencia(numero1, numero2);
    }
    
    @RequestMapping(value = "/potencia-path/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double potenciaPath(@PathVariable("numero1") String numero1,
    					    @PathVariable(value = "numero2") String numero2) {
    	return  Calculadora.potencia(numero1, numero2);
    }
    
    @GetMapping("/raiz-query")
    public String raizQuadradaQuery(@RequestParam(value = "numero1", defaultValue = "1") String numero1){
    	try {
    		return Calculadora.raiz(numero1).toString();
    	}catch (OperacaoException e) {
			return e.getMessage();
		}
    	
    }
    
    @RequestMapping(value = "/raiz-path/{numero1}", method = RequestMethod.GET)
    public String raizQuadradaPath(@PathVariable("numero1") String numero1) {
    	try {
    		return Calculadora.raiz(numero1).toString();
    	}catch (OperacaoException e) {
			return e.getMessage();
		}
    	
    }
	}