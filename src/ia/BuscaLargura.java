
package ia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
BUSCA EM LARGURA POSSUE UMA FRONTEIRA EM FILA, 
ONDE OS PRIMEIROS NÓS VISITADOS SÃO EXPANDIDOS
*/

public class BuscaLargura {
    //FRONTEIRA É UMA FILA
    private Queue<No> fronteira = new LinkedList<>();
    
    //LISTA DE NÓS RETIRADO DA PILHA PARA PODER REMONTAR O CAMINHO PERCORRIDO
    private ArrayList<No> lista = new ArrayList();

    //CONSTRUTOR PADRÃO
    public BuscaLargura(){};
    
     public void busca(No noInicial)
    {
        System.out.println("\n");
        System.out.println("Executando busca em largura!");
        
        //Inserir no inicial na fronteira
        fronteira.add(noInicial);
        No no = new No();
        
        //LISTA DE SUCESSORES POSSÍVEIS DE UM NÓ
        ArrayList<No> sucessores = new ArrayList();
        
        
        //Enquanto a fronteira não estiver Vazia
        while(!fronteira.isEmpty())
        {
            
            //NÓ REMOVIDO DA FRONTEIRA
            no = fronteira.remove();
            
            //NÓ ADICIONADO NA LISTA
            this.lista.add(no);
            
            //PAI DESSE NÓ REPRESENTA A POSIÇÃO DELE NA LISTA DE NÓS REMOVIDOS
            int pai = lista.size()-1;
            
            //testar se no é objetivo
            if(no.getEstado().EhObjetivo())
            {
                System.out.println("NÓ OBJETIVO ENCONTRADO");
                mostraCaminho(no);
                fronteira.clear();
                return;
            }
            
            //Gerar sucessores do no
            sucessores = no.geraSucessor(pai);

            //Inserir sucessores na fronteira
            fronteira.addAll(sucessores);
            
      }  
    }
     
    public void mostraCaminho(No noObj)
    {
        No aux = new No();
        aux = noObj;
        aux.printNo();
        
        while(aux.getPai() != -1)
        {  
            aux = lista.get(aux.getPai());
            aux.printNo();
        }
    }      
    
}
