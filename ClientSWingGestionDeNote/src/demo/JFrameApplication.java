package demo;

import java.awt.EventQueue;
import javax.swing.table.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import api.APIClient;
import entity.Etudiant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFrameApplication extends JFrame {

	private JPanel contentPane;
	private static JTable tableEtudiant;
	private JTextField textFieldNomEtudiant;
	private JTextField textFieldRechEt;
	private JTextField textFieldNumEt;
	private JComboBox comboBoxNiveau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameApplication frame = new JFrameApplication();
					frame.setVisible(true);
					loadDataEtudiant();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 730, 424);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 64, 128));
		panel_4.setBounds(0, 0, 204, 387);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTION ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(45, 148, 120, 53);
		panel_4.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("des");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(78, 189, 62, 32);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NOTES");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(56, 225, 120, 53);
		panel_4.add(lblNewLabel_2);
		
		JPanel BtnEtudiant = new JPanel();
		BtnEtudiant.setBackground(new Color(192, 192, 192));
		BtnEtudiant.setBounds(230, 130, 141, 139);
		panel.add(BtnEtudiant);
		BtnEtudiant.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("ETUDIANTS");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(20, 58, 98, 22);
		BtnEtudiant.add(lblNewLabel_3);
		
		JPanel BtnMatiere = new JPanel();
		BtnMatiere.setBackground(Color.LIGHT_GRAY);
		BtnMatiere.setBounds(401, 130, 141, 139);
		panel.add(BtnMatiere);
		BtnMatiere.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("MATIERES");
		lblNewLabel_3_1.setBounds(22, 57, 98, 22);
		BtnMatiere.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel BtnNote = new JPanel();
		BtnNote.setBackground(Color.LIGHT_GRAY);
		BtnNote.setBounds(563, 130, 141, 139);
		panel.add(BtnNote);
		BtnNote.setLayout(null);
		
		JLabel lblNewLabel_3_2 = new JLabel("NOTES");
		lblNewLabel_3_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_2.setBounds(41, 58, 78, 22);
		BtnNote.add(lblNewLabel_3_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 705, 225);
		panel_1.add(scrollPane);
		
		tableEtudiant = new JTable();
		tableEtudiant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int sr= tableEtudiant.getSelectedRow();
				String nEt= tableEtudiant.getValueAt(sr,0).toString();
				String mEt= tableEtudiant.getValueAt(sr,1).toString();
				String niEt= tableEtudiant.getValueAt(sr,2).toString();
				
				textFieldNumEt.setText(nEt);
				textFieldNomEtudiant.setText(mEt);
				comboBoxNiveau.setSelectedItem(niEt);
				
				
				
				
				
			}
		});
		scrollPane.setViewportView(tableEtudiant);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(192, 192, 192));
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "GESTION DES ETUDIANTS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_5.setBounds(10, 10, 705, 142);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Nom:");
		lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 15));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(353, 65, 52, 17);
		panel_5.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Niveau:");
		lblNewLabel_4_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(353, 94, 52, 17);
		panel_5.add(lblNewLabel_4_1);
		
		textFieldNomEtudiant = new JTextField();
		textFieldNomEtudiant.setBounds(400, 65, 162, 19);
		panel_5.add(textFieldNomEtudiant);
		textFieldNomEtudiant.setColumns(10);
		
		comboBoxNiveau = new JComboBox();
		comboBoxNiveau.setModel(new DefaultComboBoxModel(new String[] {"L1", "L2", "L3", "M1", "M2"}));
		comboBoxNiveau.setBounds(400, 93, 52, 21);
		panel_5.add(comboBoxNiveau);
		
		JButton btnAjoutEtudiant = new JButton("Ajouter");
		btnAjoutEtudiant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
                    String url = "http://localhost:6543/api/etudiant/createEtudiant";
                    String nomEt = textFieldNomEtudiant.getText();
                    String niveau = comboBoxNiveau.getSelectedItem().toString();

                    String requestBody = "{\"nomEt\": \"" +nomEt + "\", \"niveauEt\": \"" +niveau+ "\"}";
                    String response = APIClient.post(url, requestBody);
                    System.out.println("Réponse : " + response);
                    JOptionPane.showMessageDialog(null, "Ajout avec succès");
                    loadDataEtudiant();
                    // Faites quelque chose avec la réponse reçue, par exemple, mettez à jour l'interface utilisateur
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
			}
		});
		
		btnAjoutEtudiant.setForeground(new Color(255, 255, 255));
		btnAjoutEtudiant.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnAjoutEtudiant.setBackground(new Color(0, 0, 128));
		btnAjoutEtudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAjoutEtudiant.setBounds(584, 32, 85, 21);
		panel_5.add(btnAjoutEtudiant);
		
		JButton btnModierEt = new JButton("Modifier");
		btnModierEt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

                
               
                int request= JOptionPane.showConfirmDialog(null,"Voulez vous vraiment modifier ", "Modification", JOptionPane.YES_NO_OPTION);
				
                if(request == JOptionPane.OK_OPTION) {
                	try {
                		int numEt= Integer.parseInt(textFieldNumEt.getText());
        				
        				String url = "http://localhost:6543/api/etudiantupdateEtudiant/"+numEt;
                        String nomEt = textFieldNomEtudiant.getText();
                        String niveau = comboBoxNiveau.getSelectedItem().toString();
                        String requestBody = "{\"nomEt\": \"" +nomEt + "\", \"niveauEt\": \"" +niveau+ "\"}";
    					
    				    APIClient.update(url, requestBody);
    				    JOptionPane.showMessageDialog(null, "Modification avec succès");
    	                loadDataEtudiant();
    				} catch (Exception ex) {
    				    ex.printStackTrace();
    				}
				}
				else {
					loadDataEtudiant();
				}

				
			}
		});
		btnModierEt.setFont(new Font("Trebuchet MS", Font.PLAIN, 8));
		btnModierEt.setForeground(new Color(255, 255, 255));
		btnModierEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModierEt.setBackground(new Color(128, 128, 128));
		btnModierEt.setBounds(584, 63, 85, 21);
		panel_5.add(btnModierEt);
		
		JButton Et = new JButton("Suprimer");
		Et.setFont(new Font("Tahoma", Font.PLAIN, 8));
		Et.setForeground(new Color(255, 255, 255));
		Et.setBackground(new Color(255, 0, 0));
		Et.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Et.setBounds(584, 94, 85, 21);
		panel_5.add(Et);
		
		textFieldRechEt = new JTextField();
		textFieldRechEt.setColumns(10);
		textFieldRechEt.setBounds(45, 113, 162, 19);
		panel_5.add(textFieldRechEt);
		
		JComboBox comboBoxNiveau_1 = new JComboBox();
		comboBoxNiveau_1.setModel(new DefaultComboBoxModel(new String[] {"L1", "L2", "L3", "M1", "M2"}));
		comboBoxNiveau_1.setBounds(234, 112, 52, 21);
		panel_5.add(comboBoxNiveau_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Numero:");
		lblNewLabel_4_2.setForeground(Color.BLACK);
		lblNewLabel_4_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 15));
		lblNewLabel_4_2.setBounds(353, 32, 52, 17);
		panel_5.add(lblNewLabel_4_2);
		
		textFieldNumEt = new JTextField();
		textFieldNumEt.setForeground(new Color(0, 0, 0));
		textFieldNumEt.setEnabled(false);
		textFieldNumEt.setColumns(10);
		textFieldNumEt.setBounds(400, 36, 52, 19);
		panel_5.add(textFieldNumEt);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
	}
	
	private static void loadDataEtudiant() {
        try {
            String url = "http://localhost:6543/api/etudiant/findAllEtudiant";
            String responseBody = APIClient.get(url);

            // Utiliser Jackson pour convertir la réponse JSON en une liste d'objets Etudiant
            ObjectMapper objectMapper = new ObjectMapper();
            List<Etudiant> etudiants = objectMapper.readValue(responseBody, new TypeReference<List<Etudiant>>(){});

            // Faire le traitement avec la liste d'étudiants
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("Numero Etudiant");
            df.addColumn("Nom Etudiant");
            df.addColumn("Niveau");

            for (Etudiant etudiant : etudiants) {
                df.addRow(new Object[]{etudiant.getNumEt(), etudiant.getNomEt(), etudiant.getNiveauEt()});
            }

            tableEtudiant.setModel(df);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des données des étudiants.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}



