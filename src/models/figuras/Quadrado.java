package models.figuras;

import java.awt.*;
import java.util.StringTokenizer;

public class Quadrado extends Figura {
    protected Ponto p;
    protected int lado, quadrante;

    public Quadrado(int x, int y, int lado, int quadrante) {
        this(x, y, lado, quadrante, Color.BLACK, Color.WHITE);
    }

    public Quadrado(int x, int y, int lado, int quadrante, Color cor, Color fill) {
        super(cor, fill);

        this.p = new Ponto(x, y);

        this.lado = lado;
        this.quadrante = quadrante;
    }

    public Quadrado(String s) {
        StringTokenizer quebrador = new StringTokenizer(s, ":");

        quebrador.nextToken();

        int x = Integer.parseInt(quebrador.nextToken());
        int y = Integer.parseInt(quebrador.nextToken());

        int lado = Integer.parseInt(quebrador.nextToken());
        int quadrante = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color(Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken())); // B

        Color fill = new Color(Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken())); // B

        this.p = new Ponto(x, y, cor, fill);
        this.lado = lado;
        this.quadrante = quadrante;
        this.cor = cor;
        this.fill = fill;
    }

    public void torneSeVisivel(Graphics g) {
        g.setColor(this.cor);
        switch (quadrante) {
            case 1:
                g.drawRect(this.p.getX(), this.p.getY(), lado, lado);
                break;
            case 2:
                g.drawRect(this.p.getX(), this.p.getY(), -lado, lado);
                break;
            case 3:
                g.drawRect(this.p.getX(), this.p.getY(), -lado, -lado);
                break;
            case 4:
                g.drawRect(this.p.getX(), this.p.getY(), lado, -lado);
                break;
        }

        g.setColor(this.fill);
        switch (quadrante) {
            case 1:
                g.fillRect(this.p.getX(), this.p.getY(), lado, lado);
                break;
            case 2:
                g.fillRect(this.p.getX(), this.p.getY(), -lado, lado);
                break;
            case 3:
                g.fillRect(this.p.getX(), this.p.getY(), -lado, -lado);
                break;
            case 4:
                g.fillRect(this.p.getX(), this.p.getY(), lado, -lado);
                break;
        }
    }

    public String toString() {
        return "q:" +
                this.p.getX() +
                ":" +
                this.p.getY() +
                ":" +
                this.lado +
                ":" +
                this.quadrante +
                ":" +
                this.getCor().getRed() +
                ":" +
                this.getCor().getGreen() +
                ":" +
                this.getCor().getBlue() +
                ":" +
                this.getCor().getRed() +
                ":" +
                this.getCor().getGreen() +
                ":" +
                this.getCor().getBlue();
    }
}
