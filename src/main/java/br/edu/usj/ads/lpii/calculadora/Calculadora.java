package br.edu.usj.ads.lpii.calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculadora {


    @PostMapping(value="/calcular")
    public ModelAndView postCalcular(@RequestParam String num1, @RequestParam String operacao, @RequestParam String num2) {

        ModelAndView modelAndView = new ModelAndView("resultado");
        
        Double num1Double = Double.valueOf(num1);
        Double num2Double = Double.valueOf(num2);
        Double resultado = 0.0;
        
        switch(operacao){
            case "+":
                resultado = num1Double + num2Double;
                break;
            case "-":
                resultado = num1Double - num2Double;
                break;
            case "/":
                resultado = num1Double / num2Double;
                break;
            case "*":
                resultado = num1Double * num2Double;
                break;
        } 


        String mensagem = num1 + operacao + num2 + " = " + resultado;

        modelAndView.addObject("resultado", mensagem);

        return modelAndView;
    }

}