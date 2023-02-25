package util;

import java.util.logging.Logger;

import br.edu.unoesc.exemplo_H2.controller.Controller;

public class Calculadora {
	private static Logger logger = Logger.getLogger(Controller.class.getName());

	public static Double somar(String numero1, String numero2) {
		if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
    		return 0d;
    	}
		logger.info("Calculando... " + numero1 + " + " + numero2);
		return ConversorNumerico.converterParaDouble(numero1) + ConversorNumerico.converterParaDouble(numero2);
	}

	public static Double subtrair(String numero1, String numero2) {
		if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
    		return 0d;
    	}
		logger.info("Calculando... " + numero1 + " - " + numero2);
		return ConversorNumerico.converterParaDouble(numero1) - ConversorNumerico.converterParaDouble(numero2);
	}

	public static Double multiplicar(String numero1, String numero2) {
		if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
    		return 0d;
    	}
		logger.info("Calculando... " + numero1 + " * " + numero2);
		return ConversorNumerico.converterParaDouble(numero1) * ConversorNumerico.converterParaDouble(numero2);
	}

	public static Double dividir(String numero1, String numero2) throws OperacaoException {

		if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
			return 0d;
		}
		logger.info("Calculando... " + numero1 + " / " + numero2);
		Double num1 = ConversorNumerico.converterParaDouble(numero1);
		Double num2 = ConversorNumerico.converterParaDouble(numero2);

		if (num2 == 0) {
			throw new OperacaoException("Impossivel dividir por zero");
		} else {
			return num1 / num2;
		}

	}

	public static Double media(String numero1, String numero2) {
		if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
    		return 0d;
    	}
    	
		Double media = (ConversorNumerico.converterParaDouble(numero1) + ConversorNumerico.converterParaDouble(numero2))
				/ 2;
		logger.info("A média é : " + media);
		return media;
	}

	public static Double potencia(String numero1, String numero2) {
		if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
    		return 0d;
    	}
		logger.info("Calculando... " + numero1 + " ^ " + numero2);
		return Math.pow(ConversorNumerico.converterParaDouble(numero1), ConversorNumerico.converterParaDouble(numero2));

	}

	public static Double raiz(String numero1) throws OperacaoException {
		if (!ConversorNumerico.ehNumerico(numero1)) {
    		return 0d;
    	}
		Double num1 = ConversorNumerico.converterParaDouble(numero1);
		
		if (num1 < 0) {
			throw new OperacaoException("Impossível fazer raíz de um número negativo");
		} else {
			logger.info("Calculando raíz quadrada de " + numero1);
			return Math.sqrt(ConversorNumerico.converterParaDouble(numero1));
		}
		

	}
}
