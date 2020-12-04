package ia;
import ia.No;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*

Função de avaliação do A estrela é f = g+h

custo acumulado até o nó = g
função heurística = h

Nesse problema, o custo acumulado é igual à profundiade do nó, visto que 
o número de movimentações é a profundidade do nó na árvore.

Nesse caso, falta inserir o atributo h de cada nó, ou seja criar na classe nó
um atributo h, e também um atributo f.

*/


public class Aestrela 
{
    private PriorityQueue<No> fronteira = new PriorityQueue();
    private ArrayList<No> lista = new ArrayList();
    
    
    public void busca(No noInicial)
    {
        System.out.println("\n");
        System.out.println("Executando busca por A*");
        
        //Inserir no inicial na fronteira
        fronteira.add(noInicial);
        No no = new No();
        ArrayList<No> sucessores = new ArrayList();
        int indice;
        
        //Enquanto a fronteira não estiver Vazia
        while(!fronteira.isEmpty())
        {
            //no = remover na fronteira
            no = fronteira.poll();
            this.lista.add(no);
             indice = lista.size()-1;
            
            //testar se no é objetivo
            if(no.getEstado().EhObjetivo())
            {
                System.out.println("Solução Encontrada!");
                //imprimeCaminho(no);
                
                imprimeCaminho(no);
                return;
            }
            
            //Gerar sucessores do no
            sucessores = no.geraSucessor(indice);

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
    
    
