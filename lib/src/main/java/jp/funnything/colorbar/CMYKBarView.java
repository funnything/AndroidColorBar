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

public abstract class CMYKBarView extends ColorBarView {
    public CMYKBarView( Context context ) {
        super( context , 4 );
    }

    public CMYKBarView( Context context , AttributeSet attrs ) {
        super( context , attrs , 4 );
    }

    public CMYKBarView( Context context , AttributeSet attrs , int defStyle ) {
        super( context , attrs , defStyle , 4 );
    }

    @Override
    protected int getRGBColor( float[] values ) {
        float k = values[ 3 ];
        int r = Math.round( ( 1f - Math.min( 1f , values[ 0 ] * ( 1f - k ) + k ) ) * 0xff );
        int g = Math.round( ( 1f - Math.min( 1f , values[ 1 ] * ( 1f - k ) + k ) ) * 0xff );
        int b = Math.round( ( 1f - Math.min( 1f , values[ 2 ] * ( 1f - k ) + k ) ) * 0xff );

        return Color.rgb( r , g , b );
    }

    @Override
    public void setRGBColor( int color ) {
        float r = 1.f * Color.red( color ) / 0xff;
        float g = 1.f * Color.green( color ) / 0xff;
        float b = 1.f * Color.blue( color ) / 0xff;

        float k = Math.min( 1f - r , Math.min( 1f - g , 1f - b ) );

        _values[ 0 ] = ( 1f - r - k ) / ( 1f - k );
        _values[ 1 ] = ( 1f - g - k ) / ( 1f - k );
        _values[ 2 ] = ( 1f - b - k ) / ( 1f - k );
        _values[ 3 ] = k;
    }
}
