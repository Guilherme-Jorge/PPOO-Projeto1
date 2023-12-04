package models;

import models.figuras.Texto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaTexto extends JFrame implements ActionListener {
    protected JTextArea textArea;
    protected JScrollPane scrollPane;
    protected JLabel fontLabel;
    protected JLabel styleLabel;
    protected JSpinner fontSizeSpinner;
    protected SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 2, 1);
    protected JSpinner fontStyleSpinner;
    protected JComboBox<String> fontBox;
    protected JButton concluir;
    protected String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    private String selectedFontFamily = "Arial";
    private int selectedStyle = 0;
    private int selectedSize = 20;
    protected Font selectedFont;
    protected Janela.MeuJPanel pai;
    protected int x, y;

    public JanelaTexto(Janela.MeuJPanel pai, int x, int y) {
        this.setTitle("Digite o texto:");
        this.setSize(600, 600);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font(selectedFontFamily, selectedStyle, selectedSize));

        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450, 450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        fontLabel = new JLabel("Fonte: ");

        fontSizeSpinner = new JSpinner();
        fontSizeSpinner.setPreferredSize(new Dimension(50, 25));
        fontSizeSpinner.setValue(20);
        fontSizeSpinner.addChangeListener((e) -> {
            selectedSize = (int) fontSizeSpinner.getValue();
            textArea.setFont(new Font(selectedFontFamily, selectedStyle, selectedSize));
        });

        styleLabel = new JLabel("Estilo: ");

        fontStyleSpinner = new JSpinner(spinnerModel);
        fontStyleSpinner.setPreferredSize(new Dimension(50, 25));
        fontStyleSpinner.setValue(0);
        fontStyleSpinner.addChangeListener((e) -> {
            selectedStyle = (int) fontSizeSpinner.getValue();
            switch (selectedStyle) {
                case 0:
                    textArea.setFont(new Font(selectedFontFamily, Font.PLAIN, selectedSize));
                    break;
                case 1:
                    textArea.setFont(new Font(selectedFontFamily, Font.BOLD, selectedSize));
                    break;
                case 2:
                    textArea.setFont(new Font(selectedFontFamily, Font.ITALIC, selectedSize));
                    break;
            }
        });

        fontBox = new JComboBox<>(fonts);
        fontBox.addActionListener(this);
        fontBox.setSelectedItem(selectedFontFamily);

        concluir = new JButton("Concluir");
        concluir.addActionListener((e) -> {
            Font f = new Font(selectedFontFamily, Font.PLAIN, selectedSize);
            switch (selectedStyle) {
                case 0:
                    f = new Font(selectedFontFamily, Font.PLAIN, selectedSize);
                    break;
                case 1:
                    f = new Font(selectedFontFamily, Font.BOLD, selectedSize);
                    break;
                case 2:
                    f = new Font(selectedFontFamily, Font.ITALIC, selectedSize);
                    break;
            }
            this.pai.addTexto(this.x, this.y, this.textArea.getText(), f);
            this.dispose();
        });

        this.add(fontLabel);
        this.add(fontSizeSpinner);
        this.add(styleLabel);
        this.add(fontStyleSpinner);
        this.add(fontBox);
        this.add(concluir);
        this.add(scrollPane);
        this.setVisible(true);

        this.pai = pai;
        this.x = x;
        this.y = y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fontBox) {
            selectedFontFamily = (String) fontBox.getSelectedItem();
            selectedStyle = (int) fontStyleSpinner.getValue();
            selectedSize = (int) fontSizeSpinner.getValue();
            textArea.setFont(new Font(selectedFontFamily, selectedStyle, selectedSize));
        }
    }
}
