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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Retangulo r = (Retangulo) obj;

        if (!r.p.equals(this.p)) return false;
        if (r.altura != this.altura) return false;
        if (r.comprimento != this.comprimento) return false;

        if (r.cor.equals(this.cor)) return false;
        if (r.fill.equals(this.fill)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int ret = 1;

        ret = 7*ret + this.p.hashCode();
        ret = 7*ret + Integer.valueOf(this.altura).hashCode();
        ret = 7*ret + Integer.valueOf(this.comprimento).hashCode();

        ret = 7*ret + this.cor.hashCode();
        ret = 7*ret + this.fill.hashCode();

        if (ret < 0) ret = -ret;

        return ret;
    }

    private Retangulo(Retangulo r) throws Exception {
        if (r == null) throw new Exception("Modelo nulo");

        this.p = (Ponto) r.p.clone();
        this.altura = r.altura;
        this.comprimento = r.comprimento;

        this.cor = r.cor;
        this.fill = r.fill;
    }

    @Override
    public Object clone() {
        Retangulo ret = null;

        try {
            ret = new Retangulo(this);
        } catch (Exception e) {}

        return ret;
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
