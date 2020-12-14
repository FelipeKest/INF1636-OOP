package Controller;

import Model.ModelAPI;
import View.MenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class MenuController {

	private MenuView view;
	private String[] names;
	private ModelAPI model = ModelAPI.getAPIInstance();
	
	public MenuController() {
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
					JFileChooser file = view.openFileSelector();
					// Pegar string do TXT
					String stringPath = file.getSelectedFile().getPath();
					
					String nome = stringPath;
				    String data = "";
					
					try {
				      FileReader arq = new FileReader(nome);
				      BufferedReader lerArq = new BufferedReader(arq);

				      String linha = lerArq.readLine(); 
				      while (linha != null) {
				        data+= linha;
				        data+= "\n";
				        linha = lerArq.readLine();
				      }

				      arq.close();
				    } catch (IOException e1) {
				        System.err.printf("Erro na abertura do arquivo: %s.\n",
				          e1.getMessage());
				    }
					
					model.loadGameData(data);
					view.hideView();
					String names[] = model.getPlayersNames();
					model.startGame(names[0], names[1]);
					new GameController();
				  }
					
				
			};
			
			return actionListener;
		}
	
	private ActionListener addExitListener() {
		
		ActionListener actionListener = new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.quitView();
				
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
