package Image_Processing;

import IKImage.IKImage;

class Sobel extends Derivative{
	
	//variables
	private float[][]sobel_kernel_x={{-1,-2,-1},{0,0,0},{1,2,1}};
	private float[][]sobel_kernel_y={{-1,0,1},{-2,0,2},{-1,0,1}};
	
	//constructors
	public Sobel(){}
	public Sobel(String name){
		this.name=name;
	}
	
	public void processAndSave(IKImage input) {//from abstract class
		IKImage sobel_x=convolution(grayScale(input), sobel_kernel_x);
		IKImage sobel_y=convolution(grayScale(input), sobel_kernel_y);
		IKImage sobel_final=addTwoImages(sobel_x, sobel_y);
		sobel_final.saveImage("sobel_out.jpg");	
	}
}