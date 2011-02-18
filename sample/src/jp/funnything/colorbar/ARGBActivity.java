/**
 * Copyright 2010 funnything Licensed under the Apache License, Version 2.0 (the &quot;License&quot;); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to
 * in writing, software distributed under the License is distributed on an &quot;AS IS&quot; BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package jp.funnything.colorbar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

public class ARGBActivity extends Activity {
    private TextView _indicatorTextView;
    private View _okButton;
    private ColorBarView _alphaColorBarView;
    private ColorBarView _redColorBarView;
    private ColorBarView _greenColorBarView;
    private ColorBarView _blueColorBarView;

    private ColorBarHelper _helper;

    private final OnClickListener _okButtonClick = new OnClickListener() {
        @Override
        public void onClick( final View v ) {
            setResult( RESULT_OK , new Intent().putExtra( "color" , _helper.getRGBColor() ) );
            finish();
        }
    };

    private final OnColorChangeListener _listener = new OnColorChangeListener() {
        @Override
        public void onColorChange( final int color ) {
            setColorIndicator( color );
        }
    };

    private void assignWidget() {
        _indicatorTextView = ( TextView ) findViewById( R.id.indicatorTextView );
        _okButton = findViewById( R.id.okButton );
        _alphaColorBarView = ( ColorBarView ) findViewById( R.id.alphaColorBarView );
        _redColorBarView = ( ColorBarView ) findViewById( R.id.redColorBarView );
        _greenColorBarView = ( ColorBarView ) findViewById( R.id.greenColorBarView );
        _blueColorBarView = ( ColorBarView ) findViewById( R.id.blueColorBarView );
    }

    @Override
    public void onCreate( final Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        requestWindowFeature( Window.FEATURE_NO_TITLE );

        setContentView( R.layout.argb );

        assignWidget();

        _okButton.setOnClickListener( _okButtonClick );

        _helper =
                new ColorBarHelper( new ColorBarView[] { _alphaColorBarView , _redColorBarView , _greenColorBarView , _blueColorBarView } )
                        .setOnColorChangeListener( _listener ).setRGBColor( 0xffabcdef );
        setColorIndicator( 0xffabcdef );
    }

    private void setColorIndicator( final int color ) {
        _indicatorTextView.setBackgroundColor( color );
        final int complementary = Color.rgb( 0xff - Color.red( color ) , 0xff - Color.green( color ) , 0xff - Color.blue( color ) );
        _indicatorTextView.setTextColor( complementary );
        _indicatorTextView.setText( String.format( "#%02x%02x%02x%02x" , //
                Color.alpha( color ) , //
                Color.red( color ) , //
                Color.green( color ) , //
                Color.blue( color ) ) );
    }
}
