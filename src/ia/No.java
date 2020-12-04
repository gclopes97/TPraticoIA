package ia;

import ia.Estado;
import java.util.ArrayList; 
//IMPORTAÇÃO DA CLASSE PARA MANIPULAÇÃO DE VETORES

public class No implements Comparable<No> //CADA NÓ DA ÁRVORE
{
// CLASSE QUE IMPLEMENTA A CLASSE INTERFACE COMPARABLE PARA PODER
// COMPARAR OS NÓS E ORDEM DELES NA FRONTEIRA

    private Estado estado;
    private int pai;
    private int profundidade; //custo acumuladO = profundiade
    
    //PARA O A ESTRELA
    protected int h; // heurística = custo estimado para o proximo nó
    private int funcaoAvaliacao;//função de avaliação int f; //g+h
    
    //CONSTRUTOR PERSONALIZADO
    public No(Estado estado, int pai, int profundidade) 
    {
        this.estado = estado;
        this.pai = pai;
        this.profundidade = profundidade;
        
        //PARA A* e Gulosa
        this.h = this.h_pecasFora(this.getEstado()); //Tem q mudar a função Heuristica aqui ;;
        this.funcaoAvaliacao = this.profundidade + this.h;
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
        
        //PARA A*
        System.out.println("HEURÍSTICA " + this.h);
        System.out.println("FUNÇÃO DE AVALIAÇÃO: " + this.funcaoAvaliacao);
    }

    //SOBRESCRIÇÃO DA FUNÇÃO DE COMPARAÇÃO PARA COMPARAR AS PROFUNDIADES DO NÓ
    //ESSE NÓ COM PROFUNDIDADE MAIOR - RETORNA 1
    //ESSE NÓ COM PROFUNDIDADE MENOR - RETORNA -1
    //ESSE NÓ COM PROFUNDIDADE IGUAL - RETORNA 0
    @Override
    public int compareTo(No no) 
    {
        if (this.funcaoAvaliacao > no.funcaoAvaliacao) 
        {
            return 1;
        } 
        else if (this.funcaoAvaliacao < no.funcaoAvaliacao) 
        {
            return -1;
        } 
        else 
        {
            return 0;
        }
    }
    
    
//FUNÇÃO PARA PEGAR AS COORDENADAS DAS PEÇAS FORAS DO LUGAR UTILIZADAS 
//NA DISTÂNCIA DE MANHATAN
private int[] getCoordenadas(int valor) 
{
    int objetivo[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int[] coord = new int[2];
        
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if (valor == objetivo[i][j]) 
                {
                    coord[0] = i;
                    coord[1] = j;
                    return coord;
                }
            }
        }
        return null;
}


//DISTÂNCIA DE MANHATAN
//SOMATÓRIO DOS MOVIMENTOS NECESSÁRIO DE CADA PEÇA ATÉ A POSIÇÃO IDEAL
public int distanciaDeManhantan() 
{
    int manhatan = 0;
    for (int i = 0; i < 3; i++) 
    {
        for (int j = 0; j < 3; j++) 
        {
            int[] coord = getCoordenadas(this.getEstado().getMat()[i][j]);
            manhatan += Math.abs(i - coord[0]) + Math.abs(j - coord[1]);
        }
    }
        return manhatan;
}

//CÁLCULO DA FUNÇÃO HEURÍSTICA PARA UM ESTADO DIFERENTE PELA SOMA DO NÚMERO DE
//PEÇAS FORA DO LUGAR
    public int h_pecasFora(Estado state) 
    {

        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int heu = 0;

        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if (state.getMat()[i][j] != mat[i][j]) 
                {
                    heu++;
                }
            }
        }
        return heu;
    }

}//KBOU





