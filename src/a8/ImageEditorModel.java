package a8;

import java.io.IOException;



public class ImageEditorModel {

	private Frame original;
	private Frame current;

	public ImageEditorModel(Frame f) {
		original = f;
		current = original.copy();
	}

	public Frame getCurrent() {
		return current;
	}

	public Pixel getPixel(int x, int y) {
		return current.getPixel(x, y);
	}

	public void paintAt(int x, int y, Pixel brushColor, int brush_size) {
		current.suspendNotifications();

		for (int xpos=x-brush_size+1; xpos <=x+brush_size-1; xpos++) {
			for (int ypos=y-brush_size+1; ypos <=y+brush_size-1; ypos++) {
				if (xpos >= 0 &&
						xpos < current.getWidth() &&
						ypos >= 0 &&
						ypos < current.getHeight()) {
					current.setPixel(xpos, ypos, brushColor);
				}
			}
		}
		current.resumeNotifications();
	}

	public void blurAt(int x, int y, int brush_size, int blur_size) {
		current.suspendNotifications();
		double redSum = 0.0, greenSum = 0.0, blueSum = 0.0;
		double pixelCount = 0.0;

		for(int i =x-brush_size+1; i <=x+brush_size-1; i++){
			for(int j = y-brush_size+1; j <= y+brush_size-1; j++){
				redSum = 0.0;
				greenSum = 0.0;
				blueSum = 0.0;
				pixelCount = 0.0;

				if (i >= 0 &&
						i < current.getWidth() &&
						j >= 0 &&
						j < current.getHeight()) {
					for (int xpos=i-blur_size+1; xpos <=i+blur_size-1; xpos++) {
						for (int ypos=j-blur_size+1; ypos <=j+blur_size-1; ypos++) {
							if (xpos >= 0 &&
									xpos < current.getWidth() &&
									ypos >= 0 &&
									ypos < current.getHeight()) {
								Pixel p = current.getPixel(xpos, ypos);

								redSum += p.getRed();
								greenSum += p.getGreen();
								blueSum += p.getBlue();

								pixelCount++;
							}
						}
					}
					ColorPixel blurPixel = new ColorPixel(redSum/pixelCount, greenSum/pixelCount,
							blueSum/pixelCount);
					current.setPixel(i, j, blurPixel);
				}
			}
		}
		current.resumeNotifications();
	}

	public void setCurrent(Frame f){
		original = f;
		current = f;
	}
}
