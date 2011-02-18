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
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public abstract class ColorBarView extends View {
    private static final int DRAW_STEP = 8;

    protected float[] _values;
    private ColorBarView[] _anothers;
    private OnColorChangeListener _colorChangeListener = null;

    public ColorBarView( Context context , AttributeSet attrs , int nBar ) {
        super( context , attrs );

        init( nBar );
    }

    public ColorBarView( Context context , AttributeSet attrs , int defStyle , int nBar ) {
        super( context , attrs , defStyle );

        init( nBar );
    }

    public ColorBarView( Context context , int nBar ) {
        super( context );

        init( nBar );
    }

    protected abstract int getIndex();

    public int getRGBColor() {
        return getRGBColor( _values );
    }

    protected abstract int getRGBColor( float[] values );

    private void init( int nBar ) {
        _values = new float[ nBar ];
    }

    @Override
    public void onDraw( Canvas canvas ) {
        int width = getWidth();
        int height = getHeight();

        for ( int x = 0 ; x < width ; x += DRAW_STEP ) {
            Paint paint = new Paint();

            float[] values = new float[ _values.length ];
            for ( int index = 0 ; index < _values.length ; index++ ) {
                values[ index ] = index == getIndex() ? 1f * x / width : _values[ index ];
            }

            paint.setColor( getRGBColor( values ) );

            canvas.drawRect( new Rect( x , 0 , Math.min( x + DRAW_STEP , width ) , height ) , paint );
        }
    }

    @Override
    public boolean onTouchEvent( MotionEvent event ) {
        int width = getWidth();

        setValue( Math.min( Math.max( 1f * event.getX() / width , 0 ) , 1 ) );

        invalidate();
        for ( ColorBarView another : _anothers ) {
            another.setValue( _values );
            another.invalidate();
        }

        if ( _colorChangeListener != null ) {
            _colorChangeListener.onColorChange( getRGBColor() );
        }

        return true;
    }

    public void setAnother( ColorBarView[] anothers ) {
        _anothers = anothers;
    }

    public void setOnColorChangeListener( OnColorChangeListener listener ) {
        _colorChangeListener = listener;
    }

    public abstract void setRGBColor( int color );

    private void setValue( float value ) {
        _values[ getIndex() ] = value;
    }

    private void setValue( float[] values ) {
        _values = values;
    }
}
