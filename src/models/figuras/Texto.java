package models.figuras;

import java.awt.*;
import java.util.StringTokenizer;

public class Texto extends Figura {
    protected Ponto p;
    protected String texto;
    protected Font fonte;

    public Texto(int x, int y, String texto, Font fonte) {
        this(x, y, texto, fonte, Color.BLACK, Color.WHITE);
    }

    public Texto(int x, int y, String texto, Font fonte, Color cor, Color fill) {
        super(cor, fill);

        this.p = new Ponto(x, y);

        this.texto = texto;

        this.fonte = fonte;
    }

    public Texto(String s) {
        StringTokenizer quebrador = new StringTokenizer(s, ":");

        quebrador.nextToken();

        int x = Integer.parseInt(quebrador.nextToken());
        int y = Integer.parseInt(quebrador.nextToken());

        String texto = String.valueOf(quebrador.nextToken());

        Font fonte = new Font(String.valueOf(quebrador.nextToken()), // Família fonte
                Integer.parseInt(quebrador.nextToken()),  // Estilo
                Integer.parseInt(quebrador.nextToken())); // Tamanho


        Color cor = new Color(Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken())); // B

        Color fill = new Color(Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken())); // B

        this.p = new Ponto(x, y, cor, fill);
        this.texto = texto;
        this.fonte = fonte;
        this.cor = cor;
        this.fill = fill;
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
                this.fonte.getFamily() +
                ":" +
                this.fonte.getStyle() +
                ":" +
                this.fonte.getSize() +
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
