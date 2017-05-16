package br.cesjf.lppo.exr1;

import java.util.Date;


public class cPedido {
    
    private Date atualizacao;
    private Long Id; 
    private float valor;
    private int pedido;
    private String nome;
    private String dono;
    
    

    public cPedido() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String texto) {
        this.nome = texto;
    }

    public Date getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(Date data) {
        this.atualizacao = data;
    }

}
