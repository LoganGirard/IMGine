package a8;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class BlurBrushTool implements Tool {
	private BlurBrushToolUI ui;
	private ImageEditorModel model;
	
	
	public BlurBrushTool(ImageEditorModel model) {
		this.model = model;
		ui = new BlurBrushToolUI();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		model.blurAt(e.getX(), e.getY(), ui.getBrushSize(), ui.getBlurSize());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		model.blurAt(e.getX(), e.getY(), ui.getBrushSize(), ui.getBlurSize());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Blur Brush";
	}

	@Override
	public JPanel getUI() {
		return ui;
	}
	
	
}
