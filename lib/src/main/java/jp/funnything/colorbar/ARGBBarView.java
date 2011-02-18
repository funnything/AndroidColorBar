/**
 *  Copyright 2010 funnything
 *
 *  Licensed under the Apache License, Version 2.0 (the &quot;License&quot;);
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an &quot;AS IS&quot; BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package jp.funnything.colorbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

public abstract class ARGBBarView extends ColorBarView {
    public ARGBBarView( Context context ) {
        super( context , 4 );
    }

    public ARGBBarView( Context context , AttributeSet attrs ) {
        super( context , attrs , 4 );
    }

    public ARGBBarView( Context context , AttributeSet attrs , int defStyle ) {
        super( context , attrs , defStyle , 4 );
    }

    @Override
    protected int getRGBColor( float[] values ) {
        int alpha = Math.round( values[ 0 ] * 0xff );
        int red = Math.round( values[ 1 ] * 0xff );
        int green = Math.round( values[ 2 ] * 0xff );
        int blue = Math.round( values[ 3 ] * 0xff );

        return Color.argb( alpha , red , green , blue );
    }

    @Override
    public void setRGBColor( int color ) {
        _values[ 0 ] = 1f * Color.alpha( color ) / 0xff;
        _values[ 1 ] = 1f * Color.red( color ) / 0xff;
        _values[ 2 ] = 1f * Color.green( color ) / 0xff;
        _values[ 3 ] = 1f * Color.blue( color ) / 0xff;
    }
}
