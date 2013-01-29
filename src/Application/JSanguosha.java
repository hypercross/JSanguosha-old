package Application;

import java.util.ArrayList;

import Application.InGame.DefaultSkin;
import Application.InGame.EntityInfoLabel;
import Game.IPlayer;
import Game.Entity.Entity;
import Game.Entity.GameEntity;
import Test.TestEnvironment;
import Test.TestPlayerManager;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class JSanguosha implements ApplicationListener {
    public Stage stage;
    GameEntity ge;
    
    ArrayList<EntityInfoLabel> labels = new ArrayList<EntityInfoLabel>(); 

	public void create () {
    	 stage = new Stage();
         Gdx.input.setInputProcessor(stage);
         
         Table table = new Table();
         table.setFillParent(true);
         stage.addActor(table);
         
         //--------------------------------
         ge = new GameEntity();
         ge.init();
         ge.environment = new TestEnvironment();
         ge.players = new TestPlayerManager();
         ge.setupCommon();
         //--------------------------------
         
         EntityInfoLabel game = 
         new EntityInfoLabel(ge);
         
         labels.add(game);
         table.add(game);
         
         game.addListener(new ClickListener()
         {
        	 public void clicked (InputEvent event, float x, float y) {
        		 ge.step();
        		 for(EntityInfoLabel label : labels)
        			 label.update();
        	}
         });
         
         for(IPlayer ip : ge.players.players)
         {
        	 EntityInfoLabel label = new EntityInfoLabel((Entity) ge.child("player" + ip.PlayerId()));
        	 labels.add(label);
        	 table.add(label);
         }
         
         table.row();
         
         TextField tf = 
         new TextField("", DefaultSkin.instance);
         
         tf.setTextFieldListener(new TextFieldListener() {
			public void keyTyped (TextField textField, char key) {
				if (key == '\r') textField.setText("");
			}
		});
         
         table.add(tf).width(300);
    }

	public void resize (int width, int height) {
        stage.setViewport(width, height, true);
}

public void render () {
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        Table.drawDebug(stage); // This is optional, but enables debug lines for tables.
}

public void dispose() {
        stage.dispose();
}

@Override
public void pause() {
	// TODO Auto-generated method stub
	
}

@Override
public void resume() {
	// TODO Auto-generated method stub
	
}
}