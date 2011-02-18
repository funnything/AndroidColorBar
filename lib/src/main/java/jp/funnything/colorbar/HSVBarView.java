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

public abstract class HSVBarView extends ColorBarView {
    public HSVBarView( Context context ) {
        super( context , 3 );
    }

    public HSVBarView( Context context , AttributeSet attrs ) {
        super( context , attrs , 3 );
    }

    public HSVBarView( Context context , AttributeSet attrs , int defStyle ) {
        super( context , attrs , defStyle , 3 );
    }

    @Override
    protected int getRGBColor( float[] values ) {
        return Color.HSVToColor( new float[] { values[ 0 ] * 360f , values[ 1 ] , values[ 2 ] } );
    }

    @Override
    public void setRGBColor( int color ) {
        float[] hsv = new float[ 3 ];
        Color.colorToHSV( color , hsv );

        _values[ 0 ] = hsv[ 0 ] / 360f;
        _values[ 1 ] = hsv[ 1 ];
        _values[ 2 ] = hsv[ 2 ];
    }
}
