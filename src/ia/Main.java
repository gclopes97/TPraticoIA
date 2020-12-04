package ia;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int estadoInicial[][] = {{7, 2, 4}, {5, 0, 6}, {8, 3, 1}};
        //int estadoInicial[][] = {{0, 2, 3}, {1, 4, 6}, {7 , 5, 8}};
        
        Estado e = new Estado(estadoInicial);
        System.out.println("Estado Inicial:");
        e.ImprimirEstado();
        
        No no = new No(e,-1,0);
        
        //INSTANCIAÇÃO DE UM OBJETO buscaProfundidade
        //BuscaProfundidade buscaprofundidade = new BuscaProfundidade();
        //buscaprofundidade.busca(no);

        //INSTANCIAÇÃO DE UM OBJETO buscaLargura
        //BuscaLargura buscalargura = new BuscaLargura();
        //buscalargura.busca(no);
        
        //INSTANCIAÇÃO DE UM OBJETO A*
        //Aestrela a = new Aestrela();
        //a.busca(no);
        
        //INSTANCIAÇÃO DE UM GULOSA
        Gulosa g = new Gulosa();
        g.busca(no);
    }
}
