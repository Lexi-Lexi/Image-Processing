package Image_Processing;

import IKImage.IKImage;

interface Filter {
	
	//abstract class
	public abstract void processAndSave(IKImage original);
}
