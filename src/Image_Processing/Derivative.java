package Image_Processing;

import IKImage.IKImage;

abstract class Derivative extends Kernel{
	
	//(modifier:default)
	static IKImage grayScale(IKImage inputImage) {
		IKImage outputImage=new IKImage(inputImage); //using copy constructor
		//for pixels in input image
		for (int i = 0; i < inputImage.getWidth(); i++) {
			for (int j = 0; j < inputImage.getHeight(); j++) {
                int red=inputImage.getPixel(j, i, IKImage.RED);
                int green=inputImage.getPixel(j, i, IKImage.GREEN);
				int blue= inputImage.getPixel(j, i, IKImage.BLUE);
				int gray=(red+green+blue)/3;				
				outputImage.setPixelColor(j,i,gray, gray, gray);
			}
		}
		return outputImage;
	}
	
	//(modifier:default)
	static IKImage addTwoImages(IKImage first, IKImage second) {
		IKImage outputImage=new IKImage(first); //using copy constructor
		for(int i=0; i<first.getWidth(); i++) {
			for(int j=0; j<first.getHeight(); j++) {
				int red=first.getPixel(j,i, IKImage.RED)+second.getPixel(j,i, IKImage.RED);
				int green=first.getPixel(j,i, IKImage.GREEN)+second.getPixel(j,i, IKImage.GREEN);
				int blue=first.getPixel(j,i, IKImage.BLUE)+second.getPixel(j,i, IKImage.BLUE);
				//make sure pixel values are 0-255
				red=Math.min(255, Math.max(0, red));
				green=Math.min(255, Math.max(0, green));
				blue=Math.min(255, Math.max(0, blue));
				outputImage.setPixelColor(j,i, red, green, blue);
			}
		}
		return outputImage;
	}
}