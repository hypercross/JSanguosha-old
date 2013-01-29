package Application.InGame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class DefaultSkin extends Skin{

	public static Skin instance = new DefaultSkin();

	public DefaultSkin()
	{
		Texture def = new Texture("../JSanguosha/asset/default.png");
		
		TextureRegion tr = new TextureRegion(def);
		tr.setRegion(0, 0, 160,26);
		this.add("banner", tr);
		
		tr = new TextureRegion(def);
		tr.setRegion(0,25,160,60);
		this.add("state", tr);
		
		LabelStyle ls = new LabelStyle();
		ls.font = new BitmapFont();
		ls.background = this.getDrawable("state");
		this.add("label", ls);
		
		TextField.TextFieldStyle tfs = new TextField.TextFieldStyle();
		tfs.font = ls.font;
		tfs.background = this.getDrawable("banner");
		tfs.fontColor = Color.LIGHT_GRAY;
		this.add("default", tfs);
	}
}
