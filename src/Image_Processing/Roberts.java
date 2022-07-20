package Image_Processing;

import IKImage.IKImage;

class Roberts extends Derivative{
	
	//variables
	private float[][]roberts_kernel_x= {{-1,0,0},{0,1,0},{0,0,0}};
	private float[][]roberts_kernel_y= {{0,0,-1},{0,1,0},{0,0,0}};
	
	//constructors
	public Roberts(){}
	public Roberts(String name){
		this.name=name;
	}
	
	public void processAndSave(IKImage input) {//from abstract class
		IKImage roberts_x=convolution(grayScale(input), roberts_kernel_x);
		IKImage roberts_y=convolution(grayScale(input), roberts_kernel_y);
		IKImage roberts_final=addTwoImages(roberts_x, roberts_y);
		roberts_final.saveImage("roberts_out.jpg");	
	}
}
