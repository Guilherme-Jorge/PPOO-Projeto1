package models.figuras;

import java.awt.*;
import java.util.StringTokenizer;

public class Texto extends Figura {
    protected Ponto p;
    protected String texto;

    public Texto(int x, int y, String texto) {
        this(x, y, texto, Color.BLACK);
    }

    public Texto(int x, int y, String texto, Color cor) {
        super(cor);

        this.p = new Ponto(x, y);

        this.texto = texto;
    }

    public Texto(String s) {
        StringTokenizer quebrador = new StringTokenizer(s, ":");

        quebrador.nextToken();

        int x = Integer.parseInt(quebrador.nextToken());
        int y = Integer.parseInt(quebrador.nextToken());

        String texto = String.valueOf(quebrador.nextToken());

        Color cor = new Color(Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken())); // B

        this.p = new Ponto(x, y, cor);
        this.texto = texto;
        this.cor = cor;
    }

    public void torneSeVisivel(Graphics g) {
        g.setColor(this.cor);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString(this.texto, this.p.getX(), this.p.getY());
    }

    public String toString() {
        return "t:" +
                this.p.getX() +
                ":" +
                this.p.getY() +
                ":" +
                this.texto +
                ":" +
                this.getCor().getRed() +
                ":" +
                this.getCor().getGreen() +
                ":" +
                this.getCor().getBlue();
    }
}
