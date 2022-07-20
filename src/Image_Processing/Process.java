package Image_Processing;

import IKImage.IKImage;

public class Process {

	public static void main(String[] args) {
		
		// making an array for each filter use
		int n=3; //default size
		Filter[][] filter = new Filter[7][3];
		try{
			for (int i=0; i<3; i++) {
				filter[0][i] = new Box(n, "roof.jpg");
				filter[1][i] = new Gaussian(n, "roof.jpg");
				filter[2][i] = new Sobel("roof.jpg");
				filter[3][i] = new Roberts("roof.jpg");
				filter[4][i] = new Median(n, "roof.jpg");
				filter[5][i] = new Min(n, "roof.jpg");
				filter[6][i] = new Max (n, "roof.jpg");
				n=n+2; //change the size into 5 and 7
			}
		}catch(RuntimeException e) {
			e.getMessage(); //catches the error Kernel's constructor and Non_kernel's constructor throw
		}
		//process and save all images
		IKImage inputImage=new IKImage("roof.jpg");
		for(int i=0; i<7; i++) {
			for (int j=0; j<3; j++) {
				filter[i][j].processAndSave(inputImage);
			}
		}	
	}
}