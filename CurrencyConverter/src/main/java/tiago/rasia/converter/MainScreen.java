package tiago.rasia.converter;

import java.awt.Desktop;
import java.awt.Dimension;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Rasia
 */
public class MainScreen extends javax.swing.JFrame {
    
    private Map<String,Double> rateBRL = new HashMap<>();

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        
        initComponents();
        
        setLanguage();
        
        currencyConvert();
        
        this.jTextFieldAmount.requestFocus();
        this.jTextFieldAmount.selectAll();
        
        // TODO TimeConverter
        this.jTabbedPaneConversions.remove(this.jPanelTime);
        
    }
    
    private void updateRate(){
        this.rateBRL = CurrencyConverter.getExchangeRateBRL();
    }
    
    private void currencyConvert(){
        
        if(this.rateBRL.isEmpty()) {
            updateRate();
        }
        double amount = 0.0;
        try {
            amount =  Double.parseDouble(jTextFieldAmount.getText());
        } catch(NumberFormatException e) {
            System.out.println("não é um numero valido " + jTextFieldAmount.getText());
            //amount = 0.0;
            this.jTextFieldAmount.setText("0");
        }
        
        double convertedAmount;
                
        String CFIfrom = ((String)this.jComboBoxCurrencyFrom.getSelectedItem()).substring(0,3);
        String CFIto = ((String)this.jComboBoxCurrencyTo.getSelectedItem()).substring(0,3);
        
        if(CFIfrom.equals("BRL")) {
            System.out.println("from BRL");
            convertedAmount = amount * this.rateBRL.get(CFIto);
        } else if (CFIto.equals("BRL")) {
            System.out.println("to BRL");
            convertedAmount = amount / this.rateBRL.get(CFIfrom);
        } else {
            // alert, só pode converter de ou para BRL
            convertedAmount = 0.0;
        }
        
        System.out.printf("%.2f %s = %.2f %s", amount, CFIfrom, convertedAmount, CFIto);
        System.out.println();
        
        
        String formattedValue = String.format("%.2f", convertedAmount);
        //Double.toString(convertedAmount)
        this.jTextFieldConvertedAmount.setText(formattedValue);
        
    }
    
    private void setLanguage(){
        
        Map<String,String> languageMap;
        /*
        languageMap = switch (this.jComboBoxLanguage.getSelectedIndex()) {
            case 1 -> Languages.getLanguage("ptBR");
            case 2 -> Languages.getLanguage("esES");
            default -> Languages.getLanguage("enUS");
        }; */
        // alterei o switch para usar java 8
        switch (this.jComboBoxLanguage.getSelectedIndex()) {
            case 1:
                languageMap = Languages.getLanguage("ptBR");
                break;
            case 2:
                languageMap = Languages.getLanguage("esES");
                break;
            default:
                languageMap = Languages.getLanguage("enUS");
        }
        
        this.jLabelTop.setText(languageMap.get("jLabelTop"));
        this.jTabbedPaneConversions.setTitleAt(0, languageMap.get("jPanelCurrency"));
        this.jTabbedPaneConversions.setTitleAt(1, languageMap.get("jPanelRomanNumber"));
        // this.jTabbedPaneConversions.setTitleAt(2, languageMap.get("jPanelTime"));
        
        this.jLabelFrom.setText(languageMap.get("jLabelFrom"));
        this.jLabelTo.setText(languageMap.get("jLabelTo"));
        
        
        // getting exiting combo box model
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.jComboBoxCurrencyFrom.getModel();
        try {
            // removing old data
            model.removeAllElements();
        } catch (Exception e){
            // "Just keep swimming" - Dory
        }
        
        model.insertElementAt(languageMap.get("BRL"), 0);
        model.insertElementAt(languageMap.get("USD"), 1);
        model.insertElementAt(languageMap.get("EUR"), 2);
        model.insertElementAt(languageMap.get("GBP"), 3);
        model.insertElementAt(languageMap.get("ARS"), 4);
        model.insertElementAt(languageMap.get("CLP"), 5);
        
        // setting model with new data
        this.jComboBoxCurrencyFrom.setModel(model);
        this.jComboBoxCurrencyFrom.setSelectedIndex(0); 
        
        
        // getting exiting combo box model
        model = (DefaultComboBoxModel) this.jComboBoxCurrencyTo.getModel();
        try {
            // removing old data
            model.removeAllElements();
        } catch (Exception e){
            // "Just keep swimming" - Dory
        }
        
        model.insertElementAt(languageMap.get("BRL"), 0);
        model.insertElementAt(languageMap.get("USD"), 1);
        model.insertElementAt(languageMap.get("EUR"), 2);
        model.insertElementAt(languageMap.get("GBP"), 3);
        model.insertElementAt(languageMap.get("ARS"), 4);
        model.insertElementAt(languageMap.get("CLP"), 5);
        
        // setting model with new data
        this.jComboBoxCurrencyTo.setModel(model);
        this.jComboBoxCurrencyTo.setSelectedIndex(1); 
        
        
    
        this.jLabelDecimalNumber.setText(languageMap.get("jLabelDecimalNumber"));
        this.jLabelRomanNumber.setText(languageMap.get("jLabelRomanNumber"));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackground = new javax.swing.JPanel();
        jPanelTop = new javax.swing.JPanel();
        jLabelTop = new javax.swing.JLabel();
        jComboBoxLanguage = new javax.swing.JComboBox<>();
        jPanelMain = new javax.swing.JPanel();
        jTabbedPaneConversions = new javax.swing.JTabbedPane();
        jPanelCurrency = new javax.swing.JPanel();
        jComboBoxCurrencyFrom = new javax.swing.JComboBox<>();
        jComboBoxCurrencyTo = new javax.swing.JComboBox<>();
        jTextFieldAmount = new javax.swing.JTextField();
        jTextFieldConvertedAmount = new javax.swing.JTextField();
        jLabelFrom = new javax.swing.JLabel();
        jLabelTo = new javax.swing.JLabel();
        jPanelRomanNumber = new javax.swing.JPanel();
        jLabelDecimalNumber = new javax.swing.JLabel();
        jTextFieldDecimalNumber = new javax.swing.JTextField();
        jLabelRomanNumber = new javax.swing.JLabel();
        jTextFieldRomanNumber = new javax.swing.JTextField();
        jPanelTime = new javax.swing.JPanel();
        jCheckBoxLocalTime = new javax.swing.JCheckBox();
        jLabelLocalTime = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Challenge ONE: Conversor");
        setBackground(new java.awt.Color(102, 153, 255));
        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(350, 350));
        setPreferredSize(new java.awt.Dimension(390, 390));

        jPanelBackground.setBackground(new java.awt.Color(102, 153, 255));

        jPanelTop.setBackground(new java.awt.Color(153, 204, 255));

        jLabelTop.setBackground(new java.awt.Color(153, 204, 255));
        jLabelTop.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTop.setText("Converter");

        jComboBoxLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Português", "Español" }));
        jComboBoxLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLanguageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
        jPanelTop.setLayout(jPanelTopLayout);
        jPanelTopLayout.setHorizontalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(44, 44, 44)
                .addComponent(jComboBoxLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTopLayout.setVerticalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelMain.setBackground(new java.awt.Color(153, 204, 255));

        jTabbedPaneConversions.setBackground(new java.awt.Color(153, 204, 255));
        jTabbedPaneConversions.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPaneConversions.setName(""); // NOI18N
        jTabbedPaneConversions.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPaneConversionsFocusGained(evt);
            }
        });

        jPanelCurrency.setBackground(new java.awt.Color(153, 204, 255));
        jPanelCurrency.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanelCurrencyFocusGained(evt);
            }
        });

        jComboBoxCurrencyFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BRL", "USD", "EUR", "GBP", "ARS", "CLP" }));
        jComboBoxCurrencyFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCurrencyFromActionPerformed(evt);
            }
        });

        jComboBoxCurrencyTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BRL", "USD", "EUR", "GBP", "ARS", "CLP" }));
        jComboBoxCurrencyTo.setSelectedIndex(1);
        jComboBoxCurrencyTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCurrencyToActionPerformed(evt);
            }
        });

        jTextFieldAmount.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldAmount.setText("1");
        jTextFieldAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldAmountFocusLost(evt);
            }
        });
        jTextFieldAmount.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldAmountPropertyChange(evt);
            }
        });
        jTextFieldAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAmountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAmountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAmountKeyTyped(evt);
            }
        });

        jTextFieldConvertedAmount.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldConvertedAmount.setText("1");
        jTextFieldConvertedAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldConvertedAmountKeyTyped(evt);
            }
        });

        jLabelFrom.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelFrom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrom.setText("From: BRL");
        jLabelFrom.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelTo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTo.setText("To: USD");
        jLabelTo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanelCurrencyLayout = new javax.swing.GroupLayout(jPanelCurrency);
        jPanelCurrency.setLayout(jPanelCurrencyLayout);
        jPanelCurrencyLayout.setHorizontalGroup(
            jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCurrencyLayout.createSequentialGroup()
                .addGroup(jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCurrencyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextFieldAmount))
                    .addGroup(jPanelCurrencyLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxCurrencyFrom, 0, 133, Short.MAX_VALUE))))
                .addGap(32, 32, 32)
                .addGroup(jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldConvertedAmount, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxCurrencyTo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 135, Short.MAX_VALUE)
                    .addComponent(jLabelTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelCurrencyLayout.setVerticalGroup(
            jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCurrencyLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCurrencyFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCurrencyTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldConvertedAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPaneConversions.addTab("Currency", jPanelCurrency);

        jPanelRomanNumber.setBackground(new java.awt.Color(153, 204, 255));

        jLabelDecimalNumber.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDecimalNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDecimalNumber.setText("Decimal Number");

        jTextFieldDecimalNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldDecimalNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDecimalNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDecimalNumberKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDecimalNumberKeyTyped(evt);
            }
        });

        jLabelRomanNumber.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelRomanNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRomanNumber.setText("Roman Number");

        jTextFieldRomanNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldRomanNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRomanNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRomanNumberKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldRomanNumberKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanelRomanNumberLayout = new javax.swing.GroupLayout(jPanelRomanNumber);
        jPanelRomanNumber.setLayout(jPanelRomanNumberLayout);
        jPanelRomanNumberLayout.setHorizontalGroup(
            jPanelRomanNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRomanNumberLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRomanNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDecimalNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(jTextFieldDecimalNumber)
                    .addComponent(jLabelRomanNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldRomanNumber))
                .addContainerGap())
        );
        jPanelRomanNumberLayout.setVerticalGroup(
            jPanelRomanNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRomanNumberLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelDecimalNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDecimalNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabelRomanNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldRomanNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPaneConversions.addTab("Roman Number", jPanelRomanNumber);

        jPanelTime.setBackground(new java.awt.Color(153, 204, 255));

        jCheckBoxLocalTime.setText("Use Local Time");

        jLabelLocalTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelLocalTime.setText("jLabelLocalTime");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Under Construction");

        javax.swing.GroupLayout jPanelTimeLayout = new javax.swing.GroupLayout(jPanelTime);
        jPanelTime.setLayout(jPanelTimeLayout);
        jPanelTimeLayout.setHorizontalGroup(
            jPanelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBoxLocalTime, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabelLocalTime, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelTimeLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTimeLayout.setVerticalGroup(
            jPanelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxLocalTime)
                    .addComponent(jLabelLocalTime))
                .addGap(54, 54, 54)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPaneConversions.addTab("Time", jPanelTime);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><a href=\"\"  target=\"_blank\">github.com/rasia83/challenge-one-conversor/</a></html>");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneConversions)
                .addContainerGap())
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(14, 14, 14))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneConversions, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelBackgroundLayout = new javax.swing.GroupLayout(jPanelBackground);
        jPanelBackground.setLayout(jPanelBackgroundLayout);
        jPanelBackgroundLayout.setHorizontalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelBackgroundLayout.setVerticalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCurrencyFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCurrencyFromActionPerformed
        
        if(this.jComboBoxCurrencyFrom.getSelectedItem().toString().startsWith("BRL")) {
            if(this.jComboBoxCurrencyTo.getSelectedItem().toString().startsWith("BRL")) {
                this.jComboBoxCurrencyTo.setSelectedIndex(1);
            }
        } else {
            this.jComboBoxCurrencyTo.setSelectedIndex(0);
        }
        
        currencyConvert();
        this.jTextFieldAmount.requestFocus();
        this.jTextFieldAmount.selectAll();
    }//GEN-LAST:event_jComboBoxCurrencyFromActionPerformed

    private void jComboBoxCurrencyToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCurrencyToActionPerformed
           
        if(this.jComboBoxCurrencyTo.getSelectedItem().toString().startsWith("BRL")) {
            if(this.jComboBoxCurrencyFrom.getSelectedItem().toString().startsWith("BRL")) {
                this.jComboBoxCurrencyFrom.setSelectedIndex(1);
            }
        } else {
            this.jComboBoxCurrencyFrom.setSelectedIndex(0);
        }
                
        currencyConvert();
        this.jTextFieldAmount.requestFocus();
        this.jTextFieldAmount.selectAll();
    }//GEN-LAST:event_jComboBoxCurrencyToActionPerformed

    private void jTextFieldAmountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAmountFocusLost

    }//GEN-LAST:event_jTextFieldAmountFocusLost

    private void jTextFieldAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAmountKeyPressed
        
    }//GEN-LAST:event_jTextFieldAmountKeyPressed

    private void jTextFieldAmountPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldAmountPropertyChange

    }//GEN-LAST:event_jTextFieldAmountPropertyChange

    private void jTextFieldAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAmountKeyTyped
        char c = evt.getKeyChar();
        
        if(c == ',') {
            evt.setKeyChar('.');
            c = '.';
        }
        
        // se não for numero ou ponto não aceitar a tecla digitada
        if(!Character.isDigit(c) && c != '.') {
            evt.consume();
        }
        
        // limitar o tamanho do campo
        if(this.jTextFieldAmount.getText().length() > 17 ) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldAmountKeyTyped

    private void jTextFieldAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAmountKeyReleased
        currencyConvert();
    }//GEN-LAST:event_jTextFieldAmountKeyReleased

    private void jTextFieldConvertedAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldConvertedAmountKeyTyped
        evt.consume();
    }//GEN-LAST:event_jTextFieldConvertedAmountKeyTyped

    private void jComboBoxLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLanguageActionPerformed
        setLanguage();
    }//GEN-LAST:event_jComboBoxLanguageActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/rasia83/challenge-one-conversor/").toURI());
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jTextFieldDecimalNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDecimalNumberKeyTyped
        
        char c = evt.getKeyChar();
              
        // se não for numero não aceitar a tecla digitada
        if(!Character.isDigit(c)) {
            evt.consume();
        }
        
        // limitar o tamanho do campo
        if(this.jTextFieldDecimalNumber.getText().length() >= 4 ) {
            evt.consume();
        } 
    }//GEN-LAST:event_jTextFieldDecimalNumberKeyTyped

    private void jTextFieldRomanNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRomanNumberKeyTyped
        
        evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        char c = evt.getKeyChar();
                      
        /*  
        ** Passei a validar o codigo com expressão regular para confirmar se era um numero romano valido
        ** então não foram mais necessarias estas validações de entrada 
        
        // se não for uma letra não aceitar a tecla digitada
        if(!Character.isLetter(c)) {
            evt.consume();
        }
        // se não for uma letra valida não aceitar a tecla digitada
        // testando até milhar M, falta os caracteres especiais para 5K e 10K
        if(c != 'I' && c != 'V' && c != 'X' && c != 'L' && c != 'C' && c != 'D' && c != 'M' ) {
            evt.consume();
        }
        
        // limitar o tamanho do campo
        if(this.jTextFieldRomanNumber.getText().length() >= 14 ) {
            evt.consume();
        } 
        */
        
        // matches the valid Roman Numerals from 1 to 3999
        if(!RomanNumberConverter.isValidRomanNumber(this.jTextFieldRomanNumber.getText() + c)){
            evt.consume();
        }
        
    }//GEN-LAST:event_jTextFieldRomanNumberKeyTyped

    private void jTextFieldDecimalNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDecimalNumberKeyReleased
        int decimalNumber;
        try {
            decimalNumber = Integer.parseInt(this.jTextFieldDecimalNumber.getText());
        } catch (NumberFormatException ex){
            System.out.println(ex.getMessage());
            decimalNumber = 0;
        }
        String romanNumber = RomanNumberConverter.convertToRoman(decimalNumber);
        this.jTextFieldRomanNumber.setText(romanNumber);
            
    }//GEN-LAST:event_jTextFieldDecimalNumberKeyReleased

    private void jTextFieldRomanNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRomanNumberKeyReleased
        String romanNumber = this.jTextFieldRomanNumber.getText();
        int decimalNumber  = RomanNumberConverter.convertToInt(romanNumber);
        this.jTextFieldDecimalNumber.setText(String.valueOf(decimalNumber));
    }//GEN-LAST:event_jTextFieldRomanNumberKeyReleased

    private void jTabbedPaneConversionsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPaneConversionsFocusGained
        
    }//GEN-LAST:event_jTabbedPaneConversionsFocusGained

    private void jPanelCurrencyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanelCurrencyFocusGained

    }//GEN-LAST:event_jPanelCurrencyFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxLocalTime;
    private javax.swing.JComboBox<String> jComboBoxCurrencyFrom;
    private javax.swing.JComboBox<String> jComboBoxCurrencyTo;
    private javax.swing.JComboBox<String> jComboBoxLanguage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelDecimalNumber;
    private javax.swing.JLabel jLabelFrom;
    private javax.swing.JLabel jLabelLocalTime;
    private javax.swing.JLabel jLabelRomanNumber;
    private javax.swing.JLabel jLabelTo;
    private javax.swing.JLabel jLabelTop;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JPanel jPanelCurrency;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelRomanNumber;
    private javax.swing.JPanel jPanelTime;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JTabbedPane jTabbedPaneConversions;
    private javax.swing.JTextField jTextFieldAmount;
    private javax.swing.JTextField jTextFieldConvertedAmount;
    private javax.swing.JTextField jTextFieldDecimalNumber;
    private javax.swing.JTextField jTextFieldRomanNumber;
    // End of variables declaration//GEN-END:variables
}
