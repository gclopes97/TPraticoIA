
package ia;

import java.util.ArrayList;
import java.util.Stack;

/*
BUSCA EM PROFUNIDADE EXPANDE SEMPRE NA MAIOR PROFUNDIDADE POSSÍVEL SEMPRE
CONSIDERANDO PARA CADA ITERAÇÃO SE O NÓ É O OBJETIVO.
*/


public class BuscaProfundidade 
{
    //FRONTEIRA É UMA PILHA
    private Stack<No> fronteira = new Stack();
    
    //LISTA DE NÓS RETIRADO DA PILHA PARA PODER REMONTAR O CAMINHO PERCORRIDO
    private ArrayList<No> lista = new ArrayList();
    
    private int profundidade_maxima = 5;//USA BUSCA DE PROFUNDIDADE LIMITADA PARA EVITAR LOOP
    
    
    //CONSTRUTOR PADRÃO
    public BuscaProfundidade(){};

    
    
    public void busca(No noInicial)
    {
        System.out.println("\n");
        System.out.println("Executando busca em profundidade!");
        
        //Inserir no inicial na fronteira
        fronteira.add(noInicial);
        No no = new No();
        
        //LISTA DE SUCESSORES POSSÍVEIS DE UM NÓ
        ArrayList<No> sucessores = new ArrayList();
        
        
        //Enquanto a fronteira não estiver Vazia
        while(!fronteira.isEmpty())
        {
            
            //NÓ REMOVIDO DA FRONTEIRA
            no = fronteira.pop();
            
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
            
            if(no.getProfundidade() < profundidade_maxima)
            {
                //Gerar sucessores do no
                sucessores = no.geraSucessor(pai);

                //Inserir sucessores na fronteira
                fronteira.addAll(sucessores);
            }
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
}//KBOU



