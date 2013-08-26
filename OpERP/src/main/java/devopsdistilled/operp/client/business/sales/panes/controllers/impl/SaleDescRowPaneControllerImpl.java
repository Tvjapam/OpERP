package devopsdistilled.operp.client.business.sales.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.business.sales.panes.SaleDescRowPane;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDescRowPaneController;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDescRowPaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.server.data.entity.business.SaleDescRow;

public class SaleDescRowPaneControllerImpl implements SaleDescRowPaneController {

	@Inject
	private SaleDescRowPane view;

	@Inject
	private SaleDescRowPaneModel model;

	@Inject
	private StockModel stockModel;

	@Override
	public void validate() throws EntityValidationException {
		// TODO Auto-generated method stub

	}

	@Override
	public SaleDescRow save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleDescRowPaneModel getModel() {
		return model;
	}

	@Override
	public SaleDescRowPane getView() {
		return view;
	}

	@Override
	public void init(SaleDescRow saleDescRow, EntityOperation entityOperation) {

		view.setController(this);
		view.resetComponents();

		model.registerObserver(view);
		model.setEntityAndEntityOperation(saleDescRow, entityOperation);

		stockModel.registerObserver(view);
	}

}