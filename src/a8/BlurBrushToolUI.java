package a8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BlurBrushToolUI extends JPanel implements ChangeListener {


	//#TODO
	private JSlider brush_slider;
	private JSlider blur_slider;

	private int blur_size = 2;
	private int brush_size = 5;

	public BlurBrushToolUI() {
		setLayout(new GridLayout(0,1));

		JPanel color_chooser_panel = new JPanel();
		color_chooser_panel.setLayout(new BorderLayout());

		JPanel slider_panel = new JPanel();
		slider_panel.setLayout(new GridLayout(0,1));

		JPanel brush_slider_panel = new JPanel();
		JLabel brush_label = new JLabel("Brush Size: ");
		brush_slider_panel.setLayout(new BorderLayout());
		brush_slider_panel.add(brush_label, BorderLayout.WEST);
		brush_slider = new JSlider(0,25,5);
		brush_slider.addChangeListener(this);
		brush_slider.setSnapToTicks(true);
		brush_slider.setPaintTicks(true);
		brush_slider.setPaintLabels(true);
		brush_slider.setMajorTickSpacing(5);
		brush_slider.setMinorTickSpacing(1);
		brush_slider_panel.add(brush_slider, BorderLayout.CENTER);

		JPanel blur_slider_panel = new JPanel();
		JLabel blur_label = new JLabel("Blur Area: ");
		blur_slider_panel.setLayout(new BorderLayout());
		blur_slider_panel.add(blur_label, BorderLayout.WEST);
		blur_slider = new JSlider(0,5,2);
		blur_slider.addChangeListener(this);
		blur_slider.setSnapToTicks(true);
		blur_slider.setPaintTicks(true);
		blur_slider.setPaintLabels(true);
		blur_slider.setMajorTickSpacing(1);
		blur_slider_panel.add(blur_slider, BorderLayout.CENTER);


		slider_panel.add(brush_slider_panel);
		slider_panel.add(blur_slider_panel);

		color_chooser_panel.add(slider_panel, BorderLayout.CENTER);


		add(color_chooser_panel);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() == brush_slider ){
			brush_size = brush_slider.getValue();
		} else if(e.getSource() == blur_slider){
			blur_size = blur_slider.getValue();
		}
	}

	public int getBrushSize(){
		return brush_size;
	}

	public int getBlurSize(){
		return blur_size;	
	}
}
