package models.figuras;

import java.awt.*;
import java.util.StringTokenizer;

public class Quadrado extends Figura {
    protected Ponto p;
    protected int lado;

    public Quadrado(int x, int y, int lado) {
        this(x, y, lado, Color.BLACK, Color.WHITE);
    }

    public Quadrado(int x, int y, int lado, Color cor, Color fill) {
        super(cor, fill);

        this.p = new Ponto(x, y);

        this.lado = lado;
    }

    public Quadrado(String s) {
        StringTokenizer quebrador = new StringTokenizer(s, ":");

        quebrador.nextToken();

        int x = Integer.parseInt(quebrador.nextToken());
        int y = Integer.parseInt(quebrador.nextToken());

        int lado = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color(Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken())); // B

        Color fill = new Color(Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken())); // B

        this.p = new Ponto(x, y, cor, fill);
        this.lado = lado;
        this.cor = cor;
        this.fill = fill;
    }

    public void torneSeVisivel(Graphics g) {
        g.setColor(this.cor);
        g.drawRect(this.p.getX(), this.p.getY(), lado, lado);
        g.setColor(this.fill);
        g.fillRect(this.p.getX(), this.p.getY(), lado, lado);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Quadrado q = (Quadrado) obj;

        if (q.lado != this.lado) return false;
        if (!q.p.equals(this.p)) return false;

        if (q.cor.equals(this.cor)) return false;
        if (q.fill.equals(this.fill)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int ret = 1;

        ret = 7*ret + Integer.valueOf(this.lado).hashCode();
        ret = 7*ret + this.p.hashCode();

        ret = 7*ret + this.cor.hashCode();
        ret = 7*ret + this.fill.hashCode();

        if (ret < 0) ret = -ret;

        return ret;
    }

    private Quadrado(Quadrado q) throws Exception {
        if (q == null) throw new Exception("Modelo nulo");

        this.lado = q.lado;
        this.p = (Ponto) q.p.clone();

        this.cor = q.cor;
        this.fill = q.fill;
    }

    @Override
    public Object clone() {
        Quadrado ret = null;

        try {
            ret = new Quadrado(this);
        } catch (Exception e) {}

        return ret;
    }

    public String toString() {
        return "q:" +
                this.p.getX() +
                ":" +
                this.p.getY() +
                ":" +
                this.lado +
                ":" +
                this.getCor().getRed() +
                ":" +
                this.getCor().getGreen() +
                ":" +
                this.getCor().getBlue() +
                ":" +
                this.getFill().getRed() +
                ":" +
                this.getFill().getGreen() +
                ":" +
                this.getFill().getBlue();
    }
}
