package jmagickOperation;

import java.io.File;

import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;

public class MoveImageConvertion extends ImageConvertion{

	@Override
	public boolean convertion(String pass, String extension) {
		if(extension == "test") {
			return true;
		}
		String[] passArray = fileSplit(pass);
		int strNum = passArray.length - 1;
		File image = new File(pass);
		if(!(image.exists())) {
			return false;
		}
		passArray[strNum] = extension;
		String resultPass = link(passArray);
		File resultImage = new File(resultPass);
		try {
			MagickImage mi = new MagickImage(new ImageInfo(image.getPath()));
	        MagickImage mo = mi.scaleImage((int) mi.getXResolution(),(int) mi.getYResolution());
	        mo.setFileName(resultImage.getName());
	        mo.writeImage(new ImageInfo());
		}catch(MagickException e2) {
			return false;
		}

		return true;
	}

	public String[] fileSplit(String pass) {
		String splitstr = "[" + File.separator + ".]";
		String[] splitPass = pass.split(splitstr);
		return splitPass;
	}

	public String link(String[] strArray) {
		StringBuffer buf = new StringBuffer();
		int i = 0;
		for(i = 0 ; i < strArray.length -1 ; i ++) {

			buf.append(strArray[i] + File.separator);
		}
		buf.append("." + strArray[i]);
		return buf.toString();

	}

}
