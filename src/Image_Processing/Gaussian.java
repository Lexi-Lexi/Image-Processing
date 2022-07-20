package Image_Processing;

import IKImage.IKImage;

class Gaussian extends Kernel{
	
	//constructors
	public Gaussian(){}
	public Gaussian(int n, String name){
		this.n=n;
		this.name=name;
		}
	
	//private method - only used in this class
	//creates kernels used for gaussian filter
	private static float[][] createKernels (int length, double weight){
		//Modified the code written by Dewald Esterhuizen(https://softwarebydefault.com/2013/06/08/calculating-gaussian-kernels/)
	    float[][] Kernel = new float[length][length]; 
	    float sumTotal = 0; 

	    int kernelRadius = length / 2; 
	    float distance = 0; 
	    
	    double calculatedEuler = 1.0 /  
	    (2.0 * Math.PI * Math.pow(weight, 2)); 

	    for (int filterY = -kernelRadius; filterY <= kernelRadius; filterY++){
	        for (int filterX = -kernelRadius; filterX <= kernelRadius; filterX++) {
	        	distance = (float) (((filterX * filterX) + (filterY * filterY)) / (2 * (weight * weight))); 
	        	Kernel[filterY + kernelRadius][filterX + kernelRadius] = (float) (calculatedEuler * Math.exp(-distance)); 
	            sumTotal = sumTotal + Kernel[filterY + kernelRadius][filterX + kernelRadius]; 
	        } 
	    } 
	    for (int y = 0; y < length; y++){ 
	        for (int x = 0; x < length; x++){ 
	            Kernel[y][x] = (float) (Kernel[y][x] * (1.0 / sumTotal)); 
	        } 
	    } 
	    return Kernel; 		
	}
	public void processAndSave(IKImage input) {//from abstract class
		IKImage gaussian_out=convolution(input, createKernels(n, n));
		gaussian_out.saveImage("gaussian_size_"+n+"_out.jpg");
	}

}
