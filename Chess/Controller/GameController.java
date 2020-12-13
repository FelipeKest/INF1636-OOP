package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Model.ModelAPI;
import View.*;

public class GameController {
	
	protected TableView tableView;

	public GameController() {
		tableView = new TableView();
	}

	
	public void movePiece(int x0,int y0, int xF, int yF) {
		ModelAPI m = ModelAPI.getAPIInstance();
		m.movePiece(x0, y0, xF, yF);
	}
	
	public ActionListener getSaveAction() {
		ActionListener saveAction = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Insira nome para salvamento de jogo:
				// get text
				// salvar arquivo com dados de jogo
			}
		};
		return saveAction;
	}
}
