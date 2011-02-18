/**
 * Copyright 2010 funnything Licensed under the Apache License, Version 2.0 (the &quot;License&quot;); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to
 * in writing, software distributed under the License is distributed on an &quot;AS IS&quot; BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package jp.funnything.colorbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button _rgbButton;
    private Button _hsvButton;
    private Button _argbButton;
    private Button _cmykButton;

    private final OnClickListener rgbButtonClick = new OnClickListener() {
        @Override
        public void onClick( final View v ) {
            startActivity( new Intent( MainActivity.this , RGBActivity.class ) );
        }
    };

    private final OnClickListener hsvButtonClick = new OnClickListener() {
        @Override
        public void onClick( final View v ) {
            startActivity( new Intent( MainActivity.this , HSVActivity.class ) );
        }
    };

    private final OnClickListener argbButtonClick = new OnClickListener() {
        @Override
        public void onClick( final View v ) {
            startActivity( new Intent( MainActivity.this , ARGBActivity.class ) );
        }
    };

    private final OnClickListener cmykButtonClick = new OnClickListener() {
        @Override
        public void onClick( final View v ) {
            startActivity( new Intent( MainActivity.this , CMYKActivity.class ) );
        }
    };

    private void assignWidget() {
        _rgbButton = ( Button ) findViewById( R.id.rgbButton );
        _hsvButton = ( Button ) findViewById( R.id.hsvButton );
        _argbButton = ( Button ) findViewById( R.id.argbButton );
        _cmykButton = ( Button ) findViewById( R.id.cmykButton );
    }

    @Override
    public void onCreate( final Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.main );

        assignWidget();

        _rgbButton.setOnClickListener( rgbButtonClick );
        _hsvButton.setOnClickListener( hsvButtonClick );
        _argbButton.setOnClickListener( argbButtonClick );
        _cmykButton.setOnClickListener( cmykButtonClick );
    }
}
