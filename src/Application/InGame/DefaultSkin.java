package Application.InGame;

import Test.CardDodge;
import Test.CardSlash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class DefaultSkin extends Skin{

	public static Skin instance = new DefaultSkin();

	public DefaultSkin()
	{
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("../JSanguosha/asset/pack.atlas"));
		this.addRegions(atlas);
		
		LabelStyle ls = new LabelStyle();
		ls.font = new BitmapFont();
		ls.background = this.getDrawable("state");
		this.add("label", ls);
		
		ls = new LabelStyle();
		ls.font = new BitmapFont();
		this.add("default", ls);
		
		ButtonStyle bs = new ButtonStyle();
		bs.up = this.getDrawable("banner");
		bs.pressedOffsetX = 1;
		bs.pressedOffsetY = -1;
		this.add("default", bs);
		
		TextField.TextFieldStyle tfs = new TextField.TextFieldStyle();
		tfs.font = ls.font;
		tfs.background = this.getDrawable("banner");
		tfs.fontColor = Color.LIGHT_GRAY;
		this.add("default", tfs);
		
		this.add(CardSlash.typeCardSlash.fullName(), this.getRegion("card/slash"), TextureRegion.class);
		this.add(CardDodge.typeDodge.fullName(), this.getRegion("card/dodge"), TextureRegion.class);
		
	}
}
