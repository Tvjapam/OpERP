package devopsdistilled.operp.client.party.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.party.panes.controllers.CreateVendorPaneController;
import devopsdistilled.operp.client.party.panes.models.observers.CreateVendorPaneModelObserver;

public class CreateVendorPane extends SubTaskPane implements
		CreateVendorPaneModelObserver {

	@Inject
	private CreateVendorPaneController controller;

	private final JPanel pane;
	private final JTextField nameField;
	private final JTextField panVatField;
	private final JButton btnCancel;
	private final JButton btnCreate;

	public CreateVendorPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][]"));

		JLabel lblVendorName = new JLabel("Vendor Name");
		pane.add(lblVendorName, "cell 0 0,alignx trailing");

		nameField = new JTextField();
		nameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.getModel().getVendor()
						.setPartyName(nameField.getText().trim());
			}
		});
		pane.add(nameField, "cell 1 0,growx");
		nameField.setColumns(10);

		JLabel lblPanvat = new JLabel("PAN/VAT");
		pane.add(lblPanvat, "cell 0 1,alignx trailing");

		panVatField = new JTextField();
		panVatField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.getModel().getVendor()
						.setPanVat(panVatField.getText().trim());
			}
		});
		pane.add(panVatField, "cell 1 1,growx");
		panVatField.setColumns(10);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnCancel, "flowx,cell 1 3");

		btnCreate = new JButton("Create");
		pane.add(btnCreate, "cell 1 3");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	public void setContactInfopanel(JPanel contactInfopanel) {
		pane.add(contactInfopanel, "cell 0 2,grow,span");
		pane.validate();
	}

}
