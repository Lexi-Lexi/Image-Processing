package Image_Processing;

import IKImage.IKImage;

abstract class Kernel implements Filter{
	//variables
	protected IKImage input, output;
	protected String name;
	protected int n;
	
	//constructors
	public Kernel() {}
	public Kernel(int n, String name) throws RuntimeException{ 
		this.name=name;
		input=new IKImage(name);
		if (n % 2 == 0 || n < 0)
			throw new RuntimeException("size 'n' should be an odd number bigger than 3");
			/* throws an exception about n's restrictions
			 it is caught in Homework6's main method */
		this.n=n;

	}
	//convolution method (modifier:default)
	IKImage convolution(IKImage inputImage, float[][] kernel) {
		IKImage outputImage=new IKImage(inputImage); //using copy constructor
		//for each pixel in image
		for(int i=0; i<inputImage.getWidth(); i++) {
			for(int j=0; j<inputImage.getHeight(); j++) { // i need to put something that says the sum of all elements of k is 1
				float new_red=0;
				float new_green=0;
				float new_blue=0;
				//for each element of kernel
				for(int k=0; k<kernel.length; k++) {
					for(int l=0; l<kernel[0].length; l++) {
						int cur_i=Math.min(inputImage.getWidth()-1, Math.max(0, i- kernel.length/2 +k));
						int cur_j=Math.min(inputImage.getHeight()-1, Math.max(0, j- kernel[0].length/2 +l));
		                
						new_red=new_red+(inputImage.getPixel(cur_j, cur_i, IKImage.RED))
								* kernel[l][k];
						new_green=new_green+(inputImage.getPixel(cur_j, cur_i, IKImage.GREEN))
								* kernel[l][k];
						new_blue=new_blue+(inputImage.getPixel(cur_j, cur_i, IKImage.BLUE))
								* kernel[l][k];
					}
				}
				//absolute values
				new_red=Math.abs(new_red);
				new_green=Math.abs(new_green);
				new_blue=Math.abs(new_blue);
				//limiting the range of pixels (boundary pixel handling)
				new_red=Math.min(255, Math.max(0, new_red));
				new_green=Math.min(255, Math.max(0, new_green));
				new_blue=Math.min(255, Math.max(0, new_blue));
				
				outputImage.setPixelColor(j,i, (int)(new_red), (int)(new_green), (int)(new_blue));
			}
		}return outputImage;
	}
}
