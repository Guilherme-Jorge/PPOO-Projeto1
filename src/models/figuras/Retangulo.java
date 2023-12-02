package models.figuras;

import java.awt.*;
import java.util.StringTokenizer;

public class Retangulo extends Figura {
    protected Ponto p;
    protected int altura, comprimento;

    public Retangulo(int x, int y, int comprimento, int altura) {
        this(x, y, comprimento, altura, Color.BLACK, Color.WHITE);
    }

    public Retangulo(int x, int y, int comprimento, int altura, Color cor, Color fill) {
        super(cor, fill);

        this.p = new Ponto(x, y);

        this.comprimento = comprimento;
        this.altura = altura;
    }

    public Retangulo(String s) {
        StringTokenizer quebrador = new StringTokenizer(s, ":");

        quebrador.nextToken();

        int x = Integer.parseInt(quebrador.nextToken());
        int y = Integer.parseInt(quebrador.nextToken());

        int altura = Integer.parseInt(quebrador.nextToken());
        int comprimento = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color(Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken())); // B

        Color fill = new Color(Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken())); // B

        this.p = new Ponto(x, y, cor, fill);
        this.comprimento = comprimento;
        this.altura = altura;
        this.cor = cor;
        this.fill = fill;
    }

    public void torneSeVisivel(Graphics g) {
        g.setColor(this.cor);
        g.drawRect(this.p.getX(), this.p.getY(), comprimento, altura);
        g.setColor(this.fill);
        g.fillRect(this.p.getX(), this.p.getY(), comprimento, altura);
    }

    public String toString() {
        return "r:" +
                this.p.getX() +
                ":" +
                this.p.getY() +
                ":" +
                this.comprimento +
                ":" +
                this.altura +
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
