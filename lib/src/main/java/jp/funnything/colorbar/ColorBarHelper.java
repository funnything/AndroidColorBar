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

public class ColorBarHelper {
    private final ColorBarView[] _bars;

    public ColorBarHelper( ColorBarView[] bars ) {
        _bars = bars;

        init();
    }

    private ColorBarView[] buildArgument( int target ) {
        ColorBarView[] argument = new ColorBarView[ _bars.length - 1 ];

        for ( int index = 0 , position = 0 ; index < _bars.length ; index++ ) {
            if ( index != target ) {
                argument[ position++ ] = _bars[ index ];
            }
        }

        return argument;
    }

    public int getRGBColor() {
        return _bars[ 0 ].getRGBColor();
    }

    private void init() {
        for ( int index = 0 ; index < _bars.length ; index++ ) {
            _bars[ index ].setAnother( buildArgument( index ) );
        }
    }

    public ColorBarHelper setOnColorChangeListener( OnColorChangeListener listener ) {
        for ( ColorBarView bar : _bars ) {
            bar.setOnColorChangeListener( listener );
        }

        return this;
    }

    public ColorBarHelper setRGBColor( int color ) {
        for ( ColorBarView bar : _bars ) {
            bar.setRGBColor( color );
        }

        return this;
    }
}
