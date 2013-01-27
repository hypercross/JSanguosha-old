package Application;

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
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class JSanguosha implements ApplicationListener {
    public Stage stage;
    public static GameEntity ge;

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
         new EntityInfoLabel("Blah",ge);
         
         table.add(game);
         
         game.addListener(new ClickListener()
         {
        	 public void clicked (InputEvent event, float x, float y) {
        		 ge.step();
        	}
         });
         
         for(IPlayer ip : ge.players.players)
         {
        	 table.add(new EntityInfoLabel("Blah", (Entity) ge.child("player" + ip.PlayerId())));
         }
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