package ia;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //int estadoInicial[][] = {{7, 2, 4}, {5, 0, 6}, {8, 3, 1}};
        int estadoInicial[][] = {{1, 2, 3}, {0, 4, 5}, {7 , 8, 6}};
        
        Estado e = new Estado(estadoInicial);
        System.out.println("Estado Inicial:");
        e.ImprimirEstado();
        
        No no = new No(e,-1,0);
        
        //INSTANCIAÇÃO DE UM OBJETO buscaProfundidade
        //BuscaProfundidade buscaprofundidade = new BuscaProfundidade();
        //buscaprofundidade.busca(no);

        //INSTANCIAÇÃO DE UM OBJETO buscaLargura
        BuscaLargura buscalargura = new BuscaLargura();
        buscalargura.busca(no);
        
        //INSTANCIAÇÃO DE UM OBJETO A*
        //Aestrela a = new Aestrela();
        //a.busca(no);
        
    }
}
