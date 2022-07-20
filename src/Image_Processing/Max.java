package Image_Processing;

import IKImage.IKImage;

class Max extends Non_kernel{
	
	//constructors
	public Max() {}
	public Max(int n, String name) {
		this.n=n;
		this.name=name;
	}
	public void processAndSave(IKImage input) {//from abstract class
		IKImage max_out=nonKernelFilter(input, n, 2);
		max_out.saveImage("max_size_"+n+"_out.jpg");
	}
}
