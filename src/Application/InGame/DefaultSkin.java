package Application.InGame;

import java.io.IOException;

import Test.CardSlash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
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
		FileHandle handle = Gdx.files.internal("../JSanguosha/asset/skin_default.json");
		
		if(handle.exists())
		{
			load(handle);
			return ;
		}
		
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
		
		Texture slash = new Texture("../JSanguosha/asset/slash.jpg");
		
		tr = new TextureRegion(slash);
		tr.setRegion(0, 0, 93,130);
		this.add(CardSlash.typeCardSlash.fullName(), tr);
		
		Texture glow = new Texture("../JSanguosha/asset/glow.png");
		
		tr = new TextureRegion(glow);
		tr.setRegion(0, 0, 93,130);
		this.add("card_glow", tr);

		Texture char_mask = new Texture("../JSanguosha/asset/character.png");
		
		tr = new TextureRegion(char_mask);
		tr.setRegion(0, 0, 200,290);
		this.add("character_mask", tr);
		
		tr = new TextureRegion(char_mask);
		tr.setRegion(0, 292, 29,29);
		this.add("magatama", tr);
		
		tr = new TextureRegion(char_mask);
		tr.setRegion(0, 322, 30,25);
		this.add("magatama", tr);
		
		Texture default_general = new Texture("../JSanguosha/asset/default_general.jpg");
		
		tr = new TextureRegion(default_general);
		tr.setRegion(0, 0, 200,290);
		this.add("default_general", tr);
		
		handle = Gdx.files.external("../JSanguosha/asset/skin_default.json");
		if(!handle.exists())
			try {
				handle.file().createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
