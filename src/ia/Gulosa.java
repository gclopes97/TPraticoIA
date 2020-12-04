package ia;
import ia.No;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*

Função de avaliação da busca gulosa é a heuristica somente

*/


public class Gulosa 
{
    private PriorityQueue<No> fronteira = new PriorityQueue();
    private ArrayList<No> lista = new ArrayList();
    
    
    public void busca(No noInicial)
    {
        System.out.println("\n");
        System.out.println("Executando busca gulosa");
        
        //Inserir no inicial na fronteira
        fronteira.add(noInicial);
        No no = new No();
        ArrayList<No> sucessores = new ArrayList();
        int pai;
        
        //Enquanto a fronteira não estiver Vazia
        while(!fronteira.isEmpty())
        {
            //no = remover na fronteira
            no = fronteira.poll();
            this.lista.add(no);
            pai = lista.size()-1;
            
            //testar se no é objetivo
            if(no.getEstado().EhObjetivo())
            {
                System.out.println("Solução Encontrada!");
                //imprimeCaminho(no);
                
                imprimeCaminho(no);
                return;
            }
            
            //Gerar sucessores do no
            sucessores = no.geraSucessor(pai);

            //Inserir sucessores na fronteira
            fronteira.addAll(sucessores);      
      }  
    }
    
    
    
    public void imprimeCaminho(No no)
    {
        No aux = new No();
        aux = no;
        aux.printNo();
        
        System.out.println("\n");
        System.out.println("Caminho na árvore:");
        
        while(aux.getPai() != -1)
        {  
            aux = lista.get(aux.getPai());
            aux.printNo();
        }
             
    }    
}//KBOU
    
    
