package com.example;

public class Jogo {
    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();

    public Jogo() {
        monte.embaralhar();
    }
    public Carta distribuiCartaParaJogador(Jogador jogado){
        if (jogador.parou()){
            return null;
        }
        Carta virada = monte.virar();
        jogador.receberCarta(virada);

        return virada;
    }

    public boolean acabou(){
        return computador.getPontos() > 21 || jogador.getPontos() > 21 || computador.parou() || jogador.parou();
    }

    public String resultado(){
        if (computador.getPontos() > jogador.getPontos()){
            return "Você perdeu!";
        }
        if (jogador.getPontos() > computador.getPontos()){
            return "Você ganhou!";
        }
        return "Empate!";
    }

    public Jogador getJogador() {
        return jogador;
    }

    public Computador getComputador() {
        return computador;
    }
}
