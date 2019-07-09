package jmagickOperation;

import java.io.File;

public class MoveImageConvertion extends ImageConvertion{

	@Override
	public boolean convertion(String pass, String extension) {
		
		return false;
	}

	public String[] fileSplit(String pass) {
		String[] splitPass = pass.split(File.separator);
		
		return splitPass;
	}

}
