package main;
import java.util.InputMismatchException;

import controller.Controller;
import model.data_structures.noExisteException;

public class Main {
	
	public static void main(String[] args) 
	{
		Controller controler = new Controller();
		try {
			controler.run();
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (noExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
