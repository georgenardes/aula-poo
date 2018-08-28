/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

/**
 *
 * @author 6473091
 */
public class GeradorProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Prova p1 = new Prova("Programação");
//        p1.setLocal("Sala 202 D6");
//        p1.setData("25/08/2018");
//        System.out.println(p1.obtemDetalhes());
        Discursiva d = new Discursiva();
        d.setPergunta("Qqié");
        d.setCriteriosCorrecao("Nao sei");
        d.setPeso(10);
        
        Objetiva o = new Objetiva();
        o.setPergunta("Qual das alternativas esta correta?");
        o.setPeso(10);
        String[] op = {"A", "B", "C", "D", "E"};
        
        o.setOpcoes(op);
        o.setRespostaCorreta(4);
        
    }

}
