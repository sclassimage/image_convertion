package jmagickOperation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class MoveImageConvertion extends ImageConvertion{

	@Override
	public boolean convertion(String pass, String extension) {
			File image = new File(pass);
			
			String[] passArray = fileSplit(pass);
			int strNum = passArray.length - 1;
			passArray[strNum] = extension;
			
			String resultPass = link(passArray);
			File resultImage = new File(resultPass);
			
			BufferedImage b;
			try {
				b = ImageIO.read(image);
			} catch (IOException e1) {
				return false;
			}
			int ww=b.getWidth();
			int hh=b.getHeight();
			
			BufferedImage b2=new BufferedImage(ww,hh,BufferedImage.TYPE_INT_RGB);
			Graphics g2=b2.getGraphics();
			g2.drawImage(b,0,0,null);
			g2.dispose();
			
			try {
				ImageIO.write(b2, extension, resultImage);
			} catch (IOException e) {
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
			for(i = 0 ; i < strArray.length -2 ; i ++) {

				buf.append(strArray[i] + File.separator);
			}
			buf.append(strArray[i]);
			i++;
			buf.append("." + strArray[i]);
			return buf.toString();

		}

}
