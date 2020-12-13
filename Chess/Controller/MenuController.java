package Controller;

import Model.ModelAPI;
import View.MenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {

	private MenuView view;
	private String[] names;
	private ModelAPI model = ModelAPI.getAPIInstance();
	
	public MenuController() {
		// TODO Auto-generated constructor stub
		ActionListener listeners[] = {addStartListener(),addLoadListener(),addExitListener()};
		view = new MenuView(listeners);
	}

	
	private ActionListener addStartListener() {
		
		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				names = view.getNames();
				view.hideView();
				model.startGame(names[0], names[1]);
				new GameController();
			}
			
		};
		
		return actionListener;
	}
	
	private ActionListener addLoadListener() {
			
			ActionListener actionListener = new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("Calling Loads");
				}
				
			};
			
			return actionListener;
		}
	
	private ActionListener addExitListener() {
		
		ActionListener actionListener = new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Calling Exit");
			}
			
		};
		
		return actionListener;
	}

	
	public void startGame(String name1, String name2) {
		ModelAPI m = ModelAPI.getAPIInstance();
		m.startGame(name1, name2);
	}
	
	public static void main(String args[]) {
		new MenuController();
	}
	
}
