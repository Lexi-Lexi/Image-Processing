package Image_Processing;

import IKImage.IKImage;

class Box extends Kernel{
	//constructors
	public Box(){}
	public Box(int n, String name){
		this.n=n;
		this.name=name;
	}
	
	//private method - only used in this class
	//write the kernel used for box filter
	private float[][] writeKernel(int n) {
		//write Box Kernel
		float[][]box=new float[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				box[i][j]=1/(float)(n*n);
			}
		}
		return box;
	}
	public void processAndSave(IKImage input) {//from abstract class
		IKImage box_out=convolution(input, writeKernel(n));
		box_out.saveImage("box_size_"+n+"_out.jpg");
	}
}
