package ia;

import java.util.ArrayList; 
//IMPORTAÇÃO DA CLASSE PARA MANIPULAÇÃO DE VETORES

public class No implements Comparable<No> //CADA NÓ DA ÁRVORE
{
// CLASSE QUE IMPLEMENTA A CLASSE INTERFACE COMPARABLE PARA PODER
// COMPARAR OS NÓS E ORDEM DELES NA FRONTEIRA

    private Estado estado;
    private int pai;
    private int profundidade; //custo acumuladO = profundiade
        
    //CONSTRUTOR PERSONALIZADO
    public No(Estado estado, int pai, int profundidade) 
    {
        this.estado = estado;
        this.pai = pai;
        this.profundidade = profundidade;
    }
    

    //CONSTRUTOR PADRÃO
    public No() 
    {
    }

    //GETS E SETS
    public Estado getEstado() 
    {
        return estado;
    }

    public void setEstado(Estado estado) 
    {
        this.estado = estado;
    }

    public int getPai() 
    {
        return pai;
    }

    public void setPai(int pai) 
    {
        this.pai = pai;
    }

    public int getProfundidade() 
    {
        return profundidade;
    }

    public void setProfundidade(int profundidade) 
    {
        this.profundidade = profundidade;
    }

    //FUNÇÃO PARA GERAR SUCESSORES DE UM NÓ
    public ArrayList<No> geraSucessor(int pai) 
    {
        ArrayList<No> sucessores = new ArrayList();
        Estado e;
        No noSuc;

        //ANALISA SE HÁ POSSIBILIDADE DE MOVIMENTO PARA ESQUERDA, CIMA, BAIXO, 
        //DIREITA.
        
        //ESQUERDA
        e = this.estado.GeraSucessor('e');
        if (e != null) {
            noSuc = new No(e, pai, this.profundidade + 1);
            sucessores.add(noSuc);
        }
        //CIMA
        e = this.estado.GeraSucessor('c');
        if (e != null) {
            noSuc = new No(e, pai, this.profundidade + 1);
            sucessores.add(noSuc);
        }
        //BAIXO
        e = this.estado.GeraSucessor('b');
        if (e != null) {
            noSuc = new No(e, pai, this.profundidade + 1);
            sucessores.add(noSuc);
        }

        //DIREITA
        e = this.estado.GeraSucessor('d');
        if (e != null) {
            noSuc = new No(e, pai, this.profundidade + 1);
            sucessores.add(noSuc);
        }

        return sucessores;
        //RETORNA O ARRAY DE SUCESSORES QUE SERÃO INSERIDOS NA FRONTEIRA
    }

    
    public void printNo() 
    {
        System.out.println();
        //System.out.println("ESTADO ATUAL: ");
        this.estado.ImprimirEstado();
        System.out.println("NÓ PAI ESTÁ NA POSIÇÃO " + this.pai+" DA LISTA");
        System.out.println("PROFUNDIDADE NA ÁRVORE: " + this.profundidade);
    }

    //SOBRESCRIÇÃO DA FUNÇÃO DE COMPARAÇÃO PARA COMPARAR AS PROFUNDIADES DO NÓ
    //ESSE NÓ COM PROFUNDIDADE MAIOR - RETORNA 1
    //ESSE NÓ COM PROFUNDIDADE MENOR - RETORNA -1
    //ESSE NÓ COM PROFUNDIDADE IGUAL - RETORNA 0
    @Override
    public int compareTo(No no) 
    {
        if (this.getProfundidade() > no.getProfundidade()) 
        {
            return 1;
        } 
        else if (this.getProfundidade() < no.getProfundidade()) 
        {
            return -1;
        } 
        else 
        {
            return 0;
        }
    }
}//KBOU





