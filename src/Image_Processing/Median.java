package Image_Processing;

import IKImage.IKImage;

class Median extends Non_kernel{
	
	//constructors
	public Median() {}
	public Median(int n, String name) {
		this.n=n;
		this.name=name;
	}
	
	public void processAndSave(IKImage input) {//from abstract class
		IKImage median_out=nonKernelFilter(input, n, 0);
		median_out.saveImage("median_size_"+n+"_out.jpg");
	}
}
