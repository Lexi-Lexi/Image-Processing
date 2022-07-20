package Image_Processing;

import IKImage.IKImage;

class Min extends Non_kernel{
		
	//constructors
	public Min() {}
	public Min(int n, String name) {
		this.n=n;
		this.name=name;
	}
	public void processAndSave(IKImage input) {//from abstract class
		IKImage min_out=nonKernelFilter(input, n, 1);
		min_out.saveImage("min_size_"+n+"_out.jpg");
	}
}
