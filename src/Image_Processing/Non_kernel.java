package Image_Processing;

import java.util.Arrays;
import IKImage.IKImage;

abstract class Non_kernel implements Filter{
	//variables
	protected IKImage input, output;
	protected String name;
	protected int n;
	final static int MEDIAN_FILTER=0;
	final static int MIN_FILTER=1;
	final static int MAX_FILTER=2;
	
	//constructors
	public Non_kernel() {}
	public Non_kernel(int n, String name) throws RuntimeException{ 
		this.name=name;
		input=new IKImage(name);
		if (n % 2 == 0 || n < 0)
			throw new RuntimeException("size 'n' should be an odd number bigger than 3");
			/* throws an exception about n's restrictions
		 	it is caught in Homework6's main method */
		this.n=n;
	}
	
	// (modifier:default)
	static IKImage nonKernelFilter(IKImage inputImage, int n, int which_filter) {
		//decide one of the three filters using 'which_filter'
		IKImage outputImage=new IKImage(inputImage); //using copy constructor
		int[] red=new int[n*n];
		int[] green=new int[n*n];
		int[] blue=new int[n*n];
		//for pixels in input image
		for (int i = 0; i < inputImage.getWidth(); i++) {
			for (int j = 0; j < inputImage.getHeight(); j++) {
				//for each pixel in neighborhood
				for(int k=0; k<n; k++) {
					for(int l=0; l<n; l++) {
						// Absolute coord of current neighborhood pixel
	                    int x = Math.min(inputImage.getWidth()-1, Math.max(0, i + k - (n/2)));
	                    int y = Math.min(inputImage.getHeight()-1, Math.max(0, j + l - (n/2)));
	                   /* when copying pixel colors to array, the program calculates the absolute coordinates
	                    * of the current neighborhood pixel. And if that coordinate is outside the boundary,
	                    * it faces the limitation, and it copies the nearest pixel inside the bounary instead */
	                    // index into color arrays
	                    int index = l * n + k;
						red[index]= inputImage.getPixel(y, x, IKImage.RED);
						green[index]=inputImage.getPixel(y, x, IKImage.GREEN);
						blue[index]= inputImage.getPixel(y, x, IKImage.BLUE);
					}
				}
				Arrays.sort(red);
				Arrays.sort(green);
				Arrays.sort(blue);
				
				int index_to_pick=0;
				switch(which_filter) {
				case MEDIAN_FILTER: //case of median filter
					index_to_pick=(n*n)/2;
					break;
				case MIN_FILTER: //case of min filter
					index_to_pick=0;
					break;
				case MAX_FILTER: //case of max filter
					index_to_pick=n*n-1;
				}
				outputImage.setPixelColor(j,i, red[index_to_pick], green[index_to_pick], blue[index_to_pick]);
			}
		}	
		return outputImage;
	}	
}