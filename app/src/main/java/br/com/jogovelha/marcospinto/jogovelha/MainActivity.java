package br.com.jogovelha.marcospinto.jogovelha;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView tvHello;
    private ImageView imgAnimacao;
    private boolean ativo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tvHello = (TextView)findViewById(R.id.tvHello);

        this.imgAnimacao = (ImageView) findViewById(R.id.imgAnimacao);


    }

    public void animacaoRodando(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.jump);
        tvHello.startAnimation(animation);
    }

    public void animacaoImagem(){
        AnimationDrawable animation =  (AnimationDrawable) this.imgAnimacao.getDrawable();
        if(ativo) ativo = false;
        else ativo = true;

        if(ativo)  animation.start();
        else animation.stop();
    }

    public void ativarEfeito(View view){
        this.animacaoRodando();
        this.animacaoImagem();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
